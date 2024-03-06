package lesson21.homeWork21;

public class RubberArray {
    private final int INIT_DATA_SIZE = 10;
    private final float EXTEND_INDEX = 1.5f;
    public int[] data;
    private int length;

    public RubberArray() {
        data = new int[INIT_DATA_SIZE];
        length = 0;
    }

    public int[] getDataArray() { return data; }

    public int get(int idx) {
        return data[idx];
    }

    public int[] extensionArray() {
        // create new array
        int[] newData = new int[(int) (data.length * EXTEND_INDEX)];
        // move all items to new array
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        // change link to new array
        data = newData;
        return newData;
    }

    public void add(int value) {
        if (length == data.length) {
            extensionArray();
        }
        // add value
        data[length] = value;
        length++;
    }

    public void add(int value, int idx) {
        if (length == data.length) {
            extensionArray();
        }
        for (int i = length; i >= idx; i--) {
            data[i + 1] = data[i];
        }
        data[idx] = value;
        length++;
    }

    public void remove(int idx) {
        // move elements right to left from idx
        for (int i = idx; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        length--;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public int indexOf(int value) {
        for (int i = 0; i < data.length; i++) {
            if (value == data[i]) { return i; }
        } return -1;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < length; i++) {
            str.append(data[i]);
            if (i < length - 1) {
                str.append(", ");
            }
        }
        return str.append("]").toString();
    }
}
