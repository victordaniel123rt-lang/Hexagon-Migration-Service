package com.vdgarcia.Hexagon_Migration_Service.domain.model;

import java.util.List;

public class Cliente {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private List<Pedido> pedidos;



    public void actualizarDatos(Cliente cliente){
        this.nombre= cliente.getNombre();
        this.apellido= cliente.getApellido();
        this.telefono = cliente.getTelefono();
        this.email = cliente.getEmail();
    }


    public Cliente(Long id) {
        this.id = id;
    }

    public Cliente(String apellido, String email, Long id, String nombre, List<Pedido> pedidos, String telefono) {
        this.apellido = apellido;
        this.email = email;
        this.id = id;
        this.nombre = nombre;
        this.pedidos = pedidos;
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
