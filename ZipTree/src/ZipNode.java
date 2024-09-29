
public class ZipNode {
	private int rank;//random rank
	private int data;//info stored
	private ZipNode left;//left subtree
	private ZipNode right;//right subtree
	
	public ZipNode (int d) {//Constructor
		data = d;
		left = null;
		right = null;
	}
	public ZipNode(int d, ZipNode leftNode, ZipNode rightNode) {//Constructor
		data = d;
		left= leftNode;
		right = rightNode;
	}
	public int getRank() {//extracts rank
		return rank;
	}
	
	public int getData() {//extracts value of node
		return data;
	}
	public ZipNode getLeft() {//extracts left subtree
		return left;
	}
	public ZipNode getRight() {//extracts right subtree
		return right;
	}
	public void setRank(int newR){
		rank = newR;
	}
	public void setData(int newD) {//modifies data
		data = newD;
	}
	public void setLeft(ZipNode newLeft) {//modifies left subtree
		left = newLeft;
	}
	public void setRight(ZipNode newRight) {//modifies right subtree
		right = newRight;
	}

}
