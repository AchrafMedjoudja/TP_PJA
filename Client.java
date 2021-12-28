package tpjavaa;
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client {
private Socket socket = null;
private DataInputStream scan = null;
private DataInputStream input = null;

private DataOutputStream output = null;
@SuppressWarnings("deprecation")
public Client(String ip , int port) {
	Scanner sc = new Scanner(System.in);
	try {
		socket = new Socket(ip,port);
		System.out.println("connected");
		scan= new DataInputStream(System.in);
		output = new DataOutputStream(socket.getOutputStream());
		input= new DataInputStream(socket.getInputStream());

		
		
	} catch (UnknownHostException e) {
		System.out.println(e);
	}catch(IOException u){
		System.out.println(u);
	}
	try {
	while(true) {
	System.out.println("choose number of three to select an operation \n 1.nomRep \n 2.nomFichier \n 3.Quit");
	int oper=sc.nextInt();
	while (oper != 1 && oper !=2 && oper!=3) {
		System.out.println("enter a valid number from 1 to 3");
		oper= sc.nextInt();
	}
	 if(oper==3) {break;}
	
	output.writeInt(oper);
	switch(oper) {
	
	  case 1:
	    System.out.println("enter the name of folder");
	    String folder =scan.readLine();
	    output.writeUTF(folder);
	    break;
	  case 2:
	    System.out.println("enter the name of file");
	    String file =scan.readLine();
	    output.writeUTF(file);
	    break;
	  
	}
	String data = input.readUTF();
	System.out.println(data);
	

		}
	} catch (Exception e) {
		System.out.println(e);
		}
		
	
	try {
		input.close();
		output.close();
		socket.close();
		sc.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Client client = new Client("127.0.0.1",5000);
	}

}

