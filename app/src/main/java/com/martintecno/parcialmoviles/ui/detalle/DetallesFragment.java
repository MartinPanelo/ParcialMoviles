package com.martintecno.parcialmoviles.ui.detalle;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.martintecno.parcialmoviles.NotaModelo;
import com.martintecno.parcialmoviles.databinding.FragmentDetallesBinding;

import java.text.SimpleDateFormat;


public class DetallesFragment extends Fragment {

    private FragmentDetallesBinding binding;
    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");


    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DetallesViewModel detallesViewModel =
                new ViewModelProvider(this).get(DetallesViewModel.class);

        binding = FragmentDetallesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        detallesViewModel.getitemMutable().observe(getActivity(), new Observer<NotaModelo>() {
            @Override
            public void onChanged(NotaModelo itemTarea) {
                if(itemTarea != null){
                    binding.TVTituloItem.setText(itemTarea.getTitulo());
                    binding.TVDescripcionItem.setText(itemTarea.getdescripcion());
                    String fechaHoraFormateada = formato.format(itemTarea.getFechaDeCreacion());

                    binding.TVCreacion.setText(fechaHoraFormateada);

                }

            }
        });

        Bundle bundle = getArguments();

        if(bundle != null){
            detallesViewModel.CargarItem(bundle);
        }






        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}