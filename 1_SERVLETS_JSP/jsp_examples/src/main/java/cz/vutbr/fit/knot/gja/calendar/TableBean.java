/*
 * Project: Examples for GJA course
 * Author: Ing. Jaroslav Dytrych idytrych@fit.vutbr.cz
 * File: TableBean.java
 * Description: Table for calendar
 */

/**
 * @file TableBean.java
 *
 * @brief Table for calendar
 */

package cz.vutbr.fit.knot.gja.calendar;

import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Table for calendar
 * 
 * @brief Table for calendar
 */
public class TableBean {

  /** Table data */
  private HashMap table;
  /** Calendar */
  private JspCalendar JspCal;
  /** List of entries to display */
  private Entries entries;
  /** Current date */
  private String date;
  /** User name */
  private String name = null;
  /** User email */
  private String email = null;
  /** Eroor indicator */
  private boolean processError = false;

  /**
   * Constructor
   */
  public TableBean() {
    this.table = new HashMap(10);
    this.JspCal = new JspCalendar();
    this.date = JspCal.getCurrentDate();
  }

  /**
   * Sets user name
   * 
   * @param nm New user name
   */
  public void setName(String nm) {
    this.name = nm;
  }

  /**
   * Gets user name
   * 
   * @return Returns user name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Sets user email
   * 
   * @param mail New user email
   */
  public void setEmail(String mail) {
    this.email = mail;
  }

  /**
   * Gets user email
   * 
   * @return Returns user email
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * Gets current date
   * 
   * @return Returns current date
   */
  public String getDate() {
    return this.date;
  }

  /**
   * Gets list of entries
   * 
   * @return Returns list of entries
   */
  public Entries getEntries() {
    return this.entries;
  }

  /**
   * Processes HTTP request
   * 
   * @param request HTTP request
   */
  public void processRequest(HttpServletRequest request) {

    // Get the name and e-mail.
    this.processError = false;
    if (name == null || name.equals("")) {
      setName(request.getParameter("name"));
    }
    if (email == null || email.equals("")) {
      setEmail(request.getParameter("email"));
    }
    if (name == null || email == null
            || name.equals("") || email.equals("")) {
      this.processError = true;
      return;
    }

    // Get the date.
    String dateR = request.getParameter("date");
    if (dateR == null) {
      date = JspCal.getCurrentDate();
    } else if (dateR.equalsIgnoreCase("next")) {
      date = JspCal.getNextDate();
    } else if (dateR.equalsIgnoreCase("prev")) {
      date = JspCal.getPrevDate();
    }

    // get entries for current date
    entries = (Entries) table.get(date);
    if (entries == null) {
      entries = new Entries();
      table.put(date, entries);
    }

    // If time is provided add the event.
    String time = request.getParameter("time");
    if (time != null) {
      entries.processRequest(request, time);
    }
  }  // processRequest()

  /**
   * Gets error indicator
   * 
   * @return If error occurred returns true, false otherwise
   */
  public boolean getProcessError() {
    return this.processError;
  }
}  // public class TableBean
