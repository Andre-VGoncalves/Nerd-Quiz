package com.example.andre.questquiz.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.andre.questquiz.R;

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

    }
}
