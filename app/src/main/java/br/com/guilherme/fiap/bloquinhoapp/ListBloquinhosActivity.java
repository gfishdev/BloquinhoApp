package br.com.guilherme.fiap.bloquinhoapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.guilherme.fiap.bloquinhoapp.adapter.BloquinhoAdapter;
import br.com.guilherme.fiap.bloquinhoapp.api.UserAPI;
import br.com.guilherme.fiap.bloquinhoapp.fragment.ListFragment;
import br.com.guilherme.fiap.bloquinhoapp.model.Bloquinho;

public class ListBloquinhosActivity extends AppCompatActivity {
    private RecyclerView rvBloquinhos;
    private BloquinhoAdapter adapter;
    private List<Bloquinho> bloquinhos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_list_bloquinhos);

        rvBloquinhos = (RecyclerView) findViewById(R.id.rvBloquinhos);
        bloquinhos = new ArrayList<>();

        mostrarDados();
        rvBloquinhos.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BloquinhoAdapter(bloquinhos);
        rvBloquinhos.setAdapter(adapter);
    }

    private void mostrarDados() {
//of() — indica a activity ou Fragment em que o ViewModel será utilizado
//get() — indica o ViewModel que será utilizado.
        ViewModelProviders.of(this)
                .get(ListBloquinhosViewModel.class)
                .getBloquinhos()
                .observe(this, new Observer<List<Bloquinho>>() {
                    @Override
                    public void onChanged(@Nullable List<Bloquinho>
                                                  tarefas) {
                        adapter.setList(tarefas);
                        rvBloquinhos.getAdapter().notifyDataSetChanged();
                    }
                });
    }
}