package com.martintecno.parcialmoviles.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.martintecno.parcialmoviles.NotaModelo;
import com.martintecno.parcialmoviles.R;
import com.martintecno.parcialmoviles.databinding.FragmentHomeBinding;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



/*        --------------*/

        homeViewModel.getListaMutable().observe(getActivity(), new Observer<List<NotaModelo>>() {
            @Override
            public void onChanged(List<NotaModelo> listaTareas) {
                RecyclerView rv=binding.RVTareas;
                GridLayoutManager glm=new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);
                rv.setLayoutManager(glm);
                NotaAdapter notaAdapter=new NotaAdapter(listaTareas,getActivity(),getLayoutInflater());
                rv.setAdapter(notaAdapter);
            }
        });
        homeViewModel.cargarLista();

      /*  --------------------*/


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}