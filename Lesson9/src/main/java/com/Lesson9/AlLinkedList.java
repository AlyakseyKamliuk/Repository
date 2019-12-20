package com.Lesson9;


public class AlLinkedList<T> {


    private Element<T> first = null;
    private Element<T> last = null;
    private int size = 0;
    private Element<T> lastReturnedElement = null;
    private int index = 0;

    public void add(T element) {
        addLast(element);
    }

    public void addLast(T element) {
        Element<T> first = this.last;
        Element<T> el = new Element<>(element, last, null);
        if (first == null) {
            this.first = el;
            this.last = el;
        } else {
            this.last = el;
            this.last.prev.next = el;
        }
        size++;
    }

    public void set(int index, T element) {
        lastReturnedElement = first;
        for (int i = 0; i < index; i++) {
            lastReturnedElement = nextI(i);
        }
        lastReturnedElement.value = element;
        this.index = 0;
    }

    public void addFirst(T element) {
        Element<T> e = new Element<>(element, null, this.first);
        this.first.prev = e;
        this.first = e;
        size++;
    }

    public T next() {
        Element<T> next = first;
        if (index == 0) {
            index++;
            lastReturnedElement = next;
            return lastReturnedElement.value;
        } else {
            lastReturnedElement = nextI(index);
            if (this.index == size) {
                this.index = 0;
            }
            return lastReturnedElement.value;
        }
    }

    public void removeLast() {
        last = last.prev;
        last.next=null;
        size--;
    }

    public void removeFirst() {
        first = first.next;
        first.prev=null;
        size--;
    }

    private Element nextI(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        this.index++;
        return lastReturnedElement = lastReturnedElement.next;
    }

    public T getFirst() {
        return first.value;
    }

    public T getLast() {
        return last.value;
    }

    public Element<T> getLastReturnedElement() {
        return lastReturnedElement;
    }

    public int size() {
        return size;
    }

    private static class Element<T> {
        T value;
        Element prev;
        Element next;

        public Element(T value, Element prev, Element next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

}
