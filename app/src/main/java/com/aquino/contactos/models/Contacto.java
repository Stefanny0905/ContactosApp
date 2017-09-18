package com.aquino.contactos.models;


public class Contacto {

    String nombre;
    String correo;
    String oficina;
    int telefono;

    public Contacto(){}

    public Contacto(String nombre, String correo, String oficina, int telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.oficina = oficina;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
