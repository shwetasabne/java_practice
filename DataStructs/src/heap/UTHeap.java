package heap;

public class UTHeap {

	public static void main(String[] args) {
		
		Heap h = new Heap(5);
		h.insertElement(10);
		h.insertElement(1);
		h.insertElement(11);
		h.insertElement(9);
		h.insertElement(7);
		h.insertElement(5);
		h.insertElement(2);
		h.printHeap();
	//	System.out.println(h.count);
	//	System.out.println("Min in max is "+h.findMinInMaxHeap());
	//	h.deleteIthIndex(3);
	//	h.heapSort(h, h.array, h.count);
	//	h.printHeap();
		h.findElementsLessThanData(0, 8);
	}

}
