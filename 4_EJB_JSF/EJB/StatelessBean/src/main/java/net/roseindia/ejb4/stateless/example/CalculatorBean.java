/*
 * Adapted from http://www.roseindia.net/ejb/examples-of-StatelessBean.shtml
 * Updated to jakarta EJB 4
 */

package net.roseindia.ejb4.stateless.example;

import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;

/**
 *
 * Simple stateless bean CalculatorBean. Can Do basic mathematical operations
 */
@Stateless(name = "CalculatorBean")
@Remote(CalculatorRemote.class)
public class CalculatorBean implements CalculatorRemote {

    /**
     *
     * @param x first operand
     * @param y second operand
     * @return x + y
     */
    @Override
  public float add(float x, float y) {
    return x + y;
  }

    /**
     *
     * @param x first operand
     * @param y second operand
     * @return x - y
     */
    @Override
  public float subtract(float x, float y) {
    return x - y;
  }

    /**
     *
     * @param x first operand
     * @param y second operand
     * @return x * y
     */
    @Override
  public float multiply(float x, float y) {
    return x * y;
  }

    /**
     *
     * @param x first operand
     * @param y second operand
     * @return x / y
     */
    @Override
  public float division(float x, float y) {
    return x / y;
  }
}
