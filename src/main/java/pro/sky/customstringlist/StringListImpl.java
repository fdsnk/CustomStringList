package pro.sky.customstringlist;

import java.util.Arrays;
import java.util.Objects;


public class StringListImpl implements StringList {

    private String[] array;

    public StringListImpl() {
        this.array = new String[3];
    }

    private int size = 0;


    @Override
    public String add(String item) {
        if (Objects.isNull(item)) {
            throw new NotExistException();
        } else if (size == array.length) {
            array = Arrays.copyOf(array, (int) (array.length * 1.5 + 1));
        }
        array[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (Objects.isNull(item)) {
            throw new NotExistException();
        }
        if (index >= size || index < 0) {
            throw new CustomIndexOutOfBoundsException();
        }
        if (size == array.length) {
            array = Arrays.copyOf(array, (int) (array.length * 1.5 + 1));
        }
        for (int i = 0; i < array.length; i++) {

            if (i == index) {
                System.arraycopy(array, index, array, index + 1, array.length - i - 1);
                array[i] = item;
                size++;
                break;
            }
        }
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (Objects.isNull(item)) {
            throw new NotExistException();
        }
        if (index >= size || index < 0) {
            throw new CustomIndexOutOfBoundsException();
        }
        for (int i = 0; i < array.length; i++) {

            if (i == index) {
                System.arraycopy(array, index, array, index, array.length - i - 1);
                array[i] = item;
                break;
            }
        }
        return item;
    }

    @Override
    public String remove(String item) {
        if (Objects.isNull(item)) {
            throw new NotExistException();
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(item)) {
                System.arraycopy(array, i + 1, array, i, array.length - i - 1);
                size--;
                break;
            }
            if (!array[size - 1].equals(item)) {
                throw new CustomNullPointerException();
            }
        }
        return item;
    }

    @Override
    public String remove(int index) {
        if (index >= size || index < 0) {
            throw new CustomIndexOutOfBoundsException();
        }
        String temp="";
        for (int i = 0; i < array.length; i++) {

            if (i == index) {
                temp=array[index];
                System.arraycopy(array, i + 1, array, i, array.length - i - 1);
                size--;
                break;
            }
        }
        return temp;
    }

    @Override
    public boolean contains(String item) {
        return Arrays.binarySearch(array, item) != -1;
    }

    @Override
    public int indexOf(String item) {
        return Arrays.binarySearch(array, item);
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= size || index < 0) {
            throw new CustomIndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (Objects.isNull(otherList)) {
            throw new NotExistException();
        }
        return Arrays.equals(toArray(), otherList.toArray());
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
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(array, size);
    }
}
