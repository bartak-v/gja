/*
 * Adapted from http://www.roseindia.net/c-tutorials/example-of-statelfulbean.shtml
 * Updated to jakarta EJB 4
 */

package net.roseindia.ejb4.statefull.example;

import jakarta.ejb.Remote;
import jakarta.ejb.Remove;
import jakarta.ejb.Stateful;

/**
 *
 * Stateful AccountBean. Keeps bank account balance.
 */
@Stateful(name = "AccountBean")
@Remote(AccountRemote.class)
public class AccountBean implements AccountRemote {

  float balance = 0;

    /**
     *
     * Adds amount to current account balance
     * @param amount amount to deposit
     * @return new account balance
     */
    @Override
  public float deposit(float amount) {
    balance += amount;
    return balance;
  }

  
    /**
     *
     * Subtracts amount to current account balance
     * @param amount amount to withdraw
     * @return new account balance
     */
  @Override
  public float withdraw(float amount) {
    balance -= amount;
    return balance;
  }

    /**
     * Sets account balance to 0
     */
    @Override
  @Remove
  public void remove() {
    balance = 0;
  }
}