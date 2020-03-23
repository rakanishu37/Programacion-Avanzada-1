package Ejercicio3;

public class Main {
    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();
        pila.push(2);
        //System.out.println(pila);
        pila.push(21);
        System.out.println(pila);
        pila.push(-1);
        //System.out.println(pila);

        System.out.println(pila.size());

        System.out.println(pila.pop());
        System.out.println(pila.size());
    }
}
