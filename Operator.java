
package Publication_Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Operator {
   // private Server instance;
    private Socket clientSocket;
    private BufferedReader clientIn;
    private PrintWriter clientOut;
    private BufferedReader stdin;
    
    
    public Operator(){
        //instance = instance.getInstance();
        try{
            clientSocket = new Socket("localhost", 81);
            clientIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            clientOut = new PrintWriter(clientSocket.getOutputStream(),true);
            stdin = new BufferedReader(new InputStreamReader(System.in));
        }
        
        catch(IOException ex){
            System.out.println("Error establishing connection");
            ex.printStackTrace();
        }
//        if(!instance.isRunning){
//            instance.runServer();
//        }
        
    }
    public void runOperator(){
        String read;
        try{
            
            while(true){
                read = stdin.readLine();
                System.out.println("in client loop");
                clientOut.println(read);
                String s = clientIn.readLine();


                
                System.out.println("Echo: " + s );
                    

                


            }
        }
         catch(IOException ex){
                ex.printStackTrace();
            }
        
    }


public static void main(String[] args)  {
        Operator op = new Operator();
        op.runOperator();
    }
}