package com.example.andre.questquiz.ui.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.andre.questquiz.R;
import com.example.andre.questquiz.config.ConfigFirebase;
import com.example.andre.questquiz.data.SharedPrefeHelper;
import com.example.andre.questquiz.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class CadastroUserActivity extends AppCompatActivity {

    private FirebaseAuth autenticacao;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_user);
    }

    private void cadastrarUser() {
        autenticacao = ConfigFirebase.getFirebaseAutenticacao();

        autenticacao.createUserWithEmailAndPassword(
                user.getEmail(),
                user.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(CadastroUserActivity.this,"Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                    Log.i("sucesso", "Cadastrado");

                    String identificadorUser =  "";
                            //criar metodo e uma classe para deixar na base 64
                            //identificadorUser = Base64Custom.codificarBase64(user.getEmail());
                    user.setId(identificadorUser);
                    user.salvar();

                    SharedPrefeHelper data = new SharedPrefeHelper(CadastroUserActivity.this);
                    data.salvarDados(identificadorUser, user.getNome());

                    abrirLoginUser();

                }else{
                    String erro ="";
                    try{
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){
                        erro = "Digite uma senha mais forte.";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        erro += "Email Invalido.";
                    } catch (FirebaseAuthUserCollisionException e) {
                        erro = "Email ja cadastrado.";
                    } catch (Exception e) {
                        erro = "Erro ao cadastrar o Usuario.";
                        e.printStackTrace();
                    }
                    Toast.makeText(CadastroUserActivity.this,erro, Toast.LENGTH_SHORT).show();
                    Log.i("erro", "Aconteceu algum erro ao cadastrar");
                }
            }
        });

    }

    private void abrirLoginUser() {
        Intent intent = new Intent(CadastroUserActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
