package Trabajos_Practicos.Trabajo_Sincronizacion_complementario;

class TicketCounter {
    private int availableTickets;

    public TicketCounter(int totalTickets) {
        this.availableTickets = totalTickets;
    }

    public synchronized void buyTickets(int ticketsToBuy, String name) {
        if (availableTickets >= ticketsToBuy) {
            System.out.println(name + " está comprando " + ticketsToBuy + " entradas.");
            availableTickets -= ticketsToBuy;
            System.out.println("Entradas compradas por " + name + ". Entradas restantes: " + availableTickets);
        } else {
            System.out.println("Lo siento, no hay suficientes entradas disponibles para " + name);
        }
    }

    public int getAvailableTickets() {
        return availableTickets;
    }
}

