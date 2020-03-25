package TP1.Ejecicio1y2;

import java.util.Objects;

public class Persona implements Comparable{
    private float salario;

    public Persona(float salario){
        this.salario=salario;
    }
    public float getSalario(){
        return this.salario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || !(o instanceof Persona)) return false;

        Persona persona = (Persona) o;

        return Float.compare(persona.salario, salario) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(salario);
    }

    @Override
    public int compareTo(Object x) {
        if (!(x instanceof Persona)){
			return -1;
		}
		Persona o = (Persona)x;
        if(this.salario>o.getSalario()){
            return 1;
        }
        else{
            if(this.salario == o.getSalario()){
                return 0;
            }
            else{
                return -1;
            }
        }
    }

    @Override
    public String toString() {
        return "EJ1.Persona{" +
                "salario=" + salario +
                '}';
    }
}
