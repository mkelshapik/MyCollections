import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    MyArrayList<Integer> myArrayList = new MyArrayList<>();

    @Test
    void checkAddAndConstructor(){
        MyArrayList<Integer> myArrayList1 = new MyArrayList<>(2);
        myArrayList1.add(1);
        myArrayList1.add(2);
        myArrayList1.add(3);
        myArrayList1.add(4);
        myArrayList1.add(5);
        myArrayList1.add(6);
    }

    @Test
    void isEmpty() {
        // check isEmpty if adds some element into list
        myArrayList.add(1);
        assertFalse(myArrayList.isEmpty(), "ArrayList is Empty!");
    }

    @Test
    void add() {
        // check is fun add(Obj) adds element in the tail
        myArrayList.add(1);
        assertEquals(1, myArrayList.get(0), "It isn`t tail!");
        myArrayList.add(2);
        assertEquals(2, myArrayList.get(1), "It isn`t tail!");
        myArrayList.add(3);
        assertEquals(3, myArrayList.get(2), "It isn`t tail!");
    }

    @Test
    void testAdd() {
        // check exceptions(index < 0 || index > size)

        // check is fun add(index, obj) can adds element into head, tail and other pos
        myArrayList.add(2);
        myArrayList.add(0, 1);
        assertEquals(1, myArrayList.get(0));
        assertEquals(2, myArrayList.get(1));
        myArrayList.add(0,0);
        assertEquals(0, myArrayList.get(0));

        myArrayList.add(3, 3);
        myArrayList.add(4, 4);
        myArrayList.add(5, 5);
        myArrayList.add(6, 6);
        myArrayList.add(7, 7);
        myArrayList.add(8, 8);
        assertEquals(8, myArrayList.get(8));
        myArrayList.add(9, 9);
        myArrayList.add(10, 10);
        myArrayList.add(11, 11);
        assertEquals(11, myArrayList.get(11));
        myArrayList.add(1, 25);
        assertEquals(25, myArrayList.get(1));
    }

    @Test
    void remove() {
        // check fun remove() from head, tail and other pos
        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);
        myArrayList.add(40);
        myArrayList.add(50);
        assertEquals(5, myArrayList.size());
        assertEquals(10, myArrayList.remove(0));
        assertEquals(40, myArrayList.remove(2));
        assertEquals(30, myArrayList.remove(1));
        assertEquals(2, myArrayList.size());
    }

    @Test
    void contains() {

    }

    @Test
    void clear() {
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.clear();
        assertTrue(myArrayList.isEmpty(), "fun clear() doesn`t work");
    }

    @Test
    void set() {
        myArrayList.add(0, 0);
        assertEquals(5, myArrayList.set(0, 5));
        assertEquals(5, myArrayList.get(0));
        assertEquals(1, myArrayList.size());
    }

    @Test
    void indexOf() {
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        assertEquals(2, myArrayList.indexOf(3));
    }
}