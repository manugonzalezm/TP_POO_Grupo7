package service;
import model.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static constants.Constantes.ARCHIVO_CARTA;
import static service.FuncionesComida.parseComida;

public class FuncionesArchivos {

    private static String RUTA_BASE_ARCHIVOS =  "src/resources/";

    private static boolean existeArchivo(String rutaArchivo) {
        // Ruta del archivo a comprobar
        File archivo = new File(rutaArchivo);

        if(archivo.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public static void leerArchivo(String rutaArchivo) {

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_BASE_ARCHIVOS + rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void escribirArchivoMenu(String nuevoPlato) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_BASE_ARCHIVOS + "carta_comidas.txt", true))) {
            // El segundo parámetro 'true' permite agregar al archivo en lugar de sobrescribir
            // Añadir una nueva línea al archivo
            bw.write(nuevoPlato);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al escribir el archivo en " + RUTA_BASE_ARCHIVOS + "carta_comidas.txt");
        }
    }

    public static void crearArchivo(String nombreArchivo, String formato) {
        // Ruta del archivo que queremos crear
        File archivo = new File(RUTA_BASE_ARCHIVOS + nombreArchivo + formato);

        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List leerArchivoCarta() {
        String rutaArchivo = ARCHIVO_CARTA;
        List cartaComidas = new ArrayList();

        if (existeArchivo(RUTA_BASE_ARCHIVOS + rutaArchivo)) {
            try (BufferedReader br = new BufferedReader(new FileReader(RUTA_BASE_ARCHIVOS + rutaArchivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(";");
                    List<String> atributos = Arrays.asList(partes);
                    cartaComidas.add(parseComida(atributos));
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("Error al determinar existencia del archivo: " + RUTA_BASE_ARCHIVOS + rutaArchivo);
        }

        return cartaComidas;
    }
}
