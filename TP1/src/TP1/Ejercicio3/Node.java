package TP1.Ejercicio3;

public class Node<T>{
    private T element;
    private Node<T> next;

    public Node(T element) {
        this.element = element;
        this.next = null;
    }

     T getElement() {
        return element;
    }

    private void setElement(T element) {
        this.element = element;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext(){
        return this.next;
    }
}
