import java.util.LinkedList;
import java.util.Random;

public class ZipTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 400000;//start with important values
		Random rand = new Random();
		LinkedList<Integer> dataList = new LinkedList<Integer>();
		ZipTree dataZip = new ZipTree();//create tree
		
		System.out.println("All data unsorted:");
		for(int i=0; i<size;i++) {//loop to generate data
			int d = rand.nextInt(size);//generates size*size values to add the data
			dataList.add(d);//adds to list for tree
			System.out.println(d);//prints unsorted data
		}
		System.out.println();
		long  t1 = System.currentTimeMillis();
		for(int i = 0; i<size; i++) {//fills tree
			 dataZip.insert(dataList.get(i));
		}
		LinkedList<Integer> dataInorder = dataZip.traverse("inorder", dataZip.getRoot());//BST Sort
		long  t2 = System.currentTimeMillis();
		LinkedList<Integer> dataRank = dataZip.travRank("inorder", dataZip.getRoot());
		System.out.println("Tree traversed inorder:");
		for(int i = 0; i<dataInorder.size();i++) {
			System.out.println("Data: "+dataInorder.get(i)+", rank:" +dataRank.get(i));//prints sorted data
		}
		long time = (t2-t1)/1000;
		System.out.println("Time: "+ time + "seconds");
		
	}

}
