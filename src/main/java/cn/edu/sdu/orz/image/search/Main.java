package cn.edu.sdu.orz.image.search;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        DifferenceHash hash = new DifferenceHash();
        BigInteger hash1 = hash.calc(ImageIO.read(new File("C:\\Users\\xszq\\Desktop\\images.jpg")));
        BigInteger hash2 = hash.calc(ImageIO.read(new File("D:\\Temp\\b587a816ac11ff1c40cd2881e2cf1195ea4493c9.jpg")));
        System.out.println(hash1);
        System.out.println(hash2);
        System.out.println(DifferenceHash.similarity(hash1, hash2));
    }
}