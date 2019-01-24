package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Preorder {
	
	/**
	 * Iterative solution.
	 * 
	 * @param root - Root of the tree.
	 * @return List<Integer> - Preorder traversal of the n-ary tree.
	 */
	public List<Integer> preorder(Node root) {
		List<Integer> result = new ArrayList<Integer>();

		if(root == null) {
			return result;
		}
		
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			Node curNode = stack.pop();
			result.add(curNode.val);
			if(curNode.children != null) {
                int size = curNode.children.size();
				for(int i = size - 1; i >= 0; i--) {
                    stack.push(curNode.children.get(i));
                }
			}
		}
		
		return result;
	}
	
	/**
	 * Trivial recursive solution
	 * 
	 * @param root - Root of the tree.
	 * @return List<Integer> - Preorder traversal of the n-ary tree.
	 */
	public List<Integer> preorderRecurse(Node root) {
		List<Integer> result = new ArrayList<Integer>();

		if(root == null) {
			return result;
		}
		
		recurse(root, result);
		
		return result;
	}
	
	private void recurse(Node node, List<Integer> result) {
		
		if(node == null) {
			return;
		}
		
		result.add(node.val);
		
		if(node.children == null) {
			return;
		}
		
		for(Node child : node.children) {
			recurse(child, result);
		}
	}

}

/**
 * Definition for a node in an n-ary tree.
 * 
 * @author michaelwong
 *
 */
class Node {
	public int val;
	public List<Node> children;

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
};

