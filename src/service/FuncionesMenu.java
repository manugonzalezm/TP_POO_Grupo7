package service;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static constants.Constantes.*;
import static service.FuncionesArchivos.escribirArchivoMenu;
import static service.FuncionesArchivos.leerArchivoCarta;
import static service.FuncionesComida.crearPlato;
import static service.FuncionesComida.parseComida;

public class FuncionesMenu {
    private static void imprimirOpciones(String menu) {
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
            case ID_SUBMENU_REPORTES:
                System.out.println(OPCIONES_SUBMENU_REPORTES);
                break;
            default:
                System.out.println(MENSAJE_ERROR_MENU);
        }
    }

    public static String pedirInput(Scanner scanner){
        return scanner.nextLine();
    }

    private static void imprimirLineaSeparacion(int longitud, char simbolo){
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

        while(ejecutarMenu){
            // Menu Principal
            imprimirOpciones("principal");
            int opcion = scanner.nextInt(); // Leer opción seleccionada
            scanner.nextLine();  // Limpiar el buffer de la entrada

            switch (opcion){
                case 1:
                    imprimirOpciones(ID_SUBMENU_PEDIDOS);
                    mostrarSubMenu(scanner, ID_SUBMENU_PEDIDOS);
                    break;
                case 2:
                    imprimirOpciones(ID_SUBMENU_REPARTIDORES);
                    mostrarSubMenu(scanner, ID_SUBMENU_REPARTIDORES);
                    break;
                case 3:
                    imprimirOpciones(ID_SUBMENU_COMIDAS);
                    mostrarSubMenu(scanner, ID_SUBMENU_COMIDAS);
                    break;
                case 4:
                    imprimirOpciones(ID_SUBMENU_REPORTES);
                    mostrarSubMenu(scanner, ID_SUBMENU_REPORTES);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    ejecutarMenu = false;
                    break;
                default:
                    System.out.println("Opcion invalida... Cerrando el programa");
                    ejecutarMenu = false;
            }
        }
        scanner.close();
    }

    private static void mostrarSubMenu(Scanner scanner, String submenu) {
        boolean volverAMenuPrincipal = false;

        while(!volverAMenuPrincipal){
            int opcionSubmenu = scanner.nextInt();  // Leer opción seleccionada por el usuario
            scanner.nextLine();  // Limpiar el buffer de la entrada

            switch (submenu){
                case ID_SUBMENU_PEDIDOS:
                    switch(opcionSubmenu){
                        case 1:
                            // verPedidos
                            FuncionesPedido.mostrarPedidos();  // Llamada a la función para mostrar pedidos
                            break;
                        case 2:
                            // Cambiar estado de pedido
                            System.out.println("Ingrese el ID del pedido:");
                            int idPedido = scanner.nextInt();
                            scanner.nextLine();  // Limpiar el buffer
                            System.out.println("Ingrese el nuevo estado del pedido:");
                            String nuevoStatus = scanner.nextLine();
                            FuncionesPedido.cambiarEstadoPedido(idPedido, nuevoStatus);  // Llamada a la función para cambiar el estado
                            break;
                        case 3:
                            // Ver cliente por pedido
                            System.out.println("Ingrese el ID del pedido:");
                            int idClientePedido = scanner.nextInt();
                            scanner.nextLine();  // Limpiar el buffer
                            FuncionesPedido.verClientePorPedido(idClientePedido);  // Llamada a la función para ver el cliente por pedido
                            break;
                        case 0:
                            volverAMenuPrincipal = true;
                            break;
                        default:
                            System.out.println("OPCION INVALIDA... VOLVIENDO AL MENU PRINCIPAL");
                            volverAMenuPrincipal = true;
                    }
                    break;
                case ID_SUBMENU_REPARTIDORES:
                    switch(opcionSubmenu){
                        case 1:
                            // Asignar Repartidor a Pedido
                            break;
                        case 2:
                            // Ver repartidores
                            break;
                        case 0:
                            volverAMenuPrincipal = true;
                            break;
                        default:
                            System.out.println("OPCION INVALIDA... VOLVIENDO AL MENU PRINCIPAL");
                            volverAMenuPrincipal = true;
                    }
                    break;
                case ID_SUBMENU_COMIDAS:
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
                            break;
                        case 2:
                            // Crear nuevo plato
                            List atributos = new ArrayList<>();
                            atributos = crearPlato(atributos, scanner);
                            escribirArchivoMenu(String.join(";", atributos));
                            System.out.println("Se creó el siguiente plato\n" + parseComida(atributos).toString());
                            volverAMenuPrincipal = true;
                            break;
                        case 3:
                            // Cambiar precio a plato existente
                            break;
                        case 4:
                            // Cambiar disponibilidad de plato existente (BAJA)
                            break;
                        case 0:
                            volverAMenuPrincipal = true;
                            break;
                        default:
                            System.out.println("OPCION INVALIDA... VOLVIENDO AL MENU PRINCIPAL");
                            volverAMenuPrincipal = true;
                    }
                    break;
                case ID_SUBMENU_REPORTES:
                    switch(opcionSubmenu){
                        case 1:
                            // Generar reporte Diario
                            break;
                        case 0:
                            volverAMenuPrincipal = true;
                            break;
                        default:
                            System.out.println("OPCION INVALIDA... VOLVIENDO AL MENU PRINCIPAL");
                            volverAMenuPrincipal = true;
                    }
                    break;
                default:
                    System.out.println("OPCION INVALIDA... VOLVIENDO AL MENU PRINCIPAL");
                    volverAMenuPrincipal = true;
            }
        }

    }

}
