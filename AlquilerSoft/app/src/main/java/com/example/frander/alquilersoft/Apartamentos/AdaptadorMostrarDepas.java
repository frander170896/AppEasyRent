package com.example.frander.alquilersoft.Apartamentos;

import android.content.Context;
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

    private Context context;
    ArrayList<Apartamentos> apartamentos;

    public AdaptadorMostrarDepas(ArrayList<Apartamentos> apartamentos, Context context) {
        this.context = context;
        this.apartamentos = apartamentos;
    }

    @Override
    public ApartamentosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_mostrar_apartamentos,parent,false);
        ApartamentosViewHolder holder = new ApartamentosViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ApartamentosViewHolder holder, final int position) {
       holder.txtNumero.setText(apartamentos.get(position).getName());
        holder.txtPrecio.setText("₡"+apartamentos.get(position).getPrice());
        if(apartamentos.get(position).getCapacity() == 1){
            holder.txtCapacidad.setText(apartamentos.get(position).getCapacity()+" persona");
        }else{
            holder.txtCapacidad.setText(apartamentos.get(position).getCapacity()+" personas");
        }
        holder.txtUbicacion.setText(apartamentos.get(position).getAdress());
        holder.txtDisponible.setText(apartamentos.get(position).getStatusName());
        holder.Img.setImageResource(R.mipmap.ic_p1);
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
