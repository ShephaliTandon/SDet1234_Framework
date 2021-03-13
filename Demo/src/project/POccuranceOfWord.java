package project;

public class POccuranceOfWord {

	public static void main(String[] args) {
		String s = "shephali";
		s=s.toLowerCase();
		for(char ch = 'a'; ch<='z' ; ch++)
		{
		int count = 0;
		for(int i=0 ; i<s.length(); i++)
		{	
			char ch1 = s.charAt(i);
			if(ch == ch1 )
			{
				count++;
			}
			}
			if(count>0)
			{
				System.out.println(ch+" times " + count);
			}
		}

	}

}
