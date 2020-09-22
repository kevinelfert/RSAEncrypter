import java.math.BigInteger;
public class RSA
{
	private BigInteger n;
	private BigInteger e;
	private BigInteger d;

	public RSA(String p, String q)
	{
		BigInteger pBI = new BigInteger(p);
		BigInteger qBI = new BigInteger(q);
		this.n = (qBI.multiply(pBI));
		this.e = generateE(pBI, qBI);
		this.d = generateD(this.e, totient(pBI, qBI));
	}

	public RSA(String p, String q, String e)
	{
		BigInteger pBI = new BigInteger(p);
		BigInteger qBI = new BigInteger(q);
		this.e = new BigInteger(e);
		this.n = (qBI.multiply(pBI));
		this.d = generateD(this.e, totient(pBI, qBI));
	}

	public BigInteger totient(BigInteger p, BigInteger q)
	{
		p = p.subtract(BigInteger.ONE);
		q = q.subtract(BigInteger.ONE);
		BigInteger totient = p.multiply(q);
		return totient;
	}

	public BigInteger generateE(BigInteger p, BigInteger q)
	{
		BigInteger eNotPrime = (p.multiply(q).subtract(p.add(q).add(p.add(q))));
		this.e = eNotPrime.nextProbablePrime();
		return this.e;
	}

	public BigInteger generateD(BigInteger e, BigInteger totient)
	{
		BigInteger d = e.modInverse(totient);
		return d;
	}

	public String encrypt(String message)
	{
		char[] messageChar = message.toCharArray();
		String returnString = "";
		for (int i=0;i<messageChar.length;i++) 
		{
			int c = (int) messageChar[i];
			BigInteger cBI = BigInteger.valueOf(c);
			cBI = cBI.modPow(this.e,this.n);
			int cInt = cBI.intValue();
			char cChar = (char) cInt;
			returnString += cChar;
		}
		return returnString;
	}

	public String decrypt(String message)
	{
		char[] messageChar = message.toCharArray();
		String returnString = "";
		for (int i=0;i<messageChar.length;i++) 
		{
			int c = (int) messageChar[i];
			BigInteger cBI = BigInteger.valueOf(c);
			cBI = cBI.modPow(this.d,this.n);
			int cInt = cBI.intValue();
			char cChar = (char) cInt;
			returnString += cChar;
		}
		return returnString;
	}

}