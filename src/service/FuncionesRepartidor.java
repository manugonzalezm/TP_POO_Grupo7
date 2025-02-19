package service;

import model.Pedido;
import model.Repartidor;

import java.io.*;
import java.util.*;

import static constants.Constantes.ARCHIVO_PEDIDOS;
import static constants.Constantes.*;
import static service.FuncionesArchivos.RUTA_BASE_ARCHIVOS;
import static service.FuncionesPedido.guardarPedidos;

public class FuncionesRepartidor {

    public static List<Repartidor> leerRepartidoresArchivo() {
        List<Repartidor> repartidores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_BASE_ARCHIVOS + ARCHIVO_REPARTIDORES))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                Repartidor repartidor = new Repartidor(
                        datos[0],                     // idRep
                        Integer.parseInt(datos[1]),   // cantPedidos
                        new ArrayList<Pedido>(),      // pedidos
                        Boolean.parseBoolean(datos[3]) // activo
                );
                repartidores.add(repartidor);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return repartidores;
    }

    /*
    // asignar un repartidor a un pedido
    public static List<Pedido> asignarRepartidor(Pedido pedido, List<Pedido> listaPedidos) {
        List<Repartidor> listaRepartidores = leerRepartidoresArchivo();
        if (pedido == null) {
            System.out.println("Pedido no válido.");
            return listaPedidos;
        }
        if (listaRepartidores == null || listaRepartidores.isEmpty()) {
            System.out.println("No hay repartidores disponibles.");
            return listaPedidos;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione un repartidor activo por ID:");
        for (Repartidor r : listaRepartidores) {
            if (r.getActivo()) {
                System.out.println("ID: " + r.getIdRepartidor() + " - Pedidos asignados: " + r.getCantPedidos());
            }
        }
        String idRepartidor = scanner.nextLine();

        for (Repartidor r : listaRepartidores) {
            if (r.getIdRepartidor().equals(idRepartidor) && r.getActivo()) {
                listaPedidos.add(pedido);
                r.setCantPedidos(r.getCantPedidos() + 1);
                guardarPedidos(listaPedidos);
                System.out.println("Repartidor " + r.getIdRepartidor() + " asignado al pedido " + pedido.getIdPedido());
                return listaPedidos;
            }
        }
        System.out.println("Repartidor no encontrado o inactivo.");
        return listaPedidos;
    }
     */

    // Funcion que permite ver con un formato de consola los repartidores que existen en el archivo
    public static void verRepartidores() {
        List<Repartidor> listaRepartidores = leerRepartidoresArchivo();

        if (listaRepartidores == null || listaRepartidores.isEmpty()) {
            System.out.println("No hay repartidores disponibles.");
            return;
        }
        System.out.println("Lista de repartidores:");
        for (Repartidor r : listaRepartidores) {
            System.out.println("ID: " + r.getIdRepartidor() + " - Pedidos asignados: " + r.getCantPedidos() + " - Activo: " + (r.getActivo() ? "Sí" : "No"));
        }
    }

    // Funcion que permite agregar un repartidor a la lista y devuelve la lista actualizada como valor de retorno
    public static List<Repartidor> agregarRepartidor(Repartidor repartidor) {
        List<Repartidor> listaRepartidores = leerRepartidoresArchivo();

        if (repartidor == null) {
            System.out.println("Repartidor no válido.");
            return listaRepartidores;
        }
        listaRepartidores.add(repartidor);
        System.out.println("Repartidor " + repartidor.getIdRepartidor() + " agregado correctamente.");
        guardarRepartidor(listaRepartidores);
        return listaRepartidores;
    }

    // Permite pasar a inactivo un Repartidor (BAJA por logica true/false)
    public static void deshabilitarRepartidor(String idRepartidor) {
        List<String> lineasActualizadas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_BASE_ARCHIVOS + ARCHIVO_REPARTIDORES))) {
            String linea;
            boolean encontrado = false;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos[0].equals(idRepartidor) && datos[3].equals("true")) {
                    datos[3] = "false";  // se dehabilita al repartidor
                    encontrado = true;
                }
                lineasActualizadas.add(String.join(";", datos));
            }

            if (encontrado) {
                System.out.println("Repartidor " + idRepartidor + " deshabilitado correctamente.");
            } else {
                System.out.println("Repartidor no encontrado o ya está deshabilitado.");
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
            return;
        }

        // se sobrescribe el archivo con los cambios en el estado de activo del repartidor
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_BASE_ARCHIVOS + ARCHIVO_REPARTIDORES))) {
            for (String linea : lineasActualizadas) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
            e.printStackTrace();
        }
    }

    // Permite guardar el archivo de repartidores
    private static void guardarRepartidor(List<Repartidor> listaRepartidores) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_BASE_ARCHIVOS + ARCHIVO_REPARTIDORES))) {
            for (Repartidor repartidor : listaRepartidores) {
                bw.write(repartidor.toString());  // escribe cada pedido
                bw.newLine();  // añade una nueva línea
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar los pedidos.");
        }
    }
}
