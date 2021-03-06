package com.example.andre.questquiz.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.andre.questquiz.R;
import com.example.andre.questquiz.model.Question;

import static java.security.AccessController.getContext;

public class CadastroQuestionActivity extends AppCompatActivity {

    Spinner spnQuestion;
    Spinner spnSubQuestion;
    EditText edtQuestion;
    EditText edtOpOne;
    EditText edtOpTwo;
    EditText edtOpThere;
    EditText edtOpFou;
    RadioButton rdtOne;
    RadioButton rdtTwo;
    RadioButton rdtThere;
    RadioButton rdtfou;

    String categoria ="";
    String subCategoria ="generico";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_question);
        spnQuestion = findViewById(R.id.spn_categoria);
        spnSubQuestion = findViewById(R.id.spn_sub_categoria);
        edtQuestion = findViewById(R.id.edt_pergunta);
        edtOpOne = findViewById(R.id.edt_op_one);
        edtOpTwo = findViewById(R.id.edt_op_two);
        edtOpFou = findViewById(R.id.edt_op_quatro);
        edtOpThere = findViewById(R.id.edt_op_there);
        rdtOne = findViewById(R.id.rdt_op_one);
        rdtTwo = findViewById(R.id.rdt_op_two);
        rdtThere = findViewById(R.id.rdt_op_there);
        rdtfou = findViewById(R.id.rdt_op_fourth);

        String[] lsCategoria = getResources().getStringArray(R.array.lista_materia);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,lsCategoria);
        spnQuestion.setAdapter(dataAdapter);
        spnQuestion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               categoria = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void cadastrarQuestion(View view) {
        String opCorrect;
        if (rdtOne.isChecked()){
            opCorrect = "0";
        }else if (rdtTwo.isChecked()){
            opCorrect = "1";
        }else if (rdtThere.isChecked()){
            opCorrect = "2";
        }else{
            opCorrect = "3";
        }

        if (edtOpOne.getText().toString().isEmpty() || edtOpTwo.getText().toString().isEmpty() ||
               edtOpThere.getText().toString().isEmpty() || edtOpFou.getText().toString().isEmpty() ||
                edtQuestion.getText().toString().isEmpty()){
            Toast.makeText(CadastroQuestionActivity.this, "Campos em Branco", Toast.LENGTH_SHORT).show();

        }else{
            Question question= new Question(categoria,subCategoria,edtQuestion.getText().toString(),edtOpOne.getText().toString(),
                    edtOpTwo.getText().toString(),edtOpThere.getText().toString(),edtOpFou.getText().toString(),opCorrect);

            question.salvar();

            edtQuestion.setText("");
            edtOpThere.setText("");
            edtOpFou.setText("");
            edtOpOne.setText("");
            edtOpTwo.setText("");

            Toast.makeText(CadastroQuestionActivity.this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
        }



    }

}
