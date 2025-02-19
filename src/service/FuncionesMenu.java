package service;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static constants.Constantes.*;
import static service.FuncionesArchivos.*;
import static service.FuncionesComida.*;
import static service.FuncionesPedido.leerPedidos;
import static service.FuncionesRepartidor.verRepartidores;

public class FuncionesMenu {
    private static void imprimirOpciones(String menu) {
        // Funcion que imprime el menu principal
        switch (menu){
            case ID_MENU_PRINCIPAL:
                System.out.println(OPCIONES_MENU_PRINCIPAL);
                break;
            case ID_SUBMENU_PEDIDOS:
                System.out.println(OPCIONES_SUBMENU_PEDIDOS);
                break;
            case ID_SUBMENU_REPARTIDORES:
                System.out.println(OPCIONES_SUBMENU_REPARTIDORES);
                break;
            case ID_SUBMENU_COMIDAS:
                System.out.println(OPCIONES_SUBMENU_COMIDAS);
                break;
            /*
            case ID_SUBMENU_REPORTES:
                System.out.println(OPCIONES_SUBMENU_REPORTES);
                break;
             */
            default:
                System.out.println(MENSAJE_ERROR_MENU);
        }
    }

    public static String pedirInput(Scanner scanner){
        return scanner.nextLine();
    }

    // Funcion para dar formato grafico
    static void imprimirLineaSeparacion(int longitud, char simbolo){
        for (int i = 0; i < longitud; i++) {
            System.out.print(simbolo);
            if (i==longitud-1){
                System.out.println("");
            }
        }
    }

    public static void mostrarMenuPrincipal() {
        boolean ejecutarMenu = true;
        Scanner scanner = new Scanner(System.in);

        // Tomar datos de empleado
        System.out.println("Ingrese su nombre: ");
        String nombreEmpleado = pedirInput(scanner);
        System.out.println("Ingrese su legajo de Empleado: ");
        String legajoEmpleado = pedirInput(scanner);
        Empleado empleado = new Empleado(nombreEmpleado, legajoEmpleado, 0);

        List<Pedido> listaPedidos = new ArrayList<>();
        // Leer pedidos de archivo
        checkAndCreateFile(ARCHIVO_PEDIDOS);
        listaPedidos = leerPedidos();

        List<Repartidor> listaRepartidores = new ArrayList<>();
        // Leer repartidores de archivo
        checkAndCreateFile(ARCHIVO_REPARTIDORES);

        List<Cliente> listaClientes = new ArrayList<>();
        // Leer clientes de archivo
        checkAndCreateFile(ARCHIVO_CLIENTES);

        List<Comida> listaComidas = new ArrayList<>();
        // Leer platos de archivo
        checkAndCreateFile(ARCHIVO_CARTA);


        while(ejecutarMenu){
            // Menu Principal
            imprimirOpciones("principal");
            int opcion = scanner.nextInt(); // Leer opción seleccionada
            scanner.nextLine();  // Limpiar el buffer de la entrada

            switch (opcion){
                case 1:
                    imprimirOpciones(ID_SUBMENU_PEDIDOS);
                    mostrarSubMenu(scanner, ID_SUBMENU_PEDIDOS, empleado, listaPedidos, listaRepartidores, listaClientes, listaComidas);
                    break;
                case 2:
                    imprimirOpciones(ID_SUBMENU_REPARTIDORES);
                    mostrarSubMenu(scanner, ID_SUBMENU_REPARTIDORES, empleado, listaPedidos, listaRepartidores, listaClientes, listaComidas);
                    break;
                case 3:
                    imprimirOpciones(ID_SUBMENU_COMIDAS);
                    mostrarSubMenu(scanner, ID_SUBMENU_COMIDAS, empleado, listaPedidos, listaRepartidores, listaClientes, listaComidas);
                    break;
                /*
                case 4:
                    imprimirOpciones(ID_SUBMENU_REPORTES);
                    mostrarSubMenu(scanner, ID_SUBMENU_REPORTES, empleado, listaPedidos, listaRepartidores, listaClientes, listaComidas);
                    break;
                 */
                case 0:
                    System.out.println("Cerrando el programa...");
                    ejecutarMenu = false;
                    return;
                default:
                    System.out.println("Opcion invalida... Cerrando el programa");
                    ejecutarMenu = false;
                    return;
            }
        }
        scanner.close();
    }

    private static void mostrarSubMenu(Scanner scanner, String submenu, Empleado empleado,
                                       List<Pedido> listaPedidos, List<Repartidor> listaRepartidores,
                                       List<Cliente> listaClientes, List<Comida> listaComidas) {
        boolean volverAMenuPrincipal = false;

        while(!volverAMenuPrincipal){
            int opcionSubmenu = scanner.nextInt();  // Leer opción seleccionada por el usuario
            scanner.nextLine();  // Limpiar el buffer de la entrada

            switch (submenu){
                case "pedidos":
                    switch(opcionSubmenu){
                        case 1:
                            // verPedidos
                            FuncionesPedido.mostrarPedidos();  // Llamada a la función para mostrar pedidos
                            opcionSubmenu = 0;
                            volverAMenuPrincipal = true;
                            break;
                        case 2:
                            // Cambiar estado de pedido
                            listaPedidos = FuncionesPedido.cambiarEstadoPedido(scanner, listaPedidos);  // Llamada a la función para cambiar el estado
                            opcionSubmenu = 0;
                            volverAMenuPrincipal = true;
                            break;
                        case 3:
                            // Ver cliente por pedido
                            System.out.println("Ingrese el ID del pedido:");
                            int idClientePedido = scanner.nextInt();
                            scanner.nextLine();  // Limpiar el buffer
                            FuncionesPedido.verClientePorPedido(idClientePedido);  // Llamada a la función para ver el cliente por pedido
                            opcionSubmenu = 0;
                            volverAMenuPrincipal = true;
                            break;
                        case 0:
                            volverAMenuPrincipal = true;
                            break;
                        default:
                            System.out.println("OPCION INVALIDA... VOLVIENDO AL MENU PRINCIPAL");
                            opcionSubmenu = 0;
                            volverAMenuPrincipal = true;
                    }
                    break;
                case "repartidores":
                    switch(opcionSubmenu) {
                        case 1:
                            // Ver repartidores
                            verRepartidores();
                            opcionSubmenu = 0;
                            volverAMenuPrincipal = true;
                            break;
                        case 2:
                            // Agregar repartidor
                            System.out.print("Ingrese el ID del nuevo repartidor: ");
                            String idRepartidor = scanner.nextLine();
                            Repartidor nuevoRepartidor = new Repartidor(idRepartidor, 0, new java.util.ArrayList<>(), true);
                            FuncionesRepartidor.agregarRepartidor(nuevoRepartidor);
                            opcionSubmenu = 0;
                            volverAMenuPrincipal = true;
                            break;
                        case 3:
                            // Eliminar repartidor
                            System.out.print("Ingrese el ID del repartidor a deshabilitar: ");
                            String idDeshabilitar = scanner.nextLine();
                            FuncionesRepartidor.deshabilitarRepartidor(idDeshabilitar);
                            opcionSubmenu = 0;
                            volverAMenuPrincipal = true;
                            break;
                        case 0:
                            volverAMenuPrincipal = true;
                            break;
                        default:
                            System.out.println("OPCION INVALIDA... VOLVIENDO AL MENU PRINCIPAL");
                            opcionSubmenu = 0;
                            volverAMenuPrincipal = true;
                            break;
                    }
                case "comidas":
                    switch(opcionSubmenu){
                        case 1:
                            // Ver Carta de comidas
                            List cartaComidas = leerArchivoCarta();
                            System.out.println("- CARTA DE PLATOS");
                            imprimirLineaSeparacion(165, '*');
                            for (int i = 0; i < cartaComidas.size(); i++){
                                System.out.println(cartaComidas.get(i).toString());
                                imprimirLineaSeparacion(165, '*');
                            }
                            opcionSubmenu = 0;
                            volverAMenuPrincipal = true;
                            break;
                        case 2:
                            // Crear nuevo plato
                            List atributos = new ArrayList<>();
                            atributos = crearPlato(atributos, scanner);
                            System.out.println("Se creó el siguiente plato\n" + parseComida(atributos).toString());
                            opcionSubmenu = 0;
                            volverAMenuPrincipal = true;
                            break;
                            /*
                        case 3:
                            // Cambiar precio/disponibilidad a plato existente
                            editPlato(scanner, listaComidas, "precio");
                            opcionSubmenu = 0;
                            volverAMenuPrincipal = true;
                            break;
                        case 4:
                            // Cambiar disponibilidad de plato existente (BAJA)
                            editPlato(scanner, listaComidas, "disponible");
                            opcionSubmenu = 0;
                            volverAMenuPrincipal = true;
                            break;
                            */
                        case 0:
                            volverAMenuPrincipal = true;
                            break;
                        default:
                            System.out.println("OPCION INVALIDA... VOLVIENDO AL MENU PRINCIPAL");
                            opcionSubmenu = 0;
                            volverAMenuPrincipal = true;
                    }
                    break;
                    /*
                case "reportes":
                    switch(opcionSubmenu){
                        case 1:
                            // Generar reporte Diario
                            opcionSubmenu = 0;
                            volverAMenuPrincipal = true;
                            break;
                        case 0:
                            volverAMenuPrincipal = true;
                            break;
                        default:
                            System.out.println("OPCION INVALIDA... VOLVIENDO AL MENU PRINCIPAL");
                            opcionSubmenu = 0;
                            volverAMenuPrincipal = true;
                    }
                    break;
                     */
                default:
                    System.out.println("...VOLVIENDO AL MENU PRINCIPAL...");
                    volverAMenuPrincipal = true;
            }
        }

    }

}
