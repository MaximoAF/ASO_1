package Trabajos_Practicos.Trabajo_Sincronizacion_complementario;

public class Main {
    public static void main(String[] args) {
        TicketCounter ticketCounter = new TicketCounter(10);

        Thread thread1 = new Thread(new PurchaseTask(ticketCounter, "Persona 1"));
        Thread thread2 = new Thread(new PurchaseTask(ticketCounter, "Persona 2"));

        thread1.start();
        thread2.start();
    }
}
