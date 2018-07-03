package br.com.tuiuti.swapgames.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.HttpMethod;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.json.JSONException;

import br.com.tuiuti.swapgames.R;
import br.com.tuiuti.swapgames.databinding.ActivityLoginBinding;
import br.com.tuiuti.swapgames.model.Perfil;
import br.com.tuiuti.swapgames.network.NetworkManager;
import br.com.tuiuti.swapgames.util.Log;
import br.com.tuiuti.swapgames.util.SharedPrefUtil;

//Exemplo de classe usando o Android Annotations

@EActivity(R.layout.activity_login)

public class LoginActivity extends AppCompatActivity {

    // ----------------------------------------------------------------------------------------
    // ATRIBUTOS
    // ----------------------------------------------------------------------------------------

    // variaveis para acessar os campos da tela

    private ActivityLoginBinding mBinding;
    private CallbackManager mCallbackManager;


    // ----------------------------------------------------------------------------------------
    // METODOS
    // ----------------------------------------------------------------------------------------


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }

    @AfterViews
    protected void init() {

        mBinding = ActivityLoginBinding.inflate(getLayoutInflater());

        mCallbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(mCallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {

                        retrieveLoginData(loginResult);

                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onError(FacebookException exception) {
                    }
                });

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, 10000);

    }


    @Click(R.id.login_btn_semlogin)
    protected void LoginNormalClick() {
        HomeActivity_.intent(LoginActivity.this).start();
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void retrieveLoginData(LoginResult result) {
        Log.d("retrieveLoginData");

        Bundle parameters = new Bundle();
        parameters.putString("fields", "name,email");

        new GraphRequest(AccessToken.getCurrentAccessToken(),
                "/" + result.getAccessToken().getUserId(),
                parameters,
                HttpMethod.GET,
                response -> {
                    extraiDadosPerfil(response, result.getAccessToken().getToken());
                }
        ).executeAsync();
    }

    private void extraiDadosPerfil(final GraphResponse response, final String token) {
        Log.d("extraiDadosPerfil: " + response);

        Perfil perfil = new Perfil();
        perfil.setNome(getField(response, "name"));
        perfil.setEmail(getField(response, "email"));

        SharedPrefUtil.salvarPerfil(this, perfil);
        SharedPrefUtil.setEfetuouLogin(this, true);

        HomeActivity_.intent(LoginActivity.this).start();
        finish();

        Log.d("extraiDadosPerfil: " + perfil);
    };

    private String getField(final GraphResponse response, final String id) {
        try {
            return response.getJSONObject().getString(id);
        } catch (JSONException ex) {
            Log.e("getField: ", ex.getCause());
        }
        return "";
    }

}