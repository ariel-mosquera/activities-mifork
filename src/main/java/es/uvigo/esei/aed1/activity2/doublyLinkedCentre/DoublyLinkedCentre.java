
package es.uvigo.esei.aed1.activity2.doublyLinkedCentre;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

public class DoublyLinkedCentre {

  private DoubleNode centre;
  // private int numOfValuesL;
  // private int numOfValuesR;
  private int numOfValues;

  public DoublyLinkedCentre() {
    centre = null;
    numOfValues = 0;
  }

  public boolean isEmpty() {
    return numOfValues == 0;
  }

  public int size() {
    return numOfValues;
  }

  public boolean contains(int value) {
    if (isEmpty())
      return false;

    if (centre.hasValue(value))
      return true;
    else {
      DoubleNode current = centre;

      if (value < current.getValue()) {
        while (current != null && !current.hasValue(value))
          current = current.getPrevious();
      }
      else {
        while (current != null && !current.hasValue(value))
          current = current.getNext();
      }
      return current != null;
    }
  }

  public void add(int value) {

    if (numOfValues == 0) {
      centre = new DoubleNode(null, value, null);
      numOfValues++;
    }
    else {
      DoubleNode current = centre;

      if (value < current.getValue()) {
        while (current.getPrevious() != null && current.getPrevious().getValue() > value)
          current = current.getPrevious();

        DoubleNode newNode = new DoubleNode(current.getPrevious(), value, current);

        if (current.getPrevious() != null)
          current.getPrevious().setNext(newNode);

        current.setPrevious(newNode);
      }
      else {
        while (current.getNext() != null && value > current.getNext().getValue())
          current = current.getNext();

        DoubleNode newNode = new DoubleNode(current, value, current.getNext());

        if (current.getNext() != null)
          current.getNext().setPrevious(newNode);

        current.setNext(newNode);
      }
      numOfValues++;

      if (numOfValues % 2 != 0) {
        if (value < centre.getValue())
          centre = centre.getPrevious();
        else
          centre = centre.getNext();
      }
    }
  }

  @Override
  public String toString() {
    if (isEmpty())
      return "";

    StringBuilder cad = new StringBuilder();
    DoubleNode current = centre;

    while (current.getPrevious() != null)
      current = current.getPrevious();

    for (int i = 0; i < numOfValues; i++) {
      cad.append(current.getValue()).append(' ');
      current = current.getNext();
    }

    return cad.toString();
  }
}
