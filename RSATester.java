public class RSATester
{
	public static void main(String[] args)
	{
		RSA rsa = new RSA("19", "79", "17");
		String message = "Hello World";
		message = rsa.encrypt(message);
		System.out.println(message);
		message = rsa.decrypt(message);
		System.out.println(message);
	}
	
}

