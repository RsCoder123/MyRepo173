import java.util.Arrays;

public class StrinfPermutionRe {

	public static void main(String[] args) {
		int arr[]=new int[] {1,2,3,3};
		permutationString(arr,0,3);

	}
	static void permutationString(int s[],int l,int r)
	{
		if(l==r)
		{
			System.out.println(Arrays.toString(s));
			int count=0;
			for(int i=0;i<s.length-1;i++)
			{
				if((s[i]+s[i+1])%3==0)
				{
					count++;
				}
				
			}
			if(count==0)
			
		}
		for(int i=l;i<=r;i++)
		{
			interchangeString(s,l,i);
			permutationString(s,l+1,r);
			interchangeString(s,l,i);
		}
	}
	static int[] interchangeString(int s[],int a,int b)
	{
		int temp=s[a];
		     s[a]=s[b];
		     s[b]=temp;
		return s;
	}

}
