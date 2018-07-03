package br.com.tuiuti.swapgames.fragments;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import br.com.tuiuti.swapgames.R;
import br.com.tuiuti.swapgames.model.Busca;
import br.com.tuiuti.swapgames.network.NetworkManager;
import br.com.tuiuti.swapgames.network.RestResponse;
import br.com.tuiuti.swapgames.network.WebserviceResponse;
import br.com.tuiuti.swapgames.util.Log;
import br.com.tuiuti.swapgames.view.adapter.FeedRecyclerViewAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@EFragment(R.layout.fragment_feed)
public class FeedFragment extends Fragment {

    @FragmentArg
    String mTitulo;

    @ViewById(R.id.feed_recyclerview)
    RecyclerView mRecyclerView;

    @AfterViews
    protected void init() {
        Log.d("init: " + mTitulo);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);

        NetworkManager.service().getBuscar().enqueue(
                new Callback<RestResponse<Busca[]>>() {
                    @Override
                    public void onResponse(Call<RestResponse<Busca[]>> call, Response<RestResponse<Busca[]>> response) {
                        Log.d("FOI1");

                        Log.d("FeedFragment.onResponse: 1 " + response.raw());
                        Log.d("FeedFragment.onResponse: 2 " + response.message());
                        if (response.body() != null){
                            trataRespostaOkay(response.body());
                        } else {
                            trataRespostaErro(new RuntimeException("Nenhuma resposta de retorno"));
                        }
                    }

                    @Override
                    public void onFailure(Call<RestResponse<Busca[]>> call, Throwable t) {
                        Log.d("FOI2");

                        trataRespostaErro(t);
                    }
                }
        );

    }

    private void trataRespostaErro(Throwable t) {
        Log.e("trataRespostaErro: ", t);
    }

    private void trataRespostaOkay(RestResponse<Busca[]> body) {

        Log.d("trataRespostaOkay: " + body.getMensagem());
        Log.d("trataRespostaOkay: " + body.getStatus());

        List<Busca> buscas = new ArrayList<>();
        for (Busca busca : result){
            buscas.add(busca);
        }

        Log.d("FeedFragment.trataRespostaOkay: " + buscas.size());
        Log.d("FeedFragment.trataRespostaOkay: " + buscas);

        FeedRecyclerViewAdapter adapter = new FeedRecyclerViewAdapter(buscas); // BUSCA
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }
}
