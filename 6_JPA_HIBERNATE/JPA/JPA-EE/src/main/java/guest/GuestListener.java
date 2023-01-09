/*
 * Adapted from http://www.objectdb.com/tutorial/jpa/eclipse/web/listener
 */
package guest;

import javax.persistence.*;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletContextEvent;

/**
 *
 * ServletContextListener that creates entity manager to local ObjectDB database
 * and saves it into servlet context. On context destroy, closes the entity
 * manager
 */
public class GuestListener implements ServletContextListener {

    /**
     * Prepare the EntityManagerFactory {@literal &} Enhance
     * @param e server context event
     */
    @Override
    public void contextInitialized(ServletContextEvent e) {
        com.objectdb.Enhancer.enhance("guest.*");
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("$objectdb/db/guest.odb");
        e.getServletContext().setAttribute("emf", emf);
    }

    // 

    /**
     * Release the EntityManagerFactory
     * @param e server context event
     */
    @Override
    public void contextDestroyed(ServletContextEvent e) {
        EntityManagerFactory emf
                = (EntityManagerFactory) e.getServletContext().getAttribute("emf");
        emf.close();
    }
}
