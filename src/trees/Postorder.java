package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Postorder {
	
	/**
	 * Iterative solution.
	 * 
	 * @param root - Root of the tree.
	 * @return List<Integer> - Preorder traversal of the n-ary tree.
	 */
	public List<Integer> postorder(Node root) {
		List<Integer> result = new ArrayList<Integer>();
		return result;
	}
	
	/**
	 * Trivial recursive solution
	 * 
	 * @param root - Root of the tree.
	 * @return List<Integer> - Preorder traversal of the n-ary tree.
	 */
	public List<Integer> postorderRecurse(Node root) {
		List<Integer> result = new ArrayList<Integer>();

		if(root == null) {
			return result;
		}
		
		recurse(root, result);
		
		return result;
	}
	
	private void recurse(Node node, List<Integer> result) {
				
		if(node.children == null) {
			result.add(node.val);
			return;
		}
				
		for(Node child : node.children) {
			recurse(child, result);
		}
		result.add(node.val);
		
	}

}
