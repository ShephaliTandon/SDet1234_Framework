package project;

public class DemoPrimeNumber {
	
	private int x= 10;
	private static int y = 20;
	public static void main(String[] args) {
		
		//private int z =30;
		System.out.println( y);
	}
	public int getx()
	{
		return x;
		//System.out.println();
	}
	public int gety()
	{
		return y;
	}
	public void setx(int x)
	{
		this.x=x;
	}
	public void sety(int y)
	{
		this.y = y;
	}
	}
class TestECap
{
	public static void main(String[] args) {
		DemoPrimeNumber ev = new DemoPrimeNumber();
		int x =  ev.getx();
		System.out.println(x);
		ev.setx(25);
		System.out.println(ev.getx());
	}}
