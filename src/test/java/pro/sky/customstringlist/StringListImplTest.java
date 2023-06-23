package pro.sky.customstringlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {

    private final StringListImpl stringList = new StringListImpl();

    @BeforeEach
    void setUp() {
        stringList.add("aa1");
        stringList.add("aa2");
        stringList.add("aa3");
    }

    @Test
    void addCorrect() {
        assertEquals("aa4", stringList.add("aa4"));
    }

    @Test
    void addNotExist() {
        assertThrows(NotExistException.class, () -> stringList.add(null));
    }

    @Test
    void testAddCorrect() {
        assertEquals("aa4", stringList.add(1, "aa4"));
    }

    @Test
    void testAddInCorrect() {
        assertThrows(NotExistException.class, () -> stringList.add(1, null));
        assertThrows(CustomIndexOutOfBoundsException.class, () -> stringList.add(-1, "aa4"));
        assertThrows(CustomIndexOutOfBoundsException.class, () -> stringList.add(3, "aa4"));
    }

    @Test
    void setCorrect() {
        assertEquals("aa4", stringList.set(1, "aa4"));
    }

    @Test
    void setInCorrect() {
        assertThrows(NotExistException.class, () -> stringList.set(1, null));
        assertThrows(CustomIndexOutOfBoundsException.class, () -> stringList.set(-1, "aa4"));
        assertThrows(CustomIndexOutOfBoundsException.class, () -> stringList.set(3, "aa4"));
    }

    @Test
    void removeCorrect() {
        assertEquals("aa3", stringList.remove("aa3"));
    }

    @Test
    void removeInCorrect() {
        assertThrows(NotExistException.class, () -> stringList.remove(null));
        assertThrows(CustomNullPointerException.class, () -> stringList.remove("aa4"));
    }

    @Test
    void testRemoveCorrect() {
        assertEquals("aa1", stringList.remove(0));
    }

    @Test
    void testRemoveInCorrect() {
        assertThrows(CustomIndexOutOfBoundsException.class, () -> stringList.remove(3));
    }

    @Test
    void contains() {
        assertTrue(stringList.contains("aa1"));
        assertFalse(stringList.contains("aa"));
    }

    @Test
    void indexOf() {
        assertEquals(0, stringList.indexOf("aa1"));
        assertEquals(-1, stringList.indexOf("aa"));
    }

    @Test
    void lastIndexOf() {
        assertEquals(0, stringList.lastIndexOf("aa1"));
        assertEquals(-1, stringList.lastIndexOf("aa"));
    }

    @Test
    void getCorrect() {
        assertEquals("aa2", stringList.get(1));
    }

    @Test
    void getInCorrect() {
        assertThrows(CustomIndexOutOfBoundsException.class, () -> stringList.get(-1));
        assertThrows(CustomIndexOutOfBoundsException.class, () -> stringList.get(3));
    }

    @Test
    void testEqualsCorrectTrue() {
        StringListImpl extend = new StringListImpl();
        extend.add("aa1");
        extend.add("aa2");
        extend.add("aa3");

        assertTrue(stringList.equals(extend));

    }

    @Test
    void testEqualsCorrectFalse() {
        StringListImpl extend = new StringListImpl();
        extend.add("aa1");

        assertFalse(stringList.equals(extend));
    }

    @Test
    void testEqualsInCorrect() {
        assertThrows(NotExistException.class, () -> stringList.equals(null));
    }

    @Test
    void size() {
        assertEquals(3, stringList.size());
    }

    @Test
    void isEmptyFasle() {
        assertFalse(stringList.isEmpty());
    }

    @Test
    void isEmptyTrue() {
        StringListImpl actual = new StringListImpl();

        assertTrue(actual.isEmpty());
    }

    @Test
    void clear() {
        stringList.clear();

        assertTrue(stringList.isEmpty());
    }

    @Test
    void toArray() {
        String[] extend = {"aa1", "aa2", "aa3"};

        assertArrayEquals(extend, stringList.toArray());
    }
}