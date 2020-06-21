package data.structures.test;

import linked.MyLinkedList;

public class CustomLinked<E> implements CustomCollection<E>{
	
	private MyLinkedList<E> linkedList =new MyLinkedList<>(); 

	@Override
	public boolean add(E e) {
		linkedList.addLast(e);
		return true;
	}

	@Override
	public boolean contain(E e) {
		return linkedList.contains(e);
	}

	@Override
	public boolean detele(E e) {
		return false;
	}

}
