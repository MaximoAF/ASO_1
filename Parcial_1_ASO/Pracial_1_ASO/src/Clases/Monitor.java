package Clases;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Clase Monitor (Implementa AlgoritmoConcurrencia)
public class Monitor implements AlgoritmoConcurrencia {
    private boolean bloqueado; // Indica si el monitor está bloqueado
    private Queue<Proceso> colaEspera; // Cola de procesos esperando para entrar al monitor

    // Constructor
    public Monitor() {
        this.bloqueado = false; // Inicializa el monitor como no bloqueado
        this.colaEspera = new LinkedList<>(); // Inicializa la cola de espera
    }

    // Getters y Setters
    public boolean isBloqueado() {
        return bloqueado; // Devuelve si el monitor está bloqueado
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado; // Establece si el monitor está bloqueado
    }

    public Queue<Proceso> getColaEspera() {
        return colaEspera; // Devuelve la cola de espera
    }

    public void setColaEspera(Queue<Proceso> colaEspera) {
        this.colaEspera = colaEspera; // Establece la cola de espera
    }

    // Métodos de AlgoritmoConcurrencia
    @Override
    public void iniciarSimulacion(List<Proceso> procesos) {
        System.out.println("Iniciando simulación con monitor..."); // Imprime mensaje de inicio de simulación
        for (Proceso proceso : procesos) {
            entrar(proceso); // Hace que el proceso entre al monitor
            proceso.ejecutar(); // Ejecuta el proceso
            salir(proceso); // Hace que el proceso salga del monitor
        }
    }

    @Override
    public void obtenerResultados() {
        System.out.println("Obteniendo resultados de la simulación con monitor..."); // Imprime mensaje de obtención de resultados
        for (Proceso proceso : colaEspera) {
            System.out.println("Proceso ID: " + proceso.getId() + " Estado: " + proceso.getEstado()); // Imprime el estado de cada proceso en la cola de espera
        }
    }

    // Método para que un proceso entre al monitor
    public synchronized void entrar(Proceso proceso) {
        if (!bloqueado) {
            bloqueado = true; // Bloquea el monitor
            colaEspera.add(proceso); // Agrega el proceso a la cola de espera
            System.out.println("Proceso con ID: " + proceso.getId() + " ha entrado al monitor."); // Imprime mensaje de entrada al monitor
        } else {
            System.out.println("Proceso con ID: " + proceso.getId() + " está esperando para entrar al monitor."); // Imprime mensaje de espera para entrar al monitor
            while (bloqueado) {
                try {
                    wait(); // Espera hasta que el monitor esté desbloqueado
                } catch (InterruptedException e) {
                    e.printStackTrace(); // Imprime el stack trace en caso de interrupción
                }
            }
            bloqueado = true; // Bloquea el monitor
            colaEspera.add(proceso); // Agrega el proceso a la cola de espera
        }
    }

    // Método para que un proceso salga del monitor
    public synchronized void salir(Proceso proceso) {
        bloqueado = false; // Desbloquea el monitor
        colaEspera.remove(proceso); // Remueve el proceso de la cola de espera
        proceso.finalizar(); // Finaliza el proceso
        System.out.println("Proceso con ID: " + proceso.getId() + " ha salido del monitor."); // Imprime mensaje de salida del monitor
        notify(); // Notifica a los hilos en espera
    }
}
