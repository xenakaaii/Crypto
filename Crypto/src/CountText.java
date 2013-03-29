import java.io.*;
import java.util.Scanner;

public class CountText {

	public static void main (String args[]) throws IOException{
		//Error checking
		if (args.length != 1) {
			System.err.println("Feed me.");
			System.exit(1);
		}
		File file = new File(args[0]);
		if (!file.exists()) {
			System.out.println(args[0] + " does not exist.");
			return;
		}
		if (!(file.isFile() && file.canRead())) {
			System.out.println(file.getName() + " cannot be read from.");
			return;
		}
		
		//Declare variables
		int spaceSize=255;
		int messageLength=0;
		int[] abCounts = new int[spaceSize*spaceSize];
		
		FileWriter fstream = new FileWriter("out.txt");
		BufferedWriter out = new BufferedWriter(fstream);
		Scanner keyboard = new Scanner(System.in);
		
		//Initialize count array to 0
		for (int i=0; i<abCounts.length; i++){
			abCounts[i]=0;
		}
		
		//Read file and count ngrams
		try {
			FileInputStream fis = new FileInputStream(file);
			char current;
			char second;
//			char third;
//			char fourth;
			current = (char) fis.read();
			while (fis.available() > 0) {
				//TODO: Change to second/third/fourth as needed
				second = (char) fis.read();
//				keyboard.next();
				abCounts[((int)current*spaceSize)+(int)second]+=1;
				current=second;
//				second=third;
//				third=fourth;
				messageLength++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Check message stats in terminal output
		System.out.println("messageLength:"+messageLength);
		System.out.println("abCounts.length:"+abCounts.length);
		int sum=0;
		//Print counts to file
		for (int i=0; i<abCounts.length; i++){
//			if (abCounts[i]!=0){
//				System.out.println(i);
				int temp=i/spaceSize;
//				System.out.print((char)(temp));
//				System.out.print((char)(i%spaceSize)+":");
//				System.out.println(abCounts[i]);
				sum+=abCounts[i];
				out.write(abCounts[i]+"\n");
//				out.write(((char)(i/spaceSize)) +"" +((char)(i%spaceSize))+ "\t"+abCounts[i]+"\n");
//			}
		}
		System.out.println("sum:"+sum);
		out.close();
	}


}
