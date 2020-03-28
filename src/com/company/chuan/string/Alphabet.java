package com.company.chuan.string;

import java.util.HashMap;

public class Alphabet {

    public static String BiNARY = "01";      // 二进制
    public static String DNA = "ACTG";       // DNA
    public static String OCTAL = "01234567"; // 八进制
    public static String DECIMAL = "0123456789"; // 十进制
    public static String HEXADECIMAL = "0123456789ABCDEF"; // 十六进制
    public static String PROTEIN = "ACDEFGHIKLMNPQRSTVWY"; //  蛋白质
    public static String LOWERCASE = "abcdefghijklmnopqrstuvwxyz"; //   小写字母
    public static String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //   大写字母
    public static String BASE64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/."; //   base64
    public static String ASCII = ""; //    ASCII
    public static String EXTENDER_ASCII = ""; // 扩展 ASCII
    public static String UNICODE16 = ""; // Unicode 字符集

    private char[] table;
    private HashMap<Character, Integer> map;

    /**
     * @param s 根据 s 中的字符创建一张新的字母表
     */
    public Alphabet(String s) {
        table = s.toCharArray();
        map = new HashMap<>();
        for(int i = 0 ; i < table.length ; i ++) {
           map.put(table[i], i);
        }
    }

    /**
     * @param index 索引位置
     * @return 字母表中索引位置的字符
     */
    char toChar(int index) {
        return table[index];
    }

    /**
     * @param c -
     * @return c 的索引, 在 0  到 R-1 之间
     */
    int toIndex(char c) {
        return map.get(c);
    }

    /**
     * @param c -
     * @return c 是否在字母表中
     */
    boolean contains(char c) {
        return map.containsKey(c);
    }

    /**
     * @return 基数(字母表中的字符数量)
     */
    int R() {
        return table.length;
    }

    /**
     * @return 表示一个索引所需的位数
     */
    int lgR() {
        return 0;
    }

    /**
     * @param s 字符串
     * @return 将 s 转换为 R 进制的整数
     */
    int[] toIndices(String s) {
        int[] numbers = new int[s.length()];

        for(int i = 0 ; i < numbers.length ; i ++) {
            numbers[i] = map.get(s.charAt(i));
        }
        return numbers;
    }

    /**
     * @param indices R 进制的证书
     * @return 将 R 进制的整数转换为基于该字母表的字符串
     */
    String toChars(int[] indices) {
        StringBuilder sb = new StringBuilder();

        for (int index : indices) {
            sb.append(table[index]);
        }

        return sb.toString();
    }

}
