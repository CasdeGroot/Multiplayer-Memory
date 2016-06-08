import javax.swing.*;
import java.awt.*;
import java.io.DataInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Joshua on 8-6-2016.
 */
public class Client extends JPanel
{
    private Card card;

    private final int port = 6666;
    String host = "localhost";
    ObjectInputStream in;
    ObjectOutputStream out;
    Socket socket;
    Card[][] cards;
    Card card1;
    Card card2;

    public Client()
    {
        initializeGUI();
        setPreferredSize(new Dimension(800,800));
        setVisible(true);
        connectToServer();
    }

    private void connectToServer()
    {
        try
        {
            socket = new Socket(host,port);
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            cards = (Card[][]) (in.readObject());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics g)
    {
    Graphics2D g2 = (Graphics2D) g;
        for(int i = 0; i<4;i++)
        {
            for(int ii = 0; ii<4; i++)
            {
                if(cards != null) {
                    cards[i][i].draw(g2);
                }
            }
        }
    }

    public void initializeGUI()
    {
        JFrame frame =  new JFrame("Memory Client");
        frame.setSize(new Dimension(800,800));
        frame.setResizable(false);
        //frame.add(this);
        frame.setContentPane(this);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }




}
