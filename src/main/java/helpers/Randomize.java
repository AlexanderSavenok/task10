package helpers;

import java.security.SecureRandom;

public final class Randomize {
    private static final String SEQUENCE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static SecureRandom rnd = new SecureRandom();

    public static String randomString(int length){
        StringBuilder sb = new StringBuilder(length);
        for(int i = 0; i < length; i++)
            sb.append(SEQUENCE.charAt(rnd.nextInt(SEQUENCE.length())));
        return sb.toString();
    }

    public static String randomFilePath(int length) {
        return String.format("src/main/resources/%s.json", Randomize.randomString(length));
    }
}
