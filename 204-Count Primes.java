class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        if (n <= 2) return 0;
        notPrime[2] = false;
        int num = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                num += 1;
                for (int j = 2*i; j < n; j += i){
                    notPrime[j] = true;
                }
            }
        }
        return num;
    }

}

class Solution {
    public int countPrimes(int n) {
        //find all the prime numbers
        if (n <= 2) return 0;
        if (n == 3) return 1;
        boolean[] isPrime = new boolean[n];
        int number = 0;

        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i*i < n; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) number++;
        }

        return number;
    }

    //check whether n is a prime number or not
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}