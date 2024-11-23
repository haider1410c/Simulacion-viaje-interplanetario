import java.util.Scanner;

public class App {

    // Elementos necesarios para todas las acciones.
    static Scanner scanner = new Scanner(System.in);
    static String[] planetas = { "Marte", "Júpiter", "Saturno", "Urano", "Neptuno", "Venus", "Mercurio" };
    static double[] distancias = { 132.83, 617.54, 1.3676, 2.7774, 4.3982, 156.94, 140.17 };
    static String[] naves = { "Exploradora", "carga pesada", "Velocidad máxima" };
    static double[] velocidades = { 20000.0, 15000.0, 30000 };

    public static void main(String[] args) throws Exception {

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    seleccionarPlaneta();
                    break;
                case 2:
                    seleccionarNave();
                    break;
                default:
                    break;
            }

        } while (opcion != 4);

    }

    public static void mostrarMenu() {
        System.out.println("\n---Menú Principal---");
        System.out.println("1. Seleccionar un planeta de destino");
        System.out.println("2. Seleccionar una nave espacial");
        System.out.println("3. Iniciar la simulación del vuelo");
        System.out.println("4. Salir");
        System.out.println("Por favor, elige una opción: ");
    }

    public static void seleccionarNave() {

        // Selecciona la nave

        System.out.println("Selecciona la nave ");

        for (int i = 0; i < naves.length; i++) {
            System.out.println((i + 1) + ". " + naves[i] + " (Velocidad máxima: " + velocidades[i] + " km/h)");
        }

        int opcionNave;

        String naveElegida = "";

        while (true) {
            System.out.println("Introduce el número de la nave que deseas elegir: ");

            if (scanner.hasNextInt()) {
                opcionNave = scanner.nextInt();
                if (opcionNave >= 1 && opcionNave <= naves.length) {
                    naveElegida = naves[opcionNave - 1];
                    break;
                } else {
                    System.out.println("Por favor, selecciona un número válido entre 1 y " + naves.length + ".");
                }
            } else {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next(); // Limpiar entrada inválida
            }

        }

        // Seleccion de pasajeros Pasajeros.
        System.out.println("Ingrese la cantidad de pasajeros");

        int limitePasajeros[] = { 7, 15, 5 };
        int pasajeros = scanner.nextInt();
        double velocidadDefecto = velocidades[opcionNave - 1];

        // Verifica que la cantidad de pasajeros no exceda la capacidad maxima de las
        // naves
        while (pasajeros <= 0) {
            if (pasajeros <= limitePasajeros[0] || pasajeros >= limitePasajeros[1] || pasajeros <= limitePasajeros[2]) {
                System.out.println("Pasajeros ingresados correctamente");

            } else {
                System.err.println("Excediste la cantidad maxima");
            }
        }

        System.out.println("Nave: " + naveElegida + " velocidad maxima " + velocidadDefecto + " Cantidad de pasajeros : " + pasajeros);

    }

    public static void seleccionarPlaneta() {

    }

    public static void calcularRecursos() {

    }

    // Métodos auxiliares.
    public static void imprimirPlanetas() {

    }

    public static void lanzarEvento() {

    }

    public static void detenerNave() {

    }

}
