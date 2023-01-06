/*
 * Project: Examples for GJA course
 * Author: Ing. Jaroslav Dytrych idytrych@fit.vutbr.cz
 * Refactored: Bc. Vít Barták xbarta47@stud.fit.vutbr.cz
 * File: MailBean.java
 * Description: Example email
 */
/**
 * @file DummyCart.java
 *
 * Example email
 */
/**
 * @package cz.vutbr.fit.knot.gja.mail
 *
 * Example email form
 */
package cz.vutbr.fit.knot.gja.mail;

/**
 * Example email
 */
public class MailBean {

    /**
     * Sender address
     */
    private String mailfrom;
    /**
     * Receiver address
     */
    private String mailto;
    /**
     * Subject
     */
    private String mailsubject;
    /**
     * Content
     */
    private String mailcontent;

    /**
     * Sets sender address
     *
     * @param m New sender address
     */
    public void setMailfrom(String m) {
        mailfrom = m;
    }

    /**
     * Gets sender address
     *
     * @return Sender's address
     */
    public String getMailfrom() {
        return mailfrom;
    }

    /**
     * Sets receiver address
     *
     * @param m New receiver address
     */
    public void setMailto(String m) {
        mailto = m;
    }

    /**
     * Gets receiver address
     *
     * @return Receiver's address
     */
    public String getMailto() {
        return mailto;
    }

    /**
     * Sets subject
     *
     * @param s New subject
     */
    public void setMailsubject(String s) {
        mailsubject = s;
    }

    /**
     * Gets subject
     *
     * @return Subject
     */
    public String getMailsubject() {
        return mailsubject;
    }

    /**
     * Sets content
     *
     * @param c New content
     */
    public void setMailcontent(String c) {
        mailcontent = c;
    }

    /**
     * Gets content
     *
     * @return Content
     */
    public String getMailcontent() {
        return mailcontent;
    }
}  // public class MailBean