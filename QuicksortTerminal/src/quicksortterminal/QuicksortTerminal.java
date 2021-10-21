package quicksortterminal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.Scanner;


public class QuicksortTerminal {
    
    public static void main(String[] args) {
        Quicksort quickS = new Quicksort();
        
        Scanner sc = new Scanner(System.in);
        int opc;
        do{
            int numV =0;
            quickS.a.clear();
            System.out.println("1)Ingresar valores \n2)Valores aleatorios \n3)Salir");
            opc = sc.nextInt();
            String antes = "";
            switch(opc){
                case 1 -> {
                    //Para ingresar datos un número dado de veces
                    System.out.print("Número de valores a ingresar: ");
                    numV = sc.nextInt();
                    //Recibe tantos datos como se haya indicado
                    for (int i=1; i<=numV; i++) {
                        System.out.print(i+": ");
                        quickS.a.add(redondear(sc.nextDouble()));
                    }
                    antes = quickS.a.toString();//guardar valor del arrayList antes de aplicarle el Quicksort
                    quickS.ordenar();//este método llama al método recursivo Quicksort
                    System.out.println("Los números " + antes 
                            +"\nordenados por Quicksort quedan de la siguiente manera:\n"
                            +quickS.a.toString() );
                }
                
                case 2 -> {
                    //para generar un arrayList con una cantidad de valores dada
                    System.out.print("Numero de valores a generar: ");
                    numV= sc.nextInt();
                    //Genera y añade tantos datos como se le haya indicado
                    for (int i=0; i<numV; i++) {
                        quickS.a.add(numeroR());
                    }
                    antes= quickS.a.toString();//guardar valor del arrayList antes de aplicarle el Quicksort
                    quickS.ordenar(); //este método llama al método recursivo Quicksort
                    System.out.println("Los números " + antes 
                            +"\nordenados por Quicksort quedan de la siguiente manera:\n"
                            +quickS.a.toString() );
                }
            }
        }while(opc==1||opc==2);
    }
    
    //generar un double aleatorio
    public static double numeroR(){
        double min = -100; //rango mínimo del número aleatorio
        double max = 100; //rango máximo del número aleatorio
        Random r = new Random(); //crear un objeto de tipo Random
        double randomValue = redondear(min + (max - min) * r.nextDouble()); //genera el número aleatorio y lo redondea con el método redondear(double)
        return randomValue;
    }
    
    //redondear un double a 1 decimal
    public static double redondear(double value) {
        BigDecimal bd = BigDecimal.valueOf(value); //variable de tipo BigDecimal
        bd = bd.setScale(1, RoundingMode.HALF_UP); //para poder usar el método para redondear
        return bd.doubleValue();  //convierte el BigDecimal a double
    }
    
}
