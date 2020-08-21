import java.util.Iterator;
import java.util.LinkedList;

public class AllPosibleWays {
	int v;
	LinkedList<Integer> adj[];
	AllPosibleWays(int V)
	{
		v=V;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adj[i]=new LinkedList();
		}
	}
	public void addEdge(int u,int v)
	{
		adj[u].add(v);
	}
	void printAllPosibleWay(int a,int b)
	{
		int visited=0;
		int result=returnAllPosiblePath(a,b,visited);
		System.out.println(result);
	}
	int returnAllPosiblePath(int a,int b,int visited)
	{
		if(a==b)
			visited++;
		else
		{
			Iterator<Integer> it=adj[a].listIterator();
			while(it.hasNext())
			{
				int n=it.next();
				visited= returnAllPosiblePath(n,b,visited);
			}
		}
		return visited;
	}
	
	public static void main(String args[])
	{
		AllPosibleWays g=new AllPosibleWays(7);
		g.addEdge(0, 1); 
        g.addEdge(0, 4); 
        g.addEdge(0, 3); 
        g.addEdge(0, 5);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 3); 
        g.addEdge(4, 3);
        g.addEdge(4, 6);
        g.addEdge(5, 6);
        g.addEdge(6, 3);
        g.printAllPosibleWay(0,3);
       
	}

}
