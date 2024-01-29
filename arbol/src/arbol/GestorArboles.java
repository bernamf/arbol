package arbol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class GestorArboles {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scan = new Scanner(System.in);
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

    public static void insertarArbol() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los detalles del árbol:");

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nombre Común: ");
        String nombreComun = scanner.nextLine();

        System.out.print("Nombre Científico: ");
        String nombreCientifico = scanner.nextLine();

        System.out.print("Habitat: ");
        String habitat = scanner.nextLine();

        System.out.print("Altura: ");
        int altura = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Origen: ");
        String origen = scanner.nextLine();

        
        try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/eh_garden", "root", "")) {
            String consulta = "INSERT INTO arboles (id, nombre_comun, nombre_cientifico, habitat, altura, origen) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
                statement.setInt(1, id);
                statement.setString(2, nombreComun);
                statement.setString(3, nombreCientifico);
                statement.setString(4, habitat);
                statement.setInt(5, altura);
                statement.setString(6, origen);

                int filasAfectadas = statement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Árbol insertado correctamente.");
                } else {
                    System.out.println("Error al insertar el árbol. Verifica los datos e intenta nuevamente.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la BBDD");
            e.printStackTrace();
        }
    }

    public static void eliminarArbol() {
        
    }

    public static void modificarArbol() {
        
    }

    public static void visualizarArboles() {
       
    }
}
