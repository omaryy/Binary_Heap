package eg.edu.alexu.csd.filestructure.sort;
import eg.edu.alexu.csd.filestructure.sort.Heap;
public class Node <Int extends Comparable<Int>>implements INode<Int>{
	private Int value;
	private int index;
	//Heap<Int> ob=(Heap<Int>) Heap.getInst();
	Node( ){
		value=null;
		index=Heap.ob.size();
	}
	Node(Int val,int size){
		value=val;
		index=size;
	}

	public INode<Int> getLeftChild() {
		return (INode<Int>) Heap.ob.getHeap()[index*2];
	}

	@Override
	public INode<Int> getRightChild() {
		return (INode<Int>) Heap.ob.getHeap()[index*2+1];
	}

	@Override
	public INode<Int> getParent() {
		int n=(int) Math.floor(index/2);
		return (INode<Int>) Heap.ob.getHeap()[n];
	}

	@Override
	public Int getValue() {
		return value;
	}


	public  void setValue(Int val) {
		value= val;
	}
	public  void setindex(int val) {
		index= val;
	}
	

}
