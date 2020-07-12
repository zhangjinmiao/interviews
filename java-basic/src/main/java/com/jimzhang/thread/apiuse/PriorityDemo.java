package com.jimzhang.thread.apiuse;

public class PriorityDemo {

    static class ThreadHigh extends Thread {
        private int count = 0;

        public int getCount() {
            return count;
        }

        @Override
        public void run() {
            while (true) {
                count++;
            }
        }
    }

    static class ThreadLow extends  Thread {
        private int count = 0;

        public int getCount() {
            return count;
        }

        @Override
        public void run() {
            while (true) {
                count++;
            }
        }
    }

    public static void main(String[] args) {
        try {
            ThreadLow low = new ThreadLow();
            low.setPriority(2);
            low.start();
            ThreadHigh high = new ThreadHigh();
            high.setPriority(8);
            high.start();
            Thread.sleep(2000);
            low.stop();
            high.stop();
            System.out.println("low =  " + low.getCount());
            System.out.println("high = " + high.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
