package com.example.passwordapp.detalle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.passwordapp.BaseDeDatos.BDHelper;
import com.example.passwordapp.BaseDeDatos.Constants;
import com.example.passwordapp.R;

import java.util.Calendar;
import java.util.Locale;

public class Detalle_registro extends AppCompatActivity {
    TextView D_Titulo, D_Cuenta, D_Nombre_Usuario, D_Password, D_Sitio_Web, D_Nota, D_Tiempo_Registro, D_Tiempo_Actualizacion;
    String id_registro;

    BDHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_registro);

        ActionBar actionBar=getSupportActionBar();

        Intent intent=getIntent();
        //recibimos el dato id_registro
        id_registro=intent.getStringExtra("id_registro");
        Toast.makeText(this, "Id del registros"+id_registro, Toast.LENGTH_SHORT).show();
        dbHelper=new BDHelper(this);
        IniciarVaribles();
        MostrarInformacionRegistro();

        //obtener titulo del registro
        String titulo_registro=D_Titulo.getText().toString();
        assert actionBar != null;
        actionBar.setTitle(titulo_registro);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

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
    private void  MostrarInformacionRegistro(){
        String consulta="SELECT * FROM "+ Constants.TABLE_NAME+" WHERE "+Constants.C_ID+"='"+id_registro+"'";
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        Cursor cursor=db.rawQuery(consulta,null);
        if(cursor.moveToFirst()){
            do {
                @SuppressLint("Range") String id = "" + cursor.getInt(cursor.getColumnIndex(Constants.C_ID));
                @SuppressLint("Range") String titulo = "" + cursor.getString(cursor.getColumnIndex(Constants.C_TITULO));
                @SuppressLint("Range") String cuenta = "" + cursor.getString(cursor.getColumnIndex(Constants.C_CUENTA));
                @SuppressLint("Range") String nombre_usuario = "" + cursor.getString(cursor.getColumnIndex(Constants.C_Nombre_USUARIO));
                @SuppressLint("Range") String password = "" + cursor.getString(cursor.getColumnIndex(Constants.C_PASSWORD));
                @SuppressLint("Range") String sitio_web = "" + cursor.getString(cursor.getColumnIndex(Constants.C_SITIO_WEB));
                @SuppressLint("Range") String nota = "" + cursor.getString(cursor.getColumnIndex(Constants.C_NOTA));
                @SuppressLint("Range") String t_registro = "" + cursor.getString(cursor.getColumnIndex(Constants.C_TIEMPO_REGISTRO));
                @SuppressLint("Range") String t_actualizacion = "" + cursor.getString(cursor.getColumnIndex(Constants.C_TIEMPO_ACTUALIZACION));
                //Convertir tiempo a dia/mes/año 12: 00 am-pm
                //tiempo registro
                Calendar calendar_t_r=Calendar.getInstance(Locale.getDefault());
                calendar_t_r.setTimeInMillis(Long.parseLong(t_registro));
                String tiempo_registro= ""+ DateFormat.format("dd/MM/yyyy hh:mm:aa",calendar_t_r);

                //tiempo actualizacion
                Calendar calendar_t_a=Calendar.getInstance(Locale.getDefault());
                calendar_t_a.setTimeInMillis(Long.parseLong(t_actualizacion));
                String tiempo_actualizacion= ""+ DateFormat.format("dd/MM/yyyy hh:mm:aa",calendar_t_a);

                D_Titulo.setText(titulo);
                D_Cuenta.setText(cuenta);
                D_Nombre_Usuario.setText(nombre_usuario);
                D_Password.setText(password);
                D_Sitio_Web.setText(sitio_web);
                D_Nota.setText(nota);
                D_Tiempo_Registro.setText(tiempo_registro);
                D_Tiempo_Actualizacion.setText(tiempo_actualizacion);

            }while (cursor.moveToNext());
        }
        db.close();
    }


    //Aqui lo que haremos cuando de retroceso retrocesa a la actividad
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}