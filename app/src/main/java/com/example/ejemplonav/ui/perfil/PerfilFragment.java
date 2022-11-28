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
import com.example.ejemplonav.interfaces.IAuthService;
import com.example.ejemplonav.model.Auth;
import com.example.ejemplonav.model.AuthResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        TextView textoPrueba1 = view.findViewById(R.id.textPrueba);
        TextView textoPrueba2 = view.findViewById(R.id.textToken);

        final NavController navController = Navigation.findNavController(view);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuarioAutorizar = usuario.getText().toString();
                String passwordAutorizar = password.getText().toString();

                //Crear instancia retrofit
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://andresvportfolio.000webhostapp.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                IAuthService authService = retrofit.create(IAuthService.class);

                Auth auth = new Auth(usuarioAutorizar,passwordAutorizar);

                Call<AuthResponse> call = authService.setAuth(auth);

                call.enqueue(new Callback<AuthResponse>() {
                    @Override
                    public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                        //Display the results
                        textoPrueba2.setText(response.body().getResult().toString());
                    }

                    @Override
                    public void onFailure(Call<AuthResponse> call, Throwable t) {
                        textoPrueba2.setText("Hubo una falla al leer los datos del servidor");
                    }
                });


                //navController.navigate(R.id.navigation_servicios);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.registroFragment);
            }
        });


    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}