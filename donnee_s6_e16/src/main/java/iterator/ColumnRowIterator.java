package iterator;

import java.util.NoSuchElementException;

public class ColumnRowIterator implements Iterator {
    int currentRow = 0;
    int currentColumn = 0;
    Object[][] columnRowMat;

    public ColumnRowIterator(Object[][] array2d) {
        this.columnRowMat = array2d;
    }

    @Override
    public void first() {
        Object o = columnRowMat[0][0];
        System.out.println(o);

    }

    @Override
    public void next() {
        if(isDone()){
            throw new NoSuchElementException();
        }
        currentRow++;

        if(currentRow >= columnRowMat[0].length - 1){
            currentColumn++;
            currentRow = 0;
        }
    }

    @Override
    public boolean isDone() {
        return currentRow > columnRowMat.length - 1 || currentColumn > columnRowMat.length - 1;
    }

    @Override
    public Object currentItem() {
        return columnRowMat[currentRow][currentColumn];
    }
}
