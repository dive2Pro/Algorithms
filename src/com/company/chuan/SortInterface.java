package com.company.chuan;

public interface SortInterface<Key extends Comparable<Key>, Value> {

    /**
     * 将键值入表
     */
    void put(Key key, Value value);
    /**
     * 
     * @param key
     * @return 取出键 key 在表中的值
     */
    Value  get(Key key);
    /**
     * 从表中删除该键
     */
    void delete(Key key);
    /**
     * 
     * @return 键 key 是否存在表中
     */
    boolean contains(Key key);

    /**
     * 
     * @return 表是否为空
     */
    boolean isEmpty();

    /**
     * 键值对数量
     */
    int size();
    int size(Key lo, Key hi);
    /**
     * @return  最小的键
     */
    Key min();
    /**
     * 最大的键
     */
    Key max();
    /**
     * 小于等于 key 的键的最大值
     */
    Key floor(Key key);
    /**
     * 大于等于 key 的键的最小值
     * @param key
     * @return
     */
    Key ceiling(Key key);

    /**
     * 小于 key 的键的数量
     * @param key
     * @return
     */
    int rank(Key key);
    /**
     * 排名为 k 的值
     * 
     * @return
     */
    Key select(int k);

    void deleteMin();

    void deleteMax();


    Iterable<Key> keys(Key lo, Key hi);

    Iterable<Key> keys();
}