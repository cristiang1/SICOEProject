package Vista;

import Controlador.Controlador;
import java.util.Scanner;

public class Inicio {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("####################### ACCIONES ##########################");
        System.out.println("Listar productos               1");
        System.out.println("Venta productos mes julio 2020 2");
        System.out.println("No vendidos mes julio 2020     3");
        System.out.println("Ventas por cliente             4");
        System.out.println("###########################################################");

        System.out.print("Elige la opción: ");
        Controlador controlador = new Controlador();
        int opcion = scanner.nextInt();
        controlador.Selector(opcion);
    }
}
