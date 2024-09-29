import java.util.LinkedList;
import java.util.Random;
public class ZipTree {
private ZipNode root;//start Tree
	
	ZipTree(){
		root = null;//make sure root is null before insertion
	}
	private int rankmax= 4;//max rank of values
	public ZipNode getRoot() {
		return root;
	}
	public void insert(int x) {
		ZipNode z = new ZipNode(x);
		Random r = new Random();
		int rank = r.nextInt(rankmax);
		z.setRank(rank);  
		ZipNode ptr = root;
		ZipNode last = null;
		ZipNode tmp = null;
		while(ptr != null&&(rank<ptr.getRank()|| (rank == ptr.getRank()&& x> ptr.getData()))) {
			last = ptr;
			if(x<ptr.getData()) {
				ptr = ptr.getLeft();
			}
			else {
				ptr = ptr.getRight();
			}
		}
		if(ptr==root) {
			root = z;
		}
		else if (x<last.getData()) {
			last.setLeft(z);
		}
		else {
			last.setRight(z);
		}
		if(ptr==null) {
			z.setLeft(null);
			z.setRight(null);
			return;
		}
		if(x<ptr.getData()) {
			z.setRight(ptr);
		}
		else {
			z.setLeft(ptr);
		}
		last = z;
		while(ptr != null) {
			tmp = last;
			if(ptr.getData()<x) {
				while(ptr != null&& ptr.getData()<= x) {
					last = ptr;
					ptr = ptr.getRight();
				}
			}
			else {
				while(ptr != null && ptr.getData()>= x) {
					last = ptr;
					ptr = ptr.getLeft();
					
				}
			}
			if(tmp.getData()>x||(tmp==z && last.getData()> x)) {
				tmp.setLeft(ptr);
			}
			else {
				tmp.setRight(ptr);
			}
		}
		
	}
	public ZipNode zip(ZipNode x, ZipNode y) {
		if(y==null) {
			return x;
		}
		else if(x== null) {
			return y;
		}
		else if(x.getRank()<y.getRank()) {
			y.setLeft(zip(x,y.getLeft()));
			return y;
		}
		else {
			x.setRight(zip(x.getRight(), y));
			return x;
		}
	}
	
	public void delete(ZipNode x) {
		ZipNode ptr = root;
		ZipNode last = null;
		while(x.getData() != ptr.getData()) {
			last = ptr;
			if(x.getData()<ptr.getData()) {
				ptr = ptr.getLeft();
			}
			else {
				ptr = ptr.getRight();
			}
		}
		ptr = zip(ptr.getLeft(), ptr.getRight());
		
		if(root.getData()==x.getData()) {
			root = ptr;
			}
		else if(x.getData()<last.getData()) {
			last.setLeft(ptr);
			}
			else {
				last.setRight(ptr);
			}
			
	}
	public LinkedList<Integer> traverse(String mode, ZipNode node) {
		LinkedList<Integer> result= new LinkedList<Integer>();
		while(node != null) {
			if(mode == "inorder") {
						LinkedList<Integer> leftList =traverse("inorder", node.getLeft());//recursively visits left
						for(int i= 0; i<=leftList.size()-1; i++) {
						result.add(leftList.get(i));//adds left node and its children to result
						}
					result.add(node.getData());//adds current node to list
					if(node.getRight() != null) {
						LinkedList<Integer> rightList = traverse("inorder", node.getRight());//recursively visits right
						for(int i =0; i<=rightList.size()-1; i++) {
								result.add(rightList.get(i));//adds right node and its children to result
						}
					}
					node = null;
				}
		}
		return result;
	}
	public LinkedList<Integer> travRank(String mode, ZipNode node) {//traversal but retrieves rank
		LinkedList<Integer> result= new LinkedList<Integer>();
		while(node != null) {
			if(mode == "inorder") {
						LinkedList<Integer> leftList =travRank("inorder", node.getLeft());//recursively visits left
						for(int i= 0; i<=leftList.size()-1; i++) {
						result.add(leftList.get(i));//adds left node and its children to result
						}
					result.add(node.getRank());//adds current node to list
					if(node.getRight() != null) {
						LinkedList<Integer> rightList = travRank("inorder", node.getRight());//recursively visits right
						for(int i =0; i<=rightList.size()-1; i++) {
								result.add(rightList.get(i));//adds right node and its children to result
						}
					}
					node = null;
				}
		}
		return result;
	}
	

}
