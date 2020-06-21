package data.structures.test;

public interface CustomCollection<E> {
	
	//添加一个元素
	boolean add(E e);
	
	//查询一个元素
	boolean contain(E e);
	
	//删除一个元素
	boolean detele(E e);

}
