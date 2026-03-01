package es.uvigo.esei.aed1.activity2.linkedWith2References;

import es.uvigo.esei.aed1.commonLinked.Node;

public class LinkedWith2References {
  private Node first;
  private Node last;
  private int numberOfValues;

  public LinkedWith2References() {
    this.first = this.last = null;
    this.numberOfValues = 0;
  }

  public boolean isEmpty() {
    return this.numberOfValues == 0; /* Opcion 2: this.first == null && this.last == null */
  }

  public int size() {
    return this.numberOfValues;
  }

  public int numberOfOccurrences(int value) {
    var counter = 0;

    for (Node current = first; current != null; current = current.getNext()) {
      if (current.hasValue(value))
        counter++;
    }

    return counter;
  }

  public boolean contains(int value) {
    Node current = first;

    while (current.getNext() != null && !current.hasValue(value))
      current = current.getNext();

    return current != null;
  }

  public void addFirst(int value) {
    Node newNode = new Node(value, first);

    first = newNode;

    if (isEmpty())
      last = newNode;

    numberOfValues++;
  }

  public void addLast(int value) {
    Node newNode = new Node(value, null);

    if (isEmpty())
      first = newNode;
    else
      last.setNext(newNode);

    last = newNode;
    numberOfValues++;
  }

  public void remove(int value) {
    if (isEmpty()) {
      System.out.println("Empty structure");
      return;
    }

    if (this.first.hasValue(value)) {
      this.first.setNext(this.first.getNext());

      if (this.first == null)
        this.last = null;

      this.numberOfValues--;
      return;
    }

    Node current = this.first;

    while (current.getNext() != null && !current.getNext().hasValue(value)) {
      current = current.getNext();
    }

    if (current.getNext() == null) {
      System.out.println("The value it's not in the list");
    }
    else {
      current.setNext(current.getNext().getNext());

      if (current.getNext() == null)
        this.last = current;

      this.numberOfValues--;
    }
  }

  @Override
  public String toString() {
    StringBuilder cadena = new StringBuilder();

    for (Node current = this.first; current != null; current = current.getNext())
      cadena.append(current.getValue()).append(" ");

    return cadena.toString();
  }

}
