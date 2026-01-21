package es.uvigo.esei.aed1.activity9.implementation;

import java.util.function.Supplier;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public abstract class HashTableTestCase {

    private final Supplier<HashTable<Integer>> hashTableSupplier;

    public HashTableTestCase(Supplier<HashTable<Integer>> hashTableSupplier) {
        this.hashTableSupplier = hashTableSupplier;
    }

    private HashTable<Integer> createHashTableWith(Integer... values) {
        final HashTable<Integer> hashTable = this.hashTableSupplier.get();

        for (Integer value : values) {
            hashTable.add(value);
        }

        return hashTable;
    }

    @Test
    public void testAddSingleElement() {
        final HashTable<Integer> hashTable = this.hashTableSupplier.get();

        assertThat(hashTable.add(5), is(true));
        assertThat(hashTable.size(), is(1));
    }

    @Test
    public void testAddMultipleElements() {
        final HashTable<Integer> hashTable = this.hashTableSupplier.get();

        assertThat(hashTable.add(5), is(true));
        assertThat(hashTable.add(10), is(true));
        assertThat(hashTable.add(15), is(true));
        assertThat(hashTable.size(), is(3));
    }

    @Test
    public void testAddDuplicateElement() {
        final HashTable<Integer> hashTable = this.hashTableSupplier.get();

        assertThat(hashTable.add(5), is(true));
        assertThat(hashTable.add(5), is(false));
        assertThat(hashTable.size(), is(1));
    }

    @Test
    public void testAddNull() {
        final HashTable<Integer> hashTable = this.hashTableSupplier.get();

        assertThrows(NullPointerException.class, () -> hashTable.add(null));
    }

    @Test
    public void testSearchExistingElement() {
        final HashTable<Integer> hashTable = this.createHashTableWith(7, 3, 9);

        assertThat(hashTable.search(7), is(true));
    }

    @Test
    public void testSearchNonExistingElement() {
        final HashTable<Integer> hashTable = this.createHashTableWith(7, 3);

        assertThat(hashTable.search(99), is(false));
    }

    @Test
    public void testSearchEmptyHashTable() {
        final HashTable<Integer> hashTable = this.hashTableSupplier.get();

        assertThat(hashTable.search(5), is(false));
    }

    @Test
    public void testSearchNull() {
        final HashTable<Integer> hashTable = this.createHashTableWith(7, 3, 9);

        assertThrows(NullPointerException.class, () -> hashTable.search(null));
    }

    @Test
    public void testRemoveExistingElement() {
        final HashTable<Integer> hashTable = this.createHashTableWith(5, 10);

        assertThat(hashTable.remove(5), is(true));
        assertThat(hashTable.size(), is(1));
    }

    @Test
    public void testRemoveNonExistingElement() {
        final HashTable<Integer> hashTable = this.createHashTableWith(5);

        assertThat(hashTable.remove(99), is(false));
        assertThat(hashTable.size(), is(1));
    }

    @Test
    public void testRemoveEmptyHashTable() {
        final HashTable<Integer> hashTable = this.hashTableSupplier.get();

        assertThat(hashTable.remove(5), is(false));
        assertThat(hashTable.size(), is(0));
    }

    @Test
    public void testRemoveNull() {
        final HashTable<Integer> hashTable = this.createHashTableWith(5, 10);

        assertThrows(NullPointerException.class, () -> hashTable.remove(null));
    }

    @Test
    public void testSizeEmptyHashTable() {
        final HashTable<Integer> hashTable = this.hashTableSupplier.get();

        assertThat(hashTable.size(), is(0));
    }

    @Test
    public void testSizeNonEmptyHashTable() {
        final HashTable<Integer> hashTable = this.createHashTableWith(10, 11, 12, 13, 14, 15);

        assertThat(hashTable.size(), is(6));
    }

    @Test
    public void testSizeAfterOperations() {
        final HashTable<Integer> hashTable = this.hashTableSupplier.get();

        hashTable.add(1);
        assertThat(hashTable.size(), is(1));

        hashTable.add(2);
        assertThat(hashTable.size(), is(2));

        hashTable.remove(1);
        assertThat(hashTable.size(), is(1));
    }

    @Test
    public void testSearchMovesToFront() {
        final HashTable<Integer> hashTable = this.createHashTableWith(1, 2, 3, 4, 5);

        // Search should return true and move element to front
        assertThat(hashTable.search(3), is(true));
        // The element should still be findable
        assertThat(hashTable.search(3), is(true));
    }

    @Test
    public void testGetFromNonEmptyHashTable() {
        final HashTable<Integer> hashTable = this.createHashTableWith(5, 10, 15);

        Integer element = hashTable.get();
        assertThat(element != null, is(true));
    }

    @Test
    public void testGetReturnedElementIsInHashTable() {
        final HashTable<Integer> hashTable = this.createHashTableWith(5, 10, 15);

        Integer element = hashTable.get();
        assertThat(hashTable.search(element), is(true));
    }

    @Test
    public void testGetSingleElement() {
        final HashTable<Integer> hashTable = this.createHashTableWith(42);

        Integer element = hashTable.get();
        assertThat(element, is(42));
    }

    @Test
    public void testGetMultipleTimes() {
        final HashTable<Integer> hashTable = this.createHashTableWith(5, 10, 15, 20);

        Integer element1 = hashTable.get();
        Integer element2 = hashTable.get();
        
        // Both elements should be non-null
        assertThat(element1 != null, is(true));
        assertThat(element2 != null, is(true));
        
        // Both should be in the hash table
        assertThat(hashTable.search(element1), is(true));
        assertThat(hashTable.search(element2), is(true));
    }

}
