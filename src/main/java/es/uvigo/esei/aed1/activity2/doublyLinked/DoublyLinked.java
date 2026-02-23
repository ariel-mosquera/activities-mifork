
package es.uvigo.esei.aed1.activity2.doublyLinked;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

public class DoublyLinked {

  private DoubleNode first;
  private DoubleNode last;
  private int numberOfValues;

  public DoublyLinked() {
    this.first = null;
    this.last = null;
    this.numberOfValues = 0;
  }

  /**
   * 
   * @return true if the structure is empty, false if it's not empty
   */
  public boolean isEmpty() {
    return this.numberOfValues == 0; // o return this.first == null
  }

  /**
   * 
   * @return number of nodes that aren't empty
   */
  public int size() {
    return this.numberOfValues;
  }

  /**
   * 
   * @param value   value searched
   * @param counter int variable that is incremented everytime the current node
   *                has the value received
   * @return counter
   */
  public int numberOfOccurrences(int value) {
    var counter = 0;

    for (DoubleNode current = first; current != null; current = current.getNext()) {
      if (current.hasValue(value))
        counter++;
    }

    return counter;
  }

  public boolean contains(int value) {
    DoubleNode current = first;

    while (current != null && !current.hasValue(value))
      current = current.getNext();

    return current != null;
  }

  public void addFirst(int value) {
    DoubleNode newNode = new DoubleNode(null, value, first);

    if (isEmpty())
      last = newNode;
    else
      first.setPrevious(newNode);

    first = newNode;
    numberOfValues++;
  }

  public void addLast(int value) {
    DoubleNode newNode = new DoubleNode(last, value, null);

    if (isEmpty())
      first = newNode;
    else
      last.setNext(newNode);

    last = newNode;
    numberOfValues++;
  }

  public void remove(int value) {
    if (isEmpty())
      System.out.println("La estructura está vacía");
    else if (first == last && first.hasValue(value)) {

      first = last = null;
      numberOfValues--;

    } else if (first.hasValue(value)) {

      first.getNext().setPrevious(null);
      first = first.getNext();
      numberOfValues--;

    } else {
      DoubleNode current = first;

      while (current != null && !current.hasValue(value)) {
        current = current.getNext();
      }

      if (current == null)
        System.out.println("El valor no está almacenado");
      else if (current == last) {

        last.getPrevious().setNext(null);
        last = last.getPrevious();
        numberOfValues--;

      } else {
        current.getNext().setPrevious(current.getPrevious());
        current.getPrevious().setNext(current.getNext());
        numberOfValues--;
      }
    }

  }

  @Override
  public String toString() {
    StringBuilder cad = new StringBuilder();

    for (DoubleNode current = first; current != null; current = current.getNext()) {
      cad.append(current.getValue()).append(" ");
    }

    return cad.toString();
  }

}
