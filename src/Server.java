import java.net.ServerSocket;
import java.net.Socket;
public class Server {

    static int count=0;
    public static void main(String[] args){
        int port=25000;
        try{
            ServerSocket server= new ServerSocket(port);
            System.out.println("server on");
            while(true) {
                Socket socket = server.accept();
                count++;
                System.out.println("Clients connected :" + count);
                Conv conv = new Conv(socket);
                conv.start();
            }
        }catch(Exception e){
            e.printStackTrace();
        }



    }


}