import java.util.LinkedList;

public class MotherVertices {
	private int Num;
    LinkedList<Integer> list[];
	 MotherVertices(int num)
	 {
		 Num = num;
		 list=new LinkedList[Num];
		 for(int i=0;i<num;i++)
		 {
			 list[i]=new LinkedList();
		 }	 
	 }
	
	 public void addEdge(int u,int v)
	 {
		 list[u].add(v);
	 }
	 void findMotherVertices(int ver)
	 {  
		 int count=0;
		 boolean visited[]=new boolean[Num];
		 LinkedList<Integer> queue=new LinkedList<>();
		 visited[ver]=true;
		 queue.add(ver);
		 while(!queue.isEmpty())
		 {
			 int s=queue.poll();
			 count++;
			 for(Integer in:list[s])
			 {
				 if(!visited[in])
				 {
					 visited[in]=true;
					 queue.add(in);
				 }
			 }
		 }
		 if(count==Num)
		 {
			 System.out.println(ver);
		 }
	 }
	void motherVertices(int n)
	{
	for(int i=0;i<n;i++)
	{
		findMotherVertices(i);
	}
	}
	
public static void main(String args[])
{
	MotherVertices g=new MotherVertices(7);
	g.addEdge(0, 1); 
    g.addEdge(0, 2); 
    g.addEdge(1, 3); 
    g.addEdge(4, 1); 
    g.addEdge(6, 4); 
    g.addEdge(5, 6); 
    g.addEdge(5, 2); 
    g.addEdge(6, 0); 
    g.motherVertices(7);
}
}
