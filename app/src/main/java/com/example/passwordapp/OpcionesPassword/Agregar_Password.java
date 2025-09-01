package com.example.passwordapp.OpcionesPassword;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.passwordapp.R;

public class Agregar_Password extends AppCompatActivity {
EditText EtTitulo,EtCuenta,EtNombreUsuario,EtPassword,EtSitioWeb,EtNota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_password);

        ActionBar actionBar=getSupportActionBar();
        assert  actionBar!=null;
        actionBar.setTitle("");

        InicializarVariables();
    }
    //Inicializar Variables
    private void InicializarVariables(){
        EtTitulo=findViewById(R.id.EtTitulo);
        EtCuenta=findViewById(R.id.EtCuenta);
        EtNombreUsuario=findViewById(R.id.EtNombreUsuario);
        EtPassword=findViewById(R.id.EtPassword);
        EtSitioWeb=findViewById(R.id.EtSitioWeb);
        EtNota=findViewById(R.id.EtNota);
    }


    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_guardar,menu);
        return  super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.Guardar_Password){
            Toast.makeText(this, "Guardar password", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}