package Clases;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlgoritmoFernandez implements AlgoritmoConcurrencia {
    private Queue<Proceso> colaProcesos; // Cola de procesos

    // Constructor
    public AlgoritmoFernandez() {
        this.colaProcesos = new LinkedList<>(); // Inicializa la cola de procesos
    }

    // Getters y Setters
    public Queue<Proceso> getColaProcesos() {
        return colaProcesos; // Devuelve la cola de procesos
    }

    public void setColaProcesos(Queue<Proceso> colaProcesos) {
        this.colaProcesos = colaProcesos; // Establece la cola de procesos
    }

    // Métodos de AlgoritmoConcurrencia
    @Override
    public void iniciarSimulacion(List<Proceso> procesos) {
        System.out.println("Iniciando simulación con AlgoritmoFernandez..."); // Imprime mensaje de inicio de simulación
        for (Proceso proceso : procesos) {
            ejecutarProceso(proceso); // Ejecuta el proceso
        }
    }

    @Override
    public void obtenerResultados() {
        System.out.println("Obteniendo resultados de la simulación con AlgoritmoFernandez..."); // Imprime mensaje de obtención de resultados
        for (Proceso proceso : colaProcesos) {
            System.out.println("Proceso ID: " + proceso.getId() + " Estado: " + proceso.getEstado()); // Imprime el estado de cada proceso en la cola
        }
    }

    // Método para ejecutar un proceso
    private void ejecutarProceso(Proceso proceso) {
        System.out.println("Ejecutando proceso con ID: " + proceso.getId()); // Imprime mensaje de ejecución del proceso
        proceso.ejecutar(); // Ejecuta el proceso
        colaProcesos.add(proceso); // Agrega el proceso a la cola
    }
}
