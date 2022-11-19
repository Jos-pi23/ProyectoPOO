package Usuarios;
import Usuarios.*;
import Urbanizacion.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import Usuarios.Persona;

public class Visitante extends Persona {
    private Scanner entra= new Scanner (System.in);
    private String empresa;

    private String sanciones;

    public Visitante(String nombre, String email, int cedula, int telefono,
        String empresa ) {
        super(nombre, email, cedula, telefono);
        this.empresa = empresa.toUpperCase();
        this.sanciones = sanciones;
    }

    public Visitante(String nombre, String email, int cedula, int telefono) {
        super(nombre, email, cedula, telefono);
    }
    
    
    
}
