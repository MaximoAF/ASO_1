package Trabajos_Practicos.Trabajo_Sincronizacion;

public class Main {
    public static void main(String[] args) {
        final int numFilosofos = 5;
        Filosofo[] filosofos = new Filosofo[numFilosofos];
        Cubierto[] cubiertos = new Cubierto[numFilosofos];

        for (int i = 0; i < numFilosofos; i++) {
            cubiertos[i] = new Cubierto();
        }

        for (int i = 0; i < numFilosofos; i++) {
            filosofos[i] = new Filosofo(i + 1, cubiertos[i], cubiertos[(i + 1) % numFilosofos]);
            new Thread(filosofos[i]).start();
        }
    }
}




