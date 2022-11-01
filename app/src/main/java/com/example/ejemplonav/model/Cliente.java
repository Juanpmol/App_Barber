package com.example.ejemplonav.model;

public class Cliente {

    private String celular;
    private int idCliente;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String correoCliente;
    private String passwordCliente;
    private String fechaNacimiento;
    private String direccion;
    private String ciudad;
    private String departamento;

    public Cliente(String celular, String nombre1, String apellido1, String passwordCliente) {
        this.celular = celular;
        this.nombre1 = nombre1;
        this.apellido1 = apellido1;
        this.passwordCliente = passwordCliente;
    }



    public Cliente(String celular, int idCliente, String nombre1, String nombre2, String apellido1, String apellido2, String correoCliente, String passwordCliente, String fechaNacimiento, String direccion, String ciudad, String departamento) {
        this.celular = celular;
        this.idCliente = idCliente;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correoCliente = correoCliente;
        this.passwordCliente = passwordCliente;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.departamento = departamento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getPasswordCliente() {
        return passwordCliente;
    }

    public void setPasswordCliente(String passwordCliente) {
        this.passwordCliente = passwordCliente;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
