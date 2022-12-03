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
    private static Residente creador= new Residente();
    private static Visitante creadorv = new Visitante();
    private static Colaborador creadorc= new Colaborador();
    private ArrayList <Persona> personas= Persona.getListaPersonas();

    private String nombre;

    private int etapa;

    private String email;

    private String constructora;
    private Colaborador administrador;
    
    
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

    public void setAdministrador(Colaborador administrador) {
        this.administrador = administrador;
    }
    
//inicializarSistema carga los datos del residente, visitante, colabs
    public void inicializar(){
        creador.inicializar();
        creadorv.inicializar();
        creadorc.inicializar(); 
    }
    
    
/*1.Urbanizacion. 
El metodo menuUrbanizacion contiene a los metodos
que permiten 1. mostrar la informacion o 2. modificarla y el metodo
modificar informacion, contiene a los metodos que ingresan los
cambios*/ 
    
    public void menuUrbanizacion(){
        mostrarInfoUrbanizacion();
        System.out.println( " 1. actualizar informacion 2. salir.");

        String opcion= entra.next();
        
        switch(opcion){
            case "1":

                System.out.println("Que desea modificar: "
                + "\n1. nombre urbanizacion 2. etapa numero, "
                        + "3. email adm . 4adm.");
                int numero= entra.nextInt();
                
                modificarInfoUrbanizacion(numero);
                System.out.println("datos actualizados correctamente");
                break;

            case "2":

                System.out.println("saliendo...");
                break;
            default:
                System.out.println("opcion invalida.");
                break;
        }
    }
    
//imprime por pantalla los datos de la urbanizacion.
    private void mostrarInfoUrbanizacion(){
        System.out.println(this);  
        
    }
//menu con opciones para modificar la informacion de la urbanizacion
    private void modificarInfoUrbanizacion(int opcion){
        entra.skip("\n");
        switch(opcion){
            case 1:
                cambiarNombreUrbanizacion();
                break;
            case 2:
                cambiarEtapaUrbanizacion();
                break;
            case 3:
                cambiarCorreoUrbanizacion();
                break;
            case 4:
                cambiarAdminUrbanizacion();
                break;
            default:
                System.out.println("No se encuentra entre las opciones"
                        + "de menu\regresando al menu principal...");
                break;
        }
        System.out.println(this);
    }
//metodos para actualizar la informacion. privados
    private void cambiarNombreUrbanizacion(){
        System.out.println("Ingrese nuevo nombre: ");
        
        String nombre= entra.nextLine().toUpperCase();
        setNombre(nombre);
    }
    private void cambiarEtapaUrbanizacion(){
        System.out.println("Ingrese el numero de la etapa: ");
        int etapa= entra.nextInt();
        setEtapa(etapa);
    }
    private void cambiarCorreoUrbanizacion(){
        System.out.println("Ingrese nuevo correo: ");
        String correo= entra.next();
        setEmail(correo);
    }
    private void cambiarAdminUrbanizacion(){
        System.out.println("Ingrese la cedula del nuevo administrador: ");
        String cedula= entra.next();
        Persona objetivo=encontrarPersona(cedula);
        if(objetivo instanceof Colaborador empleado){
            empleado.setTipoempleado(Empleo.ADMINISTRADOR);
            setAdministrador(empleado);
        }else{
            System.out.println("Esa persona no se encuentra dentro"
                    + "de los colaboradores de la Urbanizacion");
        }
        
    }
//FIN URBANIZACION
    
    
/*2. RESIDENTES 
menuResidentes, imprime por pantalla los datos carga-
-dos previamente de los residentes.
contiene los metodos que sirven para
agregar, eliminar, modificar la informacion de residentes*/
    
    public void menuResidentes(){
        this.mostrarPersonas(2);
        System.out.println("1.Agregar residentes  2. eliminar residentes"
                + "  3.modificar datos de residente 4. salir");

        String opcion= entra.next();
        entra.skip("\n");
        switch(opcion){
            case  "1"-> {
                agregarResidente();
                this.mostrarPersonas(2);
            }
            case "2"-> {
                eliminarPersonas();
                this.mostrarPersonas(2);
            }
            case "3" -> {
                modificarDatosResidente();
                this.mostrarPersonas(2);
            }
            case "4"-> System.out.println("saliendo...");
            default -> System.out.println("opcion invalida.");
        }
        
    }
   
       
/*agrega residentes y los añade a una lista dinamica
Polimorfismo de "definirDatos"*/
    private void agregarResidente(){
        
        Persona r=creador.definirDatos();
        personas.add(r);
        System.out.println("agregado con exito!");
    }

//modifica los datos de un residente. Usa "modificarInformacion".
    private void modificarDatosResidente(){
        modificarInformacion();
        
    }
//FIN RESIDENTES
    
/*3. Visitantes 
menu Visitantes contiene los metodos que agregan, eliminan
modifican y sancionan a un visitante.usa eliminar persona.*/
    public void menuVisitantes(){
        mostrarPersonas(3);
        System.out.println("1.Agregar visitantes  2. eliminar visitantes"
                + "  3.modificar datos de visitante "
                + "4. sancionar visitante 5. salir");

        String opcion=entra.next();
        switch(opcion){
            case "1":

                agregarVisitante();
                this.mostrarPersonas(3);
                break;

            case "2":
                eliminarPersonas();
                this.mostrarPersonas(3);
                break;
            case "3":
                modificarDatosVisitante();
                this.mostrarPersonas(3);
                break;
            case "4":
                sancionarVisitante();
                this.mostrarPersonas(3);
                break;
            case "5":
                System.out.println("saliendo...");
                break;
            default:
                System.out.println("opcion invalida.");
                break;
        }
        
    }
/*agrega un visitante a una lista dinamica. 
Polimorfismo de "definirDatos"*/
    private void agregarVisitante(){
        
        Persona v= creadorv.definirDatos();
        personas.add(v);
        System.out.println("visitante agregado con exito");
        
    }
//modifica los datos de un visitante Usa "modificarInformacion".
    private void modificarDatosVisitante(){
        modificarInformacion();
        System.out.println("informacion actualizada con exito");
    }
//añade una sancion(texto) a un historial de sanciones a un visitante
    private void sancionarVisitante(){
        System.out.println("Ingrese la cedula del visitante a sancionar: ");
        String cedula= entra.next();
        Persona infractor= encontrarPersona(cedula);
        if(infractor !=null && infractor instanceof Visitante){
            Visitante sancionado = (Visitante) infractor;
            sancionado.Sancionar();
            System.out.println("sancionado con exito\n");
            
        }else{
            System.out.println("No es un visitante registrado");
        }
    }
   
    
//FIN VISITANTES
    
/*4. Colaboradores 
menuColaboradores contiene las diferentes opciones
que se pueden realizar . agregar, eliminar, modificar datos*/
    public void menuColaboradores(){
        mostrarPersonas(4);

        System.out.println("1.Agregar  colaborador  2. eliminar  colaborador"
                + "  3.modificar datos de colaborador 4. salir");

        String opcion=entra.next();

        switch(opcion){
            case "1" -> {
                System.out.println("colaborador agregado!");
                this.mostrarPersonas(4);
            }
            case "2" -> {
                eliminarPersonas();
                this.mostrarPersonas(4);
            }
            case "3" -> {
                modificarDatosColaboradores();
                this.mostrarPersonas(4);
            }
            case "4"-> System.out.println("saliendo...");
            default -> System.out.println("opcion invalida.");
        }
        
    
    }
//metodo para agregar colaboradores. Polimorfismo de "definirDatos".
    private void agregarColaborador(){
        
        Persona c= creadorc.definirDatos();
        personas.add(c);
    }
//modificar los datos de colaboradores. Usa "modificarInformacion".
    private void modificarDatosColaboradores(){
        modificarInformacion();
    }
   
//FIN COLABORADORES.
    
/*5.Permisos de Entrada 
menu Permisos contiene los metodos para crear, eliminar,
consultar los permisos*/
    public void menuPermisos(){
         System.out.println("1. Crear permisos de entrada\n2. Eliminar permiso"
        + " de entrada\n3. Consultar permisos por manzana y villa"
                 + "\n4. saliendo");

        String opcion=entra.next();
        switch(opcion){
            case "1": 
               crearPermiso();

               break;
            case "2":
                eliminarPermiso();
                
                break;
            case "3":
                consultarPermisosMZVilla();
                break;
            case "4":
                    System.out.println("saliendo...");
                break;
            default:
                System.out.println("opcion invalida.");
       }
    }
/*Usa "encontrarPersona" un residente crea el permiso y lo guarda
en sus registros de permisos creados*/
    private void crearPermiso(){
        System.out.println("Ingrese la cedula del residente que va a crear"
                + " el permiso: ");
        entra.nextLine();
        String cedula= entra.nextLine();
        Persona per =encontrarPersona(cedula);
        
        if( per !=null &&  per instanceof Residente){
            Residente creador= (Residente) per;
            creador.crearPermiso();
            creador.mostrarPermisoResidente();
        }else{
            System.out.println("Error, numero de cedula incorrecto...");
        }
    }
//cambia el estado a inactivo de un permiso
    private void eliminarPermiso(){
        System.out.println("Ingrese la cedula del residente para mostrar per"
                + "misos: ");
        entra.nextLine();
        String cedula= entra.nextLine();
        Persona per=encontrarPersona(cedula);
        if(per!=null && per instanceof Residente){
            Residente r= (Residente) per;
            r.eliminarPermiso();
            System.out.println("permiso eliminado");
        }else{
            System.out.println("Error, numero de cedula incorrecto...");
        }
    }
/*Se consulta la manzana y villa de un residente. se muestran sus 
    permisos*/
    private void consultarPermisosMZVilla(){
       creador.ubicarMzVilla();
    }

//FIN PERMISOS de entrada.
    
//6. Revision de Ingreso.menuRevision Usa entradaUrbanizacion.
    public void menuRevision(){
        entradaUrbanizacion();
    }
//revisa el codigo del permiso y la cedula del residente
    private void entradaUrbanizacion(){
        System.out.println("Ingrese el codigo del permiso:" );
        int codigo= Integer.parseInt(entra.next());
        System.out.println("Ingrese la cedula del visitante "
                + "para confirmacion: ");
        String cedula =entra.next();
        
        for(Persona c:personas){
            if (c instanceof Colaborador){
                Colaborador guardia= (Colaborador)c;
                if(guardia.getTipoempleado().equals(Empleo.GUARDIA)){
                    guardia.verificarPermisos(codigo, cedula);
                    break;
                }
            }
            
        }
    }
//FIN REVISION ENTRADA.
    
//7.reportes menuReportes Usa "Reportes()".
    public void menuReportes(){
        reportes();
}
//De un residente muestra todos los reportes creados
    public void reportes(){
        System.out.println("Ingrese la cedula del residente: ");
        
        String cedula= entra.nextLine();
        Persona p=encontrarPersona(cedula);
        if(p!=null && p instanceof Residente){
            Residente residenteObjetivo= (Residente)p;
            residenteObjetivo.mostrarReportes();
        }else{
            System.out.println("no hay reportes para mostrar...");
        }
    }
        
/*Metodo usado por residentes, visitantes, colaboradores, con una ce-
-dula encuentra un objeto y emplea polimorfismo de "modificarDatos()"*/
    private void modificarInformacion(){
        System.out.println("Ingrese la cedula para  modificar datos: ");
        Persona objetivo=encontrarPersona(entra.next());
        if (objetivo !=null){
            objetivo.modificarDatos();
            System.out.println("datos modificados");
        }else{
            System.out.println("Esa persona no se Encuentra en la Urbanización");
        }
    }

/*Metodo que encuentra un objeto Persona usando su cedula
y lo retorna */
    private Persona encontrarPersona(String cedula){
        int posicionPersona=0;
        boolean confirmacion= false;
        for(Persona persona :personas){
            if(persona.getCedula().equals(cedula)){
                posicionPersona=personas.indexOf(persona);
                confirmacion=true;
                break;
            }
        }
        return (confirmacion)? personas.get(posicionPersona):null;
    }
/*Recorre la lista de Personas y hace un downcasting para diferenciar
entre residentes, visitantes y colaboradores*/
    private void mostrarPersonas(int opcion){
        for(Persona persona: personas){
             if(opcion==2 && persona instanceof Residente ){
                 
                System.out.println(persona);
                System.out.println("");
            }else if(opcion==3 && persona instanceof Visitante){
                System.out.println(persona);
                System.out.println("");
            }else if(opcion==4 && persona instanceof Colaborador){

                System.out.println(persona);
                System.out.println("");
            }
        }
    }
/*cambia el estado a Inactivo las Personas de la urbanizacion
lo usan residentes, visitantes y colaboradores*/
    private void eliminarPersonas(){
        System.out.println("Ingrese la cedula de la persona a eliminar");
        String cedula= entra.next();
        Persona eliminado= encontrarPersona(cedula);
        if(eliminado!=null){
            
            eliminado.eliminarme();
            System.out.println("eliminado con exito");
        }else{
            System.out.println("Esa persona no esta registrada");
        }
    }

    @Override
    public String toString() {
        if (administrador == null){
            return "Urbanizacion{" + " nombre= " + nombre + ", etapa= " + etapa + 
            ", email= " + email + ",\nconstructora= " + constructora + 
                    " No hay administrador " +'}';
        }else{
            return "Urbanizacion{" + " nombre= " + nombre + ", etapa= " + etapa + 
            ", email= " + email + ",\nconstructora= " + constructora + 
            "\nADMINISTRADOR= "+ administrador+ " }";
        }
        
    }
    
}
