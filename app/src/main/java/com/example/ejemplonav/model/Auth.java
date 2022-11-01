package com.example.ejemplonav.model;

import com.google.gson.annotations.SerializedName;

public class Auth {
    @SerializedName("celular")
    private String celular;
    @SerializedName("passwordCliente")
    private String passwordCliente;

    public Auth(String celular, String passwordCliente) {
        this.celular = celular;
        this.passwordCliente = passwordCliente;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getPasswordCliente() {
        return passwordCliente;
    }

    public void setPasswordCliente(String passwordCliente) {
        this.passwordCliente = passwordCliente;
    }
}
