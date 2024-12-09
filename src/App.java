
import java.util.Random;
import java.util.Scanner;

public class App {

    // Elementos necesarios para todas las acciones.
    static Scanner scanner = new Scanner(System.in);
    static String[] planetas = { "Marte", "Júpiter", "Saturno", "Urano", "Neptuno", "Venus", "Mercurio" };
    static double[] distancias = { 132.83, 617.54, 1.3676, 2.7774, 4.3982, 156.94, 140.17 };
    static String[] descripcionPlaneta = { "Conocido como el planeta rojo debido al óxido de hierro en su superficie",
            "El planeta más grande del sistema solar, compuesto principalmente por hidrógeno y helio",
            "El elemento más llamativo de Saturno son sus 7 anillos, los cuales se cree que están compuestos millones de pedazos de hielo y roca procedentes cometas, asteroides o lunas",
            "Se trata del primero de los gigantes helados de nuestro sistema planetario y está compuesto por una especie de hielo fluido de agua, amoníaco y metano",
            "Oscuro, frío y regido por vientos supersónicos, el gigante de hielo Neptuno es el octavo y más distante planeta de nuestro sistema solar",
            "Las densas nubes de ácido sulfúrico que rodean la atmosfera de Venus generan tal efecto invernadero que hace de Venus el planeta más caliente del sistema solar",
            "Con un tamaño tan solo un poco mayor al de nuestra luna, es el planeta más pequeño del sistema solar y el más cercano al Sol" };
    static String[] naves = { "Exploradora", "carga pesada", "Velocidad máxima" };
    static int[] capacidadNave = { 7, 25, 3 };
    static double oxigeno= 9 ;
    // static double[] combustible={}
    static double[] velocidades = { 20000.0, 15000.0, 30000 };
    static String naveElegida = null;
    static double velocidadDefecto = 15000.0;
    static int planeta = -1;
    static double distanciaKm;
    static double combustible = 200;
    static int pasajeros;
    static double tiempo;
    static double recursosIniciales = 0; // Recursos iniciales para la simulación
    static double consumoPorHora = 5; // Consumo de recursos por hora

    public static void main(String[] args) throws Exception {

        int opcion;
        mostrarMenu();
        while (true) {
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion <= 4) {
                    switch (opcion) {
                        case 0:
                            System.out.println("Opción invalida");
                            System.out.println("Recuerda que las opciones validas son del 1 al 4");
                            break;
                        case 1:
                            seleccionarPlaneta();
                            break;
                        case 2:
                            seleccionarNave(planeta);
                            break;
                        case 3:
                            iniciarSimulacionVuelo(distanciaKm, oxigeno, combustible,naveElegida,pasajeros,planeta,velocidadDefecto);
                            break;
                        case 4:
                            System.out.println("Gracias por usar nuestro programa");
                            System.exit(0);

                        default:
                            break;
                    }

                } else {
                    System.out.println("Ingrese un número valido");
                    scanner.next();
                }
            } else {
                System.out.println("Ingrese un número valido");
                scanner.next();
            }

        }

    }

    public static void mostrarMenu() {
        System.out.println("\n---Menú Principal---");
        System.out.println("1. Seleccionar un planeta de destino");
        System.out.println("2. Seleccionar una nave espacial");
        System.out.println("3. Iniciar la simulación del vuelo");
        System.out.println("4. Salir");
        System.out.println("Por favor, elige una opción: ");
    }

    public static void seleccionarNave( int planeta) {
        // Selecciona la nave
        System.out.println("Selecciona la nave ");

        for (int i = 0; i < naves.length; i++) {
            System.out.println((i + 1) + ". " + naves[i] + " (Velocidad máxima: " + velocidades[i] + " km/h)"
                    + " Capacidad máxima de pasajeros " + capacidadNave[i]);
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
        int pasajeros;
        double velocidadDefecto = velocidades[opcionNave - 1];

        while (true) {
            System.out.println("Ingrese la cantidad de pasajeros");
            if (scanner.hasNextInt()) {
                pasajeros = scanner.nextInt();
                if (pasajeros > 0) {
                    System.out.println("Pasajeros registrados exitosamente");
                    System.out.println("Nave: " + naveElegida + " velocidad maxima " + velocidadDefecto
                            + " Cantidad de pasajeros :" + pasajeros);
                    System.out.println("Información del destino: " + planetas[planeta-1] + " Descripción :" +descripcionPlaneta[planeta-1]
                    +" La distancia a este planeta es de: "+ distancias[planeta-1]+" millones de kilometros");
                    
                    gestionarRecursos(naveElegida, pasajeros, planeta, velocidadDefecto);
                    
                    break;
                }
            } else {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next(); // Limpiar entrada inválida
            }
        }
    }

    // gestionarRecursos(naveElegida, pasajeros, velocidadDefecto,
    // velocidadDefecto);

    public static void confirmacion() {
        System.out.println("Esta seguro de querer elegir el planeta " + planeta);
        System.out.println("Digite 1 para confirmar");
        System.out.println("Digite 2 para elegir otro planeta");

    }

    public static void seleccionarPlaneta() {

        int confirmacion;
        System.out.println("Elige un planeta de destino");
        imprimirPlanetas();
        planeta = scanner.nextInt();
        confirmacion();
        confirmacion = scanner.nextInt();

        if (confirmacion >2 && confirmacion <1) {
            System.out.println("Opción invalida, intente nuevamente.");
        } else {
            if (confirmacion == 1) {
                switch (planeta) {
                    case 1:
                        System.out.println(planetas[0]);
                        System.out.println("La distancia de la tierra a " + planetas[0] + " es de: " + distancias[0]
                                + " millones de kilometros.");
                        System.out.println("Descripcion: " + descripcionPlaneta[0]);
                        break;
                    case 2:
                        System.out.println(planetas[1]);
                        System.out.println("La distancia de la tierra a " + planetas[1] + " es de: " + distancias[1]
                                + " millones de kilometros.");
                        System.out.println("Descripcion: " + descripcionPlaneta[1]);
                        break;
                    case 3:
                        System.out.println(planetas[2]);
                        System.out.println("La distancia de la tierra a " + planetas[2] + " es de: " + distancias[2]
                                + " millones de kilometros.");
                        System.out.println("Descripcion: " + descripcionPlaneta[2]);
                        break;
                    case 4:
                        System.out.println(planetas[3]);
                        System.out.println("La distancia de la tierra a " + planetas[3] + " es de: " + distancias[3]
                                + " millones de kilometros.");
                        System.out.println("Descripcion: " + descripcionPlaneta[3]);
                        break;
                    case 5:
                        System.out.println(planetas[4]);
                        System.out.println("La distancia de la tierra a " + planetas[4] + " es de: " + distancias[4]
                                + " millones de kilometros.");
                        System.out.println("Descripcion: " + descripcionPlaneta[4]);
                        break;
                    case 6:
                        System.out.println(planetas[5]);
                        System.out.println("La distancia de la tierra a " + planetas[5] + " es de: " + distancias[5]
                                + " millones de kilometros.");
                        System.out.println("Descripcion: " + descripcionPlaneta[5]);
                        break;
                    case 7:
                        System.out.println(planetas[6]);
                        System.out.println("La distancia de la tierra a " + planetas[6] + " es de: " + distancias[6]
                                + " millones de kilometros.");
                        System.out.println("Descripcion: " + descripcionPlaneta[6]);
                        break;
                    default:
                        break;
                }seleccionarNave(planeta);

            } else {
                System.out.println("Elige un planeta de destino");
                imprimirPlanetas();
                scanner.nextInt();
                switch (planeta) {
                    case 1:
                        System.out.println(planetas[0]);
                        System.out.println("La distancia de la tierra a " + planetas[0] + " es de: " + distancias[0]
                                + " millones de kilometros.");
                        System.out.println("Descripcion: " + descripcionPlaneta[0]);
                        break;
                    case 2:
                        System.out.println(planetas[1]);
                        System.out.println("La distancia de la tierra a " + planetas[1] + " es de: " + distancias[1]
                                + " millones de kilometros.");
                        System.out.println("Descripcion: " + descripcionPlaneta[1]);
                        break;
                    case 3:
                        System.out.println(planetas[2]);
                        System.out.println("La distancia de la tierra a " + planetas[2] + " es de: " + distancias[2]
                                + " millones de kilometros.");
                        System.out.println("Descripcion: " + descripcionPlaneta[2]);
                        break;
                    case 4:
                        System.out.println(planetas[3]);
                        System.out.println("La distancia de la tierra a " + planetas[3] + " es de: " + distancias[3]
                                + " millones de kilometros.");
                        System.out.println("Descripcion: " + descripcionPlaneta[3]);
                        break;
                    case 5:
                        System.out.println(planetas[4]);
                        System.out.println("La distancia de la tierra a " + planetas[4] + " es de: " + distancias[4]
                                + " millones de kilometros.");
                        System.out.println("Descripcion: " + descripcionPlaneta[4]);
                        break;
                    case 6:
                        System.out.println(planetas[5]);
                        System.out.println("La distancia de la tierra a " + planetas[5] + " es de: " + distancias[5]
                                + " millones de kilometros.");
                        System.out.println("Descripcion: " + descripcionPlaneta[5]);
                        break;
                    case 7:
                        System.out.println(planetas[6]);
                        System.out.println("La distancia de la tierra a " + planetas[6] + " es de: " + distancias[6]
                                + " millones de kilometros.");
                        System.out.println("Descripcion: " + descripcionPlaneta[6]);
                        break;
                    default:
                        break;
                }seleccionarNave(planeta);
            }
        }
    }

        
    public static void gestionarRecursos(String naveElegida, int pasajeros, int planeta,
            double velocidadDefecto) {
        

        // Cálculo de la duración del viaje
        double distanciaKm = distancias[planeta] * 1_000_000; // Convertir millones de km a km
        double duracionHoras = distanciaKm / velocidadDefecto;
        double duracionDias = duracionHoras / 24;

        System.out.println("Duración del viaje estimada: " + duracionDias + " días (" + duracionHoras + " horas).");
        System.out.println("Distancia al planeta: " + distanciaKm + " km.");

        // Iniciar simulación de vuelo con los datos calculados
        calcularRecursos(distanciaKm, naveElegida, pasajeros, planeta, velocidadDefecto);
    }


    public static void iniciarSimulacionVuelo(double distanciaKm, double oxigeno, double combustible, String naveElegida, int pasajeros, int planeta, double velocidadDefecto) {
            
        if (naveElegida == null || planeta == -1) {
            System.out.println("Por favor, selecciona una nave válida antes de iniciar la simulación.");
            return;
        }

        double distanciaRecorrida = 1000;
      
        double tiempoTranscurrido = 0;
        Random aleatorio= new Random();
        
        String[] eventos = {" Se acerca un asteroide","Existe fuga de oxigeno", "Se visualiza una nave invasora","Averia en el motor","Niveles de oxigeno bajos","Niveles de combustible bajos"};
        
        

        System.out.println("---- Inicio de simulación del viaje ----");
        System.out.println("");
        double porcentajeProgreso=0;

        while (oxigeno >0 && combustible> 0 && oxigeno >0  && combustible >0) {
            int eventoAleatorio= aleatorio.nextInt(5);
            tiempoTranscurrido= tiempoTranscurrido+10;
            distanciaRecorrida = velocidadDefecto*tiempoTranscurrido;
            oxigeno -= consumoPorHora;
            combustible -= consumoPorHora;
            porcentajeProgreso = porcentajeProgreso + 20;

            double tiempoRestante = (distanciaKm - distanciaRecorrida) / velocidadDefecto;
            if (porcentajeProgreso < 100) {

                System.out.printf("Progreso del viaje: %.2f%%\n", porcentajeProgreso);
                System.out.printf("Tiempo restante: %.2f horas\n", tiempoRestante);
                System.out.printf("Recursos disponibles: ");
                System.out.println("Oxigeno "+ oxigeno);
                System.out.println("Combustible "+ combustible);
                System.out.println("ALERTA");
                System.out.println(eventos[eventoAleatorio]);
                try {
                    Thread.sleep(1000); // Pausa para simular tiempo real
                } catch (InterruptedException e) {
                    System.err.println("Error en la simulación de tiempo.");
                }
            }

        }

        if (distanciaRecorrida >= distanciaKm) {

            System.out.println(" Viaje realizado con exito, bienvenido a su destino");
        }

        
        // } else {
        //     System.err.println("¡ La nave se a quedado sin recursos!, el viaje ha fallado");
        // }

    }

    public static void calcularRecursos(double distanciaKm,String naveElegida, int pasajeros, int planeta, double velocidadDefecto) {
        double oxigeno =1000;
        double combustible =5000;
        int opcionRecursos;

        System.out.println("La cantidad necesaria de oxigeno para el viaje son 9 litros por cada 6 personas");
        System.out.println("La cantidad necesaria de combustible para el viaje son 200 mil litros");
        System.out.println("¿Deseas modificar estos parametros?");
        System.out.println("1. Modificar combustible");
        System.out.println("2. Modificar oxigeno");
        System.out.println("3. Modificar oxigeno y combustible");
        System.out.println("4. No... continuar");
        do {
            opcionRecursos = scanner.nextInt();
            switch (opcionRecursos) {
                case 1:
                    System.out.println("Ingresa la modificación del combustible");
                    combustible = scanner.nextDouble();
                    if (combustible > 9) {
                        System.out.println("combustible ingresado correctamente");
                        iniciarSimulacionVuelo(distanciaKm, oxigeno, combustible, naveElegida, pasajeros, planeta, velocidadDefecto);

                        break;
                    } else {
                        System.out.println("la cantidad menor de combustible son de 9 litros");
                        scanner.nextInt();
                    }
                    break;
                case 2:
                    System.out.println("Ingresa la modificación del oxigeno");
                    oxigeno = scanner.nextDouble();
                    if (oxigeno > 200) {
                        System.out.println("oxigeno ingresado correctamente");
                        iniciarSimulacionVuelo(distanciaKm, oxigeno, combustible, naveElegida, pasajeros, planeta, velocidadDefecto);
                        break;
                    } else {
                        System.out.println("la cantidad menor de oxigeno son de 200 mil litros");
                    }
                    break;
                case 3:
                    System.out.println("Ingresa la modificación del oxigeno");
                    oxigeno = scanner.nextDouble();
                    if (oxigeno > 200) {
                        System.out.println("oxigeno ingresado correctamente");
                    } else {
                        System.out.println("la cantidad menor de oxigeno son de 200 mil litros");
                    }

                    System.out.println("Ingresa la modificación del combustible");
                    combustible = scanner.nextDouble();
                    if (combustible > 9) {
                        System.out.println("combustible ingresado correctamente");
                        iniciarSimulacionVuelo(distanciaKm, oxigeno, combustible, naveElegida, pasajeros, planeta, velocidadDefecto);
                        break;
                    } else {
                        System.out.println("la cantidad menor de combustible son de 9 litros");
                    }
                    break;
                case 4:
                    break;    
                default:
                    break;
                
                 } 


        } while (opcionRecursos != 4);
        
        iniciarSimulacionVuelo(distanciaKm, oxigeno, combustible, naveElegida, pasajeros, planeta, velocidadDefecto);
    }

    // Métodos auxiliares.
    public static void imprimirPlanetas() {
        int indice = 1;
        for (int index = 0; index < planetas.length; index++) {
            System.out.println(indice + "." + planetas[index]);
            indice = indice + 1;
        }
    }

   

    public static void detenerNave() {

    }

}