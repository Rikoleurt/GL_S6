package iterator;

import java.util.NoSuchElementException;

public class RowColumnIterator implements Iterator {
    private int currentRow = 0;
    private int currentColumn = 0;
    private Object[][] rowColumnMat;

    public RowColumnIterator(Object[][] rowColumnMat) {
        this.rowColumnMat = rowColumnMat;
    }

    @Override
    public void first() {
       Object o = rowColumnMat[0][0];
       System.out.println(o);
    }

    @Override
    public void next() {
        if(isDone()){
            throw new NoSuchElementException();
        }
        currentColumn++;
        if(currentColumn >= rowColumnMat.length - 1){
            currentRow++;
            currentColumn = 0;
        }
    }

    @Override
    public boolean isDone() {
        return currentRow > rowColumnMat.length - 1 || currentColumn > rowColumnMat.length - 1;
    }

    @Override
    public Object currentItem() {
        return rowColumnMat[currentRow][currentColumn];
    }
}
