
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

  }

  public void remove(int value) {

  }

  @Override
  public String toString() {
    return "";

  }

}
