/*** 
 * This is class implements a trie that holds a set of strings.
 * MyTrie stores stores nodes using class TreeNode
 * 
 * Name:   
 * Student Number: 
 * Uottawa Email: 
 * 
 *
 */

public class MyTrie {
	
	private TreeNode root = null;

	private int numNodes;

    // Constructor. Note that an empty trie (no strings added) contains the root node 
	public MyTrie() {
		root = new TreeNode(null, null, null,false); 
		numNodes=1;
	}

	// Method to be implemented by you. See handout part 1A
	public boolean insert(String s) {
		boolean inserted = false;
 		TreeNode current = root;
 		for (int i = 0 ; i < s.length() ; i++) {
        	if (s.charAt(i) == '0') {
        		if (i != (s.length() - 1)) {
	        		if (current.getLeftChild() == null) {
	        			current.setLeftChild(new TreeNode(current, null, null, false));
	        			numNodes++;
	        		}
	        		current = current.getLeftChild();
        		} else {
        			if (current.getLeftChild() != null) {
        				if (current.getLeftChild().getIsUsed() == false) {
        					current.getLeftChild().setIsUsed(true);
        					inserted = true;
        				}
        				else {
        					inserted = false;
        				}
        			} else {
        				current.setLeftChild(new TreeNode(current, null, null, true));
        				inserted = true;
        				numNodes++;
        			}
        		}	
        	}
        	else if (s.charAt(i) == '1') {
        		if (i != (s.length() - 1)) {
	        		if (current.getRightChild() == null) {
	        			current.setRightChild(new TreeNode(current, null, null, false));
	        			numNodes++;
	        		}
	        		current = current.getRightChild();
        		} else {
        			if (current.getRightChild() != null) {
        				if (!current.getRightChild().getIsUsed()) {
        					current.getRightChild().setIsUsed(true);
        					inserted = true;
        				}
        				else {
        					inserted = false;
        				}
        			} else {
        				current.setRightChild(new TreeNode(current, null, null, true));
        				inserted = true;
        				numNodes++;
        			}
        		}
        	}
    	}
    	current = root;
    	return inserted;
	}
	
	// Method to be implemented by you. See handout part 1A
	public boolean search(String s) {
		boolean found = false;
		TreeNode current = root;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				if (i < (s.length() - 1)) {
					current = current.getLeftChild();
				} else {
					if (current.getLeftChild() != null) { 
						if (current.getLeftChild().getIsUsed()) {
							found = true; 
						} else { found = false; }
					}
					else { found = false; }
				}
			} else if (s.charAt(i) == '1') {
				if (i < (s.length() - 1)) {
					current = current.getRightChild();
				} else {
					if (current.getRightChild() != null) { 
						if (current.getRightChild().getIsUsed()) {
							found = true; 
						} else { found = false; }
					}
					else { found = false; }
				}
			}
		}
		current = root;
		return found;
	}

	

	// Method to be implemented by you. See handout part 1A	
	public void printStringsInLexicoOrder() {
		TreeNode current = root;
		String path = "";
		String subpath = "";

		while (current.getLeftChild() != null) {
			current = current.getLeftChild();
			subpath = subpath + "0";
			if (current.getIsUsed()) {
				path = path + subpath + ",";
			}
		}
		while (current.getRightChild() != null) {
			current = current.getRightChild();
			subpath = subpath + "1";
			if (current.getIsUsed()) {
				path = path + subpath + ",";
			}
		}

		while (current.getParent() != null) {
			if (current.getParent().getLeftChild() == current) {
				current = current.getParent();
				subpath = subpath.substring(0, subpath.length() - 1);
				while (current.getRightChild() != null) {
					current = current.getRightChild();
					subpath = subpath + "1";
					if (current.getIsUsed()) {
						path = path + subpath + ",";
					}
					while (current.getLeftChild() != null) {
						current = current.getLeftChild();
						subpath = subpath + "0";
						if (current.getIsUsed()) {
							path = path + subpath + ",";
						}
 					}
				}
			} else {
				current = current.getParent();
				subpath = subpath.substring(0, subpath.length() - 1);
			}
		}
		System.out.println(path);
	}
	
	
	
	// the following method that calls its recursive counterpart
	// prints the tree and its boolean values at nodes in 
	// in-order traversal order
	
	public void printInOrder() { // not to be changed
		printInOrder(root);
	}
	private void printInOrder(TreeNode N) { // not to be changed
		System.out.print("(");
		if (N!=null) {
			printInOrder(N.getLeftChild());
			System.out.print(N.getIsUsed());
			printInOrder(N.getRightChild());

		}
		System.out.print(")");
	}
	

	
	public TreeNode root() { // not to be changed
		return root;
	}
	
	public int numNodes() { // not to be changed
		return numNodes;
	}


}
