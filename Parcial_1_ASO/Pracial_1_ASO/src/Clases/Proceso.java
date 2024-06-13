package Clases;


// Clase Proceso
public class Proceso {
    private String estado; // Estado del proceso
    private int id; // Identificador único del proceso
    private int tiempoEjecucion; // Tiempo de ejecución del proceso en segundos
    private Integer tiempoFinalizacion; // Tiempo de finalización del proceso en segundos (puede ser null)

    // Constructor
    public Proceso(String estado, int id, int tiempoEjecucion) {
        this.estado = estado; // Inicializa el estado del proceso
        this.id = id; // Asigna el ID del proceso
        this.tiempoEjecucion = tiempoEjecucion; // Establece el tiempo de ejecución del proceso
        this.tiempoFinalizacion = null; // Inicializa el tiempo de finalización como null
    }

    // Getters y Setters
    public String getEstado() {
        return estado; // Devuelve el estado del proceso
    }

    public void setEstado(String estado) {
        this.estado = estado; // Establece el estado del proceso
    }

    public int getId() {
        return id; // Devuelve el ID del proceso
    }

    public void setId(int id) {
        this.id = id; // Establece el ID del proceso
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion; // Devuelve el tiempo de ejecución del proceso
    }

    public void setTiempoEjecucion(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion; // Establece el tiempo de ejecución del proceso
    }

    public Integer getTiempoFinalizacion() {
        return tiempoFinalizacion; // Devuelve el tiempo de finalización del proceso
    }

    public void setTiempoFinalizacion(Integer tiempoFinalizacion) {
        this.tiempoFinalizacion = tiempoFinalizacion; // Establece el tiempo de finalización del proceso
    }

    // Método para ejecutar el proceso
    public void ejecutar() {
        System.out.println("Ejecutando proceso con ID: " + id); // Imprime el mensaje de ejecución del proceso
        this.estado = "ejecutando"; // Cambia el estado del proceso a "ejecutando"
        try {
            // Simula el tiempo de ejecución del proceso
            Thread.sleep(tiempoEjecucion * 1000); // Suspende el hilo actual durante el tiempo de ejecución especificado
        } catch (InterruptedException e) {
            e.printStackTrace(); // Imprime el stack trace en caso de interrupción
        }
    }

    // Método para finalizar el proceso
    public void finalizar() {
        System.out.println("Finalizando proceso con ID: " + id); // Imprime el mensaje de finalización del proceso
        this.estado = "finalizado"; // Cambia el estado del proceso a "finalizado"
        this.tiempoFinalizacion = (int) (System.currentTimeMillis() / 1000L); // Establece el tiempo de finalización al tiempo actual en segundos
    }
}