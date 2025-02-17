package service;
import java.util.List;
import java.util.Scanner;

import static constants.Constantes.*;
import static service.FuncionesArchivos.leerArchivoCarta;

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
            switch (submenu){
                case ID_SUBMENU_PEDIDOS:
                    switch(opcionSubmenu){
                        case 1:
                            // verPedidos
                            break;
                        case 2:
                            // Cambiar estado de pedido
                            break;
                        case 3:
                            // Ver cliente por pedido
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
                        case 3:
                            // ver Repartidor por Pedido
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
                            // Ver Carta de comidas visibles (FALTA FILTRAR POR DISPONIBLE = TRUE)
                            List cartaComidas = leerArchivoCarta();
                            for (int i = 0; i < cartaComidas.size(); i++){
                                System.out.println(cartaComidas.get(i).toString());
                            }
                            break;
                        case 2:
                            // Crear nuevo plato

                            break;
                        case 3:
                            // Editar plato existente
                            break;
                        case 4:
                            // Cambiar disponibilidad de plato existente (BAJA)
                            break;
                        case 5:
                            // Ver Carta de comidas VISIBLES Y NO VISIBLES
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
                        case 2:
                            // Generar reporte Mensual
                            break;
                        case 3:
                            // Consultar cantidad de pedidos del empleado
                            break;
                        case 4:
                            // Consultar cantidad de pedidos por repartidor
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
