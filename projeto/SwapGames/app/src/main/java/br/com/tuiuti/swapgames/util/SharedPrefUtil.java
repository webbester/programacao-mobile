package br.com.tuiuti.swapgames.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.tuiuti.swapgames.model.Perfil;

public class SharedPrefUtil {

    private static final String ARQUIVO = "Bronetwork_files";

    private SharedPrefUtil() {
        //vazio
    }

    public static void salvarPerfil(Context context, Perfil perfil) {

        SharedPreferences.Editor editor =
                context.getSharedPreferences(ARQUIVO, Context.MODE_PRIVATE).edit();

        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(perfil, Perfil.class);

        editor.putString("perfil", json);
        editor.apply();
    }

    public static Perfil carregarPerfil(Context context) {

        SharedPreferences preferences =
                context.getSharedPreferences(ARQUIVO, Context.MODE_PRIVATE);

        String json = preferences.getString("perfil", "");

        Gson gson = new GsonBuilder().create();
        return  gson.fromJson(json, Perfil.class);
    }

    public static void setEfetuouLogin(Context context, boolean login) {
        SharedPreferences.Editor editor =
                context.getSharedPreferences(ARQUIVO, Context.MODE_PRIVATE).edit();
        editor.putBoolean("login", login);
        editor.apply();
    }

    public  static boolean getEfetuouLogin(Context context) {
        SharedPreferences preferences =
                context.getSharedPreferences(ARQUIVO, Context.MODE_PRIVATE);
        return preferences.getBoolean("login", true);
    }
}
