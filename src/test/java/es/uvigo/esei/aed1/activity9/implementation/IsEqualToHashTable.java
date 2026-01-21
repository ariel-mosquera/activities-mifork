package es.uvigo.esei.aed1.activity9.implementation;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class IsEqualToHashTable<T> extends TypeSafeMatcher<HashTable<T>> {
    private final HashTable<T> expected;

    public IsEqualToHashTable(HashTable<T> expected) {
        this.expected = expected;
    }

    @Override
    protected boolean matchesSafely(HashTable<T> actual) {
        // Compare sizes
        if (expected.size() != actual.size()) {
            return false;
        }

        // If both are empty, they're equal
        if (expected.size() == 0) {
            return true;
        }

        // Extract elements from expected HashTable using reflection
        java.util.Collection<T> expectedElements = extractElements(expected);

        if (!expectedElements.isEmpty()) {
            // Use the search method to verify each element exists in actual
            for (T elem : expectedElements) {
                if (!actual.search(elem)) {
                    return false;
                }
            }
        }

        return true;

    }

    /**
     * Extracts all elements from a HashTable using get() and remove() methods.
     * Creates a temporary copy by extracting and restoring elements.
     */
    private java.util.Collection<T> extractElements(HashTable<T> table) {
        java.util.Collection<T> elements = new java.util.ArrayList<>();

        int size = table.size();

        // Extract all elements using get() and remove()
        for (int i = 0; i < size; i++) {
            T elem = table.get();
            if (elem != null) {
                elements.add(elem);
                table.remove(elem);
            }
        }

        // Restore the table by re-adding all extracted elements
        for (T elem : elements) {
            table.add(elem);
        }

        return elements;

    }

    @Override
    public void describeTo(Description description) {
        description.appendText("equal hash tables");
    }

    public static <T> IsEqualToHashTable<T> equalToHashTable(HashTable<T> expected) {
        return new IsEqualToHashTable<>(expected);
    }

}
