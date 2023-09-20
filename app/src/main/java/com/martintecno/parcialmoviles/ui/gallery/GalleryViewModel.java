package com.martintecno.parcialmoviles.ui.gallery;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.martintecno.parcialmoviles.MainActivity;
import com.martintecno.parcialmoviles.NotaModelo;

import java.util.Date;

public class GalleryViewModel extends AndroidViewModel {


    private Context context;


    public GalleryViewModel(@NonNull Application application) {
        super(application);
        context = application;
    }


    public void AgregarNota(String titulo,String descripcion){

        if(titulo.length() > 0 && descripcion.length() > 0){

            MainActivity.notas.add(
                    new NotaModelo(titulo, descripcion , new Date()));

            Toast.makeText(context, "La tarea se agrego con exito!!", Toast.LENGTH_LONG).show();


        }else{


            Toast.makeText(context, "Todos los campos son obligatorios!!", Toast.LENGTH_LONG).show();


        }

    }








}