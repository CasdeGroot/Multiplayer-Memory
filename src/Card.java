import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Joshua on 8-6-2016.
 */
public class Card implements Comparable<Card>
{
        private int x;
        private int y;
        private int width;
        private int height;
        BufferedImage back;
        BufferedImage front;
        CardImage state;
        boolean isFlipped;

        public Card(int x, int y, int width, int height, String url, CardImage state)
        {
                this.x = x;
                this.y = y;
                this.width = width;
                this.height = height;
                isFlipped = false;

                try
                {
                        back = ImageIO.read(new File(url));
                        front = ImageIO.read(new File("res//front.png"));
                }
                catch(Exception e)
                {
                        e.printStackTrace();
                }
        }

        public void flip()
        {
                isFlipped =! isFlipped;
        }


        @Override
        public int compareTo(Card o)
        {
                if(this.state == o.getImage())
                {
                        return 1;
                }
                else
                {
                        return 0;
                }
        }

        public CardImage getImage()
        {
                return state;
        }

        public void onClick(int x,int y)
        {
                if(x > this.x && x < this.x + width)
                {
                        if(y > this.y && y < this.y + width)
                        {
                                flip();
                        }
                }
        }

        public void draw(Graphics2D g2)
        {
                if(!isFlipped)
                        g2.drawImage(front,x,y,null);
                else
                        g2.drawImage(back, x,y,null);
        }
}
