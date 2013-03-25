import java.io.IOException;
import java.util.ArrayList;
public class Substitution {
	private char[] ciphertext;
	private int[] inttext;
	private int spaceSize;

	public Substitution(char[] ciphertext, int size){
		this.setCiphertext(ciphertext);
//		this.makeIntText();
		this.setSpaceSize(size);
	}

	public void crack() throws IOException{
		decrypt(3);
		//System.in.read();
	}

	private void decrypt(int nGramSize){
		ArrayList<NGram> counts = findNGrams(nGramSize);
		//counts;
		
	}
	
	private ArrayList<NGram> findNGrams(int n){
		ArrayList<NGram> counts = new ArrayList<NGram>(0);
		System.out.println("count size " + counts.size());
		
		for(int i = 0; i<this.getCiphertext().length-(n-1); i++){
			String s = ""+(this.getCiphertext()[i]);
			for (int j=1; j<n; j++){
				s = s+this.getCiphertext()[i+j];
			}
			boolean foundMatch=false;
			for (int k=0; k<counts.size(); k++){
				if (s.equals(counts.get(k).getS())){
					counts.get(k).setCount(counts.get(k).getCount()+1);
					foundMatch=true;
					break;
				}
			}
			if (!foundMatch){
				counts.add(new NGram(s));
			}
		}
		counts.trimToSize();
		return counts;
	}
	
//	private void makeIntText(){
//		int[] i = new int[this.getSpaceSize()];
//		for (int j=0; j<this.getCiphertext().length; j++){
//			i[j]= (int)this.getCiphertext()[j];
//		}
//		setInttext(i);
//	}

	public char[] getCiphertext() {
		return ciphertext;
	}

	public void setCiphertext(char[] ciphertext) {
		this.ciphertext = ciphertext;
	}
	
	public int[] getInttext() {
		return inttext;
	}

	public void setInttext(int[] inttext) {
		this.inttext = inttext;
	}

	public int getSpaceSize() {
		return spaceSize;
	}

	public void setSpaceSize(int spaceSize) {
		this.spaceSize = spaceSize;
	}

	

}
