import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Decoder {
    public static void main(String[] args) {
        File dinary = new File(new File(Dinary.ROOT_DIRECTORY, "dinary"), "dinary.png");
        try {
            BufferedImage hugeImage = ImageIO.read(dinary);
            ArrayList<Byte> bytes = new ArrayList<>();
            for (int p = 0; p < hugeImage.getHeight() * hugeImage.getWidth(); p++) {
                int x = p % hugeImage.getWidth();
                int y = (p - x) / hugeImage.getWidth();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
