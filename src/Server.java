import javax.swing.*;
import java.awt.*;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Joshua on 8-6-2016.
 */
public class Server {

    int port = 6666;
    DataInputStream in;
    DataOutput out;
    ServerSocket serverSocket;
    Socket socket;

    public Server()
    {
        start();
    }

    public void start()
    {
        /*try {
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        initializeGUI();

    }

    public void initializeGUI()
    {
        JFrame frame =  new JFrame();
        JTextArea textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(600,400));
        frame.add(textArea);

        frame.setContentPane(frame);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }



    public static void main(String[] args)
    {
        new Server();
    }
}
