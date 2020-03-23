package Ejecicio1y2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Contenedora<T extends Comparable> {

    private List<T> array;

    public Contenedora() {
        this.array = new ArrayList<>();
    }

    public void add(T value) {
        this.array.add(value);
    }

    public boolean verifyValue(T value) {
        return this.array.contains(value);
    }

    public T getMaxValue() {
        /*T max = null;
        if (!this.array.isEmpty()) {
            max = this.array.get(0);
            for (T e : this.array) {
                if (max.compareTo(e) < 0) {
                    max = e;
                }
            }
        }
        return max;*/
        return (T) Collections.max(this.array);
    }

    public T getMinValue() {
        /*T max = null;
        if (!this.array.isEmpty()) {
            max = this.array.get(0);
            for (T e : this.array) {
                if (max.compareTo(e) < 0) {
                    max = e;
                }
            }
        }
        return max;*/
        return (T) Collections.min(this.array);
    }

    public T remove() {
        return this.array.remove(this.array.size() - 1);
    }

    @Override
    public String toString() {
        return "EJ1.Contenedora{" +
                "array=" + array +
                '}';
    }

    public int getSize() {
        return this.array.size();
    }
}
