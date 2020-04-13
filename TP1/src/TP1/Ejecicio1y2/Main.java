package TP1.Ejecicio1y2;

public class Main {
    public static void main(String[] args) {
        Contenedora<Persona> a = new Contenedora<>();

        a.add(new Persona(100));
        a.add(new Persona(500));
        a.add(new Persona(250));
        a.add(new Persona(333));

        System.out.println(a.verifyValue(new Persona(100)));

        System.out.println(a.verifyValue(new Persona(102)));

        System.out.println(a.getMaxValue());

        System.out.println(a.getMinValue());

        Persona p = null;

        p = a.remove();

        System.out.println(p);

    }
}
