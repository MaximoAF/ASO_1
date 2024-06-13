package Clase_3.Ejercicio_2;


public class Ejercicio3 {

    // Programacion Concurrente Indeterminacion se produce cuando dos o
    // mas hilos escriben a la vez en una variable compartida

    public static void main(String[] args) {

          Hilo[] hilos = new Hilo[100];

        for (int i = 0; i < hilos.length; i++) {

            hilos[i] = new Hilo("Hilo " + i, i);
            hilos[i].start();

           /* try{
                hilos[i].join();
            }
            catch(Exception E){}*/

        }

/*


*/

        System.out.println(Hilo.cont);


        }

    }

