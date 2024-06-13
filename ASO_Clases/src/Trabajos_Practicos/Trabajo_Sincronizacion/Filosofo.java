package Trabajos_Practicos.Trabajo_Sincronizacion;

import java.util.Random;

class Filosofo implements Runnable {
    private final int id;
    private final Cubierto izquierdo;
    private final Cubierto derecho;
    private final Random random = new Random();

    public Filosofo(int id, Cubierto izquierdo, Cubierto derecho) {
        this.id = id;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    private void comer() throws InterruptedException {
        synchronized (izquierdo) {
            synchronized (derecho) {
                System.out.println("Filosofo " + id + " comiendo");
                Thread.sleep(random.nextInt(4000) + 1000);
            }
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println("El filosofo " + id + " está pensando");
        Thread.sleep(random.nextInt(4000) + 1000);
    }

    @Override
    public void run() {
        while (true) {
            try {
                comer();
                pensar();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}