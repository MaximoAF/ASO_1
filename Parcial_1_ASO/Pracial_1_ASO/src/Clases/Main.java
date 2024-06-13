package Clases;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear procesos
        Proceso proceso1 = new Proceso("listo", 1, 3);
        Proceso proceso2 = new Proceso("listo", 2, 5);
        Proceso proceso3 = new Proceso("listo", 3, 2);
        Proceso proceso4 = new Proceso("listo", 4, 4);
        Proceso proceso5 = new Proceso("listo", 5, 2);
        Proceso proceso6 = new Proceso("listo", 6, 3);

        // Crear lista de procesos
        List<Proceso> listaProcesos = new ArrayList<>();
        listaProcesos.add(proceso1);
        listaProcesos.add(proceso2);
        listaProcesos.add(proceso3);

        // Crear simulador con Semaforo
        Simulador simuladorSemaforo = new Simulador(new Semaforo(1));
        simuladorSemaforo.setListaProcesos(listaProcesos);

        // Crear simulador con Monitor
        Simulador simuladorMonitor = new Simulador(new Monitor());
        simuladorMonitor.setListaProcesos(listaProcesos);

        // Crear simulador con Algoritmo de Aguilera
        Simulador simuladorAguilera = new Simulador(new AlgoritmoAguilera());
        simuladorAguilera.setListaProcesos(listaProcesos);

        // Crear lista de procesos adicionales
        List<Proceso> listaProcesosAdicionales = new ArrayList<>();
        listaProcesosAdicionales.add(proceso4);
        listaProcesosAdicionales.add(proceso5);
        listaProcesosAdicionales.add(proceso6);

        // Crear simuladores adicionales con diferentes algoritmos
        Simulador simuladorSemaforoAdicional = new Simulador(new Semaforo(1));
        Simulador simuladorMonitorAdicional = new Simulador(new Monitor());
        Simulador simuladorAguileraAdicional = new Simulador(new AlgoritmoAguilera());

        // Agregar procesos adicionales a los simuladores adicionales
        simuladorSemaforoAdicional.setListaProcesos(listaProcesosAdicionales);
        simuladorMonitorAdicional.setListaProcesos(listaProcesosAdicionales);
        simuladorAguileraAdicional.setListaProcesos(listaProcesosAdicionales);

        // Iniciar simulación en los simuladores
        simuladorSemaforo.iniciarSimulacion();
        simuladorMonitor.iniciarSimulacion();
        simuladorAguilera.iniciarSimulacion();
        simuladorSemaforoAdicional.iniciarSimulacion();
        simuladorMonitorAdicional.iniciarSimulacion();
        simuladorAguileraAdicional.iniciarSimulacion();

        // Obtener resultados de los simuladores
        System.out.println("Resultados del simulador con Semaforo:");
        simuladorSemaforo.getAlgoritmo().obtenerResultados();
        System.out.println("\nResultados del simulador con Monitor:");
        simuladorMonitor.getAlgoritmo().obtenerResultados();
        System.out.println("\nResultados del simulador con Algoritmo de Aguilera:");
        simuladorAguilera.getAlgoritmo().obtenerResultados();
        System.out.println("\nResultados del simulador adicional con Semaforo:");
        simuladorSemaforoAdicional.getAlgoritmo().obtenerResultados();
        System.out.println("\nResultados del simulador adicional con Monitor:");
        simuladorMonitorAdicional.getAlgoritmo().obtenerResultados();
        System.out.println("\nResultados del simulador adicional con Algoritmo de Aguilera:");
        simuladorAguileraAdicional.getAlgoritmo().obtenerResultados();
    }
}
