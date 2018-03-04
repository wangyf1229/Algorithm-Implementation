class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        if (key == null || key.length == 0) return 0;
        long hashCode = 0;
        for (char i : key) {
            hashCode = (hashCode * 33 + (int) i) % HASH_SIZE;
        }
        return (int) hashCode;
    }
};