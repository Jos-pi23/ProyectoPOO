package Usuarios;

public class Colaboradores extends Persona {

    private String puestoTrabajo;

    private String tipoEmpleado;

    public Colaboradores(String puestoTrabajo, String tipoEmpleado, String nombre, String email, int cedula, int telefono) {
        super(nombre, email, cedula, telefono);
        this.puestoTrabajo = puestoTrabajo;
        this.tipoEmpleado = tipoEmpleado;
    }
    
}
