package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collection;

public class test {
	public static void main(String[]args) {
		//INode node1=new Node(10);
		//INode node2=new Node(7);
		//INode node3=new Node(5);
		IHeap<Integer> heap=(IHeap<Integer>) Heap.getInst();
		//heap.insert(10);
		//heap.insert(7);
		//heap.insert(5);
		//heap.insert(50);
		//heap.insert(11);
		//heap.insert(333);
		//heap.extract();
		//heap.extract();
		//heap.insert(20);
		ArrayList<Integer> arr=new ArrayList<Integer>();
		arr.add(1);
		arr.add(3);
		arr.add(5);
		arr.add(4);
		arr.add(6);
		arr.add(13);
		arr.add(10);
		arr.add(9);
		arr.add(8);
		arr.add(15);
		arr.add(17);
		heap.build(arr);
		
	}

}
