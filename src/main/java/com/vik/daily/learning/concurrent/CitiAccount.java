package com.vik.daily.learning.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class CitiAccount {
    private final ReentrantLock lock = new ReentrantLock();
    private Integer amount = 100;

    public ReentrantLock getLock() {
        return lock;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(final Integer amount) {
        this.amount = amount;
    }

    public boolean isSafeToTransfer(final BOAAccount account) {
        final boolean citilock = lock.tryLock();
        final boolean boalock = account.getLock().tryLock();

        if (citilock && boalock) {
            return true;
        } else {
            if (citilock) {
                lock.unlock();
            }

            if (boalock) {
                account.getLock().unlock();
            }

        }

        return false;
    }

    public void transfer(final Integer transferAmount, final BOAAccount account) {

        if (isSafeToTransfer(account)) {
            try {
                account.setAmount(account.getAmount() + transferAmount);
                setAmount(getAmount() - transferAmount);
                System.out.println(
                        "citiAmount : " + getAmount() + " BoaAmount : " + account.getAmount() + " Total : " + (getAmount() + account.getAmount()));
            } finally {
                lock.unlock();
                account.getLock().unlock();
            }

        } else {
            System.out.println("CitiAccount Unable to transfer now.");
        }

    }

}
