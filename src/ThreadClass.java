import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Joshua on 8-6-2016.
 */
public class ThreadClass implements Runnable
{
    private Socket player1;
    private Socket player2;

    // create and initialize board here

    private DataInputStream fromPlayer1;
    private DataOutputStream toPlayer1;
    private DataInputStream fromPlayer2;
    private DataOutputStream toPlayer2;

    public ThreadClass(Socket player1,Socket player2)
    {
        this.player1 = player1;
        this.player2 = player2;

        //initialize cards

    }

    public void run()
    {
        try
        {
                DataInputStream fromplayer1 = new DataInputStream(player1.getInputStream());
                DataOutputStream toPlayer1 = new DataOutputStream(player1.getOutputStream());
                DataInputStream fromplayer2 = new DataInputStream(player2.getInputStream());
                DataOutputStream toPlayer2 = new DataOutputStream(player2.getOutputStream());


            // notify player 1 its his turn
            toPlayer1.writeBoolean(true);

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
