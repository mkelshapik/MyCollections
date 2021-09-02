import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList <E> implements List {


    public MyLinkedList(){
        head = null;
        tail = null;
    }

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    private class Node<E>{
        private E val;
        private Node next;
        private Node prev;

        private Node(E val) {
            this.val = val;
            size++;
        }

    }
    @Override
    public boolean add(Object o) {
        Node<E> newNode = new Node<>((E)o);
        if (head == null){
            head = tail = newNode;
            head.next = tail;
            tail.prev = head;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        return true;
    }

    @Override
    public void add(int index, Object element) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException("Індекс вказаний не вірно!");
        Node<E> newNode = new Node<E>((E) element);
        if (head == null){
            head = tail = newNode;
            head.next = tail;
            tail.prev = head;
        } else if (index == 0){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (index == size){
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++){
                current = current.next;
            }
            newNode.next = current.next;
            current.next.prev = newNode;
            newNode.prev = current;
            current.next = newNode;
        }
    }

    @Override
    public Object remove(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("Індекс вказаний не вірно!");
        Node<E> temp;
        if (index == size - 1) {
            temp = tail;
            tail = tail.prev;
            tail.next = null;
        } else if (index == 0) {
            temp = head;
            head = head.next;
            head.prev = null;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            temp = current;
            current.next.prev = current.prev;
            current.prev.next = current.next;
        }
        size--;
        return temp.val;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> current = head;
        for (int i = 0; i < size; i++){
            if (current.val == o || current.next == null){
                break;
            } else {
                current = current.next;
            }
        }

        if (current.val != o) return false;
        if (current == head) {
            head = head.next;
            head.prev = null;
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.next.prev = current.prev;
            current.prev.next = current.next;
        }
        size--;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> current = head;
        while (current.val != (E) o){
            if (current.next == null) break;
            current = current.next;
        }
        return current.val == (E) o;
    }

    @Override
    public Object set(int index, Object element) {
        Node<E> current = head;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        current.val = (E) element;
        return current.val;
    }

    @Override
    public int indexOf(Object o) {
        Node<E> current = head;
        int index = 0;
        while (current.val != (E) o){
            index++;
            current = current.next;
        }
        if (current.val != (E) o) {
            return -1;
        } else {
            return index;
        }
    }

    @Override
    public Object get(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("Індекс вказаний не вірно!");
        if (index == 0) return head.val;
        if (index == size - 1) return tail.val;
        Node<E> current = head;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        return current.val;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (Node<E> cur = head; cur != null; ) {
            Node<E> next = cur.next;
            cur.val = null;
            cur.next = null;
            cur.prev = null;
            cur = next;
        }
        head = tail = null;
        size = 0;
    }



    //////////// NotImplemented ////////////

    @Override
    public Iterator iterator() {
        throw new NotImplementedException();
    }

    @Override
    public Object[] toArray() {
        throw new NotImplementedException();
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new NotImplementedException();
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new NotImplementedException();
    }

    @Override
    public boolean addAll(Collection c) {
        throw new NotImplementedException();
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new NotImplementedException();
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new NotImplementedException();
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new NotImplementedException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new NotImplementedException();
    }

    @Override
    public ListIterator listIterator() {
        throw new NotImplementedException();
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new NotImplementedException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new NotImplementedException();
    }
}
