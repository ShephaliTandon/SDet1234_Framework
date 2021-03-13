package project;

public class vowels {

	public static void main(String[] args) {
		String s = "shephali";
		s=s.toLowerCase();
		String vowel="aeiou";
		for(int i =0; i<vowel.length();i++)
		{
			char ch = vowel.charAt(i);
			int count = 0;
			for(int j = 0; j<s.length();j++) {
				char ch2 = s.charAt(j);
				if(ch == ch2)
				{
					count++;
				}
			}
			if(count>0)
			{
				
				System.out.println(ch + "  "+ count);
			}
		}
	}

}
