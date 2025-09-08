package com.example.passwordapp.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.passwordapp.Modelo.Password;
import com.example.passwordapp.R;

import java.util.ArrayList;


public class Adaptador_password  extends RecyclerView.Adapter<Adaptador_password.HolderPassword>{
    private Context context;
    private ArrayList<Password> passwordArrayList;

    public Adaptador_password(Context context, ArrayList<Password> passwordArrayList) {
        this.context = context;
        this.passwordArrayList = passwordArrayList;
    }

    @NonNull
    @Override
    public HolderPassword onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //aqui lo que hacemos es inflar el layout

        View view= LayoutInflater.from(context).inflate(R.layout.item_password,parent,false);
        return new HolderPassword(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderPassword holder, int position) {
        //aqui lo que hacemos es cargar los datos en el layout
        Password model_password=passwordArrayList.get(position);
        String id=model_password.getId();
        String titulo=model_password.getTitulo();
        String cuenta=model_password.getCuenta();
        String nombre_usuario=model_password.getNombre_usuario();
        String password=model_password.getPassword();
        String sitio_web=model_password.getSitio_web();
        String nota=model_password.getNota();
        String t_registro=model_password.getT_registro();
        String t_actualizacion=model_password.getT_actualizacion();

        holder.tv_item_titulo.setText(titulo);
        holder.tv_item_cuenta.setText(cuenta);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Usuario Preciona el boton de mas opciones

            }
        });
        holder.button_mas_opciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Usuario Precion en el ImageButton
            }
        });



    }

    @Override
    public int getItemCount() {
        //aqui indicamos el tamaño de la lista
        return passwordArrayList.size();
    }

    class HolderPassword extends RecyclerView.ViewHolder {

        TextView tv_item_titulo, tv_item_cuenta, tv_item_nombre_usuario, tv_item_password, tv_item_sitio_web, tv_item_nota;
        ImageButton button_mas_opciones;
        public HolderPassword(@NonNull View itemView) {
            super(itemView);
            tv_item_titulo=itemView.findViewById(R.id.tv_item_titulo);
            tv_item_cuenta=itemView.findViewById(R.id.tv_item_cuenta);
            tv_item_nombre_usuario=itemView.findViewById(R.id.tv_item_nombre_usuario);
            tv_item_password=itemView.findViewById(R.id.tv_item_password);
            tv_item_sitio_web=itemView.findViewById(R.id.tv_item_sitio_web);
            tv_item_nota=itemView.findViewById(R.id.tv_item_nota);

            button_mas_opciones=itemView.findViewById(R.id.button_mas_opciones);
        }
    }
}
