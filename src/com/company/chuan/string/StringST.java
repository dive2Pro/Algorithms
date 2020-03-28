package com.company.chuan.string;

public abstract class  StringST<Value> {
    abstract void put(String key, Value val);
    abstract Value get(String key);
    void delete(String key){}
    abstract boolean contains(String key);
    abstract boolean isEmpty();

    /**
     *
     * @param s
     * @return s 的前缀中最长的键
     */
    abstract String longestPrefixOf(String s);

    /**
     *
     * @param s
     * @return 所有以 s 为前缀的键
     */
    abstract Iterable<String> keysWithPrefix(String s);

    /**
     *
     * @param s
     * @return 所有和 s 匹配的键 ( "." 能够匹配任意字符)
     */
    abstract Iterable<String> keysThatMatch(String s);

    abstract int size();
    abstract Iterable<String> keys();
}
