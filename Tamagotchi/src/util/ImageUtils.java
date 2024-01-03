package util;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageUtils implements Serializable {

    // Charge une image depuis un fichier et la renvoie sous forme d'Image
    public static Image loadImageFromPath(String path) {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(path));
            return Toolkit.getDefaultToolkit().createImage(bufferedImage.getSource());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
