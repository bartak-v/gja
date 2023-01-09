/*
 * Adapted from http://www.roseindia.net/c-tutorials/example-of-statelfulbean.shtml
 * Updated to jakarta EJB 4
 */
package net.roseindia.ejb4.statefull.example;

import jakarta.ejb.Remote;
import jakarta.ejb.Remove;

/**
 *
 * Interface for remote Account.
 */
@Remote
public interface AccountRemote {

    /**
     *
     * Adds amount to current account balance
     *
     * @param amount amount to deposit
     * @return new account balance
     */
    public float deposit(float amount);

    /**
     *
     * Subtracts amount to current account balance
     *
     * @param amount amount to withdraw
     * @return new account balance
     */
    public float withdraw(float amount);

    /**
     * Sets account balance to 0
     */
    @Remove
    public void remove();
}
