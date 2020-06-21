package data.structures.test;

import array.Array;

public class CustomArray<E> implements CustomCollection<E>{
	
	private Array<E> array =new Array<>();

	@Override
	public boolean add(E e) {
		array.addlast(e);
		return true;
	}

	@Override
	public boolean contain(E e) {
		int index=array.find(e);
		if (-1 == index) {
			return false;
		}
		return true;
	}

	@Override
	public boolean detele(E e) {
		array.removeElement(e);
		return true;
	}

}
