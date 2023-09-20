package com.martintecno.parcialmoviles.ui.home;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.martintecno.parcialmoviles.MainActivity;
import com.martintecno.parcialmoviles.NotaModelo;

import java.util.List;

public class HomeViewModel  extends AndroidViewModel {
    private Context context;
    private MutableLiveData<List<NotaModelo>> listaMutable;
    public HomeViewModel(@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();
    }

    public LiveData<List<NotaModelo>> getListaMutable(){
        if(listaMutable==null){

            listaMutable=new MutableLiveData<>();
        }
        return listaMutable;

    }

   public void cargarLista(){

        listaMutable.setValue(MainActivity.notas);

   }

}