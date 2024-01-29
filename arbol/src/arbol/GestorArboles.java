package arbol;

import java.util.Scanner;

public class GestorArboles {

	public static void main(String[] args) {
		run();
	}
	public static void run() {
		Scanner scan = new Scanner (System.in);
		int opcion;
		
		do {
            System.out.println("Menú Principal:");
            System.out.println("1. Insertar árbol");
            System.out.println("2. Eliminar árbol");
            System.out.println("3. Modificar información del árbol");
            System.out.println("4. Visualizar árboles");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    insertarArbol();
                    break;
                case 2:
                    eliminarArbol();
                    break;
                case 3:
                    modificarArbol();
                    break;
                case 4:
                    visualizarArboles();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 0);
    }
		
	}
	

}
