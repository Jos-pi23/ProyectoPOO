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
    private int mz;
    private int villa;
    private final int habitantes=1;
    private String urbanizacion;
    private Estado estado; 
    private ArrayList <Permiso> permisos= new ArrayList();
    
    private ArrayList <Persona> personas= Persona.getListaPersonas();
    private static ArrayList <Residente> residentes= new ArrayList();
    private Scanner entra= new Scanner (System.in);
    private static Permiso p= new Permiso();
    
    //constructor
    public Residente(){ 
    }
    //constructor 2
    public Residente(String nombre, String email, String cedula, String telefono,
        int mz, int villa, String urbanizacion, Estado estado) {
        super(nombre, email, cedula, telefono);
        this.mz = mz;
        this.villa = villa;
        this.urbanizacion = urbanizacion.toUpperCase();
        this.estado = estado;
    }
    
    //setters y getters
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

    private void setUrbanizacion(String urbanizacion) {
        this.urbanizacion = urbanizacion;
    }
    
    private void setEstado(Estado estado){
        this.estado= estado;
    }
    public static ArrayList getListaResidentes(){
        return residentes;
    }
    //carga en memoria la informacion de un residente. 
    public void inicializar(){
        Residente r0=new Residente("Daniel Villamar",
        "Daniel@java","095753","098722",
        1,1 ,"Metropolis", Estado.ACTIVO );
        personas.add(r0);
        residentes.add(r0);
    }
    /*Metodos private para definir los datos de un residente, son usa-
    -dos en definirDatos() */
    private int definirManzana(){
        System.out.println("Ingrese el numero de la manzana: ");
        int mz= entra.nextInt();
        return mz;
    }
    private int definirVilla(){
        System.out.println("Ingrese el numero de la villa: ");
        int villa= entra.nextInt();
        return villa;
    }
    private String  definirUrbanizacion(){
        System.out.println("Ingrese el nombre de la urbanizacion: ");
        entra.nextLine();
        String urbanizacion= entra.nextLine().toUpperCase();
        return urbanizacion;
    }
    public void mostrarReportes(){
        for(Permiso per: permisos){
            System.out.println(per);
        }
    }
    //cambia el estado a Inactivo. eliminacion del residente.
    @Override
    public void eliminarme(){
        this.setEstado(Estado.INACTIVO);
    }
    
    /*El residente es el que crea el permiso, por eso tiene su 
    arrayList de permisos, puede crear varios */
    public void crearPermiso(){
        
        Permiso permiso= p.permisoNuevo(this);
        if(permiso!=null){
            permisos.add(permiso);
            System.out.println("permiso creado con exito");
        }else{
            System.out.println("Oh no!algo ha salido mal, permiso no creado");
        }
        
    }
    /*cambia a inactivo el estado del permiso una vez comprueba el 
    codigo*/
    public void eliminarPermiso(){
        boolean bandera= true;
        for(Permiso p: permisos){
            if (p.getEstado().equals(Estado.ACTIVO)){
                System.out.println(p);
                System.out.println("");
            }
        }
        System.out.println("Ingrese el codigo unico para eliminar: ");
        int codigo= entra.nextInt();
        
        for(Permiso p: permisos){
            if(p.getCodigoUnico()==codigo){
                p.eliminarPermiso();
                
                bandera=false;
                break;
            }
            
        }
        if(bandera){
            System.out.println("El codigo era incorrecto o No existe "
                    + " ese permiso. REVISAR");
        }
    }
    /*Ubica al residente que viva en la mz y villa y muestra sus 
    permisos*/
    public void ubicarMzVilla(){
        boolean bandera= false;
        int indice=0;
        System.out.println("Ingrese el numero de la Manzana: ");
        String m= entra.next();
        System.out.println("Ingrese el numero de la villa: ");
        String v= entra.next();
        int mz= Integer.parseInt(m);
        int villa= Integer.parseInt(v);
        for (Residente r: residentes){
            if(r.mz==mz && r.villa==villa){
                r.mostrarPermisosMZVilla();
                bandera=true;
                break;
            }

        }
        if(bandera==false){
            System.out.println("Numeros equivocados o No hay nadie en "
                    + "  esa localidad. REVISAR");
        }
        
    }
//recorre la lista de permisos del residente y los muestra en pantalla
    public void mostrarPermisoResidente(){
        System.out.println("Permisos de  "+this.getNombre()+"{");
        for(Permiso per: permisos){
            System.out.println(per);
        }
        System.out.println("}");
    }
//metodo utilizado en "ubicarMzVilla"
    private void mostrarPermisosMZVilla(){
        System.out.println("Mostrando los permisos por mz y villa...");
        if(permisos.size()!=0){
            for(Permiso per:permisos){
            System.out.println(per);
            }
        }else{
            System.out.println("No hay permisos para mostrar...");
        }
        
    }
    //Polimorfismo de definirDatos 
    @Override
    public Persona definirDatos(){
        
        Persona p= super.definirDatos();
        int mz= definirManzana();
        int villa= definirVilla();
        String urbanizacion= definirUrbanizacion();
        Residente r=new Residente(p.getNombre(),p.getEmail(),
        p.getCedula(),p.getTelefono(),
                mz,villa,urbanizacion,Estado.ACTIVO);
        residentes.add(r);
        return r ;
    }
    
    //Polimorfismo de modificarDatos
    @Override
    public void modificarDatos(){
        super.modificarDatos();
        setMz(definirManzana());
        setVilla(definirVilla());
        setUrbanizacion(definirUrbanizacion());
    }
    @Override
    public String toString() {
        return "Residente{ " + super.toString()+ " mz= " + mz + ", villa= " 
        + villa + ", habitantes= " + habitantes + 
        ", urbanizacion= " + urbanizacion + ", estado= " + estado + '}';
    }
    
    
    
    
}
