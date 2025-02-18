package service;

import model.Pedido;
import model.Repartidor;
import java.util.List;
import java.util.Scanner;

public class FuncionesRepartidor {
    private static List<Repartidor> listaRepartidores; // Lista de repartidores disponibles

    // asignar un repartidor a un pedido
    public static void asignarRepartidor(Pedido pedido) {
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
    public static void agregarRepartidor(Repartidor repartidor) {
        if (repartidor == null) {
            System.out.println("Repartidor no válido.");
            return;
        }
        listaRepartidores.add(repartidor);
        System.out.println("Repartidor " + repartidor.getIdRepartidor() + " agregado correctamente.");
    }

    // eliminar un repartidor de la lista
    public static void eliminarRepartidor(String idRepartidor) {
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
