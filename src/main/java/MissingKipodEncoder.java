import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Random;

public class MissingKipodEncoder {
    private static String string = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+<>?,./:";
    private static String flag = "KAF{kxkxkx_i_9u355_w3_f0und_h1m_f1na11y_1_mi553d_h1m_50_much_<3}";
    private static Random random = new Random();

    public static void main(String[] args) {
        int fiboOffset = new Random().nextInt(10000);
        int fiboIndex = 0;
        ArrayList<Integer> fiboObjects = new ArrayList<>();
        fiboObjects.add(0);
        fiboObjects.add(1);
        for (int i = 0; i < flag.length(); i++) {
            fiboObjects.add(fiboObject(i + 2, fiboObjects));
            System.out.println(i + " - " + fiboObjects.get(fiboObjects.size() - 1));
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10000000; i++) {
            if (fiboIndex < flag.length() && fiboObjects.get(fiboIndex + 2) == i + 1 - fiboOffset) {
                builder.append(flag.charAt(fiboIndex));
                fiboIndex++;
            } else {
                builder.append(string.charAt(random.nextInt(string.length())));
            }
        }
        File file = new File(new File(Dinary.ROOT_DIRECTORY, "binary"), "map");
        try {
            System.out.print("Writing: ");
            Files.write(file.toPath(), builder.toString().getBytes());
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int fiboObject(int fiboIndex, ArrayList<Integer> objects) {
        if (fiboIndex < objects.size())
            return objects.get(fiboIndex);
        return fiboObject(fiboIndex - 1, objects) + fiboObject(fiboIndex - 2, objects);
    }
}
