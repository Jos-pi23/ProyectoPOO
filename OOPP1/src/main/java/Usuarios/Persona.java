package Usuarios;
import Usuarios.*;
import Urbanizacion.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class Persona {
    private Scanner entra= new Scanner (System.in);
    private String nombre;
    private String email;
    private String cedula;
    private String telefono;
    
    private static ArrayList <Persona> personas= new ArrayList();
    //constructor 1
    public Persona(){
    }
    //constructor 2
    public Persona(String nombre, String email, String cedula, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.cedula = cedula;
        this.telefono = telefono;
    }
    
    //setters y getters
    public String getNombre() {
        return nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    protected void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }
    public static ArrayList getListaPersonas(){
        return personas;
    }
    ///
   
    protected Persona encontrarme(String cedula){
        return new Persona();
    }
    //Metodos privados para el ingreso de datos de un objeto Persona
    private String definirNombre(){
//el skip, hay que darle enter para que no se omita el definir nombre.
        
        entra.skip("\n");
        System.out.println("Ingrese nuevo nombre: ");
        
        String nombre2= entra.nextLine();
        return nombre2;
    }
    private String definirEmail(){
        System.out.println("Ingrese el correo: ");
        String correo= entra.next();
        return correo;
    }
    private String definirCedula(){
        System.out.println("Ingrese el numero de la cedula");
        String cedula= entra.next();
        return cedula;
    }
    private String definirTelefono(){
        System.out.println("Ingrese el numero de telefono: ");
        String telefono= entra.next();
        return telefono;
    }
    //Definir datos. metodo sobreecrito por las subclases de Persona
    public Persona definirDatos(){
        System.out.println("La primera vez presione enter  para continuar");
        
        String nombre=definirNombre();
        String correo= definirEmail();
        String cedula= definirCedula();
        String telefono= definirTelefono();
        return new Persona(nombre,correo,cedula,telefono);
    }
    //Modificar datos usa los setters y getters para cambiar los valores
    public void modificarDatos(){
        System.out.println("presione enter para continuar");
        setNombre(definirNombre());
        setEmail(definirEmail());
        setTelefono(definirTelefono());
    }
    //metodo que será heredado para cambiar el estado a inactivo.
    public void eliminarme(){ 
    }
    @Override
    public String toString() {
        return "nombre= " + nombre + ", email= " + email + 
        ", cedula= " + cedula + ", telefono= " + telefono + '}';
    }
    
    
    
}
