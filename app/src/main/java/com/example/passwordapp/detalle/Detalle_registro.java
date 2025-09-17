package com.example.passwordapp.detalle;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.passwordapp.R;

public class Detalle_registro extends AppCompatActivity {
    TextView D_Titulo, D_Cuenta, D_Nombre_Usuario, D_Password, D_Sitio_Web, D_Nota, D_Tiempo_Registro, D_Tiempo_Actualizacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_registro);
        IniciarVaribles();
    }
    private void IniciarVaribles(){
        D_Titulo = findViewById(R.id.D_Titulo);
        D_Cuenta = findViewById(R.id.D_Cuenta);
        D_Nombre_Usuario = findViewById(R.id.D_Nombre_Usuario);
        D_Password = findViewById(R.id.D_Password);
        D_Sitio_Web = findViewById(R.id.D_Sitio_Web);
        D_Nota = findViewById(R.id.D_Nota);
        D_Tiempo_Registro = findViewById(R.id.D_Tiempo_Registro);
        D_Tiempo_Actualizacion = findViewById(R.id.D_Tiempo_Actualizacion);

    }
}