package quicksortterminal;

import java.util.ArrayList;

public class Quicksort {
    private int i;
    private int j;
    private int central;
    
    //Array list sobre el que se trabajará
    public ArrayList<Double> a = new ArrayList<>();
    
    public void ordenar(){
        //el rango inicial es la posición 0 y la última posición del arraylist
        quicksort(0,a.size()-1);
    }    
    
    private void quicksort(int primero, int ultimo){
        i=primero;//se cambia el valor i y j
        j=ultimo; 
        central =(primero+ultimo)/2;//encontrar la posición central en el arrayList
        double pivote = a.get(central);//asignar un pivote
        
        do{
            while(a.get(i)<pivote) {
                i++;
            }
            while(a.get(j)>pivote) {
                j--;
            }
            if(i<=j){
                intercambiar();
                i++;
                j--;
            }
        }while(i<=j);
        if(primero<j) quicksort(primero, j); //sublista izquierda
        if(i<ultimo) quicksort(i, ultimo); //sublista derecha
    }
    
    private void intercambiar(){
        double x = a.get(i);
        a.set(i,a.get(j));
        //a[i]=a[j];
        a.set(j,x);
        //a[j]=x;
    }
}
