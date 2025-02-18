package constants;

public class Constantes {

    // MENU DE OPCIONES DEL SISTEMA
    public static final String ID_MENU_PRINCIPAL = "principal";
    public static final String OPCIONES_MENU_PRINCIPAL = "\n***** MENU PRINCIPAL | Sistema Restó *****\n1 - PEDIDOS\n2 - REPARTIDORES\n3 - COMIDAS\n4 - REPORTES\n0 - SALIR";

    public static final String ID_SUBMENU_PEDIDOS = "pedidos";
    public static final String OPCIONES_SUBMENU_PEDIDOS = "\n***** PEDIDOS | Sistema Restó *****\n1 - VER PEDIDOS\n2 - CAMBIAR ESTADO DE PEDIDO\n3 - VER CLIENTE POR PEDIDO\n0 - ATRAS";

    public static final String ID_SUBMENU_REPARTIDORES = "repartidores";
    public static final String OPCIONES_SUBMENU_REPARTIDORES = "\n***** REPARTIDORES | Sistema Restó *****\n1 - ASIGNAR REPARTIDOR A PEDIDO\n2 - VER REPARTIDORES\n3 - AGREGAR UN NUEVO REPARTIDOR\n4- ELIMINAR A UN REPARTIDOR\n0 - ATRAS";

    public static final String ID_SUBMENU_COMIDAS = "comidas";
    public static final String OPCIONES_SUBMENU_COMIDAS = "\n***** COMIDAS | Sistema Restó *****\n1 - VER CARTA DE COMIDAS\n2 - NUEVO PLATO\n3 - CAMBIAR PRECIO A PLATO\n4 - BAJA PLATO\n0 - ATRAS";

    public static final String ID_SUBMENU_REPORTES = "reportes";
    public static final String OPCIONES_SUBMENU_REPORTES = "\n***** REPORTES | Sistema Restó *****\n1 - REPORTE DIARIO\n0 - ATRAS";

    public static final String MENSAJE_ERROR_MENU = "EL MENU INGRESADO NO EXISTE";

    public static final String ARCHIVO_CARTA = "carta_comidas.txt";

    // COMIDAS
    public static final int ATRIBUTOS_COMIDA = 5;
    public static final int ATRIBUTOS_PIZZA = ATRIBUTOS_COMIDA + 3;
    public static final int ATRIBUTOS_POSTRE = ATRIBUTOS_COMIDA + 2;
    public static final int ATRIBUTOS_HAMBURGUESA = ATRIBUTOS_COMIDA + 5;
    public static final int ATRIBUTOS_PASTA = ATRIBUTOS_COMIDA + 2;
    public static final int ATRIBUTOS_MILANESA = ATRIBUTOS_COMIDA + 1;

    //PEDIDO
    public static final String ARCHIVO_PEDIDOS = "pedidos.txt";


}
