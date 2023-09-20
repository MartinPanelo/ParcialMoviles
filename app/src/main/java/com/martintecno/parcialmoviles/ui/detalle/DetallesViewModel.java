package com.martintecno.parcialmoviles.ui.detalle;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.martintecno.parcialmoviles.NotaModelo;

public class DetallesViewModel extends AndroidViewModel {

    private Context context;


    private MutableLiveData<NotaModelo> itemM;
    public DetallesViewModel(@NonNull Application application) {
        super(application);
        context = application;
    }

    public LiveData<NotaModelo> getitemMutable(){
        if(itemM==null){

            itemM=new MutableLiveData<>();
        }
        return itemM;

    }

    public void CargarItem(Bundle bundle){


        NotaModelo NM = (NotaModelo) bundle.getSerializable("item");


     // NotaModelo NM =bundle.getSerializable("item", NotaModelo.class);

        itemM.setValue(NM);

    }





















}