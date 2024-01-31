package arbol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                        	System.out.println();
                        	System.out.println();
                            insertarArbol(conexion);
                            System.out.println();
                            System.out.println();
                            break;
                        case 2:
                        	System.out.println();
                        	System.out.println();
                        	System.out.println("que arbol quieres eliminar para eso dime el id del albol");
                        	int eliminar = scanner.nextInt();
                            eliminarArbol(conexion, eliminar);
                            System.out.println();
                            System.out.println();
                            break;
                        case 3:
                        	System.out.println();
                        	System.out.println();
                            modificarArbol(conexion);
                            System.out.println();
                            System.out.println();
                            break;
                        case 4:
                        	System.out.println();
                        	System.out.println();
                            visualizarArboles(conexion);
                            System.out.println();
                            System.out.println();
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
    	 Scanner scanner = new Scanner(System.in);
         System.out.print("Ingrese el ID del árbol que desea modificar: ");
         int idModificar = scanner.nextInt();
         
         
    	
    }

    public static void visualizarArboles(Connection connection) {
    	try {
            String selectQuery = "SELECT * FROM arboles inner join habitat on arboles.id_habitat = habitat.id";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                System.out.println("Lista de Árboles:");

                // Mostrar encabezados
                System.out.printf("%-5s %-20s %-25s %-120s %-10s %-20s%n",
                        "ID", "Nombre Común", "Nombre Científico", "Habitat", "Altura", "Origen");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                // Mostrar datos de árboles
                while (resultSet.next()) {
                	Habitad habitats =  new Habitad();
                	int idHabitat = resultSet.getInt("id");
                    int id = resultSet.getInt("id");
                    String nombreComun = resultSet.getString("nombre_comun");
                    String nombreCientifico = resultSet.getString("nombre_cientifico");
                    int altura = resultSet.getInt("altura");
                    String origen = resultSet.getString("origen");
                    System.out.printf("%-5d %-20s %-25s %-120s %-10d %-20s%n",
                            id, nombreComun, nombreCientifico, habitats, altura, origen);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al intentar visualizar los árboles");
            e.printStackTrace();
        }
    }
}
