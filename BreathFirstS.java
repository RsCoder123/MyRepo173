import java.util.LinkedList;

public class BreathFirstS {
	int num;
    LinkedList<Integer> list[];
	 BreathFirstS(int num)
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
	
	 
	/* void BFS(int set)
	 {
		 boolean visited[]=new boolean[list.length];
		 LinkedList<Integer> queue=new LinkedList<>();
		 visited[set]=true;
		 queue.add(set);
		 while(!queue.isEmpty())
		 {
			 int s=queue.poll();
			 System.out.print("  "+s);
			 for(Integer val:list[s])
			 {
				 if(!visited[val])
				 {
					 visited[val]=true;
					 queue.add(val);
				 }
			 }
			 
		 }
	}
	*/
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
		int t=5;
		BreathFirstS bf=new BreathFirstS(t);
		bf.addList(0, 1);
		bf.addList(0, 2); 
        bf.addList(1, 4); 
        bf.addList(2, 0); 
        bf.addList(2, 1); 
        bf.addList(3, 2);
       // bf.BFS(2);
       bf.printList();
 
       
	}
	

}
