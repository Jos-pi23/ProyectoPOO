package Usuarios;

public class Persona {

    private String nombre;

    private String email;

    private final int cedula;

    private int telefono;

    public Persona(String nombre, String email, int cedula, int telefono) {
        this.nombre = nombre;
        this.email = email;
        this.cedula = cedula;
        this.telefono = telefono;
    }
    
    
}
