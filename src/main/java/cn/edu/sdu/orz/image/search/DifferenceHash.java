package cn.edu.sdu.orz.image.search;

import java.awt.image.BufferedImage;
import java.math.BigInteger;

// https://github.com/KilianB/JImageHash/blob/master/src/main/java/dev/brachtendorf/jimagehash/hashAlgorithms/DifferenceHash.java
public class DifferenceHash {
    private static int size = 8;
    BigInteger calc(BufferedImage raw) {
        var hash = new HashBuilder(size * size);
        var img = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        var g = img.createGraphics();
        g.drawImage(raw, 0, 0, size, size, null);
        g.dispose();
        for (int x = 1; x < size; x ++) {
            for (int y = 0; y < size; y ++) {
                if (img.getRGB(x, y) >= img.getRGB(x - 1, y))
                    hash.prependZero();
                else
                    hash.prependOne();
            }
        }
        for (int x = 0; x < size; x ++) {
            for (int y = 1; y < size; y ++) {
                if (img.getRGB(x, y) < img.getRGB(x, y - 1))
                    hash.prependZero();
                else
                    hash.prependOne();
            }
        }
        for (int x = 1; x < size; x ++) {
            for (int y = 1; y < size; y ++) {
                if (img.getRGB(x, y) < img.getRGB(x - 1, y - 1))
                    hash.prependZero();
                else
                    hash.prependOne();
            }
        }
        return hash.toBigInteger();
    }
    public static double similarity(BigInteger a, BigInteger b) {
        return (192 - a.xor(b).bitCount()) / 192.0;
    }
}
