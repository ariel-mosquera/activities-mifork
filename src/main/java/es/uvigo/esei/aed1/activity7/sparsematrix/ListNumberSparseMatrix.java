package es.uvigo.esei.aed1.activity7.sparsematrix;

import es.uvigo.esei.aed1.tads.list.LinkedList;
import es.uvigo.esei.aed1.tads.list.List;
import java.util.Iterator;

public class ListNumberSparseMatrix implements NumberSparseMatrix {

  private final int numRows;
  private final int numCols;
  private final List<ValueRow> rows;

  public ListNumberSparseMatrix(int n, int m) throws IllegalArgumentException {
    if (n <= 0 || m <= 0) {
      throw new IllegalArgumentException();
    }
    this.numRows = n;
    this.numCols = m;
    rows = new LinkedList<>();
  }

  @Override
  public int getNumRows() {
    return this.numRows;
  }

  @Override
  public int getNumCols() {
    return this.numCols;
  }

  @Override
  public Number get(int i, int j) throws IndexOutOfBoundsException {
    if (i <= 0 || i > numRows || j <= 0 || j > numCols)
      throw new IndexOutOfBoundsException();

    for (ValueRow row : rows) {
      if (row.getRow() == i) {
        for (ValueCol col : row.getColumns()) {
          if (col.getColumn() == j)
            return col.getValue();
        }
      }
    }

    return 0;
  }

  @Override
  public void set(int i, int j, Number value) throws IndexOutOfBoundsException {
    if (i <= 0 || i > numRows || j <= 0 || j > numCols)
      throw new IndexOutOfBoundsException();

    Iterator<ValueRow> rowItr = rows.iterator();
    boolean isSetted = false;
    int rowsSize = rows.size();

    int k = 0;
    while (k < rowsSize && !isSetted) {
      ValueRow row = rowItr.next();

      if (row.getRow() == i) {
        Iterator<ValueCol> colItr = row.getColumns().iterator();
        int size = row.getColumns().size();

        if (row.getColumns().isEmpty()) {
          row.getColumns().addLast(new ValueCol(j, value));
          isSetted = true;
        }

        int l = 0;
        while (l < size && !isSetted) {
          ValueCol col = colItr.next();

          if (col.getColumn() == j) {
            col.setValue(value);
            isSetted = true;
          }
          else if (col.getColumn() > j) { // the new column will be right before the actual column
            row.getColumns().add(l, new ValueCol(j, value));
            isSetted = true;
          }
          else if (l == (size - 1) && col.getColumn() < j) { // the new column will be in the last position
            row.getColumns().addLast(new ValueCol(j, value));
            isSetted = true;
          }
          l++;
        }
      }
      else if (row.getRow() > i || (k == rowsSize - 1 && !isSetted)) {
        ValueCol newCol = new ValueCol(j, value);
        List<ValueCol> colList = new LinkedList<>();
        colList.addLast(newCol);

        if (row.getRow() > i) // the new row will be added before the actual row
          rows.add(k, new ValueRow(i, colList));
        else // the new row will be in the last position
          rows.addLast(new ValueRow(i, colList));

        isSetted = true;
      }
      k++;
    }

    if (rows.isEmpty()) {
      ValueCol newCol = new ValueCol(j, value);
      rows.addLast(new ValueRow(i));
      rows.getLast().getColumns().addLast(newCol);
    }
  }
}