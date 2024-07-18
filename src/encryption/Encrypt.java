package encryption;

import java.util.Random;
import java.util.Vector;

public class Encrypt {
	
	private Vector<String> plaintext = new Vector<>();
	private Vector<Vector<String>> ciphertext = new Vector<>();

	public Encrypt() {
		plaintext.add("A");
		Vector<String> aencrypt = new Vector<>();
		aencrypt.add("GCU");
		aencrypt.add("GCC");
		aencrypt.add("GCA");
		aencrypt.add("GCG");
		ciphertext.add(aencrypt);
		
		plaintext.add("B");
		Vector<String> bencrypt = new Vector<>();
		bencrypt.add("000");
		ciphertext.add(bencrypt);
		
		plaintext.add("C");
		Vector<String> cencrypt = new Vector<>();
		cencrypt.add("UGU");
		cencrypt.add("UGC");
		ciphertext.add(cencrypt);
		
		plaintext.add("D");
		Vector<String> dencrypt = new Vector<>();
		dencrypt.add("GAU");
		dencrypt.add("GAC");
		ciphertext.add(dencrypt);
		
		plaintext.add("E");
		Vector<String> eencrypt = new Vector<>();
		eencrypt.add("GAA");
		eencrypt.add("GAG");
		ciphertext.add(eencrypt);
		
		plaintext.add("F");
		Vector<String> fencrypt = new Vector<>();
		fencrypt.add("UUU");
		fencrypt.add("UUC");
		ciphertext.add(fencrypt);
		
		plaintext.add("G");
		Vector<String> gencrypt = new Vector<>();
		gencrypt.add("GGU");
		gencrypt.add("GGC");
		gencrypt.add("GGG");
		gencrypt.add("GGA");
		ciphertext.add(gencrypt);
		
		plaintext.add("H");
		Vector<String> hencrypt = new Vector<>();
		hencrypt.add("CAC");
		hencrypt.add("CAU");
		ciphertext.add(hencrypt);
		
		plaintext.add("I");
		Vector<String> iencrypt = new Vector<>();
		iencrypt.add("AUA");
		iencrypt.add("AUU");
		iencrypt.add("AUC");
		ciphertext.add(iencrypt);
		
		plaintext.add("J");
		Vector<String> jencrypt = new Vector<>();
		jencrypt.add("200");
		ciphertext.add(jencrypt);
		
		plaintext.add("K");
		Vector<String> kencrypt = new Vector<>();
		kencrypt.add("AAA");
		kencrypt.add("AAG");
		ciphertext.add(kencrypt);
		
		plaintext.add("L");
		Vector<String> lencrypt = new Vector<>();
		lencrypt.add("UUA");
		lencrypt.add("UUG");
		lencrypt.add("CUU");
		lencrypt.add("CUG");
		lencrypt.add("CUA");
		lencrypt.add("CUC");
		ciphertext.add(lencrypt);
		
		plaintext.add("M");
		Vector<String> mencrypt = new Vector<>();
		mencrypt.add("AUG");
		ciphertext.add(mencrypt);
		
		plaintext.add("N");
		Vector<String> nencrypt = new Vector<>();
		nencrypt.add("AAC");
		nencrypt.add("AAU");
		ciphertext.add(nencrypt);
		
		plaintext.add("O");
		Vector<String> oencrypt = new Vector<>();
		oencrypt.add("133");
		ciphertext.add(oencrypt);
		
		plaintext.add("P");
		Vector<String> pencrypt = new Vector<>();
		pencrypt.add("CCU");
		pencrypt.add("CCC");
		pencrypt.add("CCA");
		pencrypt.add("CCG");
		ciphertext.add(pencrypt);
		
		plaintext.add("Q");
		Vector<String> qencrypt = new Vector<>();
		qencrypt.add("CAG");
		qencrypt.add("CAA");
		ciphertext.add(qencrypt);
		
		plaintext.add("R");
		Vector<String> rencrypt = new Vector<>();
		rencrypt.add("CGC");
		rencrypt.add("CGA");
		rencrypt.add("CGU");
		rencrypt.add("CGG");
		ciphertext.add(rencrypt);
		
		plaintext.add("S");
		Vector<String> sencrypt = new Vector<>();
		sencrypt.add("UCU");
		sencrypt.add("UCG");
		sencrypt.add("UCA");
		sencrypt.add("UCC");
		sencrypt.add("AGC");
		sencrypt.add("AGU");
		ciphertext.add(sencrypt);
		
		plaintext.add("T");
		Vector<String> tencrypt = new Vector<>();
		tencrypt.add("ACG");
		tencrypt.add("ACA");
		tencrypt.add("ACU");
		tencrypt.add("ACC");
		ciphertext.add(tencrypt);
		
		plaintext.add("U");
		Vector<String> uencrypt = new Vector<>();
		uencrypt.add("380");
		ciphertext.add(uencrypt);
		
		plaintext.add("V");
		Vector<String> vencrypt = new Vector<>();
		vencrypt.add("GUG");
		vencrypt.add("GUU");
		vencrypt.add("GUA");
		vencrypt.add("GUC");
		ciphertext.add(vencrypt);
		
		plaintext.add("W");
		Vector<String> wencrypt = new Vector<>();
		wencrypt.add("UGG");
		ciphertext.add(wencrypt);
		
		plaintext.add("X");
		Vector<String> xencrypt = new Vector<>();
		xencrypt.add("009");
		ciphertext.add(xencrypt);
		
		plaintext.add("Y");
		Vector<String> yencrypt = new Vector<>();
		yencrypt.add("UAU");
		yencrypt.add("UAC");
		ciphertext.add(yencrypt);
		
		plaintext.add("Z");
		Vector<String> zencrypt = new Vector<>();
		zencrypt.add("080");
		ciphertext.add(zencrypt);
		
	}
	
	protected String enkripsi(String plaintext) {
		StringBuilder encrypted = new StringBuilder();
		Random rand = new Random();
		for (char c : plaintext.toCharArray()) {
			encrypted.append(encryption(String.valueOf(c), rand));
		}
		return encrypted.toString();
	}
	
	protected String dekripsi(String encrypted) {
		StringBuilder decrypted = new StringBuilder();
		for(int i = 0; i < encrypted.length(); i+=3) {
			String substring = encrypted.substring(i, i+3);
			decrypted.append(decryption(substring));
		}
		return decrypted.toString();
	}
	
	public String encryption(String c, Random rand) {
		for(int i = 0;i<plaintext.size();i++) {
			if(plaintext.get(i).equals(c)) {
				Vector<String> options = ciphertext.get(i);
				return options.get(rand.nextInt(options.size()));
			}
		}
		return "";
	}
	
	public String decryption(String str) {
		for(int i = 0;i<ciphertext.size();i++) {
			Vector<String> options = ciphertext.get(i);
			if(options.contains(str)) {
				return plaintext.get(i);
			}
		}
		return "";
	}

	public Vector<String> getPlaintext() {
		return plaintext;
	}

	public void setPlaintext(Vector<String> plaintext) {
		this.plaintext = plaintext;
	}

	public Vector<Vector<String>> getCiphertext() {
		return ciphertext;
	}

	public void setCiphertext(Vector<Vector<String>> ciphertext) {
		this.ciphertext = ciphertext;
	}

	public Encrypt(Vector<String> plaintext, Vector<Vector<String>> ciphertext) {
		super();
		this.plaintext = plaintext;
		this.ciphertext = ciphertext;
	}

	

	
}
