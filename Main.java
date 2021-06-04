import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String nav, opc;
    static ArrayList<String> carrito = new ArrayList<>();
    static ArrayList<String> inventario = new ArrayList<>();
    static String[] items = { "Item1", "Red Item", "Purple Item", "Medium-sized Item", "Item5" };

    public static void main(String[] args) {
        Productos produc = new Productos("Item1", "0.49");

        while (true) {
            System.out.println("\nBienvenido: ");
            System.out.println("Selecciona una opción (numerico): ");
            System.out.println("1. Vizualizar carrito de compras: ");
            System.out.println("2. Añadir artículos al carrito: ");
            System.out.println("3. Hacer la compra / salida de caja: ");
            System.out.println("4. Quitar artículos del carrito: ");
            System.out.println("5. Vaciar el carrito: ");
            System.out.println("6. Salir: ");
            opc = sc.nextLine();
            switch (opc) {
                case "1":
                    visualizarCarrito();
                    break;
                case "2":
                    // if (nav != "c" || nav != "x") {
                    System.out.println("Añadir articulos: ");
                    añadirArticulo();
                    // }
                    break;
                case "3":
                    System.out.println("Realizar compra: ");
                    realizarCompra();
                    break;
                case "4":
                    System.out.println("Quitar artículo: ");
                    quitarArticulo();
                    break;
                case "5":
                    System.out.println("Vaciar carrito: ");
                    vaciarCarrito();
                    break;
                case "6":
                    System.out.println("Gracias");
                    return;
                default:
                    break;
            }
        }
    }

    private static void vaciarCarrito() {
        carrito.clear();
        System.out.println("Carrito de compras vacio");
    }

    private static void quitarArticulo() {
        do {
            System.out.println("--------------------------");

            // find longest item name and record length
            if (carrito.size() == 0) {
                System.out.println("\nCarrito vacio");
            } else {
                System.out.println("\nEliminar producto");
                System.out.println("\nLista de productos");
                for (int i = 0; i < carrito.size(); i++) {
                    System.out.println((i + 1) + ". " + carrito.get(i));
                }
                nav = null;
                System.out.println("\nIndique el # del item a eliminar o 'x' para salir: ");
                nav = sc.nextLine();

                if (nav != "x") {
                    try {
                        int navInt = Integer.parseInt(nav);
                        carrito.remove(navInt - 1);
                        System.out.println("\nLista de productos");
                        for (int i = 0; i < carrito.size(); i++) {
                            System.out.println((i + 1) + ". " + carrito.get(i));
                        }
                        nav = "i";
                    } catch (Exception e) {
                    }
                }

            }
        } while (nav == "i");

    }

    private static void realizarCompra() {
    }

    private static void añadirArticulo() {
        // print separators

        System.out.println("--------------------------");

        // find longest item name and record length
        int maxLength = 0;

        for (String item : items) {
            if (item.length() > maxLength) {
                maxLength = item.length();
            }
        }

        System.out.println("Inventory:");
        // print items and prices, one per line
        for (int i = 0; i < items.length; i++) {
            // get the current item
            String item = items[i];
            // add spacing to make prices column even
            while (item.length() <= maxLength) {
                item = item + " ";
            }
            // print item and price
            System.out.println((i + 1) + ". " + item + "$0.99");
        }
        // print separators
        do {
            System.out.println("--------------------------");

            // display prompt

            System.out.print("Ingrese el numero del producto a agregar o 'x' para salir: ");
            // update navigation control variable from user input
            nav = null;
            nav = sc.nextLine();
            // check if String is a value within the number of items
            // if item number was entered, add to cart and return to inventory
            // otherwise, return to main loop

            if (nav != "x") {
                try {
                    if (nav != "x") {
                        int navInt = Integer.parseInt(nav);
                        if (navInt > 0 && navInt <= items.length) {
                            // add item to cart
                            // code here
                            // print separators
                            System.out.println("--------------------------");
                            // print message
                            System.out.println("Producto \"" + items[navInt - 1] + "\" agregado al carrito.");
                            nav = "i";
                            carrito.add(items[navInt - 1]);
                        }
                    }
                } catch (Exception e) {
                }
            }
        } while (nav == "i");
    }

    private static void visualizarCarrito() {
        if (carrito.size() == 0) {
            System.out.println("El carrito de compras se encuentra vacio.");
        } else {
            System.out.println("Carrito de Compras: ");
            System.out.println("\nArtículos: ");
            for (String s : carrito) {
                System.out.println(s);
            }
        }

    }
}