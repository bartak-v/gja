/*
 * Project: Examples for GJA course
 * Author: Ing. Jaroslav Dytrych idytrych@fit.vutbr.cz
 * File: Entries.java
 * Description: Storage for calendar entries
 */

/**
 * @file Entries.java
 *
 * @brief Storage for calendar entries
 */

/**
 * @package cz.vutbr.fit.knot.gja.calendar
 * 
 * @brief Example calendar
 */
package cz.vutbr.fit.knot.gja.calendar;

import java.util.HashMap;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Storage for calendar entries
 * 
 * @bief Storage for calendar entries
 */
public class Entries {

  /** Map with calendar entries */
  private HashMap<String, Entry> entries;
  /** Usable times */
  private static final String[] TIME = {"8am", "9am", "10am", "11am", "12pm",
                                        "1pm", "2pm", "3pm", "4pm", "5pm", "6pm",
                                        "7pm", "8pm"};
  /** Number of rows */
  public static final int rows = 12;

  /**
   * Constructor
   */
  public Entries() {
    entries = new HashMap(rows);
    // Create entries for all rows
    for (int i = 0; i < rows; i++) {
      entries.put(TIME[i], new Entry(TIME[i]));
    }
  }

  /**
   * Gets number of rows
   * 
   * @return Returns number of rows
   */
  public int getRows() {
    return rows;
  }

  /**
   * Gets entry on given row
   * 
   * @param row Row
   * @return Returtns entry on given row
   */
  public Entry getEntry(int row) {
    return this.entries.get(TIME[row]);
  }

  /**
   * Gets row of given time
   * 
   * @param tm Time
   * @return Returns row of given time
   */
  public int getRow(String tm) {
    for (int i = 0; i < rows; i++) {
      if (tm.equals(TIME[i])) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Processes request for change of given row
   * 
   * @param request Request
   * @param tm Time for specification of row
   */
  public void processRequest(HttpServletRequest request, String tm) {
    int index = getRow(tm);  // find row
    if (index >= 0) {  // if row exists
      String descr = request.getParameter("description");
      entries.get(TIME[index]).setDescription(descr);
    }
  }
}  // public class Entries
