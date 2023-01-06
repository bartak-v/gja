/*
 * Project: Examples for GJA course
 * Author: Ing. Jaroslav Dytrych idytrych@fit.vutbr.cz
 * File: DummyCart.java
 * Description: Example dummy shopping cart
 */

/**
 * @file DummyCart.java
 *
 * @brief Example dummy shopping cart
 */

/**
 * @package cz.vutbr.fit.knot.gja.cart
 * 
 * @brief Example dummy shopping cart
 */
package cz.vutbr.fit.knot.gja.cart;

import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Example dummy shopping cart
 * 
 * @brief Example dummy shopping cart
 */
public class DummyCart {

  /** List of items */
  private ArrayList<String> list = new ArrayList<String>();
  /** Synchronized list of items */
  private List<String> synList = Collections.synchronizedList(list);
  /** Submission indicator */
  private String submit = null;
  /** Edited item */
  private String item = null;

  /**
   * Adds item to cart
   * 
   * @param name Name of item
   */
  private void addItem(String name) {
    synList.add(name);
  }

  /**
   * Removes item from cart
   * 
   * @param name Name of item
   */
  private void removeItem(String name) {
    synList.remove(name);
  }

  /**
   * Sets edited item name
   * 
   * @param name Name of item
   */
  public void setItem(String name) {
    item = name;
  }

  /**
   * Sets submission indicator
   * 
   * @param s Submission indicator value
   */
  public void setSubmit(String s) {
    submit = s;
  }

  /**
   * Gets array of items
   * 
   * @return Returns array of items
   */
  public List<String> getItems() {
    return synList;
  }

  /**
   * Processes HTTP request
   * 
   * @param request HTTP request
   */
  public void processRequest(HttpServletRequest request) {
    // null value for submit - user hit enter instead of clicking on 
    // "add" or "remove"
    if (submit == null) {
      addItem(item);
    }

    if (submit.equals("add")) {
      addItem(item);
    } else if (submit.equals("remove")) {
      removeItem(item);
    }

    // reset at the end of the request
    reset();
  }

  /**
   * Reset form
   */
  private void reset() {
    submit = null;
    item = null;
  }
}  // public class DummyCart
