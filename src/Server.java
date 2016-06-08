import javax.swing.*;
import java.awt.*;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
    private Card[][] cards;
    private ArrayList<Integer> states;

    public Server()
    {

        start();
    }

    public void start()
    {
        cards = new Card[4][4];
        Integer[] intArray = {1, 1,2,2,3,3,4,4,5,5,6,6,7,7,8,8};
        states = new ArrayList<Integer>(Arrays.asList(intArray));
        Collections.shuffle(states);
        try {
            serverSocket = new ServerSocket(port);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        addCard(1,0,0, 0);
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

                new Thread(new ThreadClass(player1, cards)).start();
                new Thread(new ThreadClass(player2, cards)).start();

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
    public void addCard(int i, int row, int coll, int state) {

        if (i > 16) {
            return;
        } else {
            cards[row][coll] = new Card(row * 200, coll * 200, 200, 200,states.get(state));
        }

        row++;
        i++;

        if(row % 4 == 0)
        {
            row = 0;
            coll++;
        }
        state++;
        addCard(i,row,coll,state);
    }

    public void flipCard(int x, int y)
    {
        cards[x][y].flip();
    }



    public static void main(String[] args)
    {
        new Server();
    }
}
