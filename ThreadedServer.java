package tpjavaa;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class ThreadedServer {
public Socket socket = null;
public ServerSocket server = null;

public ThreadedServer(int port) {
	try {
		server = new ServerSocket(port);
		System.out.println("server started");
		System.out.println("waiting for client");
		
		socket = server.accept();
		System.out.println("Server Listening on Port " + socket.getLocalPort());
		Thread t = new ThreadTask(socket);
		t.start();
		
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
ThreadedServer server = new ThreadedServer(5000);
	}
	
}