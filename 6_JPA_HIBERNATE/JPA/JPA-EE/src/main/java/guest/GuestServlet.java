/*
 * Adapted from http://www.objectdb.com/tutorial/jpa/netbeans/ee/servlet
 */
package guest;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import javax.persistence.*;

/**
 *
 * Handles HTTP requests, creates new guests and persists them.
 */
public class GuestServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Checks request parameter "name". If provided, method will create new
     * guest and persist it to the local ObjectDb. Sets request attribute
     * "guests" with all the guests retrieved from DB and forwards to guest.jsp
     *
     * @param request client request
     * @param response server response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtain a PersistenceManager instance:
        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();

        try {
            // Handle a new guest (if any):
            String name = request.getParameter("name");
            if (name != null) {
                em.getTransaction().begin();
                em.persist(new Guest(name));
                em.getTransaction().commit();
            }

            // Display the list of guests:
            List<Guest> guestList = em.createQuery("SELECT g FROM Guest g", Guest.class).getResultList();
            request.setAttribute("guests", guestList);
            request.getRequestDispatcher("/guest.jsp").forward(request, response);

        } finally {
            // Close the PersistenceManager:
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

    /**
     * Listens to POST request, calls doGet to make no difference between POST
     * and GET HTTP requests
     *
     * @param request client request
     * @param response server response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
