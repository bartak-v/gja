/*
 * Project: Examples for GJA course
 * Author: Ing. Jaroslav Dytrych idytrych@fit.vutbr.cz
 * File: Entry.java
 * Description: Calendar entry
 */

/**
 * @file Entry.java
 *
 * @brief Calendar entry
 */

package cz.vutbr.fit.knot.gja.calendar;

/**
 * Calendar entry
 * 
 * @brief Calendar entry
 */
public class Entry {

  /** Hour */
  private String hour;
  /** Entry description */
  private String description;
  /** Color */
  private String color;

  /**
   * Constructor
   * 
   * @param hour Hour to which entry should be placed
   */
  public Entry(String hour) {
    this.hour = hour;
    this.description = "";
  }

  /**
   * Gets hour
   * 
   * @return Returns hour
   */
  public String getHour() {
    return this.hour;
  }

  /**
   * Gets color
   * 
   * @return Returns color
   */
  public String getColor() {
    if (description.equals("")) {
      return "lightblue";
    } else {
      return "red";
    }
  }

  /**
   * Gets description
   * 
   * @return Returns description
   */
  public String getDescription() {
    if (description.equals("")) {
      return "None";
    } else {
      return this.description;
    }
  }

  /**
   * Sets description
   * 
   * @param descr New description
   */
  public void setDescription(String descr) {
    description = descr;
  }
}  // public class Entry