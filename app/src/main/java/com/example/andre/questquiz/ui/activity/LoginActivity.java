package com.example.andre.questquiz.ui.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.andre.questquiz.R;
import com.example.andre.questquiz.config.ConfigFirebase;
import com.example.andre.questquiz.data.SharedPrefeHelper;
import com.example.andre.questquiz.helper.Base64Custom;
import com.example.andre.questquiz.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends Activity {

    private FirebaseAuth autenticacao;
    private String identificadorUser;
    User user;
    EditText edtEmail;
    EditText edtSenha;

    private ValueEventListener valueEventListenerUser;
    private DatabaseReference firebase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = new User();
        edtEmail = findViewById(R.id.editText);
        edtSenha = findViewById(R.id.editText2);
        verificaUserLogado();
    }

    private void verificaUserLogado() {

        autenticacao = ConfigFirebase.getFirebaseAutenticacao();
        if (autenticacao.getCurrentUser() != null) {
            abriTelaPrincipal();
        }
    }

    private void validarLogin() {
        autenticacao = ConfigFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(
                user.getEmail(),
                user.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                String erro = "";
                if (task.isSuccessful()) {

                    identificadorUser = "";
                    //criar classe e metodo para o base64
                    Base64Custom.codificarBase64(user.getEmail());

                    firebase = ConfigFirebase.getFirebase()
                            .child("usuarios")
                            .child(identificadorUser);

                    valueEventListenerUser = new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            User usuarioRecuperado = dataSnapshot.getValue(User.class);

                            SharedPrefeHelper data = new SharedPrefeHelper(LoginActivity.this);

                            data.salvarDados(identificadorUser, usuarioRecuperado.getNome());
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    };

                    firebase.addListenerForSingleValueEvent(valueEventListenerUser);


                    Toast.makeText(LoginActivity.this, "Bem Vindo", Toast.LENGTH_SHORT).show();
                    abriTelaPrincipal();
                } else {
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthInvalidUserException e) {
                        erro = "Email Invalido";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        erro = "Senha Invalida";
                    } catch (Exception e) {
                        erro = "Erro ao realizar o login";
                        Log.i("erro", "Ocorreu um erro");
                        e.printStackTrace();
                    }
                    Toast.makeText(LoginActivity.this, erro, Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void abriTelaPrincipal() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void abrirCadastroUser(View view) {

        Intent intent = new Intent(LoginActivity.this, CadastroUserActivity.class);
        startActivity(intent);
    }

    public void logar(View view) {

        user.setEmail(edtEmail.getText().toString());
        user.setSenha(edtSenha.getText().toString());

        validarLogin();

    }

    public void abrirDialog(View view) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(LoginActivity.this);
        //configurar a dialog
        alertDialog.setTitle("Recuperar Senha");
        alertDialog.setMessage("E-mail do Usuário");
        alertDialog.setCancelable(false);
        final EditText edtEmail = new EditText(LoginActivity.this);
        alertDialog.setView(edtEmail);


        //configurar Botões
        alertDialog.setPositiveButton("Enviar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.create();
        alertDialog.show();
    }
}
