package tree.avl;

import java.net.URL ;
import java.util.ArrayList ;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test ;
import util.FileOperation ;

public class AVLTreeTest {
	
	private ArrayList<String> words;
	
	
	@Before
	public void init(){
		URL resource = this.getClass().getClassLoader().getResource("pride-and-prejudice.txt");
		words = new ArrayList<>();
		if (!FileOperation.readFile(resource.getPath() , words)) {
			throw new RuntimeException("read file error!");
		}

	}
	
	@Test
	public void testTree(){
		String wordToFind="tangjia";
		long startTime = System.currentTimeMillis();    //获取开始时间

		boolean b=words.contains(wordToFind);    //测试的代码段

		long endTime = System.currentTimeMillis();    //获取结束时间

		System.out.println("b="+b+",程序运行时间：" + (endTime - startTime));    //输出程序运行时间
		
		AVLTree<String, Integer> avlMap = new AVLTree<>();
		for (String word : words){
			avlMap.add(word, 0);
		}
		
		long startTime2 = System.currentTimeMillis();    //获取开始时间

		boolean b2=avlMap.contains(wordToFind);    //测试的代码段

		long endTime2 = System.currentTimeMillis();    //获取结束时间

		System.out.println("b2="+b2+",程序运行时间：" + (endTime2 - startTime2));    //输出程序运行时间
		
	}
	
	/**
	 * 把毫秒数转换成时分秒
	 * @param millis
	 * @return
	 */
	public String millisToStringShort(long millis) {
		StringBuilder strBuilder = new StringBuilder();
		long temp = millis;
		long hper = 60 * 60 * 1000;
		long mper = 60 * 1000;
		long sper = 1000;
		if (temp / hper > 0) {
			strBuilder.append(temp / hper).append("小时");
		}
		temp = temp % hper;
 
		if (temp / mper > 0) {
			strBuilder.append(temp / mper).append("分钟");
		}
		temp = temp % mper;
		if (temp / sper > 0) {
			strBuilder.append(temp / sper).append("秒");
		}
		return strBuilder.toString();
	}
	/**
	 * 测试AVL树添加操作
	 */
	@Ignore
	@Test
	public void testAVLAdd() {
			System.out.println("Pride and Prejudice") ;
			AVLTree<String, Integer> avlMap = new AVLTree<>();
			for (String word : words){
				avlMap.add(word, 0);
			}
			
			// isBST(), 辅助函数, 判断树是否符合二分搜索树特性
			System.out.println("AVL Tree is BST: " + avlMap.isBST()) ;
			// isBalanced(), 辅助函数, 判断树是否符合AVL树特性
			System.out.println("AVL Tree is isBalanced: " + avlMap.isBalanced()) ;
			
			// 删除操作
			for (String word : words){
				avlMap.remove(word);
				// 如果元素删除之后存在不符合二分搜索树或平衡二叉树的特性, 就打印错误日志
				if (!(avlMap.isBST() && avlMap.isBalanced())) {
					System.err.println("Error") ;
				}
			}
			
			// isBST(), 辅助函数, 判断树是否符合二分搜索树特性
			System.out.println("AVL Tree is BST: " + avlMap.isBST()) ;
			// isBalanced(), 辅助函数, 判断树是否符合AVL树特性
			System.out.println("AVL Tree is isBalanced: " + avlMap.isBalanced()) ;
		}

	
	
}
