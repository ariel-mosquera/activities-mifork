
package es.uvigo.esei.aed1.activity3.doublyLinkedDummy;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

public class DoublyLinkedDummy {

  private DoubleNode firstDummy;
  private DoubleNode lastDummy;
  private int numOfValues;

  public DoublyLinkedDummy() {
    firstDummy = new DoubleNode(null, 0, null);
    lastDummy = new DoubleNode(firstDummy, 0, null);
    firstDummy.setNext(lastDummy);
  }

  public boolean isEmpty() {
    return this.numOfValues == 0;
  }

  public int size() {
    return this.numOfValues;
  }

  public int numberOfOccurrences(int value) {
    var counter = 0;

    for (DoubleNode current = this.firstDummy.getNext(); current != null; current = current.getNext()) {
      if (current.hasValue(value))
        counter++;
    }

    return counter;
  }

  public boolean contains(int value) {

    DoubleNode current = this.firstDummy.getNext();

    while (current != lastDummy && !current.hasValue(value))
      current = current.getNext();

    return current != lastDummy;
  }

  public void addFirst(int value) {
    DoubleNode newNode = new DoubleNode(firstDummy, value, firstDummy.getNext());

    firstDummy.getNext().setPrevious(newNode);
    firstDummy.setNext(newNode);
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
      System.out.println("Empty structure");
    else {
      DoubleNode current = firstDummy.getNext();

      while (current != lastDummy && !current.hasValue(value))
        current = current.getNext();

      if (current != lastDummy) {
        current.getNext().setPrevious(current.getPrevious());
        current.getPrevious().setNext(current.getNext());
        numOfValues--;
      }
      else
        System.out.println("The value is not in the structure to be removed...");
    }
  }

  @Override
  public String toString() {
    StringBuilder cad = new StringBuilder();

    for (DoubleNode current = firstDummy.getNext(); current != lastDummy; current = current.getNext()) {
      cad.append(current.getValue()).append(' ');
    }

    return cad.toString();
  }

}
