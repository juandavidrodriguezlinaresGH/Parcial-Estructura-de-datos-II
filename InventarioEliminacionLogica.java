import java.io.*;
import java.util.Scanner;

public class InventarioEliminacionLogica {
    // Método para mostrar contenido de un archivo
    public static void mostrarArchivo(String nombreArchivo) {
        System.out.println("Contenido del archivo: " + nombreArchivo);
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
        System.out.println("-------------------------");
    }

    // Métodos a implementar
    // 1. Marcar un registro como eliminado agregando '#' al inicio si coincide con el producto indicado
    public static void marcarEliminado(String nombreArchivo, String productoEliminar) {
        // Completar implementación 
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo))) {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            
            String linea;
            while ((linea = br.readLine()) != null  ) {
                if(linea)
            }
                
            System.out.println("Escritura completada.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
        

    }

    // 2. Crear un nuevo archivo sin los registros marcados como eliminados
    public static void crearArchivoSinEliminados(String archivoOriginal, String archivoNuevo) {
        // Completar implementación

    }
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String archivo = "inventario.txt";

        mostrarArchivo(archivo);

        System.out.print("Ingrese el nombre del producto para eliminar lógicamente: ");
        String productoEliminar = sc.nextLine();

        marcarEliminado(archivo, productoEliminar);
        mostrarArchivo(archivo);

        String archivoActualizado = "inventario_actualizado.txt";
        crearArchivoSinEliminados(archivo, archivoActualizado);
        mostrarArchivo(archivoActualizado);

        sc.close();
    }
}
