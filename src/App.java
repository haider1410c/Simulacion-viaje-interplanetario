import java.util.Scanner;

public class App {

    //Elementos necesarios para todas las acciones.
    static Scanner scanner = new Scanner(System.in);
    static String[] planetas = {"Marte", "Júpiter", "Saturno", "Urano", "Neptuno", "Venus", "Mercurio"};
    static double[] distancias = {132.83, 617.54, 1.3676, 2.7774, 4.3982, 156.94, 140.17};
    static String[] descripcionPlaneta = {"Conocido como el planeta rojo debido al óxido de hierro en su superficie","El planeta más grande del sistema solar, compuesto principalmente por hidrógeno y helio","El elemento más llamativo de Saturno son sus 7 anillos, los cuales se cree que están compuestos millones de pedazos de hielo y roca procedentes cometas, asteroides o lunas","Se trata del primero de los gigantes helados de nuestro sistema planetario y está compuesto por una especie de hielo fluido de agua, amoníaco y metano","Oscuro, frío y regido por vientos supersónicos, el gigante de hielo Neptuno es el octavo y más distante planeta de nuestro sistema solar","Las densas nubes de ácido sulfúrico que rodean la atmosfera de Venus generan tal efecto invernadero que hace de Venus el planeta más caliente del sistema solar","Con un tamaño tan solo un poco mayor al de nuestra luna, es el planeta más pequeño del sistema solar y el más cercano al Sol"};
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
                case 3:
                    calcularRecursos();
                default:
                    break;
            }

        }while(opcion != 4);
            System.out.println("Opcion invalida");

    }

    

    public static void mostrarMenu(){
        System.out.println("\n---Menú Principal---");
        System.out.println("1. Seleccionar un planeta de destino");
        System.out.println("2. Seleccionar una nave espacial");
        System.out.println("3. Iniciar la simulación del vuelo");
        System.out.println("4. Salir");
        System.out.println("Por favor, elige una opción: ");
    }


    public static void seleccionarPlaneta(){
        int planeta;
        int indice = 1;
        System.out.println("Elige un planeta de destino");
        for (int index = 0; index < planetas.length; index++) {
           System.out.println(indice+ "." + planetas[index] );
           indice= indice+1;
        }
        planeta = scanner.nextInt();
        switch (planeta) {
            case 1:
                System.out.println(planetas[0]);
                System.out.println("La distancia de la tierra a este planeta es de: " +distancias[0]+" millones de kilometros");
                System.out.println("Descripcion: "+ descripcionPlaneta[0]);
                break;
            case 2:
                System.out.println(planetas[1]);
                System.out.println("La distancia de la tierra a este planeta es de: " +distancias[1]+" millones de kilometros");
                System.out.println("Descripcion: "+ descripcionPlaneta[1]);
                break;
            case 3:
                System.out.println(planetas[2]);
                System.out.println("La distancia de la tierra a este planeta es de: " +distancias[2]+" millones de kilometros");
                System.out.println("Descripcion: "+ descripcionPlaneta[2]);
                break;
            case 4:
                System.out.println(planetas[3]);
                System.out.println("La distancia de la tierra a este planeta es de: " +distancias[3]+" millones de kilometros");
                System.out.println("Descripcion: "+ descripcionPlaneta[3]);
                break;   
            case 5:
                System.out.println(planetas[4]);
                System.out.println("La distancia de la tierra a este planeta es de: " +distancias[4]+" millones de kilometros");
                System.out.println("Descripcion: "+ descripcionPlaneta[4]);
                break; 
            case 6:
                System.out.println(planetas[5]);
                System.out.println("La distancia de la tierra a este planeta es de: " +distancias[5]+" millones de kilometros");
                System.out.println("Descripcion: "+ descripcionPlaneta[5]);
                break;
            case 7:
                System.out.println(planetas[6]);
                System.out.println("La distancia de la tierra a este planeta es de: " +distancias[6]+" millones de kilometros");
                System.out.println("Descripcion: "+ descripcionPlaneta[6]);
                break;
            default:
                break;
        }
    }

    public static void seleccionarNave(){

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
