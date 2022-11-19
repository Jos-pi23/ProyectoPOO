package Urbanizacion;
import Usuarios.*;
import Urbanizacion.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
public class Urbanizacion {
    private Scanner entra= new Scanner (System.in);
    private String nombre;

    private int etapa;

    private String email;

    private String constructora;
    private Colaborador administrador;
    private ArrayList <Persona> personas= new ArrayList();
    
    public Urbanizacion(String nombre, int etapa, String email,
            String constructora, Colaborador administrador) {
        this.nombre = nombre.toUpperCase();
        this.etapa = etapa;
        this.email = email;
        this.constructora = constructora;
        this.administrador= administrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEtapa() {
        return etapa;
    }

    public void setEtapa(int etapa) {
        this.etapa = etapa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConstructora() {
        return constructora;
    }

    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }
    //inicializarSistema
    public void inicializar(){
        personas.add(new Residente("Daniel Villamar",
        "Daniel@java",                95753,98722,
        1,1 ,"Metropolis", Estado.ACTIVO ));
        
        personas.add(new Visitante("Johanna Guerrero", 
                "Johanna@espol", 91213, 01234 ));
        
        personas.add(new Colaborador("Jose Pilligua",
        "Jose@java.com",9456,94223,
        Empleo.GUARDIA,Estado.ACTIVO,
        LocalDate.of(2022,11,16),
        LocalDate.of(2022,12,2)));
        
        personas.add(new Colaborador("Leo Villamar",
        "Leo@java.com",95357,
        97822,Empleo.GUARDIA,
        Estado.ACTIVO,
        LocalDate.of(2022,11,16),
        LocalDate.of(2022,12,2)));
    }
    //1.Urbanizacion
    public void mostrarInfoUrbanizacion(){
        System.out.println(this);    
    }
    
    

    @Override
    public String toString() {
        if (administrador == null){
            return "Urbanizacion{" + " nombre= " + nombre + ", etapa= " + etapa + 
            ", email= " + email + ", constructora= " + constructora + '}';
        }else{
            return "Urbanizacion{" + " nombre= " + nombre + ", etapa= " + etapa + 
            ", email= " + email + ", constructora= " + constructora + 
            " ADMINISTRADOR= "+ administrador+ " }";
        }
        
    }
    
}
