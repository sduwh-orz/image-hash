package cn.edu.sdu.orz.image.search;


import java.math.BigInteger;
// https://github.com/KilianB/JImageHash/blob/master/src/main/java/dev/brachtendorf/jimagehash/hashAlgorithms/HashBuilder.java
public class HashBuilder {
    private static final byte[] MASK = { 1, 1 << 1, 1 << 2, 1 << 3, 1 << 4, 1 << 5, 1 << 6, (byte) (1 << 7) };

    private byte[] data;
    private int bit = 0;
    private int index;
    protected int length;
    public HashBuilder(int bits) {
        data = new byte[(int) Math.ceil(bits / 8d)];
        index = data.length - 1;
    }

    public void prependZero() {
        carry();
        bit++;
        length++;
    }

    public void prependOne() {
        carry();
        data[index] |= MASK[bit++];
        length++;
    }

    private void carry() {
        if (bit == 8) {
            bit = 0;
            index--;
            if (index == -1) {
                byte[] temp = new byte[data.length + 1];
                System.arraycopy(data, 0, temp, 1, data.length);
                data = temp;
                index = 0;
            }
        }
    }

    public BigInteger toBigInteger() {
        return new BigInteger(1, data);
    }
}