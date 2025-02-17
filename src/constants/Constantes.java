package constants;

public class Constantes {

    // MENU DE OPCIONES DEL SISTEMA
    public static final String ID_MENU_PRINCIPAL = "principal";
    public static final String OPCIONES_MENU_PRINCIPAL = "***** MENU PRINCIPAL | Sistema Restó *****\n1 - PEDIDOS\n2 - REPARTIDORES\n3 - COMIDAS\n4 - REPORTES\n0 - SALIR";

    public static final String ID_SUBMENU_PEDIDOS = "pedidos";
    public static final String OPCIONES_SUBMENU_PEDIDOS = "***** PEDIDOS | Sistema Restó *****\n1 - VER PEDIDOS\n2 - CAMBIAR ESTADO DE PEDIDO\n3 - VER CLIENTE POR PEDIDO\n0 - ATRAS";

    public static final String ID_SUBMENU_REPARTIDORES = "repartidores";
    public static final String OPCIONES_SUBMENU_REPARTIDORES = "***** REPARTIDORES | Sistema Restó *****\n1 - ASIGNAR REPARTIDOR A PEDIDO\n2 - VER REPARTIDORES\n3 - VER REPARTIDOR POR PEDIDO\n0 - ATRAS";

    public static final String ID_SUBMENU_COMIDAS = "comidas";
    public static final String OPCIONES_SUBMENU_COMIDAS = "***** COMIDAS | Sistema Restó *****\n1 - VER CARTA DE COMIDAS (DISP.)\n2 - NUEVO PLATO\n3 - EDITAR PLATO\n4 - BAJA PLATO\n5 - VER CARTA (DISP. + NO DISP.)\n0 - ATRAS";

    public static final String ID_SUBMENU_REPORTES = "reportes";
    public static final String OPCIONES_SUBMENU_REPORTES = "***** REPORTES | Sistema Restó *****\n1 - REPORTE DIARIO\n2 - REPORTE MENSUAL\n3 - CONSULTAR CANT. DE PEDIDOS DEL EMPLEADO\n4 - CONSULTAR CANTIDAD DE PEDIDOS POR REPARTIDOR\n0 - ATRAS";

    public static final String MENSAJE_ERROR_MENU = "EL MENU INGRESADO NO EXISTE";

    public static final String ARCHIVO_CARTA = "carta_comidas.txt";

    // COMIDAS
    public static final int ATRIBUTOS_COMIDA = 5;
    public static final int ATRIBUTOS_PIZZA = ATRIBUTOS_COMIDA + 3;
    public static final int ATRIBUTOS_POSTRE = ATRIBUTOS_COMIDA + 2;
    public static final int ATRIBUTOS_HAMBURGUESA = ATRIBUTOS_COMIDA + 5;
    public static final int ATRIBUTOS_PASTA = ATRIBUTOS_COMIDA + 2;
    public static final int ATRIBUTOS_MILANESA = ATRIBUTOS_COMIDA + 1;



}
