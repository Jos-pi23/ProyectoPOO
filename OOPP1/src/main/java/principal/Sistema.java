/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package principal;
import java.util.Scanner;
import Usuarios.*;
import Urbanizacion.*;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
/**
 *
 * @author DANIEL
 */
public class Sistema {
    public static Scanner entra= new Scanner(System.in);

    public static void main(String[] args) {
        //Carga en memoria los datos de urbanizacion y personas dentro.
        Urbanizacion u1= inicializarSistema();
        int valorMenu;
        do{
            System.out.println("-----Menú del Sistema-------");
            System.out.println("1.Urbanizacion\n2.Residentes\n3.Visitantes"
            + "\n4.Colaboradores de la Urbanizacion"
            + "\n5.Permisos de entrada"
            + "\n6.Revision de entrada"
            + "\n7.Reportes"
            + "\n8.Salir\n");

            System.out.print("Elija una opción: ");
            valorMenu= entra.nextInt();
            switch(valorMenu){
                case 1: 
                    System.out.println("\tUrbanizacion\n");
                    menuUrbanizacion(u1);
                    break;
                case 2:
                    System.out.println("\tResidentes\n");
                    menuResidentes(u1);
                    break;
                case 3:
                    System.out.println("\tVisitantes\n");
                    menuVisitantes(u1);
                    break;
                case 4:
                    System.out.println("\tColaboradores de la Urbanización\n");
                    menuColaboradores(u1);
                    break;
                case 5:
                    System.out.println("\tPermisos de entrada\n");
                    menuPermisos(u1);
                    break;
                case 6: 
                    System.out.println("\tRevision de entrada\n");
                    menuRevision(u1);
                    break;
                case 7: 
                    System.out.println("\tReportes\n");
                    menuReportes(u1);
                    break;
                case 8:
                    System.out.println("\tSaliendo del sistema...");
                    break;
                default:
                    System.out.println("Ese numero no se encuentra entre las"
                            + " opciones del menú");
            }
        }while(valorMenu !=8);
    }
    //Los datos de la urbanizacion
    public static Urbanizacion  inicializarSistema(){
        Urbanizacion u1= new Urbanizacion("Metropolis",1,
        "adminMetropolis@out.com","Constructora BBB",
        null);
        
        u1.inicializar();
        
        return u1;
    }
    //Los metodos de los diferentes apartados del menú.
    public static void menuUrbanizacion(Urbanizacion u){
        
        u.menuUrbanizacion();
    }
    public static void menuResidentes(Urbanizacion u){
        u.menuResidentes();
    }
    
    public static void menuVisitantes(Urbanizacion u){
        u.menuVisitantes();
        
    }
    public static void menuColaboradores(Urbanizacion u){
        u.menuColaboradores();
    }
    public static void menuPermisos(Urbanizacion u){
        
        u.menuPermisos();
    }
    public static void menuRevision(Urbanizacion u){
        u.menuRevision();
    }
    public static void menuReportes(Urbanizacion u){
        u.menuReportes();
    }
}
