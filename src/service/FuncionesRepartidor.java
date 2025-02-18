package service;

import model.Pedido;
import model.Repartidor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
                // Verifica que los datos estén bien formateados
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
        return listaRepartidores;
    }

    // eliminar un repartidor de la lista
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
    }
}
