package Ejercicio3;

public class Pila<T> {
    private Node<T> lista;

    public Pila() {
        this.lista = null;
    }

    /**
     * Agrega un elemento a la EJ3.Pila
     *
     * @param elemento
     */
    public void push(T elemento) {
        Node<T> nuevoElemento = new Node<T>(elemento);
        if (this.lista == null) {
            this.lista = nuevoElemento;
        } else {
            if (this.lista.getNext() == null) {
                this.lista.setNext(nuevoElemento);
            } else {
                Node<T> aux = this.lista.getNext();
                while (aux.getNext() != null) {
                    aux = aux.getNext();
                }
                aux.setNext(nuevoElemento);
            }
        }
    }

    /**
     * Tomar el primer elemento de la pila y lo devuelve
     *
     * @return
     */
    public T pop() {
        T eliminado = null;
        if (this.lista != null) {
            if (this.lista.getNext() == null) {
                eliminado = this.lista.getElement();
                this.lista = null;
            } else {
                Node<T> ant = this.lista;
                Node<T> aux = ant.getNext();

                while (aux.getNext() != null) {
                    ant = ant.getNext();
                    aux = aux.getNext();
                }
                ant.setNext(null);
                eliminado = aux.getElement();
            }
        }
        return eliminado;
    }

    /**
     * Cuenta la cantidad de elementos que hay en la EJ3.Pila
     *
     * @return
     */
    public int size() {
        int size = 0;

        if (this.lista != null) {
            Node<T> aux = this.lista;
            size = 1;
            while (aux.getNext() != null) {
                size++;
                aux = aux.getNext();
            }
        }

        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tope\n");

        for (int i = size() - 1; i >= 0; i--) {
            //sb.append(lista.get(i).getElement()+" \n");
        }
        sb.append("Base");
        return sb.toString();
    }

}
