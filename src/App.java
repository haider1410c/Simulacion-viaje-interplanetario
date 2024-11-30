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
                    calcularRecursos();
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
        int limitePasajeros[] = { 7, 15, 5 };
        int pasajeros; 
        double velocidadDefecto = velocidades[opcionNave - 1];
        while (true) {
            System.out.println("Ingrese la cantidad de pasajeros");
            if (scanner.hasNextInt()) { //se verifica que el dato ingresado sea un número
                pasajeros = scanner.nextInt();
                if (pasajeros >=1) {
                    if (opcionNave == 1 && pasajeros >7 ) {
                    System.out.println("El número de pasajeros supera la capacidad máxima de la nave. Capacidad máxima(7 pasajeros)");

                    } else {
                        if (opcionNave == 2 && pasajeros >15 ) {
                            System.out.println("El número de pasajeros supera la capacidad máxima de la nave. Capacidad máxima(15 pasajeros) ");
                        } else {
                            if (opcionNave == 3 && pasajeros >5) {
                                System.out.println("El número de pasajeros supera la capacidad máxima de la nave. Capacidad máxima(5 pasajeros) ");
                            } else {
                                System.out.println("Pasajeros registrados exitosamente");
                                break;
                            } 
                        }
                    }
                } else {
                    System.out.println("El número de pasajeros debe ser mayor a 0");
                    
                }
            } else {
                System.out.println("Por favor, introduce un número válido.");
                scanner.nextInt();
            }

        }
        
        // Verifica que la cantidad de pasajeros no exceda la capacidad maxima de las naves

        // while (pasajeros <= 0) {
        //     if (pasajeros <= limitePasajeros[0] || pasajeros >= limitePasajeros[1] || pasajeros <= limitePasajeros[2]) {
        //         System.out.println("Pasajeros ingresados correctamente");

        //     } else {
        //         System.err.println("Excediste la cantidad maxima");
        //     }
        // }

        gestionarRecursos(naveElegida,pasajeros);

        System.out.println("Nave: " + naveElegida + " velocidad maxima " + velocidadDefecto + " Cantidad de pasajeros : " + pasajeros);

    }

    public static void seleccionarPlaneta() {
        int planeta;
        int velocidadFija= 1;
        double tiempo;
        System.out.println("Elige un planeta de destino");
        imprimirPlanetas();
        planeta = scanner.nextInt();
        switch (planeta) {
            case 1:
                tiempo= distancias[0]/velocidadFija;
                System.out.println(planetas[0]);
                System.out.println("La distancia de la tierra a "+ planetas[0] +" es de: " +distancias[0]+" millones de kilometros."+ "El tiempo aproximado para llegar es de: "+tiempo +" horas, viajando a una velocidad fija de: "+ velocidadFija + " millón de kilometros por hora");
                System.out.println("Descripcion: "+ descripcionPlaneta[0]);

                break;
            case 2:
                tiempo= distancias[1]/velocidadFija;
                System.out.println(planetas[1]);
                System.out.println("La distancia de la tierra a "+ planetas[1] +" es de: " +distancias[1]+" millones de kilometros."+ "El tiempo aproximado para llegar es de: "+ tiempo +" horas, viajando a una velocidad fija de: "+ velocidadFija + " millón de kilometros por hora");
                System.out.println("Descripcion: "+ descripcionPlaneta[1]);

                break;
            case 3:
                tiempo= distancias[2]/velocidadFija;
                System.out.println(planetas[2]);
                System.out.println("La distancia de la tierra a "+ planetas[2] +" es de: " +distancias[2]+" millones de kilometros."+ "El tiempo aproximado para llegar es de: "+ tiempo +" horas, viajando a una velocidad fija de: "+ velocidadFija + " millón de kilometros por hora");
                System.out.println("Descripcion: "+ descripcionPlaneta[2]);
                break;
            case 4:
                tiempo= distancias[3]/velocidadFija;
                System.out.println(planetas[3]);
                System.out.println("La distancia de la tierra a "+ planetas[3] +" es de: " +distancias[3]+" millones de kilometros."+ "El tiempo aproximado para llegar es de: "+ tiempo +" horas, viajando a una velocidad fija de: "+ velocidadFija + " millón de kilometros por hora");
                System.out.println("Descripcion: "+ descripcionPlaneta[3]);
                break;   
            case 5:
                tiempo= distancias[4]/velocidadFija;
                System.out.println(planetas[4]);
                System.out.println("La distancia de la tierra a "+ planetas[4] +" es de: " +distancias[4]+" millones de kilometros."+ "El tiempo aproximado para llegar es de: "+ tiempo +" horas, viajando a una velocidad fija de: "+ velocidadFija + " millón de kilometros por hora");
                System.out.println("Descripcion: "+ descripcionPlaneta[4]);
                break; 
            case 6:
                tiempo= distancias[5]/velocidadFija;
                System.out.println(planetas[5]);
                System.out.println("La distancia de la tierra a "+ planetas[5] +" es de: " +distancias[5]+" millones de kilometros."+ "El tiempo aproximado para llegar es de: "+ tiempo +" horas, viajando a una velocidad fija de: "+ velocidadFija + " millón de kilometros por hora");
                System.out.println("Descripcion: "+ descripcionPlaneta[5]);
                break;
            case 7:
                tiempo= distancias[6]/velocidadFija;
                System.out.println(planetas[6]);
                System.out.println("La distancia de la tierra a "+ planetas[6] +" es de: " +distancias[6]+" millones de kilometros."+ "El tiempo aproximado para llegar es de: "+ tiempo +" horas, viajando a una velocidad fija de: "+ velocidadFija + " millón de kilometros por hora");
                System.out.println("Descripcion: "+ descripcionPlaneta[6]);
                break;
            default:
                break;
        }
    }

   public static void gestionarRecursos(String naveElegida, int pasajeros){
       
   }

    public static void calcularRecursos() {
        // Disntancia del viaje
      
        seleccionarNave();
       
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
