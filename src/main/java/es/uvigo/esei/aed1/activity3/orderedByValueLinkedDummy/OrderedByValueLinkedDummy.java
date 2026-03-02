package es.uvigo.esei.aed1.activity3.orderedByValueLinkedDummy;

public class OrderedByValueLinkedDummy {

  private NodePair dummy;
  // private int numOfValues;

  public OrderedByValueLinkedDummy() {
    this.dummy = new NodePair(null, null);
    // this.numOfValues = 0;
  }

  public boolean contains(int value) {

    NodePair current = dummy.getNext();

    while (current != null && current.getPair().getValue() < value)
      current = current.getNext();

    return !(current == null || current.getPair().getValue() < value);
  }

  public void add(int value) {
    NodePair current = dummy;

    while (current.getNext() != null && current.getNext().getPair().getValue() < value)
      current = current.getNext();

    /*
     * if (current.getNext().getPair().getValue() == value)
     * current.getNext().getPair().setCounter(current.getPair().getCounter() + 1);
     * else { NodePair newNode = new NodePair(new Pair(1, value),
     * current.getNext()); current.setNext(newNode); }
     */

    if (current.getNext() == null || current.getNext().getPair().getValue() > value) {
      NodePair newNode = new NodePair(new Pair(1, value), current.getNext());
      current.setNext(newNode);
    }
    else {
      Pair myPair = current.getNext().getPair();
      myPair.setCounter(myPair.getCounter() + 1);
    }

    // numOfValues++;
  }

  public void remove(int value) {
    if (dummy.getNext() == null)
      System.out.println("Empty structure");
    else {
      NodePair current = dummy;

      while (current.getNext() != null && current.getNext().getPair().getValue() < value)
        current = current.getNext();

      if (current.getNext() == null || current.getNext().getPair().getValue() > value)
        System.out.println("The value is not in the structure...");
      else {
        Pair myPair = current.getNext().getPair();

        if (myPair.getCounter() == 1)
          current.setNext(current.getNext().getNext());
        else
          current.getNext().getPair().setCounter(myPair.getCounter() - 1);
      }
      // numOfValues--;
    }
  }

  @Override
  public String toString() {
    StringBuilder cad = new StringBuilder();

    for (NodePair current = dummy.getNext(); current != null; current = current.getNext()) {
      cad.append(current.getPair()).append(" ");
    }

    return cad.toString();
  }
}
