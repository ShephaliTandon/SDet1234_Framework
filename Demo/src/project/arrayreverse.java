package project;

public class arrayreverse{
	public static void main(String[] args) {
		
		//rev array
		/*int [] arr = {78,28,28,28,36,78,45,26,2,1,0};
		int [] revarr = new int [ arr.length];
		int count = 0;
		for(int i = arr.length -1 ; i>=0; i--)
		{
			revarr[count++] = arr[i];
		}
		for(int i : revarr)
		{
			System.out.print(i + " ");
		}
		*/
		
		int [] arr = {10,20,30,10,30,20,25,45,85,85};
		for(int i = 0; i<arr.length; i++)
		{
			int num1 = arr[i];
			int count = 0;
			for(int j = 0; j<arr.length;j++)
			{
				int num2 = arr[j];
				if(num1 ==num2 && i>j)
				{
					break;
				}
				if(num1==num2) {
					count++;
				}
			}
			if(count>0) {
				System.out.println(num1 + "  " + count);
			}
		}
		
	}
	
}
