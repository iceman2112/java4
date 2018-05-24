package tatun.lesson2;

import java.util.Arrays;
import java.util.Random;

public class BigArray {
    private int[] arr;
    private int size;

    private void fillRandomValues() {
        Random random = new Random();
        for(int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
            size++;
        }
    }

    public BigArray() {
        this(100000);
    }

    private void swap(int a, int b) {
        int temp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = temp;
    }

    public BigArray(int size) {
        this(size, false);
    }

    public BigArray(int size, boolean fillRandom) {
        this.size = 0;
        this.arr = new int[size];

        if (fillRandom) fillRandomValues();
    }

    public void insert(int value) {
        if (size >= arr.length) {
            int[] tempArr = arr;
            arr = new int[this.size * 2];
            System.arraycopy(tempArr, 0, this.arr, 0, size);
        }

        arr[this.size++] = value;
    }

    public boolean delete(int value) {
        int index = getIndex(value);
        boolean isExist = false;
        while (index != -1) {
            System.arraycopy(arr, index + 1,
                    arr, index, size - index - 1);
            this.size--;
            index = getIndex(index, value);
            isExist = true;
        }
        return isExist;
    }

    public int getIndex(int value) {
        return getIndex(0, value);
    }

    public int getIndex(int beginIndex, int value) {
        for (int i = beginIndex; i < this.size; i++) {
            if (this.arr[i] == value)
                return i;
        }
        return -1;
    }

    public int binSearch(int value) {
        int left = 0;
        int right = this.size - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (value == this.arr[mid]) {
                return mid;
            } else {
                if (value < this.arr[mid])
                    right = mid;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }

    public void sortBubble() { //O(n^2)
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size - 1; j++) {
                if (this.arr[j] > this.arr[j + 1])
                    swap(j, j + 1);
            }
        }
    }

    public void sortSelect() {
        int p;
        for (int out = 0; out < this.size; out++) {
            p = out;
            for (int in = out; in < this.size; in++) {
                if (this.arr[in] < this.arr[p])
                    p = in;
            }
            swap(out, p);
        }
    }

    public void sortInsert() {
        int in;
        int out;
        for (out = 1; out < this.size; out++) {
            int temp = this.arr[out];
            in = out;
            while (in > 0 && this.arr[in - 1] >= temp) {
                this.arr[in] = this.arr[in - 1];
                in--;
            }
            this.arr[in] = temp;
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sb.append(arr[i] + " ");
        }
        return sb.toString();
    }
}