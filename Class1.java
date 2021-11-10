package Dev_TP2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
class Employee implements Serializable
{
public String name;
   public String address;
   public transient int SSN;
   public int number;
   public Employee(String name,String address,int SSN , int number) {
	   this.name = name;
	   this.address=address;
	   this.SSN = SSN;
	   this.number = number;
	   
   }
   public void mailCheck()
   {
      System.out.println("Mail de verification de " + name + " " + address);
   }
}
public class Class1{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("entrer le nombre de objet que vous ");
		int i = sc.nextInt();
		System.out.println("madame il ya un probleme avec le methode next line donc le nom et le adrees doit une seul String "
				+ "et tu peut pas utiliser espace \n");
		String name;
		String address;
		int number,SSN;
		   ArrayList<Object> al = new ArrayList<Object>();
			try
		      {
		         FileOutputStream fileOut =
		         new FileOutputStream("src/Dev_TP2/emp.dat");
		         ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         for (int j = 0; j < i; j++) {
		     		System.out.println("enter le nom ");
		     		
		     		name = sc.next();
		     		
		     		System.out.println("entrer address");
		     		
		     		address=sc.next();
		     		System.out.println("entrer SSN");
		     		SSN = sc.nextInt();
		     		sc.nextLine();
		     		System.out.println("entrer number");
		     			number = sc.nextInt();
		     			sc.nextLine();
		     			Employee e = new Employee(name,address,SSN,number);
		     			al.add(e);
				         
		     			}
		         out.writeObject(al);
		         
		         fileOut.close();
		         System.out.printf("donnees serialisees sauvegardees dans emp.dat");
		      }catch(IOException p)
		      {
		          p.printStackTrace();
		      }
		
	      
	   
	

sc.close();
	}

}
