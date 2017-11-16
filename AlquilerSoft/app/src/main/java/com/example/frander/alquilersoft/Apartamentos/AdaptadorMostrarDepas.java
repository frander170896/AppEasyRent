package com.example.frander.alquilersoft.Apartamentos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.frander.alquilersoft.R;

import java.util.ArrayList;

/**
 * Created by Frander on 26/05/2017.
 */

public class AdaptadorMostrarDepas extends RecyclerView.Adapter<AdaptadorMostrarDepas.ApartamentosViewHolder> {

    ArrayList<Apartamentos> apartamentos;

    public AdaptadorMostrarDepas(ArrayList<Apartamentos> apartamentos) {
        this.apartamentos = apartamentos;
    }

    @Override
    public ApartamentosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_mostrar_apartamentos,parent,false);
        ApartamentosViewHolder holder = new ApartamentosViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ApartamentosViewHolder holder, int position) {
       /* holder.txtNumero.setText(apartamentos.get(position).getNombre+"");
        holder.txtPrecio.setText("₡"+apartamentos.get(position).getPrecio()+"");
        if(apartamentos.get(position).getCapacidad() == 1){
            holder.txtCapacidad.setText(apartamentos.get(position).getCapacidad()+" persona");
        }else{
            holder.txtCapacidad.setText(apartamentos.get(position).getCapacidad()+" personas");
        }
        holder.txtUbicacion.setText(apartamentos.get(position).getUbicacion());
        if(apartamentos.get(position).getDisponible() == 0){
            holder.txtDisponible.setText("Disponible");
        }else{
            holder.txtDisponible.setText("Ocupado");
        }
        holder.Img.setImageResource(apartamentos.get(position).getImagen());*/
    }

    @Override
    public int getItemCount() {
        return apartamentos.size();
    }

    public static class ApartamentosViewHolder extends RecyclerView.ViewHolder{
        TextView txtNumero;
        TextView txtPrecio;
        TextView txtCapacidad;
        TextView txtUbicacion;
        TextView txtDisponible;
        ImageView Img;

        public ApartamentosViewHolder(View itemView) {
            super(itemView);
            txtNumero = (TextView) itemView.findViewById(R.id.txtNumeroD);
            txtPrecio = (TextView) itemView.findViewById(R.id.txtPrecio);
            txtCapacidad = (TextView) itemView.findViewById(R.id.txtCapacidad);
            txtUbicacion = (TextView) itemView.findViewById(R.id.txtUbicacion);
            txtDisponible = (TextView) itemView.findViewById(R.id.txtDisponible);
            Img = (ImageView) itemView.findViewById(R.id.imgApartamento);
        }
    }
}
