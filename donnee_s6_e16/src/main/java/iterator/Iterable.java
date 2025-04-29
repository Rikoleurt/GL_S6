package iterator;

public interface Iterable {
	
	public Iterator createRowColumnIterator();
	public Iterator createColumnRowIterator();
}
