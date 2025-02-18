package service;

import model.*;
import java.io.*;
import java.util.*;
import static constants.Constantes.ARCHIVO_PEDIDOS;

public class FuncionesPedido {

    private static final String RUTA_BASE_ARCHIVOS = "src/resources/";

    // Lee los pedidos desde el archivo
    public static List<Pedido> leerPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_BASE_ARCHIVOS + ARCHIVO_PEDIDOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                // Verifica que los datos estén bien formateados
                if (datos.length == 12) { // Asegúrate de que haya 12 datos por cada línea
                    Pedido pedido = new Pedido(
                            Integer.parseInt(datos[0]),   // idPedido
                            datos[1],                     // direccion
                            datos[2],                     // comentario
                            new Date(Long.parseLong(datos[3])), // horaPedido (convertir timestamp a Date)
                            new Date(Long.parseLong(datos[4])), // horaEstimada
                            Arrays.asList(datos[5].split(",")), // contenido (suponiendo que es una lista separada por comas)
                            Double.parseDouble(datos[6]),  // propina
                            Double.parseDouble(datos[7]),  // importe
                            datos[8],                      // medioPago
                            datos[9],                      // status
                            datos[10],                     // repAsignado
                            datos[11]                      // idCliente
                    );
                    pedidos.add(pedido);
                } else {
                    System.out.println("Línea de datos malformada: " + linea);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println("Pedidos cargados: " + pedidos.size());
        return pedidos;
    }

    // Muestra los pedidos cargados
    public static void mostrarPedidos() {
        List<Pedido> pedidos = leerPedidos();
        System.out.println("Pedidos leídos: " + pedidos.size()); // Agregar depuración
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        }
    }

    // Cambiar el estado de un pedido específico
    public static void cambiarEstadoPedido(int idPedido, String nuevoStatus) {
        List<Pedido> pedidos = leerPedidos(); // Leer todos los pedidos
        boolean encontrado = false;

        // Modificar el estado de un pedido específico
        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido() == idPedido) {
                pedido.setStatus(nuevoStatus);  // Cambia el estado del pedido
                encontrado = true;
                break;  // Sale del bucle cuando encuentra el pedido
            }
        }

        if (encontrado) {
            // Guardar los cambios en el archivo
            guardarPedidos(pedidos);
            System.out.println("Estado del pedido actualizado correctamente.");
        } else {
            System.out.println("Pedido no encontrado.");
        }
    }

    // Ver el cliente asociado a un pedido específico
    public static void verClientePorPedido(int idPedido) {
        List<Pedido> pedidos = leerPedidos();
        boolean encontrado = false;

        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido() == idPedido) {
                System.out.println("Cliente: " + pedido.getIdCliente());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Pedido no encontrado.");
        }
    }

    // Guardar los pedidos en el archivo después de cualquier modificación
    private static void guardarPedidos(List<Pedido> pedidos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_BASE_ARCHIVOS + ARCHIVO_PEDIDOS))) {
            for (Pedido pedido : pedidos) {
                bw.write(pedido.toString());  // Escribe cada pedido
                bw.newLine();  // Añade una nueva línea
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar los pedidos.");
        }
    }
    private static List<Pedido> listaPedidos;

    public static List<Pedido> getListaPedidos() {
        return listaPedidos;
    }
    public static Pedido buscarPedidoPorId(int idPedido) {
        for (Pedido pedido : listaPedidos) {
            if (pedido.getIdPedido() == idPedido) {
                return pedido;
            }
        }
        return null;
    }
}
