package com.example.frander.alquilersoft.Publicaciones;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.frander.alquilersoft.Apartamentos.Apartamentos;
import com.example.frander.alquilersoft.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Frander on 30/05/2017.
 */

public class AdptadorPublicaciones extends RecyclerView.Adapter<AdptadorPublicaciones.PublicacionesHolder> {

    ArrayList<Apartamentos> apartamentos;
    public AdptadorPublicaciones(ArrayList<Apartamentos> apartamentos){
        this.apartamentos = apartamentos;
    }

    @Override
    public PublicacionesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_publicaciones,parent,false);
        PublicacionesHolder holder = new PublicacionesHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PublicacionesHolder holder, int position) {
       /* holder.img.setImageResource(apartamentos.get(position).getImagen());
        holder.precio.setText("₡"+apartamentos.get(position).getPrecio());
        if(apartamentos.get(position).getCapacidad() == 1){
            holder.capacidad.setText(apartamentos.get(position).getCapacidad()+" persona");
        }else{
            holder.capacidad.setText(apartamentos.get(position).getCapacidad()+" personas");
        }
        holder.capacidad.setText(""+apartamentos.get(position).getCapacidad());
        holder.contacto.setText(apartamentos.get(position).getContacto());
        holder.ubicacion.setText(apartamentos.get(position).getUbicacion());*/
    }

    @Override
    public int getItemCount() {
        return apartamentos.size();
    }


    public static class PublicacionesHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView precio;
        TextView capacidad;
        TextView contacto;
        TextView ubicacion;

        public PublicacionesHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.imagenPublicacion);
            precio = (TextView)itemView.findViewById(R.id.txtPrecioAl);
            capacidad = (TextView)itemView.findViewById(R.id.txtCapacidadA);
            contacto = (TextView)itemView.findViewById(R.id.txtContacto);
            ubicacion = (TextView)itemView.findViewById(R.id.txtUbicacionA);
        }
    }
}
