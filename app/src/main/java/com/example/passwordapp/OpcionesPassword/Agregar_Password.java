package com.example.passwordapp.OpcionesPassword;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.passwordapp.BaseDeDatos.BDHelper;
import com.example.passwordapp.MainActivity;
import com.example.passwordapp.R;

public class Agregar_Password extends AppCompatActivity {
    EditText EtTitulo,EtCuenta,EtNombreUsuario,EtPassword,EtSitioWeb,EtNota;
    String titulo,cuenta,nombre_usuario,password,sitio_web,nota;
    private BDHelper bdHelper;

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
        //aqui inicializamos las variables
        //mapeando con la parte grafica
        EtTitulo=findViewById(R.id.EtTitulo);
        EtCuenta=findViewById(R.id.EtCuenta);
        EtNombreUsuario=findViewById(R.id.EtNombreUsuario);
        EtPassword=findViewById(R.id.EtPassword);
        EtSitioWeb=findViewById(R.id.EtSitioWeb);
        EtNota=findViewById(R.id.EtNota);

        bdHelper=new BDHelper(this);
    }

    private void GuardarPassword(){
        //aqui obtenemos los datos de entrada
        titulo=EtTitulo.getText().toString().trim();
        cuenta=EtCuenta.getText().toString().trim();
        nombre_usuario=EtNombreUsuario.getText().toString().trim();
        password=EtPassword.getText().toString().trim();
        sitio_web=EtSitioWeb.getText().toString().trim();
        nota=EtNota.getText().toString().trim();

        if(titulo.isEmpty()|| cuenta.isEmpty()|| nombre_usuario.isEmpty()|| password.isEmpty()|| sitio_web.isEmpty()|| nota.isEmpty()){
            EtTitulo.setError("Campo requerido");
            EtTitulo.setFocusable(true);
            EtCuenta.setError("Campo requerido");
            EtCuenta.setFocusable(true);
            EtNombreUsuario.setError("Campo requerido");
            EtNombreUsuario.setFocusable(true);
            EtPassword.setError("Campo requerido");
            EtPassword.setFocusable(true);
            EtSitioWeb.setError("Campo requerido");
            EtSitioWeb.setFocusable(true);
            EtNota.setError("Campo requerido");
            EtNota.setFocusable(true);
            return;
        }
        try {
            String tiempo=""+System.currentTimeMillis();
            long id=bdHelper.insertarRegistro(
                    ""+titulo,
                    ""+cuenta,
                    ""+nombre_usuario,
                    ""+password,
                    ""+sitio_web,
                    ""+nota,
                    ""+tiempo,
                    ""+tiempo
            );
            if(id>0){
                Toast.makeText(this, "Registro guardado correctamente", Toast.LENGTH_SHORT).show();
                //ir al main principal
                startActivity(new Intent(Agregar_Password.this, MainActivity.class));
                finish();
            }
        }catch (Exception e){
            Toast.makeText(this, "Error al guardar el registro", Toast.LENGTH_SHORT).show();
        }

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
            GuardarPassword();
        }
        return super.onOptionsItemSelected(item);
    }
}