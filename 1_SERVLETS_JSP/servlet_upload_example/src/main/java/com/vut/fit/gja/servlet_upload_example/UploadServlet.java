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
            + "    <body>";
    private static final String HTML_FOOTER = "</body>\n"
            + "</html>";

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
        if (!new File(UPLOAD_DIRECTORY).isDirectory()) {
            throw new ServletException(UPLOAD_DIRECTORY + " is not a directory");
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UploadServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href=\"" + contextPath + "\">Go back to upload.</a>");
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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

        PrintWriter out = response.getWriter();
        // Check if a file was actually uploaded
        Part filePart = request.getPart("file");
        if (filePart == null || filePart.getSubmittedFileName().isEmpty()) {
            out.println("<h1>No file uploaded.</h1> <a href=\"" + contextPath + "\">Go back to upload.</a>");
            return;
        }
        // Get the uploaded filename
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        // Validate the file's extension
        if (!fileName.endsWith(".jpg") && !fileName.endsWith(".jpeg") && !fileName.endsWith(".png")) {
            out.println("<h1>Invalid file type - .jpg, .jpeg, and .png are allowed.</h1> <a href=\"" + contextPath + "\">Go back to upload.</a>");
            return;
        }
        // Save the file to the specified location
        try (InputStream inputStream = filePart.getInputStream()) {
            Files.copy(inputStream, Paths.get(UPLOAD_DIRECTORY + fileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            out.println("<h1>Error while uploading the file.</h1> <a href=\"" + contextPath + "\">Go back to upload.</a>");
        }

        out.println("<h1>"); // TODO remove

        // Print the HTML page
        out.println(HTML_HEADER);
        out.println("<div class=\"card w-50 mx-auto my-5 text-center\">\n"
                + "        <div class=\"card-header text-info\">\n"
                + "            GJA - Jakarta EE 10 Upload Servlet Example\n"
                + "        </div>\n"
                + "        <div class=\"card-body\">\n"
                + "            <h4 class=\"card-title\"><strong>Random Number Guesser Game</strong></h4>\n"
                + "            <p class=\"card-text\">File " + fileName + " uploaded.</h1></p>\n"
                + "            <a href=\"#\" class=\"btn btn-primary\">Guess</a>\n"
                + "            <div class=\"d-flex mx-auto w-50 my-3 flex-row justify-content-center\">\n"
                + "                <div class=\"p-2 mx-1 flex-fill rounded border border-secondary\">User: 5 </div>\n"
                + "                <div class=\"p-2 mx-1 flex-fill rounded border border-secondary\">Score: 5</div>\n"
                + "                <div class=\"p-2 mx-1 flex-fill rounded border border-secondary\">Record: 5</div>\n"
                + "            </div>\n"
                + "            <div class=\"rounded m-3 p-3 border text-danger\"> Your guess 7 is too low. Try again.</div>\n"
                + "        </div>\n"
                + "        <div class=\"card-footer text-muted \">\n"
                + "            Number of guesses <div class=\"text-danger\">3 of 3</div>\n"
                + "        </div> <a href=\"" + contextPath + "\">Go back to upload.</a>\n"
                + "    </div>");
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
