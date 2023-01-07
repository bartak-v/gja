package com.vut.fit.gja.jersey.entity;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * Dummy Item class
 */
@XmlRootElement
public class Item {

    private int id;
    private String name;

    /**
     *
     * @param id
     * @param name
     */
    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Empty Constructor
     */
    public Item() {

    }

    /**
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
