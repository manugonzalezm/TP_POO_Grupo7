package service;

import model.Pedido;
import model.Repartidor;

import java.io.*;
import java.util.*;

import static constants.Constantes.ARCHIVO_PEDIDOS;
import static constants.Constantes.*;
import static service.FuncionesArchivos.RUTA_BASE_ARCHIVOS;

public class FuncionesRepartidor {

    public static List<Repartidor> leerRepartidoresArchivo() {
        List<Repartidor> repartidores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_BASE_ARCHIVOS + ARCHIVO_REPARTIDORES))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                Repartidor repartidor = new Repartidor(
                        datos[0],                     // idRep
                        0,                            // cantPedidos
                        new ArrayList<Pedido>(),      // pedidos
                        true                       // activo
                );
                repartidores.add(repartidor);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        finally {
            return repartidores;
        }
    }

    // asignar un repartidor a un pedido
    public static void asignarRepartidor(Pedido pedido) {
        List<Repartidor> listaRepartidores = leerRepartidoresArchivo();
        if (pedido == null) {
            System.out.println("Pedido no válido.");
            return;
        }
        if (listaRepartidores == null || listaRepartidores.isEmpty()) {
            System.out.println("No hay repartidores disponibles.");
            return;
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
                r.getPedidos().add(pedido);
                r.setCantPedidos(r.getCantPedidos() + 1);
                System.out.println("Repartidor " + r.getIdRepartidor() + " asignado al pedido " + pedido.getRepAsignado());
                return;
            }
        }
        System.out.println("Repartidor no encontrado o inactivo.");
    }

    // ver todos los repartidores disponibles
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

    // agregar un nuevo repartidor a la lista
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

    /* eliminar un repartidor de la lista
    public static void eliminarRepartidor(String idRepartidor) {
        List<Repartidor> listaRepartidores = leerRepartidoresArchivo();

        if (listaRepartidores == null || listaRepartidores.isEmpty()) {
            System.out.println("No hay repartidores para eliminar.");
            return;
        }

        for (Repartidor r : listaRepartidores) {
            if (r.getIdRepartidor().equals(idRepartidor)) {
                listaRepartidores.remove(r);
                System.out.println("Repartidor " + r.getIdRepartidor() + " eliminado correctamente.");

                return;
            }
        }
        System.out.println("Repartidor no encontrado.");
    }*/

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
