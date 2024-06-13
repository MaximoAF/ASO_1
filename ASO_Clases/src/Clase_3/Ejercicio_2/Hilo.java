package Clase_3.Ejercicio_2;

public class Hilo extends Thread{

private int id;
 static int cont =0;

    public Hilo(String name, int id) {
        super(name);
        this.id = id;
    }

    public void run(){

        for (int i = 0; i < 10 ; i++) {

            cont++;

        }
    }
}
