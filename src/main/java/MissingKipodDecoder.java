import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;

public class MissingKipodDecoder {

    public static void main(String[] args) {
        try {
            String map = new String(Files.readAllBytes(new File(new File(Dinary.ROOT_DIRECTORY, "binary"), "map").toPath()));
            int first = map.indexOf("KAF");
            String flag = "";
            int fiboIndex = 0;
            ArrayList<Long> fiboObjects = new ArrayList<>();
            fiboObjects.add((long) 0);
            fiboObjects.add((long) 1);
            for (int i = 0; i < 89; i++) {
                fiboObjects.add(fiboObject(i + 2, fiboObjects));
                System.out.println(i + " - " + fiboObjects.get(fiboObjects.size() - 1));
            }
            while (!flag.contains("}")) {
                flag += map.charAt((int) fiboObject(fiboIndex + 2, fiboObjects) + first - 1);
                fiboIndex++;
                System.out.println(flag);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static long fiboObject(int fiboIndex, ArrayList<Long> objects) {
        if (fiboIndex < objects.size())
            return objects.get(fiboIndex);
        return fiboObject(fiboIndex - 1, objects) + fiboObject(fiboIndex - 2, objects);
    }
}
