package concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintEvenAndOddWithTwoThreads {

    public static void main(String[] args) {
        var lock = new ReentrantLock();
        var even = lock.newCondition();
        var odd = lock.newCondition();
        var printer = new Printer(lock, even, odd);
        new Thread(new Print(10, printer, false)).start();
        new Thread(new Print(10,  printer, true)).start();
    }

    private static class Print implements Runnable{
        private final int max;
        private final boolean isEven;
        private final Printer printer;

        public Print(int max, Printer printer, boolean isEven) {
            this.max = max;
            this.isEven = isEven;
            this.printer = printer;
        }

        @Override
        public void run() {
            int number = isEven ? 2 : 1;
            while (number <= max){
                if (isEven){
                    printer.printEven(number);
                } else {
                    printer.printOdd(number);
                }
                number = number + 2;
            }
        }

    }

    private static class Printer {
        private final Lock lock;
        private final Condition even;
        private final Condition odd;
        boolean isOdd = false;

        public Printer(Lock lock, Condition even, Condition odd) {
            this.lock = lock;
            this.even = even;
            this.odd = odd;
        }

        public void printEven(int number) {
            lock.lock();
            while (!isOdd) {
                try {
                    even.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Even:" + number);
            isOdd = false;
            odd.signalAll();
            lock.unlock();
        }

        public void printOdd(int number) {
            lock.lock();
            while (isOdd) {
                try {
                    odd.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Odd:" + number);
            isOdd = true;
            even.signalAll();
            lock.unlock();
        }

    }
}
