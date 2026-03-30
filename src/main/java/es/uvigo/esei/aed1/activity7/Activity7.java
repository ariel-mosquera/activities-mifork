package es.uvigo.esei.aed1.activity7;

import es.uvigo.esei.aed1.activity7.hospital.Hospital;
import es.uvigo.esei.aed1.tads.list.IteratorList;
import es.uvigo.esei.aed1.tads.list.LinkedList;
import es.uvigo.esei.aed1.tads.list.List;
import es.uvigo.esei.aed1.activity7.hospital.Doctor;

import static java.util.Objects.requireNonNull;

import java.util.Iterator;

public class Activity7 {

  // Exercise 1
  public static List<Integer> getHigherThan(List<Integer> listToFilter, int threshold) throws NullPointerException {
    requireNonNull(listToFilter);

    List<Integer> newList = new LinkedList<>();

    for (Integer i : listToFilter) {
      if (i > threshold)
        newList.addLast(i);
    }

    return newList;
  }

  // Exercise 2
  public static <T> List<T> invert(List<T> list) throws NullPointerException {
    requireNonNull(list);

    List<T> invertedList = new LinkedList<>();

    for (T t : list) {
      invertedList.addFirst(t);
    }

    return invertedList;
  }

  // Exercise 3
  private static <T> int countValueAppearances(List<T> list, T referenceValue) {
    int counter = 0;

    for (T t : list) {
      if (t.equals(referenceValue))
        counter++;
    }

    return counter;
  }

  public static <T> boolean allValuesAppearancesAreEqual(List<T> list) throws NullPointerException {
    requireNonNull(list);

    if (list.isEmpty())
      return false;

    int appearancesFirstValue = countValueAppearances(list, list.getFirst());

    for (T t : list) {
      if (countValueAppearances(list, t) != appearancesFirstValue)
        return false;
    }

    return true;
  }

  // Exercise 4
  public static <T extends Comparable<T>> boolean isAscendingOrder(List<T> list) throws NullPointerException {
    requireNonNull(list);

    boolean isAscending = true;
    Iterator<T> itr = list.iterator();

    for (T t : list) {
      if (t.compareTo(itr.next()) < 0)
        isAscending = false;
    }

    return isAscending;
  }

  // Exercise 5
  public static <T> List<T> buildListWithRepeatedValues(List<T> list) throws NullPointerException {
    requireNonNull(list);

    List<T> result = new LinkedList<>();

    for (T t : list) {
      if (countValueAppearances(list, t) > 1 && countValueAppearances(result, t) == 0)
        result.addLast(t);
    }

    return result;
  }

  // Exercise 6
  private static <T> boolean countTuplesWithAValue(List<Terna<T>> list, T value) {
    for (Terna<T> terna : list) {
      if (terna.getValue().equals(value))
        return true;
    }
    return false;
  }

  public static <T> List<Terna<T>> buildSummaryList(List<T> list1, List<T> list2) throws NullPointerException {
    requireNonNull(list1);
    requireNonNull(list2);

    List<Terna<T>> summary = new LinkedList<>();
    int cntrList1;
    int cntrList2;

    // adding to summary the values that are in both lists or only in list1

    for (T t : list1) {
      if (!countTuplesWithAValue(summary, t)) {
        cntrList1 = countValueAppearances(list1, t);
        cntrList2 = countValueAppearances(list2, t);
        summary.addLast(new Terna<T>(t, cntrList1, cntrList2));
      }
    }

    // adding to summary the values that are only in list2

    for (T t : list2) {
      if (!countTuplesWithAValue(summary, t)) {
        cntrList2 = countValueAppearances(list2, t);
        summary.addLast(new Terna<T>(t, 0, cntrList2));
      }
    }

    return summary;
  }

  // Exercise 7
  public static int countValuesEqualSumPreceding(List<Integer> list) throws NullPointerException {
    requireNonNull(list);

    int counter = 0;
    int sum = 0;

    for (Integer i : list) {
      if (i.equals(sum))
        counter++;
      sum += i;
    }

    return counter;
  }

  // Exercise 8
  public static <T> List<T> printLots(List<T> list, List<Integer> index) throws NullPointerException {
    requireNonNull(list);
    requireNonNull(index);

    int pos = 1;
    Iterator<Integer> indexItr = index.iterator();
    List<T> result = new LinkedList<>();
    int targetIndex = 0;

    if (indexItr.hasNext())
      targetIndex = indexItr.next();

    for (T t : list) {
      if (targetIndex == pos) {
        result.addLast(t);
        if (indexItr.hasNext())
          targetIndex = indexItr.next();
      }
      pos++;
    }

    return result;
  }

  // Exercise 9
  public static void duplicateValues(List<Integer> list) throws NullPointerException {
    requireNonNull(list);

    IteratorList<Integer> itr = list.iteratorList();

    while (itr.hasNext()) {
      int value = itr.next();
      itr.setPrevious(value * 2);
    }
  }

  // Exercise 10
  public static Integer getMorePatients(Hospital chuo) {
    Doctor mostPatients = chuo.getDoctors().getFirst();

    for (Doctor doctor : chuo.getDoctors()) {
      if (doctor.getPatients().size() > mostPatients.getPatients().size())
        mostPatients = doctor;
    }

    return mostPatients.getNumber();
  }

  // Exercise 11
  // En este ejercicio debes implementar los métodos get y set de la clase
  // es.uvigo.esei.aed1.activity7.sparsematrix.ListNumberSparseMatrix

}
