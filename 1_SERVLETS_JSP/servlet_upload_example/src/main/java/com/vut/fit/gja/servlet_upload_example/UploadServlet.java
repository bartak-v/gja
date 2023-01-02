package com.vut.fit.gja.servlet_upload_example;

import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.PrintWriter;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;

/**
 * An example of HTTP Servlet using Jakarta EE 10 API. This is current example
 * for a FileUpload using Servlet 3.0+. It also showcases custom ServletError
 * error handling.
 *
 * @author xbarta47
 */
// This annotation specifies that this servlet will handle file uploads and
// limits of these files.
@MultipartConfig(
        // 0,5 MB the file will be stored onto the disk if it is bigger than this.
        fileSizeThreshold = (1024 * 1024) / 2,
        // 2 MB
        maxFileSize = 2 * 1024 * 1024,
        // 10 MB max for all files uploaded in one request.
        maxRequestSize = 100 * 1024 * 1024)
@WebServlet(name = "FileUpload", urlPatterns = {"/FileUpload"})
public class UploadServlet extends HttpServlet {

    // Specify explicit serialVersionUID for correct serialization. 
    private static final long serialVersionUID = 42L;

    //Temporary Windows and Linux solution for uploading directory.
    private static final String UPLOAD_DIRECTORY = System.getProperty("java.io.tmpdir");

    private static final String HTML_HEADER = "<!DOCTYPE html>\n"
            + "<html>\n"
            + "    <head>\n"
            + "        <title>File Upload Servlet Example</title>\n"
            + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
            + "        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" \n"
            + "              integrity=\"sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD\" crossorigin=\"anonymous\">\n"
            + "    </head>\n"
            + "    <body>"
            + "<div class=\"card w-50 mx-auto my-5 text-center\">\n"
            + "        <div class=\"card-header text-info\">\n"
            + "            GJA - Jakarta EE 10 Upload Servlet Example\n"
            + "        </div>\n"
            + "        <div class=\"card-body\">\n";
    private String HTML_FOOTER;

    // Root context path of the servlet (index.html)
    private String contextPath;

    /**
     * Default no-arg constructor.
     */
    public UploadServlet() {
        super();
    }

    /**
     * Override the parent's init() method.
     *
     * @param config Configuration object
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        contextPath = super.getServletContext().getContextPath();

        HTML_FOOTER = "</div>\n"
                + "<div class=\"card-footer text-muted\">\n"
                + "<a href=\"" + contextPath + "\">Go back to upload.</a>\n"
                + "</div>\n"
                + "</div>\n"
                + "</body>\n"
                + "</html>";

        if (!new File(UPLOAD_DIRECTORY).isDirectory()) {
            throw new ServletException(UPLOAD_DIRECTORY + " is not a directory");
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(HTML_HEADER);
            out.println("<h4 class=\"card-title\"><strong>File Upload Servlet</strong></h4>\n");
            out.println(HTML_FOOTER);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Print the HTML header
            out.println(HTML_HEADER);
            // Check if a file was actually uploaded
            Part filePart = request.getPart("file");
            if (filePart == null || filePart.getSubmittedFileName().isEmpty()) {
                out.println("<h1>No file uploaded.</h1>");
                out.println(HTML_FOOTER);
                return;
            }
            // Get the uploaded filename
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

            // Validate the file's extension
            if (!fileName.endsWith(".jpg") && !fileName.endsWith(".jpeg") && !fileName.endsWith(".png")) {
                out.println("<h1>Invalid file type - .jpg, .jpeg, and .png are allowed.</h1>");
                out.println(HTML_FOOTER);
                return;
            }
            // Save the file to the specified location
            try (InputStream inputStream = filePart.getInputStream()) {
                Files.copy(inputStream, Paths.get(UPLOAD_DIRECTORY + fileName), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                out.println("<h1>Error while uploading the file.</h1>");
                out.println(HTML_FOOTER);
            }

            // Print the HTML page
            out.println("            <h4 class=\"card-title\"><strong>File " + fileName + " uploaded.</strong></h4>\n"
                    + "            <div class=\"rounded m-3 p-3 border text-danger\"> Your guess 7 is too low. Try again.</div>\n");
            out.println(HTML_FOOTER);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "An example of HTTP Servlet using Jakarta EE 10 API.";
    }

}
