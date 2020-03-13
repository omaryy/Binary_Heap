package eg.edu.alexu.csd.filestructure.sort;
import eg.edu.alexu.csd.filestructure.sort.Heap;
public class Node <T extends Comparable<T>>implements INode<T>{
	private T value;
	private int index;
	 Heap<T> ob=new Heap<T>(3);
	Node( ){
		value=null;
		index=ob.size()+1;
	}
	Node(T val,int size){
		value=val;
		index=size;
	}

	public INode<T> getLeftChild() {
		return (INode<T>) ob.getHeap()[index*2];
	}

	@Override
	public INode<T> getRightChild() {
		return (INode<T>) ob.getHeap()[index*2+1];
	}

	@Override
	public INode<T> getParent() {
		int n=(int) Math.floor(index/2);
		return (INode<T>) ob.getHeap()[n];
	}

	@Override
	public T getValue() {
		return value;
	}


	public  void setValue(T val) {
		value= val;
	}
	public  void setindex(int val) {
		index= val;
	}
	

}
