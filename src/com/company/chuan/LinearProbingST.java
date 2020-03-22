package com.company.chuan;

/**
 * @param <Key>
 * @param <Value>
 */
public class LinearProbingST<Key, Value> {

    /**
     * 
     * 这两个都是自动伸缩数组, 利用率在 1/8 在 1/2 之间
     * 
     */
    private Key[] keys;
    private Value[] values;

    private int M;
    private int N = 0;

    public LinearProbingST() {
        this(100);
    }

    public LinearProbingST(int M) {
        this.M = M;
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0xfffffff) % M;
    }

    public void put(Key key, Value value) {
        int index = hash(key);
        while (true) {
            if (keys[index] != null) {
                index = (++index) % M;
                if (keys[index].equals(key)) {
                    values[index] = value;
                    break;
                }
            } else {
                keys[index] = key;
                values[index] = value;
                N++;
                if(N > M / 2) {
                    resize( M * 2);
                }
                break;
            }
        }
    }

    public Value get(Key key) {
        int index = hash(key);
        while(keys[index] != null) {
            if(keys[index].equals(key)) {
                return values[index];
            }
            index = ( 1 + index) % M;
        }
        return null;
    }

    public void delete(Key key) {
        int index = hash(key);
        if(keys[index] == null) {
            return;
        }

        while(!keys[index].equals(key)) {
            index = (1 + index) % M;
        }
        keys[index] = null;
        values[index] = null;

        int nextIndex = index + 1;
        while(keys[nextIndex] != null) {
            Key keyToRedo = keys[nextIndex];
            Value valueToRedo = values[nextIndex];

            keys[nextIndex] = null;
            values[nextIndex] = null;

            keys[nextIndex - 1 ] = keyToRedo;
            values[nextIndex - 1 ] = valueToRedo;

            nextIndex = ( 1 + nextIndex) % M;
        }
        N --;
        if(N > 0 && N < M  / 8) {
            resize(N / 2);
        }
    }

    private void resize(int cap) {
        LinearProbingST<Key, Value> st;
        st = new LinearProbingST<>(cap);

        for( int i = 0 ; i < M; i ++) {
            if(keys[i] != null) {
                st.put(keys[i], values[i]);
            }
        }
        keys = st.keys;
        values = st.values;
        this.M = cap;
    }

}