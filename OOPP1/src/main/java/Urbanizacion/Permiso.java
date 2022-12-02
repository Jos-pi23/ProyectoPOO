package Urbanizacion;
import java.util.Random;
import Usuarios.*;
import Urbanizacion.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
public class Permiso {
    private Estado estado;
    private LocalDateTime fechaHoraCreacion;
    private LocalDate fechaIngreso;
    private LocalTime horaIngreso;
    private Residente creador;
    private Visitante visita;
    private LocalTime duracionVisita;
    private  int codigoUnico=generarCodigo();
    private String observacion;
    private Colaborador guardiaVerificador;
    
    private ArrayList <Visitante> visitantes= Visitante.getListaVisitantes();
    private static ArrayList <Permiso> permisos= new ArrayList();
    private Scanner entra= new Scanner (System.in);
    private static Visitante creadorv= new Visitante();
    
    //Constructor 1
    public Permiso(){
    }
    //Constructor 2
    public Permiso(Estado estado, LocalDateTime fechaHoraCreacion, 
        LocalDate fechaIngreso,LocalTime horaIngreso, Residente creador, 
        Visitante visita,LocalTime duracionVisita) {
        this.estado= estado;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.fechaIngreso = fechaIngreso;
        this.horaIngreso= horaIngreso;
        this.creador = creador;
        this.visita = visita;
        this.duracionVisita = duracionVisita;
    }

    //setters y getters
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public LocalDateTime getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public LocalTime getHoraIngreso() {
        return horaIngreso;
    }
    public void setHoraIngreso(LocalTime horaIngreso) {
        this.horaIngreso = horaIngreso;
    }
    public Residente getCreador() {
        return creador;
    }
    public void setCreador(Residente creador) {
        this.creador = creador;
    }
    public Visitante getVisita() {
        return visita;
    }
    public void setVisita(Visitante visita) {
        this.visita = visita;
    }
    public LocalTime getDuracionVisita() {
        return duracionVisita;
    }
    public void setDuracionVisita(LocalTime duracionVisita) {
        this.duracionVisita = duracionVisita;
    }
    public int getCodigoUnico() {
        return codigoUnico;
    }
    public ArrayList getListaPermisos(){
        return permisos;
    }
    public String getObservacion() {
        return observacion;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public Colaborador getGuardiaVerificador() {
        return guardiaVerificador;
    }
    public void setGuardiaVerificador(Colaborador guardiaVerificador) {
        this.guardiaVerificador = guardiaVerificador;
    }
    
    //Contiene metodos que ingresan datos y crea un permiso
    public Permiso permisoNuevo(Residente r){
        boolean confirmacion= false;
        Estado estado= Estado.ACTIVO;
        LocalDateTime fechacreacion= fechaHoraCreacion();
        LocalDate fechaIngreso= definirFechaIngreso();
        LocalTime horaIngreso= definirHoraIngreso();
        //Intervalo 15min antes y despues de la hora ingresada
         if(horaIngreso!= null){
            LocalTime antes= horaIngreso.minusMinutes(15);

            System.out.println("15 minutos antes: "+antes);
            LocalTime despues= horaIngreso.plusMinutes(15);

            
            System.out.println("15minutos despues: "+despues);
        }
        //el creador es el Residente que viene por parametro
        Visitante visita=definirVisitante();
        LocalTime duracion=definirDuracionVisita();
        if(visita != null && horaIngreso !=null && duracion!=null){
            if(verificarSanciones(visita)&& 
            verificarfechaIngreso(fechaIngreso) ){
            confirmacion=true;
            }
        }
        //crea el permiso, lo guarda y lo retorna
        Permiso per= new Permiso(estado,
        fechacreacion,fechaIngreso,horaIngreso,r,
                visita,duracion);
        permisos.add(per);
        return (confirmacion)? per : null;
    }
    //Momento exacto de la creacion del permiso
    private LocalDateTime fechaHoraCreacion(){
        LocalDateTime creacion= LocalDateTime.now();
        
        return LocalDateTime.of(creacion.getYear(),
        creacion.getMonthValue(), creacion.getDayOfMonth(), 
        creacion.getHour(), creacion.getMinute());
    }
    private Visitante definirVisitante(){
        boolean confirmacion= false;
        
        System.out.println("El visitante se encuentra dentro de la lista"
                + "previa de visitantes?  1.SI  2.NO");
        int opcion= entra.nextInt();
        if(opcion==1){
            confirmacion= true;
        }
        return (confirmacion)? encontrarVisitante(): 
                (Visitante) creadorv.definirDatos();
    }
    private LocalDate definirFechaIngreso(){
        boolean confirmacion= false;
        System.out.println("Ingrese el año actual: ");
        String a= entra.next();
        int año = Integer.parseInt(a);
        System.out.println("Ingrese el mes actual: ");
        String m= entra.next();
        int mes = Integer.parseInt(m);
        System.out.println("Digite el día de ingreso: ");
        String d= entra.next();
        int dia = Integer.parseInt(d);
        LocalDateTime fechaActual=fechaHoraCreacion();
        //verificacion de la fecha. Que sea ese día o un día despues 
        if(fechaActual.getYear()== año && fechaActual.getMonthValue()==mes && 
        (fechaActual.getDayOfMonth()+1==dia || fechaActual.getDayOfMonth()==dia)){
            confirmacion=true;
        }
        return (confirmacion)? LocalDate.of(año,mes,dia):null;
    }
    //verificar que el dato de fecha ingreso no sea nulo
    private boolean verificarfechaIngreso(LocalDate fecha){
        if(fecha==null){
            System.out.println("error en la fecha de ingreso/"
                    + "permiso anticipado invalido");
        }
        return (fecha!= null)? true : false;
    }
    //Usa el metodo definir Hora para ingresar un valor.
    private LocalTime definirHoraIngreso(){
        System.out.println("Ingrese la hora de ingreso (hh-mm) : ");
        LocalTime horaIngreso=definirHora();
        return horaIngreso;
        
    }
    //Usa el metodo definir Hora para ingresar la duracion.
    private LocalTime definirDuracionVisita(){
        System.out.println("Ingrese la duracion de la visita (hh-mm) : ");
        LocalTime duracion=definirHora();
        return duracion;
    }
    /*Los valores ingresados deben estar entre (0-23) para las horas y
    (0-59) para los minutos, se trata ya de un manejo de excepciones
    mas que de un tema de validacion de datos, la cual sí se hizo,
    simplemente la clase LocalTime no admite valores que no estan en 
    lo establecido.
    */
    //Entrada y tratamiento de datos para retornar dato LocalTime
    private LocalTime definirHora(){
        boolean confirmacion=false;
        int hora,minutos;
        entra.nextLine();
        String f=entra.nextLine();
        String [] h= f.replace(" ", "-")
        .replace("/","-").replace(":", "-")
        .split("-");
        
        hora= Integer.parseInt(h[0]);
        minutos=Integer.parseInt(h[1]);
        if((hora>=0 || hora<=23) && (minutos>=0 || minutos<=59)){
            confirmacion=true;
        }
        LocalTime Hora= LocalTime.of(hora, minutos);
        return (confirmacion)? Hora: null;
    }
//verificar que el visitante no tenga sanciones para crear un permiso
    private boolean verificarSanciones(Visitante v){ 
       
        ArrayList sanciones= v.getSanciones();
        return (sanciones.size()==0)? true: false;
        
    }
    
    
    //Muestra por pantalla el estado del permiso
    public void vizualizarEstado() {
        System.out.println("fecha en el rango correcto ");
        System.out.println("ESTADO DEL PERMISO: "+this.estado);
    }
    //busca el permiso con el codigo y la cedula del visitante
    public Permiso encontrarPermiso(int codigo, String cedula){
        boolean confirmacion=false;
        int indice=0;
        for(Permiso per: permisos){
            Visitante llegando= per.getVisita();
            if(per.getCodigoUnico()==codigo && 
                    llegando.getCedula().equals(cedula) ){
                confirmacion=true;
                indice= permisos.indexOf(per);
                per.vizualizarEstado();
                break;
            }
        }
        return (confirmacion)? permisos.get(indice): null;
    }
    //Estado del permiso a inactivo
    public void eliminarPermiso(){
        setEstado(Estado.INACTIVO);
    }
    //una vez es revisado por el guardia el estado cambia a Usado
    public void usado(){
        setEstado(Estado.USADO);
    }
    //El codigo que se asigna a cada permiso es irrepetible.
    private int generarCodigo(){
        Random rd= new Random();
        int var1= rd.nextInt(100, 10000);
        int var2= rd.nextInt(100, 10000);
        
        int codigo= (var1*var2)*2;
        return codigo;
    }
    //Metodo usado cuando el permiso es para alguien en memoria.
    private Visitante encontrarVisitante(){
        System.out.println("Ingrese cedula del visitante: ");
        String cedula= entra.next();
        int posicion=0;
        boolean confirmacion= false;
        for(Visitante v :visitantes){
            if(v.getCedula().equals(cedula)){
                posicion=visitantes.indexOf(v);
                confirmacion=true;
                break;
            }
        }
        return (confirmacion)? visitantes.get(posicion):null;
    }
    @Override
    public String toString() {
        if(observacion==null || guardiaVerificador==null){
            return "Permiso{" + " Estado= "+ estado+  
        "\nfecha y hora de Creacion=" + fechaHoraCreacion +
        "\nfechaIngreso=" + fechaIngreso +  " HoraIngreso= "+ horaIngreso+
        "\ncreador=" + creador + 
        "\nvisita=" + visita + ", \nduracionVisita=" + duracionVisita + 
        "\ncodigoUnico=" + codigoUnico + "\n}";
        }else{
            return "Permiso{" + " Estado= "+ estado+  
        "\nfecha y hora de Creacion=" + fechaHoraCreacion +
        "\nfechaIngreso=" + fechaIngreso +  " HoraIngreso= "+ horaIngreso+
        "\ncreador=" + creador + 
        "\nvisita=" + visita + ", \nduracionVisita=" + duracionVisita + 
        "\ncodigoUnico=" + codigoUnico + "\nOBSERVACIONES= "+observacion+
          "\nGuaria que revisó el permiso:\n"+guardiaVerificador+"\n}";
        }
        
    }
    
    
}
