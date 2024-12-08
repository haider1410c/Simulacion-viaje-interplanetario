import java.util.Scanner;

public class App {

    // Elementos necesarios para todas las acciones.
    static Scanner scanner = new Scanner(System.in);
    static String[] planetas = { "Marte", "Júpiter", "Saturno", "Urano", "Neptuno", "Venus", "Mercurio" };
    static double[] distancias = { 132.83, 617.54, 1.3676, 2.7774, 4.3982, 156.94, 140.17 };
    static String[] descripcionPlaneta = {"Conocido como el planeta rojo debido al óxido de hierro en su superficie","El planeta más grande del sistema solar, compuesto principalmente por hidrógeno y helio","El elemento más llamativo de Saturno son sus 7 anillos, los cuales se cree que están compuestos millones de pedazos de hielo y roca procedentes cometas, asteroides o lunas","Se trata del primero de los gigantes helados de nuestro sistema planetario y está compuesto por una especie de hielo fluido de agua, amoníaco y metano","Oscuro, frío y regido por vientos supersónicos, el gigante de hielo Neptuno es el octavo y más distante planeta de nuestro sistema solar","Las densas nubes de ácido sulfúrico que rodean la atmosfera de Venus generan tal efecto invernadero que hace de Venus el planeta más caliente del sistema solar","Con un tamaño tan solo un poco mayor al de nuestra luna, es el planeta más pequeño del sistema solar y el más cercano al Sol"};
    static String[] naves = { "Exploradora", "carga pesada", "Velocidad máxima" };
    static double[] oxigeno={20.43,30.56,40.78,45.6,96.9,24.38,23.35};
    //static double[] combustible={}
    static double[] velocidades = { 20000.0, 15000.0, 30000 };

    static String naveElegida = null;
    static double velocidadDefecto = 100;
    static int planeta = -1;
    static double tiempo;
    static double recursosIniciales = 50000.0; // Recursos iniciales para la simulación
    static double consumoPorHora = 50.0; // Consumo de recursos por hora

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
                case 3:      
                    double distanciaKm = tiempo / 1000000.0; // Convertir millones de km a km
                    double duracionHoras = distanciaKm / velocidadDefecto;
                    double duracionDias = duracionHoras / 24;
                    iniciarSimulacionVuelo(duracionDias,duracionHoras,distanciaKm);

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
        int limitePasajeros[] = { 7, 15, 5 };
        int pasajeros;
        double velocidadDefecto = velocidades[opcionNave - 1];
        while (true) {
            System.out.println("Ingrese la cantidad de pasajeros");
            if (scanner.hasNextInt()) { //se verifica que el dato ingresado sea un número
                pasajeros = scanner.nextInt();
                System.out.println("Pasajeros registrados exitosamente");
                break;
            } else {
                System.out.println("Por favor, introduce un número válido.");
                scanner.nextInt();
            }

        }
        
        gestionarRecursos(naveElegida,pasajeros);

        System.out.println("Nave: " + naveElegida + " velocidad maxima " + velocidadDefecto + " Cantidad de pasajeros : " + pasajeros);

    }

    public static void seleccionarPlaneta() {
           
        int confirmacion;
        System.out.println("Elige un planeta de destino");
        imprimirPlanetas();
        planeta = scanner.nextInt();
        System.out.println("Esta seguro de querer elegir el planeta "+ planeta);
        System.out.println("Digite 1 para confirmar");
        System.out.println("Digite 2 para elegir otro planeta");
        confirmacion= scanner.nextInt();
        
        if (confirmacion != 1 || confirmacion != 2) {
            System.out.println("Opción invalida, intente nuevamente.");
        } else {
            if (confirmacion ==1) {
                switch (planeta) {
                    case 1:
                        System.out.println(planetas[0]);
                        System.out.println("La distancia de la tierra a "+ planetas[0] +" es de: " +distancias[0]+" millones de kilometros.");
                        System.out.println("Descripcion: "+ descripcionPlaneta[0]);
                        break;
                    case 2:
                        System.out.println(planetas[1]);
                        System.out.println("La distancia de la tierra a "+ planetas[1] +" es de: " +distancias[1]+" millones de kilometros.");
                        System.out.println("Descripcion: "+ descripcionPlaneta[1]);
                        break;
                    case 3:
                        System.out.println(planetas[2]);
                        System.out.println("La distancia de la tierra a "+ planetas[2] +" es de: " +distancias[2]+" millones de kilometros.");
                        System.out.println("Descripcion: "+ descripcionPlaneta[2]);
                        break;
                    case 4:
                        System.out.println(planetas[3]);
                        System.out.println("La distancia de la tierra a "+ planetas[3] +" es de: " +distancias[3]+" millones de kilometros.");
                        System.out.println("Descripcion: "+ descripcionPlaneta[3]);
                        break;   
                    case 5:
                        System.out.println(planetas[4]);
                        System.out.println("La distancia de la tierra a "+ planetas[4] +" es de: " +distancias[4]+" millones de kilometros.");
                        System.out.println("Descripcion: "+ descripcionPlaneta[4]);
                        break; 
                    case 6:
                        System.out.println(planetas[5]);
                        System.out.println("La distancia de la tierra a "+ planetas[5] +" es de: " +distancias[5]+" millones de kilometros.");
                        System.out.println("Descripcion: "+ descripcionPlaneta[5]);
                        break;
                    case 7:
                        System.out.println(planetas[6]);
                        System.out.println("La distancia de la tierra a "+ planetas[6] +" es de: " +distancias[6]+" millones de kilometros.");
                        System.out.println("Descripcion: "+ descripcionPlaneta[6]);
                        break;
                    default:
                        break;
                }
        
            } else {
                System.out.println("Elige un planeta de destino");
                imprimirPlanetas();
                scanner.nextInt();
            
            }
        }
    }

   public static void gestionarRecursos(String naveElegida, int pasajeros){
    if (naveElegida == null || planeta == -1) {
        System.out.println("Por favor, selecciona una nave y un planeta antes de iniciar la simulación.");
        return;
    }

    // Cálculo de la duración del viaje
    ;

    //  recursos necesarios para la nave
   }

    
    public static void iniciarSimulacionVuelo(double duracionDias, double duracionHoras,double
    distanciaKm){

        
        double distanciaRecorrida = 100;
        double recursosDisponibles = recursosIniciales;
        double tiempoTranscurrido = 0;

        System.out.println("\n---Resultados de la simulación ---");
        System.out.println("Nave: " + naveElegida);
        System.out.println("Planeta: " + planetas[planeta -1]);
        System.out.printf("Duración estimada del viaje: %.2f días\n", duracionDias);
        scanner.nextLine();

        System.out.println("---- Inicio de simulación del viaje ----");

     
        while (distanciaRecorrida < recursosIniciales && tiempoTranscurrido >= 0) {

            tiempoTranscurrido ++;
            distanciaRecorrida += velocidadDefecto;
            recursosDisponibles -= consumoPorHora;

            double porcentajeProgreso = (distanciaRecorrida / distanciaKm) * 100;

            double tiempoRestante = (distanciaKm - distanciaRecorrida) / velocidadDefecto;

            if (tiempoTranscurrido < 100) {
            
                System.out.printf("Progreso del viaje: %.2f%%\n", porcentajeProgreso);
                System.out.printf("Tiempo restante: %.2f horas\n", tiempoRestante);
                System.out.printf("Recursos disponibles: %.2f\n", recursosDisponibles);
                System.out.println("");

            try {
                Thread.sleep(1000); // Pausa para simular tiempo real
            } catch (InterruptedException e) {
                System.err.println("Error en la simulación de tiempo.");
            }
            }

            
        }

        if (distanciaRecorrida >= distanciaKm) {
             
            System.out.println(" Viaje realizado con exito, bienvenido a su destino");
             
        }else{
            System.err.println("¡ La nave se a quedado sin recursos!, el viaje ha fallado");
        }
        
    }

    // Métodos auxiliares.
    public static void imprimirPlanetas() {
        int indice = 1;
        for (int index = 0; index < planetas.length; index++) {
            System.out.println(indice+ "." + planetas[index] );
            indice= indice+1;
         }
    }

    public static void lanzarEvento() {
        
    }

    public static void detenerNave() {
        
    }

}
