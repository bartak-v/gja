package com.vut.fit.gja.jersey.repository;

import com.vut.fit.gja.jersey.entity.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * A Class representing repository for Item entity.
 */
public class ItemRepository {

    private final List<Item> database = new ArrayList();

    /**
     * Instantiate Repository with 4 default records "jogurt", "bread", "milk"
     * and "apple".
     */
    public ItemRepository() {

        database.add(new Item(1, "jogurt"));
        database.add(new Item(2, "bread"));
        database.add(new Item(3, "milk"));
        database.add(new Item(4, "apple"));
    }

    /**
     *
     * @param name search
     * @return list of items with matching name
     */
    public ArrayList<Item> findItemsByName(String name) {

        ArrayList<Item> found = new ArrayList();
        for (Item item : database) {
            if (item.getName().equals(name)) {
                found.add(item);
            }
        }
        return found;
    }

    /**
     * Returns Item with matching id. If no matching item is found, null
     * returned.
     *
     * @param id search
     * @return item with matching id
     */
    public Item findItemsById(int id) {

        for (Item item : database) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
