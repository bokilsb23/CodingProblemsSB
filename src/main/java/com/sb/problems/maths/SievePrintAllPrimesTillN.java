package com.sb.problems.maths;

import java.util.ArrayList;

public class SievePrintAllPrimesTillN {
    /**
     * Prints all the primes Till number A
     * @param A - number
     * @return List of prime numbers till A
     */
    public ArrayList<Integer> sieve(int A) {
        ArrayList<Integer> primes = new ArrayList<>();
        VerifyPrime vPrimes = new VerifyPrime();
        primes.add(2);
        int i = 3;
        while(i <= A) {
            if(vPrimes.verifyPrime(i)) {
                primes.add(i);
            }
            i+=2;
        }
        return primes;
    }

    public static void main(String[] args) {
        SievePrintAllPrimesTillN sieve = new SievePrintAllPrimesTillN();
        System.out.println(sieve.sieve(10));
    }
}
