package service;

import model.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import static constants.Constantes.ARCHIVO_PEDIDOS;
import static constants.Constantes.ESTATUS_PEDIDOS;
import static service.FuncionesMenu.imprimirLineaSeparacion;

public class FuncionesPedido {

    private static final String RUTA_BASE_ARCHIVOS = "src/resources/";

    private static Pedido parsePedido(String atributos) throws ParseException {
        String[] datos = atributos.split(";");
        // Formato correspondiente al patrón de la fecha
        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

        Pedido pedido = null;
        try {
            pedido = new Pedido(
                    Integer.parseInt(datos[0]),   // idPedido
                    datos[1],                     // direccion
                    datos[2],                     // comentario
                    format.parse(datos[3]),       // horaPedido (convertir timestamp a Date)
                    format.parse(datos[4]),       // horaEstimada
                    Arrays.asList(datos[5].split(",")), // contenido (suponiendo que es una lista separada por comas)
                    Double.parseDouble(datos[6]),  // propina
                    Double.parseDouble(datos[7]),  // importe
                    datos[8],                      // medioPago
                    datos[9],                      // status
                    datos[10],                     // repAsignado
                    datos[11]                      // idCliente
            );
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return pedido; //PONER CONTENIDO COMO IDS DE COMIDA Y CANTIDADES

        /*
        // Crear un HashMap para almacenar los pares clave-valor
        Map<String, Integer> mapa = new HashMap<>();

        // Agregar elementos al mapa
        mapa.put("Juan", 25);
        mapa.put("María", 30);
        mapa.put("Carlos", 22);

        // Mostrar el mapa
        System.out.println("Mapa de claves y valores: " + mapa);

        // Acceder a un valor utilizando una clave
        System.out.println("Edad de Juan: " + mapa.get("Juan"));

        // Verificar si una clave está presente
        if (mapa.containsKey("María")) {
            System.out.println("María está en el mapa.");
        }

        // Iterar sobre los pares clave-valor
        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
            System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
        }
        */
        
    }

    // Lee los pedidos desde el archivo
    public static List<Pedido> leerPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_BASE_ARCHIVOS + ARCHIVO_PEDIDOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                pedidos.add(parsePedido(linea));
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Pedidos cargados: " + pedidos.size() + "\n");
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
                imprimirLineaSeparacion(165, '*');
            }
        }
    }

    // Cambiar el estado de un pedido específico
    public static List cambiarEstadoPedido(Scanner scanner, List<Pedido> listaPedidos) {
        String listaPedidosString = "";

        System.out.println("Ingrese el ID del pedido:");
        int idPedido = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        // Leer todos los pedidos
        boolean encontrado = false;

        // Modificar el estado de un pedido específico
        for (Pedido pedido : listaPedidos) {
            if (pedido.getIdPedido() == idPedido) {
                System.out.println("El estado actual del pedido: " + idPedido + " es: " + pedido.getStatus());
                System.out.println("Ingrese el nuevo estado del pedido: (seleccione un numero)");
                System.out.println(ESTATUS_PEDIDOS);
                String nuevoStatus = scanner.nextLine();

                if(Objects.equals(nuevoStatus, "1")){
                    nuevoStatus = "en preparacion";
                } else if(Objects.equals(nuevoStatus, "2")){
                    nuevoStatus = "pendiente";
                } else if(Objects.equals(nuevoStatus, "3")) {
                    nuevoStatus = "confirmado";
                } else if (Objects.equals(nuevoStatus, "4")) {
                    nuevoStatus = "en camino";
                } else if(Objects.equals(nuevoStatus, "5")) {
                    nuevoStatus = "enviado";
                } else {
                    nuevoStatus = pedido.getStatus();
                    System.out.println("Ocurrio un error con el nuevo estatus, se mantiene el anterior");
                }

                pedido.setStatus(nuevoStatus);  // Cambia el estado del pedido
                encontrado = true;
                break;  // Sale del bucle cuando encuentra el pedido
            }
        }

        if (encontrado) {
            // Guardar los cambios en el archivo
            guardarPedidos(listaPedidos);
            System.out.println("Estado del pedido actualizado correctamente.");
            return listaPedidos;
        } else {
            System.out.println("Pedido no encontrado.");
            return listaPedidos;
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
    public static void guardarPedidos(List<Pedido> pedidos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_BASE_ARCHIVOS + ARCHIVO_PEDIDOS))) {
            for (Pedido pedido : pedidos) {
                bw.write(pedido.toStringArchivo());  // Escribe cada pedido
                bw.newLine();  // Añade una nueva línea
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar los pedidos.");
        }
    }

    // Funcion que permite buscar un pedido por su ID
    public static Pedido buscarPedidoPorId(int idPedido, List<Pedido> listaPedidos) {
        for (Pedido pedido : listaPedidos) {
            if (pedido.getIdPedido() == idPedido) {
                return pedido;
            }
        }
        return null;
    }
}
