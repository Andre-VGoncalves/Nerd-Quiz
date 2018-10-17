package com.example.andre.questquiz.model;

import com.example.andre.questquiz.config.ConfigFirebase;
import com.google.firebase.database.DatabaseReference;

public class Question {

    String categoria;
    String subCategoria;
    String question;
    String opOne;
    String opTwo;
    String opTheree;
    String opFou;
    String correct;

    public Question(String categoria, String subCategoria, String question, String opOne,
                    String opTwo, String opTheree, String opFou, String correct) {
        this.categoria = categoria;
        this.subCategoria = subCategoria;
        this.question = question;
        this.opOne = opOne;
        this.opTwo = opTwo;
        this.opTheree = opTheree;
        this.opFou = opFou;
        this.correct = correct;
    }

    public void salvar(){
        DatabaseReference referenceFirebase = ConfigFirebase.getFirebase();
        referenceFirebase.child(getCategoria()).child(getSubCategoria()).setValue(this);
    }

    public String getCategoria() {
        return categoria;
    }

    public String getSubCategoria() {
        return subCategoria;
    }

    public String getQuestion() {
        return question;
    }

    public String getOpOne() {
        return opOne;
    }

    public String getOpTwo() {
        return opTwo;
    }

    public String getOpTheree() {
        return opTheree;
    }

    public String getOpFou() {
        return opFou;
    }

    public String getCorrect() {
        return correct;
    }
}
