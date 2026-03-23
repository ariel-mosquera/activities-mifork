
package es.uvigo.esei.aed1.activity6.implementation;

import static java.util.Objects.requireNonNull;

public class RoundLinkedQueue<T> implements CustomQueue<T> {

  private Node<T> last;
  private int numOfValues;

  public RoundLinkedQueue() {
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
      throw new EmptyException("Empty queue");

    return last.getNext().getValue();
  }

  @Override
  public void add(T value) throws NullPointerException {
    requireNonNull(value);

    Node<T> newNode = new Node<>(value, null);

    if (isEmpty())
      newNode.setNext(newNode);
    else {
      newNode.setNext(last.getNext());
      last.setNext(newNode);
    }

    last = newNode;
    numOfValues++;
  }

  @Override
  public T remove() throws EmptyException {
    if (isEmpty())
      throw new EmptyException("Empty queue");

    Node<T> first = last.getNext();

    if (numOfValues == 1)
      last = null;
    else
      last.setNext(first.getNext());

    numOfValues--;

    return first.getValue();
  }

  @Override
  public void clear() {
    last = null;
    numOfValues = 0;
  }
}
