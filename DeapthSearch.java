import java.util.Iterator;
import java.util.LinkedList;

public class DeapthSearch {
	int num;
	LinkedList<Integer> list[];
	 DeapthSearch(int num)
	 {
		 int Num = num;
		 list=new LinkedList[Num];
		 for(int i=0;i<num;i++)
		 {
			 list[i]=new LinkedList();
		 }	 
	 }

	 public void addList(int u,int v)
	 {
		 list[u].add(v);
	 }
	 void DFSUtil(int v,boolean visited[]) 
	    { 
	        // Mark the current node as visited and print it 
	        visited[v] = true; 
	        System.out.print(v+" "); 
	  
	        // Recur for all the vertices adjacent to this vertex 
	        Iterator<Integer> i = list[v].listIterator(); 
	        while (i.hasNext()) 
	        { 
	            int n = i.next(); 
	            if (!visited[n]) 
	                DFSUtil(n, visited); 
	        } 
	    } 
	 void DFS(int v)
	 {
		 boolean visited[]=new boolean[list.length];
		 DFSUtil(v,visited);
	 }
	 void printList()
	 {
		 for(int i=0;i<list.length;i++)
		 {
			System.out.println("for the node    "+i);
			{
				for(int j=0;j<list[i].size();j++)
				{
					System.out.print("-->"+list[i].get(j));
				}
				System.out.println();
			}
		 }
	 }
	
	
public static void main(String args[])
{
	int t=4;
	DeapthSearch bf=new DeapthSearch(t);
	bf.addList(0, 1);
	bf.addList(0, 2); 
    bf.addList(1, 2); 
    bf.addList(2, 0); 
    bf.addList(2, 3); 
    bf.addList(3, 3);
   bf.DFS(2);
   bf.printList();
}

	
}
