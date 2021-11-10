package Dev_TP2;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Class2 {

	public static void main(String[] args) {
		Employee tr;
		// TODO Auto-generated method stub
		 try {
			 RandomAccessFile file = new RandomAccessFile("src/Dev_TP2/empdirect.dat", "rw");
		        FileInputStream fis=new FileInputStream("src/Dev_TP2/emp.dat");
		        ObjectInputStream ois=new ObjectInputStream(fis);
		        Employee wo=null;
		        Employee[] woj=new Employee[2];

		        ArrayList<Employee> woi=new ArrayList<>();
		        woi=(ArrayList<Employee>)ois.readObject();

		        for(int i=0;i<woi.size();i++){
		        	
		        	tr = (Employee)woi.get(i);
		        	String msg = i+1 +" : le nom est "+ tr.name+ " \n"+"l'address est "+ tr.address+ " \n"+"le SSN est "+ tr.SSN+ " \n"
		        			+"le nombre est "+ tr.number+ " \n";
		        	file.writeBytes(msg);
		        }
	}catch(Exception e){}

}}

