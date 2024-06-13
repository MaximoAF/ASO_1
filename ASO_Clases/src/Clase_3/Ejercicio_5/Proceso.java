package Clase_3.Ejercicio_5;

import java.util.Random;

public class Proceso  implements Runnable{
    static int cont =0;
    private static Object object = new Object();

    @Override
    public void run(){
        synchronized (object){
            for (int i = 0;i<2000;i++){
                cont++;
            }
        }
    }
}