package tpjavaa;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ThreadTask extends Thread{
	public Socket client = null;
	public  DataInputStream input = null;
	private DataOutputStream output = null;
	public ThreadTask(Socket client) {
		this.client = client;
		try {
			input = new DataInputStream(client.getInputStream());
			output = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		
	}
	@Override
	public void run() {
		try {
			while(true) {
				System.out.println("this is thread task");
				int num = input.readInt();
				 String data = "";
				String oper= input.readUTF();	
				if(num==3) {break;}
				switch(num) {
				  case 1:
					 
				    String[]va = ThreadedServer.nomRep(oper);
				    if(va[0]=="0") {
				    	data = va[1];
				    }else {
				    	
				    	for (int i = 0; i < va.length; i++) {
							data+=va[i]+"\n";
						}
				    	
				    }
				    
				  output.writeUTF(data);
				    break;
				  case 2:
					  String fileco = ThreadedServer.nomFichier(oper);
					  output.writeUTF(fileco);
				    break;
				
				}	
				
			}
			
			
			

		} catch (IOException e) {
			e.printStackTrace();

		}
		try {
			input.close();
			output.close();
		} catch (Exception e) {
			e.printStackTrace();

			// TODO: handle exception
		}
	}

}
