package project;

public class DemoOccurancNonRepeated {

	public static void main(String[] args) {
		String s ="Mahabharat";
		s = s.toLowerCase();
		for(char ch= 'a'; ch<= 'z'; ch++)
		{
			int count = 0;
			for(int i =0; i<s.length();i++) 
			{
				char c = s.charAt(i);
				if(ch==0)
				{
					count++;
				}
			}
			if(count>0)
			{
				System.out.println(ch + count + "times.");
			}
		} 
	}

}
