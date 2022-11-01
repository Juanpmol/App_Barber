package com.example.ejemplonav.interfaces;

import com.example.ejemplonav.model.Cliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IClienteService {

    @GET("clientes?celular={celular}")
    Call<Cliente> getClienteById(@Path("celular") String celular);

    @GET("clientes?page={page}")
    Call <List<Cliente>> getCliente(@Path("page") int page);

    @POST("clientes/")
    Call<Cliente> setCliente(@Body Cliente nuevoCliente);

    @PUT("clientes/")
    Call<Cliente> updateCliente(Cliente cliente);

    @DELETE("clientes/")
    Call <Cliente> deleteCliente(Cliente cliente);

}
