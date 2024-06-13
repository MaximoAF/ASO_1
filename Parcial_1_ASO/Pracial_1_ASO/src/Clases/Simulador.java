package Clases;

import java.util.LinkedList;
import java.util.List;

// Clase Simulador
public class Simulador {
    private AlgoritmoConcurrencia algoritmo; // Algoritmo de concurrencia utilizado en la simulación
    private List<Proceso> listaProcesos; // Lista de procesos a simular

    // Constructor
    public Simulador(AlgoritmoConcurrencia algoritmo) {
        this.algoritmo = algoritmo; // Establece el algoritmo de concurrencia
        this.listaProcesos = new LinkedList<>(); // Inicializa la lista de procesos
    }

    // Getters y Setters
    public AlgoritmoConcurrencia getAlgoritmo() {
        return algoritmo; // Devuelve el algoritmo de concurrencia
    }

    public void setAlgoritmo(AlgoritmoConcurrencia algoritmo) {
        this.algoritmo = algoritmo; // Establece el algoritmo de concurrencia
    }

    public List<Proceso> getListaProcesos() {
        return listaProcesos; // Devuelve la lista de procesos
    }

    public void setListaProcesos(List<Proceso> listaProcesos) {
        this.listaProcesos = listaProcesos; // Establece la lista de procesos
    }

    // Método para agregar un proceso a la lista
    public void agregarProceso(Proceso proceso) {
        listaProcesos.add(proceso); // Agrega un proceso a la lista
    }

    // Método para iniciar la simulación
    public void iniciarSimulacion() {
        algoritmo.iniciarSimulacion(listaProcesos); // Inicia la simulación usando el algoritmo de concurrencia
    }

    // Método para seleccionar el algoritmo de concurrencia
    public void seleccionarAlgoritmo(AlgoritmoConcurrencia algoritmo) {
        this.algoritmo = algoritmo; // Establece el algoritmo de concurrencia
    }
}