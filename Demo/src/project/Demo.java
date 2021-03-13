package project;

public class Demo {

public static void main(String[] args) {
	int [] arr = {25,4,8,9,3,5};
	for(int i = 0; i<arr.length;i++)
	{
		for(int j =i+1; j<arr.length; j++)
		{
			if(arr[i] <arr[j])
			{
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
	for(int i : arr)
	{
		System.out.println(i + "  ");
	}
}
	}
