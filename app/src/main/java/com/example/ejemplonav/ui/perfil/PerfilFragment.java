package com.example.ejemplonav.ui.perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.ejemplonav.R;
import com.example.ejemplonav.databinding.FragmentPerfilBinding;
import com.example.ejemplonav.model.Auth;

public class PerfilFragment extends Fragment {

    private FragmentPerfilBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       PerfilViewModel perfilViewModel =
                new ViewModelProvider(this).get(PerfilViewModel.class);

        binding = FragmentPerfilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textPerfil;
        //perfilViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btn1 = view.findViewById(R.id.ingresar);
        Button btn2 = view.findViewById(R.id.registro1);
        EditText usuario = view.findViewById(R.id.nameLogin);
        EditText password = view.findViewById(R.id.passwordLogin);

        final NavController navController = Navigation.findNavController(view);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuarioAutorizar = usuario.getText().toString();
                String passwordAutorizar = password.getText().toString();
                authorizeUser(usuarioAutorizar,passwordAutorizar);

                navController.navigate(R.id.navigation_servicios);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.registroFragment);
            }
        });


    }
    public void authorizeUser(String user, String password){
        Auth auth = new Auth(user,password);
    }

    private void initViewModel(){
        vModel1 = new ViewModelProvider(this).get(PerfilViewModel.class);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}