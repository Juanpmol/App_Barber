package com.example.ejemplonav.ui.perfil;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ejemplonav.RetrofitInstance;
import com.example.ejemplonav.interfaces.IAuthService;
import com.example.ejemplonav.model.Auth;
import com.example.ejemplonav.model.AuthResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private MutableLiveData<AuthResponse> authorizeUserLiveData;

    public PerfilViewModel() {
        mText = new MutableLiveData<>();
        authorizeUserLiveData = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    //Retorna el JSON del post de Auth.
    public MutableLiveData<AuthResponse> getAuthObserver(){
        return authorizeUserLiveData;
    }

    public void authorizeUser(Auth auth){
        IAuthService iAuthService = RetrofitInstance.getInstance().create(IAuthService.class);
        Call<AuthResponse> call = iAuthService.setAuth(auth);
        call.enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                if (response.isSuccessful()){
                    authorizeUserLiveData.postValue(response.body());
                }
                else{
                    authorizeUserLiveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                authorizeUserLiveData.postValue(null);
            }
        });
    }

    public LiveData<String> getText() {
        return mText;
    }
}