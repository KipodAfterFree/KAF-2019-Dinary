import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Encoder {

    public static void main(String[] args) {
        int size = 8192;

        BufferedImage bufferedImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);

        byte[] bytes = readData();

        for (int i = 0; i < bytes.length; i++) {
            byte section = bytes[i];
            for (int bit = 0; bit < 8; bit++) {
                int pixel = i * 8 + bit;
                int pixelX = pixel % size;
                int pixelY = (pixel - pixelX) / size;
                bufferedImage.setRGB(pixelX, pixelY, ((section >> bit & 1) == 1 ? Color.white : Color.black).getRGB());
            }
        }

        System.out.println("Writing");

        File file = new File(new File(Dinary.ROOT_DIRECTORY, "dinary"), "dinary.png");
        try {
            ImageIO.write(bufferedImage, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] readData() {
        try {
            File bin = new File(new File(Dinary.ROOT_DIRECTORY, "binary"), "binary");
            File map = new File(new File(Dinary.ROOT_DIRECTORY, "binary"), "map");
            String string = new String(Files.readAllBytes(bin.toPath())).replace("[MAP]", new String(Files.readAllBytes(map.toPath())));
            return string.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
