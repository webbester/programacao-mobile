package br.com.tuiuti.swapgames.model;

import com.google.gson.annotations.SerializedName;

public class Busca {

    // region SERIALIZENAME

    @SerializedName("nome")
    protected String mNome = "";

    @SerializedName("editor")
    protected String mEditor = "";

    @SerializedName("estilo")
    protected String mEstilo = "";

    @SerializedName("plataforma")
    protected String mPlataforma = "";

    //endregion

    //region GETTERS AND SETTERS

    public String getNome() {
        return mNome;
    }

    public void setNome(String nome) {
        mNome = nome;
    }

    public String getEditor() {
        return mEditor;
    }

    public void setEditor(String editor) {
        mEditor = editor;
    }

    public String getEstilo() {
        return mEstilo;
    }

    public void setEstilo(String estilo) {
        mEstilo = estilo;
    }

    public String getPlataforma() {
        return mPlataforma;
    }

    public void setPlataforma(String plataforma) {
        mPlataforma = plataforma;
    }


    //endregion
}
