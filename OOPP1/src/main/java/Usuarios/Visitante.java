package Usuarios;

import Usuarios.Persona;

public class Visitante extends Persona {

    private String empresa;

    private String sanciones;

    public Visitante(String empresa, String sanciones, String nombre, String email, int cedula, int telefono) {
        super(nombre, email, cedula, telefono);
        this.empresa = empresa;
        this.sanciones = sanciones;
    }
    
    
}
