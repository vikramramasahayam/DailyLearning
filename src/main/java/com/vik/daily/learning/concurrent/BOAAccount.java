package com.vik.daily.learning.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class BOAAccount {

    private final ReentrantLock lock = new ReentrantLock();
    private Integer amount = 500;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(final Integer amount) {
        this.amount = amount;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public boolean isSafeToTransfer(final CitiAccount account) {
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

    public void transfer(final Integer transferAmount, final CitiAccount account) {

        if (isSafeToTransfer(account)) {
            try {
                account.setAmount(account.getAmount() + transferAmount);
                setAmount(getAmount() - transferAmount);
                System.out.println(
                        "BOAAmount : " + getAmount() + " CitiAmount : " + account.getAmount() + " Total : " + (getAmount() + account.getAmount()));
            } finally {
                lock.unlock();
                account.getLock().unlock();
            }

        } else {
            System.out.println("BOAAccount Unable to transfer now.");
        }

    }

}
