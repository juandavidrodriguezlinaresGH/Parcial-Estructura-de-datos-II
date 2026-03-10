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
        // Leemos todas las líneas del archivo original
    StringBuilder contenidoModificado = new StringBuilder();

    try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            // Verificamos si la línea contiene el producto a eliminar
            // split(",")[0] obtiene solo el nombre del producto (primer campo)
            // trim() elimina espacios en blanco al inicio y al final
            // equalsIgnoreCase compara sin importar mayúsculas/minúsculas
            String nombreProducto = linea.split(",")[0].trim();
            if (nombreProducto.equalsIgnoreCase(productoEliminar)) {
                // Si coincide, marcamos la línea con '#' al inicio
                contenidoModificado.append("#").append(linea).append("\n");
            } else {
                // Si no coincide, dejamos la línea tal cual
                contenidoModificado.append(linea).append("\n");
            }
        }
    } catch (IOException e) {
        System.out.println("Error al leer archivo: " + e.getMessage());
        return;
    }

    // Sobreescribimos el archivo original con el contenido modificado
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
        bw.write(contenidoModificado.toString());
    } catch (IOException e) {
        System.out.println("Error al escribir archivo: " + e.getMessage());
    }
       
        

    }

    // 2. Crear un nuevo archivo sin los registros marcados como eliminados
    public static void crearArchivoSinEliminados(String archivoOriginal, String archivoNuevo) {
        // Completar implementación
         try (
        // Abrimos el archivo original para lectura
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        // Creamos/sobreescribimos el archivo nuevo para escritura
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivoNuevo))
    ) {
        String linea;
        while ((linea = br.readLine()) != null) {
            // Solo escribimos las líneas que NO están marcadas con '#'
            // startsWith('#') detecta registros eliminados lógicamente
            if (!linea.startsWith("#")) {
                bw.write(linea);
                bw.newLine(); // Agregamos salto de línea entre registros
            }
        }
        System.out.println("Archivo actualizado creado: " + archivoNuevo);
    } catch (IOException e) {
        System.out.println("Error al procesar archivos: " + e.getMessage());
    }
    }
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String archivo = "inventario.txt";

        mostrarArchivo(archivo);

        System.out.print("Ingrese el nombre del producto para eliminar logicamente: ");
        String productoEliminar = sc.nextLine();

        marcarEliminado(archivo, productoEliminar);
        mostrarArchivo(archivo);

        String archivoActualizado = "inventario_actualizado.txt";
        crearArchivoSinEliminados(archivo, archivoActualizado);
        mostrarArchivo(archivoActualizado);

        sc.close();
    }
}
