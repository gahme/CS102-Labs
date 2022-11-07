import javax.swing.JPanel;
import java.awt.*;

public class StickFigure extends JPanel{
    private int x; // Middle x coordinate
    private int y; // Bottom y coordinate
    private Color color; // Color 
    private int initialHeight; // Initial height 
    private int height; // Height of figure
    private double scale = 1; // Scale of the figure
    private boolean forward = true;

    private boolean backToggle = true;
    private boolean armsToggle = true;
    private boolean legsToggle = true;
    private boolean eyesToggle = true;
    private boolean noseToggle = true;
    private boolean mouthToggle = true;
    private boolean headToggle = true;

    // Constructor
    public StickFigure(int center, int bottom, Color shade, int size){
        x = center;
        y = bottom;
        color = shade;
        height = size;
        initialHeight = size;
    }


    @Override
    public void paintComponent(Graphics page){
        super.paintComponent(page);
        height = (int) (initialHeight * scale);
        page.setColor (color);

        // Backbone
        if (backToggle){
            page.drawLine (x, y-(int)(height*0.67), x, y-(height/8));   // upper torso
        }
        // Legs
        if (legsToggle){
            page.drawLine (x-(height/4),y, x, y-(height/8));   // Left leg
            page.drawLine (x+(height/4),y, x, y-(height/8));   // Right leg
        }
        // Arms
        if (armsToggle){
            page.drawLine (x, y-(height/2), x+(height/4), y-(height/3));  // Right arm
            page.drawLine (x, y-(height/2), x-(height/4), y-(height/3));  // Left arm
        }
        // Head
        if (headToggle){
            page.drawOval(x-(height/5), y-height, 2*(height/5), (height/3));  // head
        }
        // Eyes
        if (eyesToggle){
            page.fillOval (x-(height/7), y-(int)(height*0.95), (int)(height/7*0.9), (height/7));   // Left eye
            page.fillOval ((int)(x+(height/7)-(height/7*0.9)), y-(int)(height*0.95), (int)(height/7*0.9), (height/7));   // Right eye
        }
        //Nose
        if (noseToggle){
            int noseY = y-(int)(height*0.75);
            page.drawPolygon(new int[] {(int)(x-(height*0.01)), x, (int)(x+(height*0.01))}, new int[] {noseY, y-(int)(height*0.81), noseY}, 3); // Nose
        }

        //Mouth
        if (mouthToggle){
            page.drawArc(x-(height/7), y-(int) (height*0.85), 2*(height/7), (height/7), 190, 160); // Mouth
        }
   }

    public void slideRight(){
        if (forward){
            x = ((x+height/4)>1000 ? 0+(height/4) : x+1);
            // System.out.println(direction);
        }else{
            x = ((x-height/4)<0) ? 1000-(height/4) : x-1;
            // System.out.println(direction);
        }
        repaint();
    }

    public void slideLeft(){
        if (forward){
            x = ((x-height/4)<0) ? 1000-(height/4) : x-1;
        }else{
            x = ((x+height/4)>1000 ? 0+(height/4) : x+1);
        }
        repaint();
    }

    public void setScale(double x){
        this.scale = (x / 100d);
        repaint();
    }

    public void setColor(Color shade){
        this.color = shade;
        repaint();
    }

    public void changeDirection(){
        forward = !forward;
        repaint();
    }

    /**
     * Features toggles
     */

    public void backToggle(boolean toggle){
        backToggle = toggle;
        repaint();
    }

    public void armsToggle(boolean toggle){
        armsToggle = toggle;
        repaint();
    }

    public void legsToggle(boolean toggle){
        legsToggle = toggle;
        repaint();
    }

    public void noseToggle(boolean toggle){
        noseToggle = toggle;
        repaint();
    }

    public void eyesToggle(boolean toggle){
        eyesToggle = toggle;
        repaint();
    }

    public void headToggle(boolean toggle){
        headToggle = toggle;
        repaint();
    }
}