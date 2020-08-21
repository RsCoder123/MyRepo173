import java.util.LinkedList;
import java.util.Scanner;

public class BinaryLocation {

	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		 LinkedList<Integer>[] vertex = new LinkedList[5];
		 int i = 0, m = 6;
		 while(i!=m){
		   int temp = sc.nextInt();
		   int temp2 = sc.nextInt();
		   if (vertex[temp] == null) {
		      vertex[temp] = new LinkedList<Integer>();
		   }

		   vertex[temp].add(temp2);
		   i++;
		 }
		for(int j=0;j<vertex.length;j++)
		{
			System.out.println(vertex[j]);
		}
	}
}
