package es.uvigo.esei.aed1.activity2.circularLinked;

import es.uvigo.esei.aed1.commonLinked.Node;

public class CircularLinked {

  private Node last;
  private int numberOfValues;

  public CircularLinked() {
    this.last = null;
    this.numberOfValues = 0;
  }

  public boolean isEmpty() {
    return this.last == null; // o this.numberOfValues == 0;
  }

  public int size() {
    return this.numberOfValues;
  }

  public int firstValue() throws NullPointerException {
    if (isEmpty())
      throw new NullPointerException();

    return last.getNext().getValue();
  }

  public boolean contains(int value) {
    if (isEmpty())
      return false;

    Node current = last.getNext();

    while (current != last && !current.hasValue(value))
      current = current.getNext();

    /*
     * do { if (current.hasValue(value)) return true;
     * 
     * current = current.getNext(); } while (current != last.getNext());
     * 
     * return false;
     */

    return current.hasValue(value);
  }

  public int numberOfOccurrences(int value) {
    if (isEmpty())
      return 0;

    var counter = 0;
    Node current = last.getNext();

    for (int i = 1; i <= numberOfValues; i++) {
      if (current.hasValue(value))
        counter++;
      current = current.getNext();
    }

    return counter;
  }

  public void addLast(int value) {
    Node newNode = new Node(value, null);

    if (isEmpty())
      newNode.setNext(newNode);
    else {
      newNode.setNext(last.getNext());
      last.setNext(newNode);
    }

    last = newNode;
    numberOfValues++;
  }

  public void removeFirst() {
    if (this.isEmpty())
      System.out.println("Empty structure");
    else {
      Node first = last.getNext();

      if (numberOfValues == 1)
        last = null;
      else
        last.setNext(first.getNext());

      numberOfValues--;
    }
  }

  @Override
  public String toString() {
    StringBuilder cad = new StringBuilder();

    int i = 1;
    for (Node current = last.getNext(); i <= numberOfValues; i++) {
      cad.append(current.getValue()).append(" ");
      current = current.getNext();
    }

    return cad.toString();
  }
}
