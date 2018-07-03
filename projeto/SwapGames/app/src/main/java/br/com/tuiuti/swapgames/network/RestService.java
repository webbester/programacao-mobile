package br.com.tuiuti.swapgames.network;

import br.com.tuiuti.swapgames.model.Busca;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestService {

    @GET("select_biblioteca.php")
    Call<RestResponse<Busca[]>> getBuscar();
}
