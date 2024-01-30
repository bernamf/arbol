package arbol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GestorArboles {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        final String HOST = "localhost";
        final String BBDD = "eh_garden";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Crear la conexión utilizando try-with-resources
            try (Connection conexion = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + BBDD, USERNAME, PASSWORD)) {
                do {
                    System.out.println("Menú Principal:");
                    System.out.println("1. Insertar árbol");
                    System.out.println("2. Eliminar árbol");
                    System.out.println("3. Modificar información del árbol");
                    System.out.println("4. Visualizar árboles");
                    System.out.println("0. Salir");
                    System.out.print("Ingrese su opción: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (opcion) {
                        case 1:
                            insertarArbol(conexion);
                            break;
                        case 2:
                        	System.out.println("que arbol quieres eliminar para eso dime el id del albol");
                        	int eliminar = scanner.nextInt();
                            eliminarArbol(conexion, eliminar);
                            break;
                        case 3:
                            modificarArbol(conexion);
                            break;
                        case 4:
                            visualizarArboles(conexion);
                            break;
                        case 0:
                            System.out.println("Saliendo de la aplicación.");
                            break;
                        default:
                            System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                    }
                } while (opcion != 0);
            } catch (SQLException e) {
                System.out.println("Error al conectar con la BBDD");
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar la librería mysql conector");
            e.printStackTrace();
        }
    }

    public static void insertarArbol(Connection connection) {
        try {
            String insertQuery = "INSERT INTO arboles (nombre_comun, nombre_cientifico, habitat, altura, origen) VALUES (?, ?, ?, ?, ?)";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                
                Scanner scanner = new Scanner(System.in);
                System.out.println("Ingrese los detalles del árbol:");
                System.out.print("Nombre Común: ");
                preparedStatement.setString(1, scanner.nextLine());

                System.out.print("Nombre Científico: ");
                preparedStatement.setString(2, scanner.nextLine());

                System.out.print("Habitat: ");
                preparedStatement.setString(3, scanner.nextLine());

                System.out.print("Altura: ");
                preparedStatement.setInt(4, scanner.nextInt());
                scanner.nextLine(); // Consumir la nueva línea después de nextInt()

                System.out.print("Origen: ");
                preparedStatement.setString(5, scanner.nextLine());

                // Ejecutar la inserción
                preparedStatement.executeUpdate();
                System.out.println("Árbol insertado correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al intentar insertar el árbol");
            e.printStackTrace();
        }
    }

    public static void eliminarArbol(Connection connection, int arbolId) {
    	try {
            // Crear la sentencia de eliminación
            String deleteQuery = "DELETE FROM arboles WHERE id = " + arbolId;

            // Ejecutar la sentencia
            Statement statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate(deleteQuery);

            // Verificar si la tarea fue eliminada exitosamente
            if (rowsAffected > 0) {
                System.out.println("Tarea eliminada exitosamente.");
            } else {
                System.out.println("No se encontró la tarea con ID " + arbolId);
            }

            // Cerrar el statement
            statement.close();

        } catch (SQLException e) {
            System.out.println("Error al intentar eliminar la tarea");
            e.printStackTrace();
        }
    }    

    public static void modificarArbol(Connection connection) {
        // Implementa la lógica para modificar la información de un árbol utilizando consultas SQL
    }

    public static void visualizarArboles(Connection connection) {
        // Implementa la lógica para visualizar los árboles utilizando consultas SQL y mostrar los resultados
    }
}
