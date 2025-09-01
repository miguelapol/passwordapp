package com.example.passwordapp.Fragmentos;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.passwordapp.OpcionesPassword.Agregar_Password;
import com.example.passwordapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class F_Todas extends Fragment {
    FloatingActionButton FAB_AgregarPassword;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_f__todas, container, false);

       //AQUI TENEMOS QUE INICIALIZAR EL BOTON
        FAB_AgregarPassword= view.findViewById(R.id.FAB_AgregarPassword);

        //agregamos un evento para que si da click entonces lo redireccion a la otra vista
        FAB_AgregarPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Agregar_Password.class));
            }
        });

       return  view;
    }
}