import java.util.Random;

public class MissingKipod {
    private static String flag = "KAF{kxkxkx_i_9u355_w3_f0und_h1m_f1na11y_1_mi553d_h1m_50_much_<3}";
    private static String map = "";

    public static void main(String[] args) {
        int fiboOffset = new Random().nextInt(10000);
        int fiboJumping = 4;
        int fiboIndex = 0;
        for (int i = 0; i < 100000; i++) {
            if (fiboIndex < flag.length() && fiboObject(fiboIndex + 2 + fiboJumping) == i - fiboOffset) {
                map += flag.charAt(fiboIndex);
                fiboIndex++;
            } else {
                map += random();
            }
        }
        System.out.println(map);
    }

    private static String random() {
        String string = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+<>?,./:";
        int i = new Random().nextInt(string.length());
        return string.substring(i, i + 1);
    }

    private static int fiboObject(int fiboIndex) {
        if (fiboIndex == 0)
            return 0;
        if (fiboIndex == 1)
            return 1;
        return fiboObject(fiboIndex - 2) + fiboObject(fiboIndex - 1);
    }
}
