package br.com.tuiuti.swapgames.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.ViewsById;

import java.util.ArrayList;
import java.util.List;

import br.com.tuiuti.swapgames.R;
import br.com.tuiuti.swapgames.databinding.ActivityLoginBinding;
import br.com.tuiuti.swapgames.fragments.FeedFragment;
import br.com.tuiuti.swapgames.fragments.FeedFragment_;
import br.com.tuiuti.swapgames.view.adapter.HomeViewPagerAdapter;

import static com.facebook.internal.CallbackManagerImpl.RequestCodeOffset.Login;

@EActivity(R.layout.activity_home)
public class HomeActivity extends AppCompatActivity {

    @ViewById(R.id.home_toolbar)
    protected Toolbar mToolbar;

    @ViewById(R.id.container)
    protected ViewPager mContainer;

    private FeedFragment mFeedFragment;

    @AfterViews
    protected void init(){
        Log.d("HomeActivity");

        if(mToolbar != null){
            setSupportActionBar(mToolbar);
        }

        mFeedFragment = FeedFragment_.builder().mTitulo("Teste").build();

        List<Fragment> lista = new ArrayList<>();
        lista.add(mFeedFragment);

        // Define a classe adapter do viewpager
        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(
                getSupportFragmentManager(), lista);
        mContainer.setAdapter(adapter);
    }
}
