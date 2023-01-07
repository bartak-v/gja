/*
 * Adapted from http://www.objectdb.com/tutorial/jpa/netbeans/ee/entity
 */
package guest;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * A simple serializable guest entity to save information about guests to the
 * DB.
 */
@Entity
public class Guest implements Serializable {

    private static final long serialVersionUID = 1L;

    // Persistent Fields:
    @Id
    @GeneratedValue
    Long id;
    private String name;
    private Date signingDate;

    /**
     * Empty constructor for serialization
     */
    public Guest() {
    }

    /**
     * Initializes signingDate to current
     *
     * @param name
     */
    public Guest(String name) {
        this.name = name;
        this.signingDate = new Date(System.currentTimeMillis());
    }

    /**
     *
     * @return string representation with name and date
     */
    @Override
    public String toString() {
        return name + " (signed on " + signingDate + ")";
    }
}
