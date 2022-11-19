package Usuarios;
import Usuarios.*;
import Urbanizacion.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import Usuarios.Persona;

public class Residente extends Persona {
    private Scanner entra= new Scanner (System.in);
    private int mz;

    private int villa;

    private final int habitantes=1;

    private String urbanizacion;
    private Estado estado;

    public Residente(String nombre, String email, int cedula, int telefono,
        int mz, int villa, String urbanizacion) {
        super(nombre, email, cedula, telefono);
        this.mz = mz;
        this.villa = villa;
        this.urbanizacion = urbanizacion;
    }

    public Residente(String nombre, String email, int cedula, int telefono,
        int mz, int villa, String urbanizacion, Estado estado) {
        super(nombre, email, cedula, telefono);
        this.mz = mz;
        this.villa = villa;
        this.urbanizacion = urbanizacion.toUpperCase();
        this.estado = estado;
    }
    

    public int getMz() {
        return mz;
    }

    public void setMz(int mz) {
        this.mz = mz;
    }

    public int getVilla() {
        return villa;
    }

    public void setVilla(int villa) {
        this.villa = villa;
    }

    public String getUrbanizacion() {
        return urbanizacion;
    }

    public void setUrbanizacion(String urbanizacion) {
        this.urbanizacion = urbanizacion;
    }
    
    public void setEstado(Estado estado){
        this.estado= estado;
    }
    
    
    
    
}
