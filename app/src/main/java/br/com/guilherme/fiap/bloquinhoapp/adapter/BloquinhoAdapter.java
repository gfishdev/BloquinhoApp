package br.com.guilherme.fiap.bloquinhoapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.guilherme.fiap.bloquinhoapp.R;
import br.com.guilherme.fiap.bloquinhoapp.model.Bloquinho;

public class BloquinhoAdapter extends
        RecyclerView.Adapter<BloquinhoAdapter.BloquinhoViewHolder> {
    private List<Bloquinho> bloquinhos;

    public BloquinhoAdapter(List<Bloquinho> bloquinhos) {
        this.bloquinhos = bloquinhos;
    }

    public void setList(List<Bloquinho> bloquinhos) {
        this.bloquinhos = bloquinhos;
    }

    @Override
    public BloquinhoViewHolder onCreateViewHolder(ViewGroup parent, int
            viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_bloquinho, parent, false);
        return new BloquinhoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(BloquinhoViewHolder holder, int i) {
        Bloquinho bloquinho = bloquinhos.get(i);
        holder.tvName.setText(bloquinho.getName());
        // TODO: Format Date
        holder.tvDay.setText(bloquinho.getDay().toString());
        holder.tvStyle.setText(bloquinho.getStyle());
    }

    @Override
    public int getItemCount() {
        return bloquinhos.size();
    }

    public static class BloquinhoViewHolder extends
            RecyclerView.ViewHolder {
        TextView tvName, tvDay, tvStyle;

        public BloquinhoViewHolder(View v) {
            super(v);
            tvName = v.findViewById(R.id.tvName);
            tvDay = v.findViewById(R.id.tvDay);
            tvStyle = v.findViewById(R.id.tvStyle);
        }
    }
}