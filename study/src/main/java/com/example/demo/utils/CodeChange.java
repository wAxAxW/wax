package com.example.demo.utils;

import org.apache.commons.lang3.text.StrBuilder;

import java.math.BigInteger;

public class CodeChange {
    public static String toSpaName(String sou) {


        String s = Hex.str2HexStr(sou);
        String[] s2 = s.split(" ");
        int[] ints = new int[s2.length];
        for (int i = 0; i < ints.length; i++) {

            BigInteger bigInteger = new BigInteger(s2[i], 16);
            ints[i] = bigInteger.intValue();
        }

        StrBuilder strBuilder = button1_Click(ints);
        String s1 = strBuilder.toString();
        return test(s1);
    }


    private static StrBuilder button1_Click(int[] bytes) {
        StrBuilder strBuilder = new StrBuilder();
        int i2 = bytes.length / 2;
        int[] newInter = new int[i2];

        int j = 0;
        for (int i = 0; i < bytes.length; i++) {

            if (bytes[i] == 194) {
                i++;
                newInter[j] = bytes[i];
                j++;
            } else if (bytes[i] == 195) {
                i++;
                newInter[j] = (bytes[i]) + 64;
                j++;
            }
        }

        for (int i : newInter) {

            String s = Integer.toHexString(i);
            strBuilder.append(s);
        }
        return strBuilder;
    }

    private static String test(String s) {

        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(
                        i * 2, i * 2 + 2), 16));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            s = new String(baKeyword, "GBK");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;

    }
}