import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class Encoder {

    private static File ROOT_DIRECTORY = new File(System.getProperty("user.dir"));

    public static void main(String[] args) {
        int size = 4096;

        BufferedImage bufferedImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = bufferedImage.createGraphics();

        ArrayList<Boolean> bits = toBinary(new File(new File(ROOT_DIRECTORY, "binary"), "binary"));

        for (int i = 0; i < bits.size(); i++) {
            int x = i % size;
            int y = (i - x) / size;
            g2d.setColor(bits.get(i) ? Color.white : Color.black);
            g2d.drawLine(x, y, x, y);
        }

        // fill all the image with white
        g2d.setColor(Color.white);

        g2d.dispose();

        File file = new File(new File(ROOT_DIRECTORY, "dinary"), "dinary.png");
        try {
            ImageIO.write(bufferedImage, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Boolean> toBinary(File file) {
        try {
            byte[] bytes = Files.readAllBytes(file.toPath());
            ArrayList<Boolean> bits = new ArrayList<>();
            for (byte b : bytes) {
                for (int i = 0; i < 8; i++) {
                    bits.add((b << i & 1) == 1);
                }
            }
            return bits;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
