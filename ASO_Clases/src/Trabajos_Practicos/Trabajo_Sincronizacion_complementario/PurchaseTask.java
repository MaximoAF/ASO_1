package Trabajos_Practicos.Trabajo_Sincronizacion_complementario;

class PurchaseTask implements Runnable {
    private TicketCounter ticketCounter;
    private String name;

    public PurchaseTask(TicketCounter ticketCounter, String name) {
        this.ticketCounter = ticketCounter;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            ticketCounter.buyTickets(1, name);
            try {
                Thread.sleep(100); // Simular tiempo de espera entre compras
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
