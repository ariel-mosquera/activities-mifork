
package es.uvigo.esei.aed1.activity6;

import static java.util.Objects.requireNonNull;

import es.uvigo.esei.aed1.activity6.implementation.CustomQueue;
import es.uvigo.esei.aed1.tads.queue.LinkedQueue;
import es.uvigo.esei.aed1.tads.queue.Queue;

public class Activity6 {

    // Exercise 1.1
    public static <T> void concat(Queue<T> queue1, Queue<T> queue2) throws NullPointerException {
        requireNonNull(queue1, "Queue 1 is empty, impossible to concat");
        requireNonNull(queue2, "Queue 2 is empty, impossible to concat");

        while (!queue2.isEmpty())
            queue1.add(queue2.remove());
    }

    // Exercise 1.2
    public static <T> Queue<T> mix(Queue<T> queue1, Queue<T> queue2) throws NullPointerException {
        requireNonNull(queue1, "Queue 1 is null, stoping the procedure...");
        requireNonNull(queue2, "Queue 2 is null, stoping the procedure...");

        Queue<T> mixedQueue = new LinkedQueue<>();

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (!queue2.isEmpty())
                mixedQueue.add(queue2.remove());
            if (!queue1.isEmpty())
                mixedQueue.add(queue1.remove());
        }

        return mixedQueue;
    }

    // Exercise 2
    public static <T> Queue<T> copy(Queue<T> queue) throws NullPointerException {
        requireNonNull(queue);

        Queue<T> copyQueue = new LinkedQueue<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            copyQueue.add(queue.first());
            queue.add(queue.remove());
        }

        return copyQueue;
    }

    // Exercise 3
    public static Queue<Integer> mixInOrderly(Queue<Integer> queue1, Queue<Integer> queue2) throws NullPointerException {
        requireNonNull(queue1, "Queue 1 is null, stoping process...");
        requireNonNull(queue2, "Queue 2 is null, stoping process...");

        Queue<Integer> mixedQueue = new LinkedQueue<>();
        Queue<Integer> copy1 = copy(queue1);
        Queue<Integer> copy2 = copy(queue2);

        while (!copy1.isEmpty() && !copy2.isEmpty()) {
            if (copy1.first() < copy2.first())
                mixedQueue.add(copy1.remove());
            else if (copy2.first() < copy1.first())
                mixedQueue.add(queue2.remove());
            else {
                mixedQueue.add(copy1.remove());
                copy2.remove();
            }
        }

        if (!copy1.isEmpty()) {
            while (!copy1.isEmpty())
                mixedQueue.add(copy1.remove());
        } else if (!copy2.isEmpty()) {
            while (!copy2.isEmpty())
                mixedQueue.add(copy2.remove());
        }

        return mixedQueue;
    }

    // Exercise 4
    public static <T> void moveToFront(Queue<T> queue, T value) throws NullPointerException {
        requireNonNull(queue);
        requireNonNull(value);

        Queue<T> auxQueue = new LinkedQueue<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            if (!queue.first().equals(value))
                auxQueue.add(queue.remove());
            else
                queue.remove();
        }

        queue.add(value);

        while (!auxQueue.isEmpty())
            queue.add(auxQueue.remove());
    }

    // Exercise 5
    public static Integer josephus(Queue<Integer> soldiers, int initialPos, int jump) throws IllegalArgumentException {
        if (soldiers == null || initialPos < 0 || jump < 1)
            throw new IllegalArgumentException();

        int counter = 1;

        // moviendo la cola para que first() apunte correctamente a initialPos si necesario

        for (int i = 0; i < initialPos; i++) {
            soldiers.add(soldiers.remove());
        }

        // partiendo de initialPos elimina un elemento a cada jump desplazamientos de la cola, hasta que se quede solamente un soldado

        while (soldiers.size() > 1) {
            if (counter < jump) {
                soldiers.add(soldiers.remove());
                counter++;
            } else {
                soldiers.remove();
                counter = 1;
            }
        }

        return soldiers.first();
    }

    // Ejercicio 6
    public static <T> boolean equalsValues(CustomQueue<T> queue) throws NullPointerException {
        requireNonNull(queue, "The queue can't be null");

        T firstValue = queue.first();
        boolean valid = true;
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            if (!queue.first().equals(firstValue))
                valid = false;
            queue.add(queue.remove());
        }

        return valid;
    }

    // Ejercicio 7 (extra)
    public static boolean isRotation(Queue<Integer> queue1, Queue<Integer> queue2) throws NullPointerException {
        requireNonNull(queue1, "Queue 1 can't be null");
        requireNonNull(queue2, "Queue 2 can't be null");

        if (queue1.size() != queue2.size())
            return false;

        boolean isEquals = true;
        int size = queue1.size();
        int i = 0;

        while (!queue1.first().equals(queue2.first()) && i < size) {
            queue1.add(queue1.remove());
            if (!queue1.first().equals(queue2.first()))
                i++;
        }

        if (i != size) {
            for (int j = 0; j < size; j++) {
                if (!queue1.first().equals(queue2.first()))
                    isEquals = false;

                queue1.add(queue1.remove());
                queue2.add(queue2.remove());
            }
        }

        for (int j = i; j < size; j++)
            queue1.add(queue1.remove());

        return isEquals;
    }

}