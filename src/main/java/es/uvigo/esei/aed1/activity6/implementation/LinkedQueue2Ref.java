
package es.uvigo.esei.aed1.activity6.implementation;

import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

public class LinkedQueue2Ref<T> implements CustomQueue<T> {

  private Node<T> first;
  private Node<T> last;
  private int numOfValues;

  public LinkedQueue2Ref() {
    first = null;
    last = null;
    numOfValues = 0;
  }

  @Override
  public boolean isEmpty() {
    return numOfValues == 0;
  }

  @Override
  public int size() {
    return numOfValues;
  }

  @Override
  public T first() throws EmptyException {
    if (isEmpty())
      throw new EmptyException();

    return first.getValue();
  }

  @Override
  public void add(T value) throws NullPointerException {
    requireNonNull(value, "Value can't be null");

    Node<T> newNode = new Node<>(value, null);

    if (isEmpty())
      first = newNode;
    else {
      Node<T> current = first;

      while (nonNull(current.getNext()))
        current = current.getNext();

      current.setNext(newNode);
    }

    last = newNode;
    numOfValues++;
  }

  @Override
  public T remove() throws EmptyException {
    if (isEmpty())
      throw new EmptyException();

    T firstValue = first.getValue();

    first = first.getNext();

    if (numOfValues == 1)
      last = null;

    numOfValues--;

    return firstValue;
  }

  @Override
  public void clear() {
    first = null;
    last = null;
    numOfValues = 0;
  }

}
