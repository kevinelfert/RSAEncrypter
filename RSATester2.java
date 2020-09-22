public class RSATester2
{
	public static void main(String[] args)
	{
		
		test("19","79","Hello World");
		test("337","131","This is a secret message");
		test("97","31","Testing, testing, 1, 2, 3, testing");
	}

	public static void test(String p, String q, String message)
	{
		System.out.println("______________________________");
		System.out.println("Before Encryption: " + message); 
		RSA rsa = new RSA(p,q);
		message = rsa.encrypt(message);
		System.out.println("After Encryption: " + message);
		message = rsa.decrypt(message);
		System.out.println("After Decryption: "+ message);
		System.out.println("______________________________");
	}
	
}