package br.com.tuiuti.swapgames.network;

import com.google.gson.annotations.SerializedName;

public class WebserviceResponse<T> {

    @SerializedName("RestResponse")
    protected RestResponse<T> mResponse;

    public RestResponse<T> getResponse() {
        return mResponse;
    }

    public void setResponse(RestResponse<T> mResponse) {
        this.mResponse = mResponse;
    }
}
