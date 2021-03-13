package project;

public class removeDuplicatePractice {

	public static void main(String[] args) {
		String s = "Sjiadgkufhfsofjis";
		s= s.toLowerCase();
		String s1=s;
		for(char ch = 'a'; ch<='z'; ch++)
		{
			int count = 0;
			for(int i = 0; i<s.length() ; i++)
			{
				char c = s.charAt(i);
				if(ch == c)
				{
					count++;
				}
			}
			if(count>1)
			{
				String s2 = ch +"";
				s1 = s1.replace(s2, "");
			}
		}
			System.out.println(s1);
	}
}
