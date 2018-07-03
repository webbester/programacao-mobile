package br.com.tuiuti.swapgames.network;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RestResponse<T> {

    private Date mTimestamp;

    @SerializedName("status")
    private int mStatus;

    @SerializedName("message")
    private String mMensagem;

    @SerializedName("object")
    private T mObjeto;

    public Date getTimestamp() {
        return mTimestamp;
    }

    public void setTimestamp(Date timestamp) {
        mTimestamp = timestamp;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int status) {
        mStatus = status;
    }

    public String getMensagem() {
        return mMensagem;
    }

    public void setMensagem(String mensagem) {
        mMensagem = mensagem;
    }

    public T getObjeto() {
        return mObjeto;
    }

    public void setObjeto(T objeto) {
        mObjeto = objeto;
    }

    @SerializedName("messages")
    protected List<String> mMensagens = new ArrayList<>();

    @SerializedName("result")
    protected T mResult;

    public List<String> getmMensagens() {
        return mMensagens;
    }

    public void setmMensagens(List<String> mMensagens) {
        this.mMensagens = mMensagens;
    }

    public T getmResult() {
        return mResult;
    }

    public void setmResult(T mResult) {
        this.mResult = mResult;
    }
}
