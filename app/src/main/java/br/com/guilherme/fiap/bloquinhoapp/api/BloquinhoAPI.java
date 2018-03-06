package br.com.guilherme.fiap.bloquinhoapp.api;

import android.arch.lifecycle.LiveData;

import java.util.List;

import br.com.guilherme.fiap.bloquinhoapp.model.Bloquinho;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BloquinhoAPI {
    @GET("/bloquinho/name/{name}")
    Call<Bloquinho> findBloquinho(@Path("name") String name);

    @GET("/bloquinho/")
    LiveData<List<Bloquinho>> findAll();

    @POST("/bloquinho")
    Call<Void> save(@Body Bloquinho bloquinho);
}
