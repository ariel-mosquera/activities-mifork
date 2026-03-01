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
    return this.last.getNext().getValue();
  }

  public boolean contains(int value) {

    if (this.isEmpty()) {
      System.out.println("The list is empty");
      return false;
    }

    Node current = last.getNext();

    do {
      if (current.hasValue(value))
        return true;

      current = current.getNext();
    } while (current != last.getNext());

    return false;
  }

  public boolean contains2(int value) {

    return true;
  }

  public int numberOfOccurrences(int value) {
    var counter = 0;

    if (!isEmpty()) {
      Node current = last.getNext();

      do {
        if (current.hasValue(value)) {
          counter++;
        }
        current = current.getNext();
      } while (current != last.getNext());
    }

    return counter;
  }

  public void addLast(int value) {
    Node newNode = new Node(value, null);

    if (this.isEmpty()) {
      newNode.setNext(newNode);
    }
    else {
      newNode.setNext(last.getNext());
      last.setNext(newNode);
    }

    last = newNode;
    numberOfValues++;
  }

  public void removeFirst() {
    if (this.isEmpty()) {
      System.out.println("There are no elements to remove");
    }
    else if (last.getNext() == last) {
      last = null;
      numberOfValues--;
    }
    else {
      Node first = last.getNext();
      last.setNext(first.getNext());
      first.setNext(null);
      numberOfValues--;
    }
  }

  @Override
  public String toString() {
    StringBuilder cad = new StringBuilder();

    if (isEmpty()) {
      cad.append("Empty list");
    }
    else {
      Node current = last.getNext();

      do {
        cad.append(current.getValue()).append(" ");
        current = current.getNext();
      } while (current != last.getNext());
    }

    return cad.toString();
  }
}
