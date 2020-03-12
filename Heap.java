package eg.edu.alexu.csd.filestructure.sort;
import java.lang.*;
import java.util.Collection;

public class Heap <Int extends Comparable<Int>>implements IHeap<Int>{
	private int size=0;
	private INode<Int>[]arr=(INode<Int>[])new INode[100];
	 Heap() {
		
	}
	public static  Heap ob=new Heap();
	public static Heap getInst() {
		if(ob==null) {
			return new Heap();
		}
		return ob;
	}
	public INode<Int> getRoot() {
		if(size==0) {
			return null;
		}
		return arr[1];
	}

	public int size() {
		return size;
	}

	
	public void heapify(INode<Int> node) {
		INode<Int>l=node.getLeftChild();
		INode<Int>r=node.getRightChild();
		INode<Int>large=node;
		//int left=((Integer) l.getValue()).intValue();
		//int right=((Integer) r.getValue()).intValue();
		int n=((Integer) node.getValue()).intValue();
		if(l!=null &&((Integer) l.getValue()).intValue()>n ) {
			large=l;
		}
		if(r!=null && ((Integer) r.getValue()).intValue()>((Integer) node.getValue()).intValue()) {
			large=r;
		}
		
		if(large!=node) {
			Int x=node.getValue();
			node.setValue(large.getValue());
			large.setValue(x);
			heapify(large);
		}
		
	}

	@Override
	public Int extract() {
		Int temp=arr[1].getValue();
		arr[1].setValue(arr[size].getValue());
		size--;
		heapify(arr[1]);
		for(int i=1;i<=size;i++) {
			System.out.println(arr[i].getValue());
		}
		return temp;
	}

	public void insert(Int element) {
		Node<Int> n=new Node<Int>(element,size+1);
		if(size==arr.length) {
			System.out.println("Maximum capacity");
			return;
		}
		arr[size+1]=n;
		size++;
		int i=size;
		while(i!=1&&i!=0 &&(((Integer) arr[i].getValue()).intValue())>(((Integer) arr[i/2].getValue()).intValue())) {
			Int temp=arr[i].getValue();
			arr[i].setValue(arr[i/2].getValue());
			arr[i/2].setValue(temp);
			System.out.println("element"+" "+arr[i].getValue()+"swaped"+arr[i/2].getValue());
			i=i/2;
		}
		for(i=1;i<=size;i++) {
			System.out.println(arr[i].getValue());
		}
		
	}

	public void build(Collection<Int> unordered) {
		arr=(INode<Int>[])new INode[100];
		size=0;
		for(Int E:unordered) {
			insert(E);
		}
		int end=unordered.size()/2;
		for(int i=end;i>0;i--) {
			heapify(arr[i]);
		}
		for(int i=1;i<=size;i++) {
			System.out.println(arr[i].getValue());
		}
		
	}
	public INode<Int>[] getHeap(){
		return arr;
	}
	
}


