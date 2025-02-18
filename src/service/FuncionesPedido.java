package service;

import model.*;
import java.io.*;
import java.util.*;
import static constants.Constantes.ARCHIVO_PEDIDOS;

public class FuncionesPedido {
    private static final String RUTA_BASE_ARCHIVOS = "src/resources/";

    public static List<Pedido> leerPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_BASE_ARCHIVOS + ARCHIVO_PEDIDOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");


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
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println("Pedidos cargados: " + pedidos.size());
        return pedidos;
    }


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


    public static void cambiarEstadoPedido(int idPedido, String nuevoStatus) {
        List<Pedido> pedidos = leerPedidos(); // Leer todos los pedidos
        boolean encontrado = false;

        // Modificar el estado de un pedido específico
        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido() == idPedido) {
                pedido.setStatus(nuevoStatus);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_BASE_ARCHIVOS + ARCHIVO_PEDIDOS))) {
                // Reescribir todo el archivo con los cambios
                for (Pedido pedido : pedidos) {
                    bw.write(pedido.toString());
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Estado del pedido actualizado correctamente.");
        } else {
            System.out.println("Pedido no encontrado.");
        }
    }


    public static void verClientePorPedido(int idPedido) {
        List<Pedido> pedidos = leerPedidos();
        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido() == idPedido) {
                System.out.println("Cliente: " + pedido.getIdCliente());
                return;
            }
        }
        System.out.println("Pedido no encontrado.");
    }
}