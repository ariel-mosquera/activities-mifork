
package es.uvigo.esei.aed1.activity3.circularDoublyLinkedDummy;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

public class CircularDoublyLinkedDummy {

  private DoubleNode lastDummy;
  private int numOfValues;

  public CircularDoublyLinkedDummy() {
    lastDummy = new DoubleNode(null, 0, null);
    lastDummy.setNext(lastDummy);
    lastDummy.setPrevious(lastDummy);
    numOfValues = 0;
  }

  public boolean isEmpty() {
    return numOfValues == 0;
  }

  public int size() {
    return numOfValues;
  }

  public int numberOfOccurrences(int value) {
    int counter = 0;

    for (DoubleNode current = lastDummy.getNext(); current != lastDummy; current = current.getNext()) {
      if (current.hasValue(value))
        counter++;
    }

    return counter;
  }

  public boolean contains(int value) {
    DoubleNode current = lastDummy.getNext();

    while (current != lastDummy && !current.hasValue(value))
      current = current.getNext();

    return current != lastDummy;
  }

  public void addFirst(int value) {
    DoubleNode newNode = new DoubleNode(lastDummy, value, lastDummy.getNext());

    lastDummy.getNext().setPrevious(newNode);
    lastDummy.setNext(newNode);
    numOfValues++;
  }

  public void addLast(int value) {
    DoubleNode newNode = new DoubleNode(lastDummy.getPrevious(), value, lastDummy);

    lastDummy.getPrevious().setNext(newNode);
    lastDummy.setPrevious(newNode);
    numOfValues++;
  }

  public void remove(int value) {
    if (isEmpty())
      System.out.println("Empty structure, there is no values to remove");
    else {
      DoubleNode current = lastDummy.getNext();

      while (current != lastDummy && !current.hasValue(value))
        current = current.getNext();

      if (current != lastDummy) {
        current.getNext().setPrevious(current.getPrevious());
        current.getPrevious().setNext(current.getNext());
        numOfValues--;
      }
      else
        System.out.println("The value is not in the structure");
    }
  }

  @Override
  public String toString() {
    StringBuilder cad = new StringBuilder();

    for (DoubleNode current = lastDummy.getNext(); current != lastDummy; current = current.getNext()) {
      cad.append(current.getValue()).append(' ');
    }

    return cad.toString();
  }

}
