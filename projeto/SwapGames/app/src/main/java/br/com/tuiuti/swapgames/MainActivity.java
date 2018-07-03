package br.com.tuiuti.swapgames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.tuiuti.swapgames.activities.HomeActivity_;
import br.com.tuiuti.swapgames.activities.LoginActivity_;
import br.com.tuiuti.swapgames.util.Log;
import br.com.tuiuti.swapgames.util.SharedPrefUtil;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MAIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("mainActivity.onCreate");

        boolean estaLogado = SharedPrefUtil.getEfetuouLogin(this);
        Log.d("onCreate: " + estaLogado);

        if (estaLogado) {
            HomeActivity_.intent(this).start();
            finish();
        }
        else {
            LoginActivity_.intent(this).start();
            finish();
        }
    }
}
