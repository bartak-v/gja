package com.vut.fit.gja.jersey.controller;

import com.vut.fit.gja.jersey.entity.Item;
import com.vut.fit.gja.jersey.entity.ItemOrder;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import com.vut.fit.gja.jersey.repository.ItemRepository;

/**
 *
 * A Controller class showing work with user input.
 */
@Path("/items")
public class Arguments {

    /**
     * Method handling HTTP GET requests with path parameter. Client requests an
     * item with specific id. The @Path annotation extends class annotation
     *
     * @param id
     * @return String that represents the item (may be fetched from DB) try curl
     * http://localhost:8080/jersey/example/items/4 or open in browser
     *
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Item getItem(@PathParam("id") Integer id) {
        
        ItemRepository repository = new ItemRepository();
        return repository.findItemsById(id);
    }

    /**
     * Method handling HTTP GET requests with query parameter. Client uses some
     * search functionality and wants to filter items by name
     *
     * @param name
     * @return String that represents items (may be fetched from DB) try curl
     * http://localhost:8080/jersey/example/items/search?name=jogurt or open in browser
     *
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/search")
    public ArrayList<Item> searchForItems(@QueryParam("name") String name) {

        ItemRepository repository = new ItemRepository();
        return repository.findItemsByName(name);
    }

    /**
     * Method handling HTTP POST requests with form submission. Client orders
     * items of some quantity on some address using form inputs
     *
     *
     * @param deliveryAddress
     * @param quantity
     * @return String that contains submitted values. Try curl -X POST -H \
     * 'Content-Type:application/x-www-form-urlencoded' \ -d
     * 'deliveryAddress=Brno VUT FIT{@literal &}quantity=500' \
     * http://localhost:8080/jersey/example/items/place-order
     *
     */
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/place-order")
    public String itemShipment(
            @FormParam("deliveryAddress") String deliveryAddress,
            @FormParam("quantity") Long quantity) {
        return "Form parameters are [deliveryAddress=" + deliveryAddress + ", quantity=" + quantity + "]";
    }

    /**
     * Method handling HTTP POST requests with form submission.To process a
     * specific combination of parameters it is possible to use a bean as
     * parameters template. This example uses class ItemOrder, which is a set of
     * a header, path and form parameter.
     *
     * @param itemOrder
     * @return String that contains submitted values. Try curl -X POST -H \
     * 'Content-Type:application/x-www-form-urlencoded' --header \
     * 'coupon:FREE10p' -d total=70 http://localhost:8080/jersey/example/items/28711
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ItemOrder itemOrder(@BeanParam ItemOrder itemOrder) {
        return itemOrder;
    }

}
