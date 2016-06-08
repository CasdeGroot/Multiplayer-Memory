import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Joshua on 8-6-2016.
 */
public class ThreadClass implements Runnable
{
    private Socket player;
    // create and initialize board here

    private DataInputStream fromPlayer;
    private DataOutputStream toPlayer;
    private Card[][] cards;

    public ThreadClass(Socket player, Card[][] cards)
    {
        this.player = player;
        this.cards = cards;
    }

    public void run()
    {
        try
        {
            ObjectInputStream fromplayer = new ObjectInputStream(player.getInputStream());
            ObjectOutputStream toPlayer = new ObjectOutputStream(player.getOutputStream());

            // notify player 1 its his turn
            toPlayer.writeObject(cards);

            while(true)
            {
                // recieve 2 moves from player 1
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void sendMove(DataOutputStream out, int x, int y)
            throws IOException {
        out.writeInt(x);
        out.writeInt(y);
        //TODO put position here

    }

    private boolean isFlipped()
    {
        // if clicked card return true or false
        return false;
    }

    private boolean isWon()
    {
        return false;
    }





}
