package Usuarios;

import Usuarios.Persona;

public class Residente extends Persona {

    private int mz;

    private int villa;

    private final int habitantes=1;

    private String urbanizacion;

    public Residente(int mz, int villa, String urbanizacion, String nombre, String email, int cedula, int telefono) {
        super(nombre, email, cedula, telefono);
        this.mz = mz;
        this.villa = villa;
        this.urbanizacion = urbanizacion;
    }
    
    
    
}
