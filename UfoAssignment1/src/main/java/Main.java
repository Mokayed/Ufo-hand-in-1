import java.util.*;
import java.io.*;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Main {

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        ClassLoader classLoader = new Main().getClass().getClassLoader();
        BufferedImage img = ImageIO.read(new File(classLoader.getResource("Stego.png").getFile()));
        m.marchThroughImage(img);
    }

    public void printPixelARGB(int pixel) {
        int alpha = (pixel >> 24) & 0xff;
        int red = (pixel >> 16) & 0xff;
        int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff;
        if(red >= 16 && red <= 23 && green == 0 && blue == 0 && alpha == 255){
            System.out.println("found a red value!");
            System.out.println("argb: " + alpha + ", " + red + ", " + green + ", " + blue + ", pixel was: " + pixel);
        }
        //System.out.println("argb: " + alpha + ", " + red + ", " + green + ", " + blue);
    }

    public void marchThroughImage(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();
        //System.out.println("width, height: " + w + ", " + h);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
               // System.out.println("x,y: " + j + ", " + i);
                int pixel = image.getRGB(j, i);
                printPixelARGB(pixel);
                //System.out.println("");
            }
        }
    }
}