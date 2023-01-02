package com.vut.fit.gja.servlet_upload_example;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * An example of ErrorHandlerServlet that prints Errors / Exceptions in a custom
 * HTML template. web.xml specifies this servlet as an error handler.
 *
 * @author xbarta47
 */
@WebServlet(name = "ErrorHandlerServlet", urlPatterns = {"/ErrorHandlerServlet"})
public class ErrorHandlerServlet extends HttpServlet {

    // Specify explicit serialVersionUID for correct serialization. 
    private static final long serialVersionUID = 424242L;

    /**
     * Override the parent's init() method.
     *
     * @param config Configuration object
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /**
     * Handles the HTTP <code>GET</code> method. A custom handling / printing of
     * an error from other servlets (or other Jakarta modules potentially).
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Throwable throwable = (Throwable) request
                .getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        Integer statusCode = (Integer) request
                .getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String servletName = (String) request
                .getAttribute(RequestDispatcher.ERROR_SERVLET_NAME);
        if (servletName == null) {
            servletName = "Unknown";
        }
        String requestUri = (String) request
                .getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
        if (requestUri == null) {
            requestUri = "Unknown";
        }

        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.write("<h1>Error Details</h1>");
        out.write("<p>Status Code: " + statusCode + "</p>");
        out.write("<p>Request URI: " + requestUri + "</p>");
        out.write("<p>Servlet Name: " + servletName + "</p>");
        if (throwable != null) {
            out.write("<p>Exception Message: " + throwable.getMessage() + "</p>");
        }
    }
}
