import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.*;

public class MyArrayList <T> implements List {
    private final int INITIAL_CAPACITY = 10;
    private int size;
    private int capacity;
    T[] t;

    MyArrayList(){
        t = (T[]) new Object[INITIAL_CAPACITY];
        this.size = 0;
        this.capacity = INITIAL_CAPACITY;
    }

    MyArrayList(int capacity){
        if (capacity > 0) {
            t = (T[]) new Object[capacity];
            this.capacity = capacity;
            this.size = 0;
        } else if (capacity == 0){
            t = (T[]) new Object[INITIAL_CAPACITY];
            this.size = 0;
            this.capacity = INITIAL_CAPACITY;
        } else {
            throw new IllegalArgumentException("Неправильно вказаний індекс");
        }
    }

    @Override
    public boolean add(Object o) {
        if (size >= capacity) {
            T[] temp = t;
            t = (T[]) new Object[temp.length + INITIAL_CAPACITY];
            System.arraycopy(temp, 0, t, 0, temp.length);
            capacity = t.length;
        }
        t[size++] = (T) o;
        return true;
    }

    @Override
    public void add(int index, Object element) {
        if (index > size || index < 0) throw new IllegalArgumentException("Неправильно вказаний індекс");
        if (index == 0){
            T[] temp = t;
            t = (T[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, t, 1, temp.length);
            t[index] = (T) element;
        } else if (index == size){
            if (capacity == size){
                T[] temp = t;
                t = (T[]) new Object[temp.length + INITIAL_CAPACITY];
                System.arraycopy(temp, 0, t, 0, temp.length);
            }
            t[index] = (T) element;
        } else {
            T[] temp = t;
            t = (T[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, t, 0, index);
            t[index] = (T) element;
            System.arraycopy(temp, index, t, index + 1, temp.length - index);
        }
        capacity = t.length;
        size++;
    }

    @Override
    public Object remove(int index) {
        if (index >= size || index < 0) throw new IllegalArgumentException("Неправильно вказаний індекс");
        T[] temp = t;
        t = (T[]) new Object[size - 1];
        if (index == t.length - 1){
            System.arraycopy(temp, 0, t, 0, t.length);
        } else if (index == 0){
            System.arraycopy(temp, 1, t, 0, t.length);
        } else {
            System.arraycopy(temp, 0, t, 0, index);
            System.arraycopy(temp, index + 1, t, index, size - (index + 1));
        }
        capacity = t.length;
        size--;
        return temp[index];
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
    public Object get(int index) {
        if (index > size || index < 0) throw new IllegalArgumentException("Неправильно вказаний індекс");
        return t[index];
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++){
            if (t[i].hashCode() == o.hashCode()){
                if (t[i].equals(o)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        t = (T[]) new Object[capacity];
        size = 0;
    }

    @Override
    public Object set(int index, Object element) {
        if (index >= size || index < 0) throw new IllegalArgumentException("Неправильно вказаний індекс");
        T oldValue = t[index];
        t[index] = (T) element;
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++){
            if (t[i].hashCode() == o.hashCode()){
                if (t[i].equals(o)){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public Object[] toArray() {
        return t;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++){
            if (t[i].hashCode() == o.hashCode()){
                if (t[i].equals(o)){

                    T[] temp = t;
                    t = (T[]) new Object[size - 1];
                    if (i == t.length - 1){
                        System.arraycopy(temp, 0, t, 0, t.length);
                    } else if (i == 0){
                        System.arraycopy(temp, 1, t, 0, t.length);
                    } else {
                        System.arraycopy(temp, 0, t, 0, i);
                        System.arraycopy(temp, i + 1, t, i, size - (i + 1));
                    }
                    size--;
                    capacity = t.length;
                    return true;
                }
            }
        }
        return false;
    }

    private class ArIterator implements Iterator {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Object next() {
            return t[index++];
        }
    }

    @Override
    public Iterator iterator() {
        return new ArIterator();
    }



    //////////// Not Implemented ////////////

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

    @Override
    public boolean retainAll(Collection c) {
        throw new NotImplementedException();
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new NotImplementedException();
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new NotImplementedException();
    }

}
