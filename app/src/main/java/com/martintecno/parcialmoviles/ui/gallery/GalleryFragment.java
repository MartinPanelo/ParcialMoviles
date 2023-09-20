package com.martintecno.parcialmoviles.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.martintecno.parcialmoviles.MainActivity;
import com.martintecno.parcialmoviles.NotaModelo;
import com.martintecno.parcialmoviles.databinding.FragmentGalleryBinding;

import java.util.Date;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();





        binding.BTNAgregarNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                galleryViewModel.AgregarNota(binding.ETTitulo.getText().toString(),
                        binding.ETDescripcion.getText().toString());

                    binding.ETTitulo.setText("");
                    binding.ETDescripcion.setText("");

                };

        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}