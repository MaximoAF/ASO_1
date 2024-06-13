package Clases;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Clase Semaforo (Implementa AlgoritmoConcurrencia)
public class Semaforo implements AlgoritmoConcurrencia {
    private Queue<Proceso> colaProcesos; // Cola de procesos esperando para ser ejecutados
    private int valor; // Valor del semáforo

    // Constructor
    public Semaforo(int valor) {
        this.colaProcesos = new LinkedList<>(); // Inicializa la cola de procesos
        this.valor = valor; // Establece el valor inicial del semáforo
    }

    // Getters y Setters
    public Queue<Proceso> getColaProcesos() {
        return colaProcesos; // Devuelve la cola de procesos
    }

    public void setColaProcesos(Queue<Proceso> colaProcesos) {
        this.colaProcesos = colaProcesos; // Establece la cola de procesos
    }

    public int getValor() {
        return valor; // Devuelve el valor del semáforo
    }

    public void setValor(int valor) {
        this.valor = valor; // Establece el valor del semáforo
    }

    // Métodos de AlgoritmoConcurrencia
    @Override
    public void iniciarSimulacion(List<Proceso> procesos) {
        System.out.println("Iniciando simulación con semáforo..."); // Imprime mensaje de inicio de simulación
        for (Proceso proceso : procesos) {
            P(proceso); // Ejecuta la operación P (wait) en el semáforo
            proceso.ejecutar(); // Ejecuta el proceso
            V(proceso); // Ejecuta la operación V (signal) en el semáforo
        }
    }

    @Override
    public void obtenerResultados() {
        System.out.println("Obteniendo resultados de la simulación con semáforo..."); // Imprime mensaje de obtención de resultados
        for (Proceso proceso : colaProcesos) {
            System.out.println("Proceso ID: " + proceso.getId() + " Estado: " + proceso.getEstado()); // Imprime el estado de cada proceso en la cola
        }
    }

    // Operación P (wait) en el semáforo
    public synchronized void P(Proceso proceso) {
        if (valor > 0) {
            valor--; // Decrementa el valor del semáforo
            colaProcesos.add(proceso); // Agrega el proceso a la cola
            System.out.println("Proceso con ID: " + proceso.getId() + " ha entrado en la sección crítica."); // Imprime mensaje de entrada a la sección crítica
        } else {
            System.out.println("Proceso con ID: " + proceso.getId() + " está esperando."); // Imprime mensaje de espera
            while (valor <= 0) {
                try {
                    wait(); // Espera hasta que el valor del semáforo sea mayor a 0
                } catch (InterruptedException e) {
                    e.printStackTrace(); // Imprime el stack trace en caso de interrupción
                }
            }
            valor--; // Decrementa el valor del semáforo
            colaProcesos.add(proceso); // Agrega el proceso a la cola
        }
    }

    // Operación V (signal) en el semáforo
    public synchronized void V(Proceso proceso) {
        valor++; // Incrementa el valor del semáforo
        colaProcesos.remove(proceso); // Remueve el proceso de la cola
        proceso.finalizar(); // Finaliza el proceso
        System.out.println("Proceso con ID: " + proceso.getId() + " ha salido de la sección crítica."); // Imprime mensaje de salida de la sección crítica
        notify(); // Notifica a los hilos en espera
    }
}