package year2015.day4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4 {
    public static void main(String[] args) {
        String input = "ckczppom";
        long i = 1;
        while (true) {
            String hash = getHash(input + i);
            if (hash.startsWith("00000")) {
                System.out.println(i);
                break;
            }
            i++;
        }
        i = 0;
        while (true) {
            String hash = getHash(input + i);
            if (hash.startsWith("000000")) {
                System.out.println(i);
                break;
            }
            i++;
        }
    }

    public static String getHash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] hashBytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
            return null;
        }

    }
}
