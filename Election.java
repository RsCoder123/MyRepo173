import java.util.Scanner;

public class Election {

	public static void main(String[] args) {
		int count=0;
		char pre='\0';
		int countA=0;
		int countB=0;
		Scanner scan=new Scanner(System.in);
		int queueSize=scan.nextInt();
		String str=scan.next();
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='-')
			{
				count++;
			}
				
			if(str.charAt(i)=='A')
			{
				countA++;
				if(count>0 && pre!='B')
				{
		å			countA=count+countA;
					count=0;
				}
				else
				if(count>0 && pre=='B')
				{
					countA=count/2+countA;
					countB=count/2+countB;
				}
				pre='A';
				count=0;
			}
			if(str.charAt(i)=='B')
			{   
				countB++;
				if(pre=='B')
					countB=count+countB;
				pre='B';
				count=0;
			}
		}
		if(countA>countB)
		{
			System.out.println("A");
		}
		else
			if(countA<countB)
					System.out.println("B");
			else
				System.out.println("Coalition government");

	}

}
