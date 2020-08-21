import java.util.ArrayList;
import java.util.PriorityQueue;

public class Rahul {

	public static void main(String[] args) {
		int nums[]=new int[] {100,4,200,1,3,2};
		  PriorityQueue<Integer> pq=new PriorityQueue<>();
	        ArrayList<Integer> al=new ArrayList<>();
	        for(int i=0;i<nums.length;i++)
	        {
	            if(!pq.contains(nums[i]))
	            pq.add(nums[i]);
	        }
	        System.out.println(pq);
	        int count=0;
	        int compar=0;
	        if(!pq.isEmpty())
	        {
	        compar=pq.poll();
	        count=1;
	        }
	        while(!pq.isEmpty())
	        {
	            int in=pq.poll();
	            if(compar+1==in)
	            {
	               count++;
	            }
	                else
	                {
	                     al.add(count);
	                    count=1;
	                }
	            compar=in;
	        }
	        al.add(count);
	        System.out.println(al);
	        if(al.isEmpty())
	            return;
	        int max=al.get(0);
	        System.out.println(max);
	          for(int i=1;i<al.size();i++)
	        {
	            if(max<al.get(i))
	            {
	            max=al.get(i);
	            }
	        }
      System.out.println(max);
    }
	}
