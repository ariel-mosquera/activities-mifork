
package es.uvigo.esei.aed1.activity3.orderedLinkedDummy;

import es.uvigo.esei.aed1.commonLinked.Node;

public class OrderedLinkedDummy {

  private Node dummy;
  private int numOfValues;

  public OrderedLinkedDummy() {
    dummy = new Node(0, null);
    numOfValues = 0;
  }

  public boolean contains(int value) {
    Node current = dummy.getNext();

    while (current != null && !current.hasValue(value))
      current = current.getNext();

    return current != null;
  }

  public void add(int value) {
    Node newNode = new Node(value, null);
    Node current = dummy;

    while (current.getNext() != null && current.getNext().getValue() < newNode.getValue())
      current = current.getNext();

    newNode.setNext(current.getNext());
    current.setNext(newNode);
    numOfValues++;
  }

  public void remove(int value) {
    Node current = dummy;

    while (current.getNext() != null && !current.getNext().hasValue(value))
      current = current.getNext();

    if (current.getNext() == null)
      System.out.println("The value is not in the structure");
    else {
      current.setNext(current.getNext().getNext());
      numOfValues--;
    }
  }

  @Override
  public String toString() {
    StringBuilder cad = new StringBuilder();

    for (Node current = dummy.getNext(); current != null; current = current.getNext())
      cad.append(current.getValue()).append(' ');

    return cad.toString();
  }
}