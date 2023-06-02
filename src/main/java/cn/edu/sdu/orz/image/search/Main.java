package cn.edu.sdu.orz.image.search;

import org.python.util.PythonInterpreter;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        DifferenceHash hash = new DifferenceHash();
        BigInteger hash1 = hash.calc(ImageIO.read(new File("E:\\OneDrive - mail.sdu.edu.cn\\image-hash\\ssss.png")));
        BigInteger hash2 = hash.calc(ImageIO.read(new File("E:\\OneDrive - mail.sdu.edu.cn\\image-hash\\test2.png")));
        System.out.println(hash1);
        System.out.println(hash2);
        System.out.println(DifferenceHash.similarity(hash1, hash2));
    }
}

//基于霍夫变换与图像哈希的图像检索引擎的设计与实现