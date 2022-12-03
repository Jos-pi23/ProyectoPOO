package Usuarios;
import Usuarios.*;
import Urbanizacion.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
public class Colaborador extends Persona {
    private String puestoTrabajo;
    private Empleo tipoempleado;
    private Estado estado;
    private LocalDate fechaInicioActividades;
    private LocalDate fechaFinActividades;
   
    private static ArrayList <Colaborador> colaboradores = new ArrayList();
    private ArrayList <Persona> personas= Persona.getListaPersonas();
    private Scanner entra= new Scanner (System.in);
    
    //Constructor 1
    public Colaborador(){
    }
    //Constructor 2
    public Colaborador(String nombre, String email, String cedula, 
    String telefono, Empleo tipoEmpleado, Estado estado,
    LocalDate fechaInicioActividades, LocalDate fechaFinActividades) {
        this(nombre,email,cedula,telefono,null,
        tipoEmpleado,estado,
        fechaInicioActividades,fechaFinActividades);
    }
    //Constructor 3
    public Colaborador(String nombre, String email, String cedula, 
    String telefono, String puestoTrabajo, Empleo tipoempleado, Estado estado,
    LocalDate fechaInicioActividades, LocalDate fechaFinActividades) {
        super(nombre, email, cedula, telefono);
        this.puestoTrabajo = puestoTrabajo;
        this.tipoempleado = tipoempleado;
        this.estado=estado;
        this.fechaInicioActividades=fechaInicioActividades;
        this.fechaFinActividades=fechaFinActividades;
    }
    //setters y getters
    public String getPuestoTrabajo() {
        return puestoTrabajo;
    }

    private void setPuestoTrabajo(String puestoTrabajo) {
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

    private void setFechaInicioActividades(LocalDate fechaInicioActividades){
        this.fechaInicioActividades = fechaInicioActividades;
    }

    public LocalDate getFechaFinActividades() {
        return fechaFinActividades;
    }

    private void setFechaFinActividades(LocalDate fechaFinActividades) {
        this.fechaFinActividades = fechaFinActividades;
    }

    private void setEstado(Estado estado) {
        this.estado = estado;
    }

    public static ArrayList<Colaborador> getListaColaboradores() {
        return colaboradores;
    }
    //carga en memoria los datos de 2 colaboradores
    public void inicializar(){
        Colaborador c0= new Colaborador("Jose Pilligua",
        "Jose@java.com","098484","093939",
        Empleo.GUARDIA,Estado.ACTIVO,
        LocalDate.of(2022,11,16),
        LocalDate.of(2022,12,2));
        
        Colaborador c1=new Colaborador("Leo Villamar",
        "Leo@java.com","095357",
        "092287",Empleo.GUARDIA,
        Estado.ACTIVO,
        LocalDate.of(2022,11,16),
        LocalDate.of(2022,12,2));
        colaboradores.add(c0);
        colaboradores.add(c1);
        personas.add(c0);
        personas.add(c1);
    }
    
    //Polimorfismo de definirDatos. Usa metodos privados
    @Override
    public Persona definirDatos(){
        Persona p= super.definirDatos();
        String puesto=definirPuestoTrabajo();
        Empleo empleo=definirEmpleo();
        Estado estado= definirEstado();
        System.out.println("Ingrese fecha inicio actividades"
                + "(DD/MM/YY): ");
        LocalDate inicioActividades= definirFecha();
        System.out.println("Ingrese fecha de fin actividades"
                + "((DD/MM/YY): ");
        LocalDate finActividades=definirFecha();
        Colaborador c=new Colaborador(p.getNombre(),p.getEmail(),
        p.getCedula(),p.getTelefono(),
        puesto,empleo,  estado,
        inicioActividades,finActividades);
        return c ;
    }
    //Entrada para datos tipo fecha (LocalDate)
    private LocalDate definirFecha(){
        
        String [] fecha= entra.nextLine().replace(" ","-").
                replace("/","-")
                .replace(":","-").split("-");
                
        int dia= Integer.parseInt(fecha[0]);
        int mes= Integer.parseInt(fecha[1]);
        int año= Integer.parseInt(fecha[2]);
        return  LocalDate.of(año,mes,dia);
    }
    
    private String definirPuestoTrabajo(){
       System.out.println("Ingrese el puesto de trabajo: ");
       String puesto= entra.nextLine();
       return puesto;
    }
    private Empleo definirEmpleo(){
       System.out.println("Ingrese el tipo de empleado (Guardia/Adminis"
               + "tador/Jardinero): ");
       String texto= entra.next().toUpperCase();
       return Empleo.valueOf(texto);
       
    }
    private Estado definirEstado(){
       System.out.println("Ingrese el estado del colaborador "
               + "(activo/inactivo): ");
       String texto= entra.next().toUpperCase();
       entra.nextLine();
       Estado estado = Estado.valueOf(texto);
       return estado;
    }
    
    /*Colaborador tipo Guardia verifica un permiso de la lista
    y puede añadir alguna observacion*/
    public void verificarPermisos(int codigo, String cedula){
       Permiso per= new Permiso();
       Permiso resultado = per.encontrarPermiso(codigo, cedula);
       
       if(resultado!=null && resultado.getEstado().equals(Estado.ACTIVO)){
           System.out.println("Ingrese alguna observación: ");
            String observacion= entra.nextLine();
            resultado.setObservacion(observacion);
            resultado.setGuardiaVerificador(this);
            resultado.usado();
            System.out.println(resultado);
       }else{
           System.out.println("El permiso está inactivo,"
                   + "no se encontró el permiso o el "
                   + "numero de cedula es incorrecto. REVISAR.");
       }
      
       
       
    }
   
   
    
    //Polimorfismo de modificarDatos. Usa los setters
    @Override
    public void modificarDatos(){
        super.modificarDatos();
        setPuestoTrabajo(definirPuestoTrabajo());
        setTipoempleado(definirEmpleo());
        setEstado(definirEstado());
        System.out.println("Ingrese fecha inicio actividades"
                + "(DD/MM/YY): ");
        setFechaInicioActividades(definirFecha());
        System.out.println("Ingrese fecha de fin actividades"
                + "((DD/MM/YY): ");
        setFechaFinActividades(definirFecha());
    }
    //Polimorfismo de eliminarme. estado Inactivo
    @Override
    public void eliminarme(){
        setEstado(Estado.INACTIVO);
    }
    
    
    @Override
    public String toString() {
        if(puestoTrabajo!=null){
            return "Colaborador{ " +super.toString() + 
                " puestoTrabajo=" + puestoTrabajo + 
                ",\ntipoempleado=" + tipoempleado + ", estado=" + estado + 
                ",\nfechaInicioActividades=" + fechaInicioActividades + 
                ",\nfechaFinActividades=" + fechaFinActividades + '}';
        }else{
            return "Colaborador{ " +super.toString() + 
                ",\ntipoempleado=" + tipoempleado + ", estado=" + estado + 
                ",\nfechaInicioActividades=" + fechaInicioActividades + 
                ",\nfechaFinActividades=" + fechaFinActividades + '}';
        }
        
    }
    
    
    
}
