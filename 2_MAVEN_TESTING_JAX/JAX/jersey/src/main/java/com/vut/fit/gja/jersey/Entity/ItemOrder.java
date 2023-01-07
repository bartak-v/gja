package com.vut.fit.gja.jersey.entity;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.PathParam;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * Item order Bean used to retrieve multiple user inputs at once.
 */
@XmlRootElement
public class ItemOrder {

    public ItemOrder() {
    }
    
    @HeaderParam("coupon")
    private String coupon;

    @PathParam("id")
    private Long id;

    @FormParam("total")
    private Double total;

    /**
     *
     * @return coupon header parameter
     */
    public String getCoupon() {
        return coupon;
    }

    /**
     *
     * @param coupon
     */
    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    /**
     *
     * @return id parh parameter
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return total form parameter
     */
    public Double getTotal() {
        return total;
    }

    /**
     *
     * @param total
     */
    public void setTotal(Double total) {
        this.total = total;
    }
}