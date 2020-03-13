package eg.edu.alexu.csd.filestructure.sort;
import java.lang.*;
import java.util.Collection;

public class Heap <T extends Comparable<T>>implements IHeap<T>{
	private static int size=0;
	private  static INode[]arr=(INode[])new INode[10000000];
	 Heap() {
		 arr=(INode<T>[])new INode[10000000];
		 size=0;
	}
	 Heap(int s){
		 
	 }
	//public static  Heap ob=new Heap();
	//public static Heap getInst() {
	//	if(ob==null) {
	//		return new Heap();
	//	}
	//	return ob;
	//}
	public INode<T> getRoot() {
		if(size==0) {
			return null;
		}
		return (INode<T>) arr[1];
	}

	public int size() {
		return size;
	}

	
	public void heapify(INode<T> node) {
		if(node==null) {
			return;
		}
		INode<T>l=node.getLeftChild();
		INode<T>r=node.getRightChild();
		INode<T>large=node;
		//int left=((Integer) l.getValue()).intValue();
		//int right=((Integer) r.getValue()).intValue();
		T n=node.getValue();
		if(l!=null &&( l.getValue().compareTo(n)>0)) {
			large=l;
		}
		if(r!=null && ( r.getValue().compareTo(node.getValue())>1)) {
			large=r;
		}
		
		if(large!=node) {
			T x=node.getValue();
			node.setValue(large.getValue());
			large.setValue(x);
			heapify(large);
		}
		
	}

	@Override
	public T extract() {
		if(size==0) {
			return null;
		}
		T temp=(T) arr[1].getValue();
		arr[1].setValue(arr[size].getValue());
		size--;
		heapify((INode<T>) arr[1]);
		return temp;
	}

	public void insert(T element) {
		Node<T> n=new Node<T>(element,size+1);
		if(size==arr.length) {
			System.out.println("Maximum capacity");
			return;
		}
		arr[size+1]=(INode<T>) n;
		size++;
		int i=size;
		while(i!=1&&i!=0 &&(((Integer) arr[i].getValue()).intValue())>(((Integer) arr[i/2].getValue()).intValue())) {
			T temp=(T) arr[i].getValue();
			arr[i].setValue(arr[i/2].getValue());
			arr[i/2].setValue((Integer) temp);
			//System.out.println("element"+" "+arr[i].getValue()+"swaped"+arr[i/2].getValue());
			i=i/2;
		}

	}

	public void build(Collection<T> unordered) {
		if(unordered==null) {
			size=0;
			return;
		}
		arr=(INode<T>[])new INode[10000000];
		size=0;
		for(T E:unordered) {
			Node<T> n=new Node<T>(E,size+1);
			arr[size+1]=(INode<T>) n;
			size++;
		}
		int end=size;
		for(int i=end;i>0;i--) {
			heapify((INode<T>) arr[i]);
		}
		
	}
	public INode<T>[] getHeap(){
		return (INode<T>[]) arr;
	}
	public void add(T element) {
		Node<T> n=new Node<T>(element,size+1);
		if(size==arr.length) {
			System.out.println("Maximum capacity");
			return;
		}
		arr[size+1]=(INode<T>) n;
		size++;
	}
	
}


