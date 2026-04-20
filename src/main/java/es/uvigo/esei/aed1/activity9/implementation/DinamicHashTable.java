package es.uvigo.esei.aed1.activity9.implementation;

import es.uvigo.esei.aed1.tads.list.LinkedList;
import es.uvigo.esei.aed1.tads.list.List;

public class DinamicHashTable<T> implements HashTable<T> {

    private int numElems;
    private List<T>[] data;

    @SuppressWarnings("unchecked")
    public DinamicHashTable(int capacity) throws IllegalArgumentException {
        numElems = 0;
        data = new List[capacity];

        for (int i = 0; i < capacity; i++) {
            data[i] = new LinkedList<>();
        }
    }

    public DinamicHashTable() {
        this(50);
    }

    private int functionHash(T key) {
        return Math.abs(key.hashCode()) % data.length;
    }

    @Override
    public boolean add(T elem) {
        int index = functionHash(elem);

        if (data[index].contains(elem))
            return false;

        data[index].addFirst(elem);
        numElems++;

        return true;
    }

    @Override
    public boolean search(T elem) {
        int index = functionHash(elem);

        if (!data[index].contains(elem))
            return false;

        data[index].removeValue(elem);
        data[index].addFirst(elem);

        return true;
    }

    @Override
    public boolean remove(T elem) {
        int index = functionHash(elem);

        if (data[index].removeValue(elem)) {
            numElems--;
            return true;
        }

        return false;
    }

    @Override
    public int size() {
        return numElems;
    }

    @Override
    public T get() {
        if (numElems == 0)
            return null;

        for (List<T> list : data) {
            if (!list.isEmpty())
                return list.getFirst();
        }

        return null;
    }

}
