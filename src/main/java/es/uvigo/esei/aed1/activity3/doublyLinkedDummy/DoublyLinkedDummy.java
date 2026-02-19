
package es.uvigo.esei.aed1.activity3.doublyLinkedDummy;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

public class DoublyLinkedDummy {

  private DoubleNode first;
  private DoubleNode last;
  private int numOfValues;

  public DoublyLinkedDummy() {
    this.first = new DoubleNode(null, 0, null);
    this.last = new DoubleNode(this.first, 0, null);
    this.first.setNext(this.last);
    this.numOfValues = 0;
  }

  public boolean isEmpty() {
    return this.numOfValues == 0;
  }

  public int size() {
    return this.numOfValues;
  }

  public int numberOfOccurrences(int value) {
    var counter = 0;

    for (DoubleNode current = this.first.getNext(); current != null; current = current.getNext()) {
      if (current.hasValue(value))
        counter++;
    }

    return counter;
  }

  public boolean contains(int value) {

    DoubleNode current = this.first.getNext();

    while (current != null && !current.hasValue(value))
      current = current.getNext();

    return current != null;
  }

  public void addFirst(int value) {

  }

  public void addLast(int value) {

  }

  public void remove(int value) {

  }

  @Override
  public String toString() {
    return "";
  }

}
