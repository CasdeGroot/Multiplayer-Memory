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
    private int connections = 0;
    JTextArea textArea;

    public Server()
    {
        start();
    }

    public void start()
    {

        initializeGUI();

    }

    public void acceptConnections()
    {
        while(true)
        {
            try {
                Socket player1 = serverSocket.accept();
                System.out.println("Player 1 connected");



                Socket player2 = serverSocket.accept();
                System.out.println("Player 2 connected");

                new Thread(new ThreadClass(player1, player2)).start();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    public void initializeGUI()
    {
        JFrame frame =  new JFrame("Memory Server");



        textArea = new JTextArea();
        JPanel panel = new JPanel();


        textArea.setPreferredSize(new Dimension(600,400));
        frame.setSize(new Dimension(600,400));

        textArea.setEditable(false);

        panel.add(textArea);
        frame.add(panel);

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }



    public static void main(String[] args)
    {
        new Server();
    }
}
