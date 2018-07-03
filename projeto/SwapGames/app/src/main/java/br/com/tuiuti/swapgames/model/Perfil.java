package br.com.tuiuti.swapgames.model;

import com.google.gson.annotations.SerializedName;

public class Perfil {

    @SerializedName("name")
    protected String mNome = "";

    @SerializedName("email")
    protected String mEmail = "";

    // region GETTER n SETTER

    public String getNome() {
        return mNome;
    }

    public void setNome(String nome) {
        mNome = nome;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    //endregion

    @Override
    public String toString() {
        return "Perfil{" +
                "mNome='" + mNome + '\'' +
                ", mEmail='" + mEmail + '\'' +
                '}';
    }
}
