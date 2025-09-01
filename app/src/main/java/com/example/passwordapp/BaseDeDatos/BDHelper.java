package com.example.passwordapp.BaseDeDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDHelper extends SQLiteOpenHelper {

    public BDHelper(@Nullable Context context) {
        super(context, Constants.BD_NAME, null,Constants.BD_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //aqui indicamos que si surge un cambio actualice tambien la version
        db.execSQL("DROP TABLE IF EXISTS "+Constants.TABLE_NAME);
        onCreate(db);
    }

    public long insertarRegistro(String titulo,String cuenta,String nombre_usuario,String password,
                                String nota,String T_registro,String T_actualizacion){
                SQLiteDatabase db =this.getWritableDatabase();

                ContentValues  values = new ContentValues();
                /*Insertamos los datos*/
                values.put(Constants.C_TITULO,titulo);
                values.put(Constants.C_CUENTA,cuenta);
                values.put(Constants.C_Nombre_USUARIO,nombre_usuario);
                values.put(Constants.C_PASSWORD,password);
                values.put(Constants.C_TIEMPO_REGISTRO,T_registro);
                values.put(Constants.C_TIEMPO_ACTUALIZACION,T_actualizacion);

                /*Insertar la fila*/
                long id=db.insert(Constants.TABLE_NAME,null,values);

                /*Cerrar conexion*/
                db.close();
                return id;
    }
}
