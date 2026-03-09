
package es.uvigo.esei.aed1.activity2.circularDoublyLinked;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

public class CircularDoublyLinked {

  private DoubleNode last;
  private int numOfValues;

  public CircularDoublyLinked() {
    last = null;
    numOfValues = 0;
  }

  public boolean isEmpty() {
    return numOfValues == 0;
  }

  public int size() {
    return numOfValues;
  }

  public int numberOfOccurrences(int value) {
    if (isEmpty())
      return 0;

    var counter = 0;
    DoubleNode current = last;

    do {
      if (current.hasValue(value))
        counter++;
      current = current.getNext();
    } while (current != last);

    return counter;
  }

  public boolean contains(int value) {
    if (isEmpty())
      return false;

    DoubleNode current = last.getNext();

    while (current != last && !current.hasValue(value))
      current = current.getNext();

    return current.hasValue(value);
  }

  public int firstValue() throws NullPointerException {
    if (isEmpty())
      throw new NullPointerException();

    return last.getNext().getValue();
  }

  public void addLast(int value) {
    DoubleNode newNode = new DoubleNode(null, value, null);

    if (isEmpty()) {
      newNode.setNext(newNode);
      newNode.setPrevious(newNode);
    }
    else {
      DoubleNode first = last.getNext();
      newNode.setPrevious(last);
      newNode.setNext(first);
      first.setPrevious(newNode);
      last.setNext(newNode);
    }
    last = newNode;
    numOfValues++;
  }

  public void removeFirst() {
    if (isEmpty())
      System.out.println("Empty structure");
    else if (numOfValues == 1) {
      last = null;
      numOfValues--;
    }
    else {
      DoubleNode first = last.getNext();
      last.setNext(first.getNext());
      first.getNext().setPrevious(last);
      numOfValues--;
    }
  }

  public void remove(int value) {

    if (isEmpty())
      System.out.println("Empty structure");
    else {
      DoubleNode current = last;
      boolean found = false;

      do {
        found = current.hasValue(value);
        if (!found)
          current = current.getNext();
      } while (current != last && !found);

      if (!found)
        System.out.println("The value is not in the structure");
      else {
        if (numOfValues == 1)
          last = null;
        else {
          current.getNext().setPrevious(current.getPrevious());
          current.getPrevious().setNext(current.getNext());

          if (current == last)
            last = current.getPrevious();
        }
        numOfValues--;
      }
    }
  }

  @Override
  public String toString() {

    if (isEmpty())
      return "";

    StringBuilder cad = new StringBuilder();
    DoubleNode current = last.getNext();

    do {
      cad.append(current.getValue()).append(' ');
      current = current.getNext();
    } while (current != last.getNext());

    return cad.toString();
  }
}
