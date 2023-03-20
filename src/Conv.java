import java.io.*;

import java.net.Socket;

public class Conv extends Thread{
    private Socket socket;
    Conv(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String word_one = input.readLine();
            String word_two = input.readLine();
            String response;
            if(word_one.contains(word_two)){
                output.println("word contained");
            }else{
                output.println("word does not contained");
            }

            Server.count--;
            System.out.println("Clients Connected : "+Server.count);
            input.close();
            output.close();
            socket.close();
        }catch(Exception e) {
            Server.count--;
            e.printStackTrace();
        }
    }
}