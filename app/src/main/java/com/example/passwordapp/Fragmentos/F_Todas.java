package com.example.passwordapp.Fragmentos;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.passwordapp.Adaptador.Adaptador_password;
import com.example.passwordapp.BaseDeDatos.BDHelper;
import com.example.passwordapp.BaseDeDatos.Constants;
import com.example.passwordapp.OpcionesPassword.Agregar_Password;
import com.example.passwordapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class F_Todas extends Fragment {

    BDHelper bdHelper;
    //el recycler view se inicializa
    RecyclerView recyclerView_List_Registros;
    FloatingActionButton FAB_AgregarPassword;
    // esto es para mostrar la vista de dialogo
    Dialog dialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_f__todas, container, false);

       //AQUI TENEMOS QUE INICIALIZAR EL BOTON
        FAB_AgregarPassword= view.findViewById(R.id.FAB_AgregarPassword);
        recyclerView_List_Registros=view.findViewById(R.id.recyclerView_List_Registros);
        //con esto le pasamos el contexto de la actividad
        bdHelper=new BDHelper(getActivity());

        //aqui inicializamps el dialogo
        dialog=new Dialog(getActivity());

        CargarRegistros();
        //agregamos un evento para que si da click entonces lo redireccion a la otra vista
        FAB_AgregarPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Agregar_Password.class));
            }
        });

       return  view;
    }

    private void CargarRegistros() {
        Adaptador_password adaptador_password=new Adaptador_password(getActivity(),bdHelper.ObtenerTodosRegistros(
                Constants.C_TITULO+" ASC"));
        recyclerView_List_Registros.setAdapter(adaptador_password);

    }

    //buscar registros
    private void BuscarRegistros(String Consulta){
        Adaptador_password  adaptador_password= new Adaptador_password(getActivity(),bdHelper.BuscarRegistros(Consulta));
        recyclerView_List_Registros.setAdapter(adaptador_password);
    }

    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater){
        inflater.inflate(R.menu.menu_fragmento_todos,menu);

        MenuItem item=menu.findItem(R.id.menu_Buscar_Registros);
        SearchView searchView=(SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                //esto lo que haces es buscar cuando le pica el boton de buscar
                BuscarRegistros(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //esto lo que haces es buscar cuando escribes algo
                BuscarRegistros(newText);
                return true;
            }
        });
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.menu_Numeros_Registros){
            Visualizer_Total_Registros();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    public void Visualizer_Total_Registros(){
        TextView Total;
        Button Btn_EntendidoTotal;
        dialog.setContentView(R.layout.cuadro_dialogo_total_registro);
        //mapear los elementos del cuadro de dialogo
        Total=dialog.findViewById(R.id.total);
        Btn_EntendidoTotal=dialog.findViewById(R.id.Btn_EntendidoTotal);

       //obtener el valor de entero de registros
        int total=bdHelper.ObtenerCantidadRegistros();
        String total_string=String.valueOf(total);
        Total.setText(total_string);
        Btn_EntendidoTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
        dialog.setCancelable(false);
    }
    }