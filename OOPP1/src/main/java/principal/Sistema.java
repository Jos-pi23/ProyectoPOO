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
        System.out.println("-----Menú del Sistema-------");
        System.out.println("1.Urbanizacion\n2.Residentes\n3.Visitantes"
        + "\n4.Colaboradores de la Urbanizacion"
        + "\n5.Permisos de entrada"
        + "\n6.Revision de entrada"
        + "\n7.Reportes"
        + "\n8.Salir\n");

        //metodo incializarSistema();
        
        System.out.print("Elija una opción: ");
        int valorMenu= entra.nextInt();
        //AQUI IRAN LOS CAMPOS DE CODIGO PARA CADA ACCION, COMO ES UN MENÚ USAMOS SWITCH
        switch(valorMenu){
            case 1: 
                System.out.println("Urbanizacion");
                break;
            case 2:
                System.out.println("Residentes");
                break;
            case 3:
                System.out.println("Visitantes");
            case 4:
                System.out.println("Colaboradores de la Urbanización");
                break;
            case 5:
                System.out.println("Permisos de entrada");
                break;
            case 6: 
                System.out.println("Revision de entrada");
                break;
            case 7: 
                System.out.println("Reportes");
            case 8:
                System.out.println("Saliendo del sistema...");
                break;
            default:
                System.out.println("Ese numero no se encuentra entre las opciones del menú");
        }
        
        
    }
}
