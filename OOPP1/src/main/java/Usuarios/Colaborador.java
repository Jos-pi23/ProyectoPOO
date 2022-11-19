package Usuarios;
import Usuarios.*;
import Urbanizacion.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
public class Colaborador extends Persona {
    private Scanner entra= new Scanner (System.in);
    private String puestoTrabajo;
    private Empleo tipoempleado;
    private Estado estado;
    private LocalDate fechaInicioActividades;
    private LocalDate fechaFinActividades;
   

    public Colaborador(String nombre, String email, int cedula, int telefono,
     Empleo tipoEmpleado, Estado estado,
    LocalDate fechaInicioActividades, LocalDate fechaFinActividades) {
        super(nombre, email, cedula, telefono);
        this.puestoTrabajo = puestoTrabajo;
        
        this.tipoempleado = tipoEmpleado;
        this.estado=estado;
        this.fechaInicioActividades=fechaInicioActividades;
        this.fechaFinActividades=fechaFinActividades;
        
    }

    public Colaborador(String nombre, String email, int cedula, int telefono,
        String puestoTrabajo, Empleo tipoempleado) {
        super(nombre, email, cedula, telefono);
        this.puestoTrabajo = puestoTrabajo;
        this.tipoempleado = tipoempleado;
    }

    public Scanner getEntra() {
        return entra;
    }

    public void setEntra(Scanner entra) {
        this.entra = entra;
    }

    public String getPuestoTrabajo() {
        return puestoTrabajo;
    }

    public void setPuestoTrabajo(String puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }

    public Empleo getTipoempleado() {
        return tipoempleado;
    }

    public void setTipoempleado(Empleo tipoempleado) {
        this.tipoempleado = tipoempleado;
    }

    public LocalDate getFechaInicioActividades() {
        return fechaInicioActividades;
    }

    public void setFechaInicioActividades(LocalDate fechaInicioActividades) {
        this.fechaInicioActividades = fechaInicioActividades;
    }

    public LocalDate getFechaFinActividades() {
        return fechaFinActividades;
    }

    public void setFechaFinActividades(LocalDate fechaFinActividades) {
        this.fechaFinActividades = fechaFinActividades;
    }
    
    
    
}
