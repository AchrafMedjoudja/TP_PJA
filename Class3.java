package Dev_TP2;

import java.io.File;
import java.util.Scanner;

public class Class3 {

	public static void main(String[] args) {
		String [] tab = new String[2];
		// TODO Auto-generated method stub
		String y,u,i;
		String [] lines = new String[4];
		String beta ;
		try {
			File file = new File("src/Dev_TP2/empdirect.dat");
			Scanner sc = new Scanner(System.in);
		    Scanner scanner = new Scanner(file);
		    System.out.println("entrer le numero de employee");
		    int p = sc.nextInt();
		    int lineNum = 0;
		    while (scanner.hasNextLine()) {
		        String line = scanner.nextLine();
		        y = scanner.nextLine();
		        u = scanner.nextLine();
		        i = scanner.nextLine();
		        lineNum++;
		        if(i.contains("le nombre est")) { 
		        	
		        	
		            int num = Integer.parseInt((String)i.subSequence(14, i.length()-1));
		            if(num==p) {
			            System.out.println(line);
			            System.out.println(y);
	System.out.println(u);
	System.out.println(i);
		            }

		        }
		    }
		} catch(Exception e) { 
e.printStackTrace();
}
	}

}
