package com.sb.multithreading;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

public class ComplexCalculation {
    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
        BigInteger result;
        PowerCalculatingThread thread1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread thread2 = new PowerCalculatingThread(base2, power2);
        AtomicInteger integer = new AtomicInteger(1);
        thread1.start();
        thread2.start();
    try{
        thread1.join(5000);
        thread2.join(5000);
    }
        catch(InterruptedException ex){
            System.out.println("Unhandled Interrupt Exception");
            return BigInteger.ZERO;
        }
        result = thread1.getResult().add(thread2.getResult());
        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */
        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            result = base;
            for(BigInteger i = BigInteger.ONE; i.compareTo(power) < 0; i = i.add(BigInteger.ONE)){
                result = result.multiply(base);
            }
        }

        public BigInteger getResult() { return result; }
    }
}