package Clases;

import java.util.List;

// Interfaz AlgoritmoConcurrencia
interface AlgoritmoConcurrencia {
    void iniciarSimulacion(List<Proceso> procesos); // Método para iniciar la simulación con una lista de procesos
    void obtenerResultados(); // Método para obtener los resultados de la simulación
}