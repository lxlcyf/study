/**  
 * @Title: MyBinaryTree.java 
 * @Package test 
 * @Description: TODO
 * @author lixiaoliang 
 * @date 2015-8-7 下午1:55:13  
 * @Copyright 当当信息技术有限公司 
 * @version V1.0 
 */
package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName: MyBinaryTree
 * @Description: TODO
 * @author lixiaoliang
 * @date 2015-8-7 下午1:55:13
 * @version V1.0
 */
public class MyBinaryTree {

	class Node {
		int value;
		Node left;
		Node right;
	}

	// 非递归
	public void depthTraversal(Node node) {
		// 根节点不为空边界
		if (node == null) {
			return;
		}
		// 注意加泛型
		Stack<Node> stack = new Stack<Node>();
		stack.push(node);
		while (!stack.empty()) {
			// node重复利用
			node = stack.pop();
			System.out.println(node.value);
			// 右子节点不为空边界
			if (node.right != null) {
				stack.push(node.right);
			}
			// 左子节点不为空边界
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}

	// 递归
	public void depthTraversal2(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.value);
		depthTraversal2(node.left);
		depthTraversal2(node.right);
	}

	// 非递归-前序遍历
	public void breadthTraversal(Node node) {
		if (node == null) {
			return;
		}
		// 使用LinkedList作为队列
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while (!queue.isEmpty()) {
			node = queue.poll();
			System.out.println(node.value);
			// 左子节点不为空边界
			if (node.left != null) {
				queue.add(node.left);
			}
			// 右子节点不为空边界
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}

}
