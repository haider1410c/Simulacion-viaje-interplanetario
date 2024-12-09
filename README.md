## Autores

- Saray Quiroz Vélez
- Haider Arley Cardenal Herrera


# Descripción simulacion viaje interplanetario

El aplicativo se desarrolló con el propósito de permitir al usuario calcular y planear un viaje entre los diferentes planetas del sistema solar, para ello se tiene una lista de los 8 planetas que se encuentran actualmente, estos planetas podrán ser elegidos por medio de un array de objetos cada uno de ellos al ser elegidos por el usuario mostrara una breve descripción al igual que la distancia de cada planeta dada en millones de kilómetros.

Se cuenta con 3 tipos de naves diferentes, las cuales contendrán una capacidad distinta de pasajeros cada una, al igual que una velocidad máxima, la cual el usuario podrá visualizar por consola

En el aplicativo se cuenta con dos opciones más, las cuales son Iniciar simulación de vuelo y permitirán salir del aplicativo

Cada uno de los planetas contienen su información al igual que la distancia que tienen desde la tierra, adicional a esto se podrá modificar la cantidad de combustible y oxígeno requerido para cada viaje, esto se calculara con base a la distancia y velocidad.

Este programa tiene modularidad en los métodos, cada método contiene diferentes parámetros que ayudaran con la elección o con la continuación de las diferentes interacciones que se realizaran durante el viaje.

A través de esto, el usuario podrá elegir o modificar recursos necesarios para el viaje, resolver eventos que se mostrarán aleatoriamente durante la simulación.

También podrá observar la duración, el progreso y el consumo de recursos durante el viaje por cada hora que pase, si no cumple con los recursos necesarios la nave se quedará varada en el espacio.


## Documentación

El programa arranca con un menú interactivo en el cual podrá seleccionar la nave, los planetas y posteriormente iniciar la simulación del viaje.

El programa cuenta con varias validaciones para que el usuario no pueda seleccionar letras o números decimales para algunos métodos, esto se hace con el fin de que no pueda dañar el programa fácilmente con algún carácter mal ingresado.

No podrá iniciar el programa sin haber seleccionado la nave o el planeta antes, con eso validamos que primero se tomen esas variables para poder correr el programa correctamente.

Se usan bucles, condicionales, arrays, entre otros. Para un mejor desempeño del programa, y hacer cumplir varias condiciones que se requieren para poder seguir correctamente con el programa.



## Despliegue del programa

Para ejecutar el proyecto usa

bash
  Java App.java
  