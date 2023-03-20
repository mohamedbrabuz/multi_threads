import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public static void main(String[] args){
        try {
            Socket socket=new Socket("localhost",25000);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            Scanner s=new Scanner(System.in);
            System.out.println("Enter word 1 : ");
            String word_one =s.nextLine();
            output.println(word_one);

            System.out.println("Enter word 2 : ");
            String word_two =s.nextLine();
            output.println(word_two);

            System.out.println(input.readLine());

            input.close();
            output.close();
            socket.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}