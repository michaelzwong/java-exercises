package trees;

import java.util.ArrayList;
import java.util.List;

import trees.Node;

//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Set;

/**
* Test classes and methods from here.
* 
* @author michaelwong
*
*/
public class Main {
	/**
	 * Main Function.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Preorder preorder = new Preorder();
		Postorder postorder = new Postorder();
		Node grandchildOne = new Node(5, null);
		Node grandchildTwo = new Node(6, null);
		Node grandchildThree = new Node(7, null);
		List<Node> grandchildrenOne = new ArrayList<Node>();
		grandchildrenOne.add(grandchildOne);
		grandchildrenOne.add(grandchildTwo);
		List<Node> grandchildrenTwo = new ArrayList<Node>();
		grandchildrenTwo.add(grandchildThree);
		Node childOne = new Node(2, null);
		Node childTwo = new Node(3, grandchildrenTwo);
		Node childThree = new Node(4, grandchildrenOne);
		List<Node> children = new ArrayList<Node>();
		children.add(childOne);
		children.add(childTwo);
		children.add(childThree);
		Node parent = new Node(1, children);
		List<Integer> preorderResult = preorder.preorderRecurse(parent);
		for(Integer num : preorderResult) {
			System.out.print(num);
		}
		System.out.println();
		List<Integer> postorderResult = postorder.postorderRecurse(parent);
		for(Integer num : postorderResult) {
			System.out.print(num);
		}
	}
	
	
}

