import java.util.Scanner;

public class App {

    //Elementos necesarios para todas las acciones.
    static Scanner scanner = new Scanner(System.in);
    static String[] planetas = {"Marte", "Júpiter", "Saturno"};
    static double[] distancias = {78.0, 628.0, 1256.0};
    static String[] naves = {"Exploradora", "carga pesada", "Velocidad máxima"};
    static double[] velocidades = {20000.0, 15000.0, 30000};
    
    public static void main(String[] args) throws Exception {
        
        int opcion;
        do{
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

        }while(opcion != 4);


    }

    

    public static void mostrarMenu(){
        System.out.println("\n---Menú Principal---");
        System.out.println("1. Seleccionar un planeta de destino");
        System.out.println("2. Seleccionar una nave espacial");
        System.out.println("3. Iniciar la simulación del vuelo");
        System.out.println("4. Salir");
        System.out.println("Por favor, elige una opción: ");
    }

    public static void seleccionarNave(){

    }

    public static void seleccionarPlaneta(){

    }

    public static void calcularRecursos(){

    }
    
    

    //Métodos auxiliares.
    public static void imprimirPlanetas(){
        

    }

    public static void lanzarEvento(){

    }

    public static void detenerNave(){

    }

}
