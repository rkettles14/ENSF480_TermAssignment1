package Publication_Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private PrintWriter serverOut;
    private BufferedReader serverIn;
    private static Server instance = null;
//    private static Server instance = null;
//    public static Boolean isRunning = false;
    
    
    private Server(){
        try {
            serverSocket = new ServerSocket(81);
            socket = serverSocket.accept();
            serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            serverOut = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Client Connected");
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        instance = this;
    }
    
//    public static Server getInstance(){
//        if(instance == null){
//            instance = new Server();
//        }
//        return instance;
//    }
    
    public void runServer(){
//        isRunning = true;
        try{
            
            while(true){
                
                    String message = serverIn.readLine();
                    System.out.println("message from client: " +message);
                    message+="....returned from server";
                    serverOut.println(message);
                
                               
            }
        }
        catch(IOException ex){
                System.out.println("Error running server...");
                ex.printStackTrace();           
        }
            
            
          
        
    }
    public static void main(String[] args)  {
        Server server = new Server();
        server.runServer();
    }

}
