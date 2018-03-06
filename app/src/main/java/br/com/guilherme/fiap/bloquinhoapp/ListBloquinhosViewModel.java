package br.com.guilherme.fiap.bloquinhoapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import br.com.guilherme.fiap.bloquinhoapp.api.BloquinhoAPI;
import br.com.guilherme.fiap.bloquinhoapp.api.UserAPI;
import br.com.guilherme.fiap.bloquinhoapp.model.Bloquinho;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListBloquinhosViewModel  extends AndroidViewModel {
    private LiveData<List<Bloquinho>> bloquinhos;
    private BloquinhoAPI api;

    public ListBloquinhosViewModel(Application application) {
        super(application);
        api = getRetrofit().create(BloquinhoAPI.class);
        carregarDados();

    }

    public LiveData<List<Bloquinho>> getBloquinhos() {
        return bloquinhos;
    }

    private void carregarDados() {
        bloquinhos = api.findAll();
    }

    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://bloquinho-app.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}