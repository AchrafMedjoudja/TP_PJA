
package tpjavaa;
import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Server {
public Socket socket = null;
public ServerSocket server = null;
public DataInputStream input = null;
private DataOutputStream output = null;
public Server(int port) {
	try {
		server = new ServerSocket(port);
		System.out.println("server started");
		System.out.println("waiting for client");
		
		socket = server.accept();
		System.out.println("Server Listening on Port " + socket.getLocalPort());
		input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		output = new DataOutputStream(socket.getOutputStream());
	} catch (Exception e) {
		// TODO: handle exception
	}
		 
		
			try {
				while(true) {
					int num = input.readInt();
					 String data = "";
					String oper= input.readUTF();	
					if(num==3) {break;}
					switch(num) {
					  case 1:
						 
					    String[]va = nomRep(oper);
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
						  String fileco = nomFichier(oper);
						  output.writeUTF(fileco);
					    break;
					
					}	
					
				}
				
				
				

			} catch (IOException e) {
			}
			try {
				input.close();
				socket.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		
	
}


public static String[] nomRep(String folder){
	File fi = new File(folder);
	if(fi.exists()) {
		return fi.list();
		
		
	}else {
		String[] empty = {"0","error "+folder+" does not exist"};
		return empty;
	}
	
	
}

public static String nomFichier(String file) {
	String data = "";
	try {
		File fi = new File(file);
if(!fi.exists()) {return "file does not exist";}
		Scanner sc = new Scanner(fi);
		
		while (sc.hasNextLine()) {
	        data += sc.nextLine()+"\n";
	       
	      }
	      sc.close();
		
	} catch (Exception e) {
		System.out.println(e);
	}

	return data;
}

	public static void main(String[] args) {
Server server = new Server(5000);
	}

}
