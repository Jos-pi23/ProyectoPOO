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
    private String empresa;
    private Estado estado;
    private ArrayList <String> sanciones= new ArrayList();
    
    private ArrayList <Persona> personas= Persona.getListaPersonas();
    private static ArrayList <Visitante> visitantes = new ArrayList();
    private Scanner entra= new Scanner (System.in);
    
    //constructor 1
    public Visitante(){
    }
    //constructor 2
    public Visitante(String nombre, String email, String cedula, String telefono,
        String empresa ,Estado estado) {
        super(nombre, email, cedula, telefono);
        this.empresa = empresa.toUpperCase();
        this.sanciones = sanciones;
        this.estado= estado;
    }
    //setters y getters
    public ArrayList<String> getSanciones() {
        return sanciones;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public static ArrayList getListaVisitantes(){
        return visitantes;
    }
    
    //carga en memoria los datos de un visitante.
    public void inicializar(){
        Visitante v0= new Visitante("Johanna Guerrero", 
                "Johanna@espol", "098383" ,
                "0948483" ,"ninguna",Estado.ACTIVO );
        visitantes.add(v0);
        personas.add(v0);
    }
    //
    
    
    
    /*Polimorfismo de definirDatos, define la empresa y el estado del
    visitante */
    @Override
    public Persona definirDatos(){
        Persona p= super.definirDatos();
        String empresa1=definirEmpresa();
        Estado estado=definirEstado();
        Visitante v= new Visitante(p.getNombre(),p.getEmail(),
        p.getCedula(),p.getTelefono(),
                empresa1,estado);
        visitantes.add(v);
        return v;
    }
    private String definirEmpresa(){
        boolean confirmacion= false;
        String empresa="";
        System.out.println("El visitante trabaja en una empresa? 1.SI 2.NO");
        int opcion=entra.nextInt();
        if(opcion==1){
            System.out.println("Escriba el nombre de la empresa: ");
            entra.nextLine();
            empresa= entra.nextLine();
            confirmacion=true;
        }else if(opcion==2){
            empresa="No pertenece a una empresa";
            
        }else{
            System.out.println("opcion no valida");
        }
        return (confirmacion)? empresa: "No pertenece a una empresa";
        
    }
    private Estado definirEstado(){
       System.out.println("Ingrese el estado del visitante "
               + "(activo/inactivo): ");
       String texto= entra.next().toUpperCase();
       entra.nextLine();
       Estado estado = Estado.valueOf(texto);
       return estado;
   }
    
    //Cambia a inactivo el estado del visitante
    @Override
    public void eliminarme(){
        setEstado(Estado.INACTIVO);
    }
    //herencia de modificarDatos
    @Override
    public void modificarDatos(){
        super.modificarDatos();
    }
    //Sobreescritura de encontrarme, busca a un visitante de la Urba.
    @Override
    public Visitante encontrarme(String cedula){
        
        for(Visitante v:visitantes){
            if(v.getCedula().equals(cedula)){
                
            }
        }
        return new Visitante();
    }
    //Permite que se pueda añadir una sancion al historial de sanciones
    public void Sancionar() {
        System.out.println("Ingrese la sancion: ");
        String Sancion = entra.nextLine().toUpperCase();
        sanciones.add(Sancion);
        
    }
    //muestra por pantalla las sanciones que tenga un visitante
    public void mostrarSanciones(){
        if(sanciones.size()!=0){
            System.out.print("Historial de sanciones de "+this.getNombre()
                    +"\n[");
            for(String sancion: sanciones){
                System.out.printf("%S ,",(sancion));
            }
            System.out.println("]");
        }else{
            System.out.println("NO CUENTA CON SANCIONES");
        }
    }
    @Override
    public String toString() {
        if(sanciones.size()==0){
            return "Visitante{ " + super.toString()+" empresa=" + empresa + 
            ", sanciones= No presenta sanciones"  + "\nEstado= "+estado+'}';
        }else{
            return "Visitante{ " +super.toString()+ " empresa=" + empresa +
            "\nEstado= "+estado+
            "\nHistorial de Sanciones de :"+this.getNombre()+ "\n "
                    + String.valueOf(sanciones);
        }
        
    }
    
    
    
}
