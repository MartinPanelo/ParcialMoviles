package com.martintecno.parcialmoviles.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.martintecno.parcialmoviles.NotaModelo;
import com.martintecno.parcialmoviles.R;

import java.io.Serializable;
import java.util.List;

public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.ViewHolder> {
    private List<NotaModelo> ListaNotas;
    private Context context;

    private LayoutInflater li;




    public NotaAdapter(List<NotaModelo> ListaNotas, Context context, LayoutInflater li) {
        this.ListaNotas = ListaNotas;
        this.context = context;
        this.li = li;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=li.inflate(R.layout.item,parent,false);




        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.titulo.setText(ListaNotas.get(position).getTitulo());
     //   holder.descripcion.setText(ListaNotas.get(position).getdescripcion());



    }

    @Override
    public int getItemCount() {
        return ListaNotas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView titulo;
        private TextView descripcion;
        private TextView fecha;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.TVTitulo);
        //    descripcion = itemView.findViewById(R.id.TVDescripcion);
            fecha = itemView.findViewById(R.id.TVFecha);

            itemView.findViewById(R.id.BTNBorrar).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ListaNotas.remove(getAdapterPosition());
                    Navigation.findNavController(view).
                            navigate(R.id.nav_home);
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int posicion = getAdapterPosition();
                    NotaModelo NM = ListaNotas.get(posicion);

                    Bundle bundle = new Bundle();

                    bundle.putSerializable("item", NM);

                    Navigation.findNavController(view).
                            navigate(R.id.detallesFragment,bundle);
                }
            });


        }
    }
}