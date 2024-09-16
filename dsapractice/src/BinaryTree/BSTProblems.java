package BinaryTree;
import BinaryTree.BinarySearchTree.Node;
import java.util.Queue;
import java.util.LinkedList;


public class BSTProblems {
	
	

	public void treeLevelTraversal(Node root) {
//		Node temp = root;
		Queue<Node> node = new LinkedList<>();
		node.offer(root);
		while(!node.isEmpty()) {
			Node temp = node.poll();
			System.out.print(" - "+temp.data);
			if(temp.left!=null)
				node.offer(temp.left);
			if(temp.right!=null)
				node.offer(temp.right);
		}
		System.out.println();
	}
	
	public int findMax(Node root) {
		if(root==null)
			return Integer.MIN_VALUE;

		int res = root.data;
		int left = findMax(root.left);
		int right = findMax(root.right);
		if(res<left)
			res=left;
		if(res<right)
			res=right;
		return res;
		
	}
	
	public Node searchKey(Node root, int key) {
		if(root==null || root.data == key ) {
			return root;
		}
		
		if(key> root.data)
			return searchKey(root.right, key);
		if(key<root.data)
			return searchKey(root.left,key);
		
		return null;
	
	}
	
	public boolean validateBST(Node root, long max,long min) {
		if(root == null)
			return true;
		if(root.data >min && root.data < max)
			return true;
		
		boolean left = validateBST(root.left,root.data,min);
		if(left) {
			boolean right = validateBST(root.right,max,root.data);
			return right;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		BSTProblems prob = new BSTProblems();
		bst.addElement(10);
		bst.addElement(5);
		bst.addElement(15);
		bst.addElement(3);
		bst.addElement(9);
		bst.addElement(13);
		bst.preOrder(bst.root);

		System.out.println();
		prob.treeLevelTraversal(bst.root);
//		System.out.println(prob.findMax(bst.root));
		if(prob.searchKey(bst.root,17)==null)
			System.out.println("Element Not found");
		else
			System.out.println("Element has been found");
	}

}
