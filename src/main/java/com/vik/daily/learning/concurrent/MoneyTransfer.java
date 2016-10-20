package com.vik.daily.learning.concurrent;

import java.util.Random;
import java.util.stream.IntStream;

public class MoneyTransfer {

    public static void main(final String[] args) {
        final BOAAccount boa = new BOAAccount();
        final CitiAccount citi = new CitiAccount();

        new Thread(new BOATransfer(boa, citi)).start();
        new Thread(new CitiTransfer(citi, boa)).start();

    }

    public static class BOATransfer implements Runnable {

        private final BOAAccount boa;
        private final CitiAccount citi;

        public BOATransfer(final BOAAccount boa, final CitiAccount citi) {
            this.boa = boa;
            this.citi = citi;
        }

        @Override
        public void run() {
            final Random random = new Random();
            IntStream.range(0, 50).forEach((value) -> {
                try {
                    Thread.sleep(random.nextInt(5));
                } catch (final InterruptedException e) {}
                boa.transfer(random.nextInt(20), citi);
            });
        }

    }

    public static class CitiTransfer implements Runnable {

        private final CitiAccount citi;
        private final BOAAccount boa;

        public CitiTransfer(final CitiAccount citi, final BOAAccount boa) {
            this.citi = citi;
            this.boa = boa;
        }

        @Override
        public void run() {
            final Random random = new Random();
            IntStream.range(0, 50).forEach((val) -> {
                try {
                    Thread.sleep(random.nextInt(5));
                } catch (final InterruptedException e) {}
                citi.transfer(random.nextInt(5), boa);
            });

        }

    }

}
