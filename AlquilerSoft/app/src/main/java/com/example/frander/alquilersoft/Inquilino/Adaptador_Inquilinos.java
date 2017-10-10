package com.example.frander.alquilersoft.Inquilino;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.frander.alquilersoft.R;

import java.util.ArrayList;

/**
 * Created by Frander on 23/05/2017.
 */

public class Adaptador_Inquilinos extends RecyclerView.Adapter<Adaptador_Inquilinos.InquilonVieHolder> {

    ArrayList<Inquilino> inquilinos;
    public Adaptador_Inquilinos ( ArrayList<Inquilino> inquilinos){
        this.inquilinos = inquilinos;
    }

    @Override
    public InquilonVieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_mostrar_inquilinos,parent,false);
        InquilonVieHolder holder = new InquilonVieHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(InquilonVieHolder holder, int position) {
        holder.foto.setImageResource(inquilinos.get(position).getImagen());
        holder.nombre.setText(inquilinos.get(position).getNombre()+" "+inquilinos.get(position).getApellido());
        holder.numero.setText(inquilinos.get(position).getNumeroCelular());
    }

    @Override
    public int getItemCount() {
        return inquilinos.size();
    }

    public static class InquilonVieHolder extends RecyclerView.ViewHolder{
        ImageView foto;
        //ImageView icono;
        TextView nombre;
        TextView numero;

        public InquilonVieHolder(View itemView) {
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.imgFoto);
            //icono = (ImageView) itemView.findViewById(R.id.imgTelefono);
            nombre = (TextView) itemView.findViewById(R.id.txtNombre);
            numero = (TextView) itemView.findViewById(R.id.txtNumero);
        }
    }


}
