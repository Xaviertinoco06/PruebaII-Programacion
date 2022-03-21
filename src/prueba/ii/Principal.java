/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba.ii;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author xavie
 */
public class Principal {

    public static void main(String[] args) throws IOException {
        Itunes it = new Itunes();
        Scanner leer = new Scanner(System.in);
        int opcion = 0, cod = 0, stars = 0;
        long offset = 0;
        String nombreCancion, cantante, g, cliente;
        double precio;
        do {
            System.out.println("\n\n *** iTUNES *** \n\n");
            System.out.println("1-Codigo");
            System.out.println("2-Añadir");
            System.out.println("3-review");
            System.out.println("4-Descargar canción");
            System.out.println("5-Songs");
            System.out.println("6-Info de una canción");
            System.out.println("7-Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("\n *** Conseguir código disponible *** \n");
                    System.out.print("Ingrese el Offset (0 o 4): ");
                    offset = leer.nextLong();
                    System.out.println(it.getCodigo(offset));
                    break;

                case 2:
                    System.out.println("\n *** Añadir canción *** \n");
                    System.out.print("Nombre de la canción: ");
                    nombreCancion = leer.nextLine();
                    leer.nextLine();

                    System.out.print("Cantante: ");
                    cantante = leer.nextLine();
                    leer.nextLine();

                    System.out.print("Precio: ");
                    precio = leer.nextDouble();
                    break;

                case 3:
                    System.out.println("\n *** Hacer review de una canción *** \n");
                    System.out.print("Ingrese el código de la canción: ");
                    cod = leer.nextInt();

                    System.out.println("Ingrese las estrellas (0 a 5)");
                    stars = leer.nextInt();
                    it.reviewSong(cod, stars);
                    break;

                case 4:
                    System.out.println("\n *** Descargar canción *** \n");
                    System.out.print("Ingrese el código de la canción: ");
                    cod = leer.nextInt();

                    System.out.print("Ingrese el nombre del cliente: ");
                    cliente = leer.next();
                    it.downloadSong(cod, cliente);
                    break;

                case 5:
                    System.out.println("\n *** Songs *** \n");
                    System.out.println("Codigo: ");
                    int codigo = leer.nextInt();

                    System.out.println("Titulo: ");
                    String titulo = leer.next();

                    System.out.println("Cantante: ");
                    cantante = leer.next();

                    System.out.println("Duracion: ");
                    int duracion = leer.nextInt();

                    System.out.println("Precio: ");
                    precio = leer.nextDouble();

                    System.out.println("Posicion: ");
                    int rai = leer.nextInt();

                    break;

                case 6:
                    System.out.println("\n Informacion\n");
                    System.out.print("codigo: ");
                    cod = leer.nextInt();
                    it.infoSong(cod);
                    break;

                case 7:
                    System.out.println("\n ** Salir *** \n");
                    System.exit(0);
                    break;

                default:
                    System.err.println("Opcion no valida.");
            }
        } while (opcion != 7);
    }
}
