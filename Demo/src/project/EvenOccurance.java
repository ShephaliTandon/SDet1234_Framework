package project;

public class EvenOccurance {

	public static void main(String[] args) {
	 String s = "shephali";
	 s= s.toLowerCase();
	 String evens =" ";
	 for(int i = 0; i<s.length(); i +=2)
	 {
		 String ch = s.charAt(i) + "";
		 if(!evens.contains(ch))
		 {
			 evens = evens + ch;
		 }
	 }
	 System.out.println(evens);
	 
	 for(int i = 0; i<evens.length();i++)
	 {
		 char ch1 = evens.charAt(i);
		 int count = 0;
		 for(int j = 0; j<s.length(); j++)
		 {
			 char ch2 = s.charAt(j);
			 if(ch1== ch2)
				{
					count++;
				}
				}
				 if(count>0) {
					 System.out.println(ch1 + "  " + count);
				 }
	 	}
	 }
}

