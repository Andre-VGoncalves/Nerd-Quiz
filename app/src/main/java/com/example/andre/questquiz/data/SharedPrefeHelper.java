package com.example.andre.questquiz.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefeHelper {

    private Context contexto;
    private SharedPreferences data;
    private SharedPreferences.Editor editor;
    private String NOME_ARQUIVO = "whatsapp.preferencias";
    private String CHAVE_IDENTIFICADOR = "identificadorUsuarioLogado";
    private String CHAVE_NOME = "nomeUsuarioLogado";
    private int MODE = 0;

    public SharedPrefeHelper(Context contexto) {
        this.contexto = contexto;
        data = contexto.getSharedPreferences(NOME_ARQUIVO, MODE);
        editor = data.edit();
    }

    public void salvarDados(String identificadorUsuario, String nomeUsuario){
        editor.putString(CHAVE_IDENTIFICADOR, identificadorUsuario);
        editor.putString(CHAVE_NOME, nomeUsuario);
        editor.commit();

    }

    public  String getIdentificador (){
        return data.getString(CHAVE_IDENTIFICADOR,null);
    }
    public  String getNome (){
        return data.getString(CHAVE_NOME,null);
    }

}
