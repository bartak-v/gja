/*
 * Adapted from http://www.roseindia.net/ejb/examples-of-StatelessBean.shtml
 * Updated to jakarta EJB 4
 */
package net.roseindia.ejb4.stateless.example;

import jakarta.ejb.Remote;

/**
 *
 * An interface for Remote Calcuilator bean
 */
@Remote
public interface CalculatorRemote {

    /**
     *
     * @param x
     * @param y
     * @return x + y
     */
    public float add(float x, float y);

    /**
     *
     * @param x
     * @param y
     * @return x - y
     */
    public float subtract(float x, float y);

    /**
     *
     * @param x
     * @param y
     * @return x * y
     */
    public float multiply(float x, float y);

    /**
     *
     * @param x
     * @param y
     * @return x / y
     */
    public float division(float x, float y);
}
