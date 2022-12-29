package com.vut.fit.gja.servlet_jsp_example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * An example of HTTP Servlet using Jakarta EE 10 API. This is an easy random
 * number guesser game, using Cookies for simple session management. The purpose
 * of this example is to showcase a servlet above "Hello World" that utilizes
 * simple session management through cookies.
 *
 * @author xbarta47
 */
public class RandomNumGuessSrv extends HttpServlet {

    // Specify explicit serialVersionUID for correct serialization. 
    private static final long serialVersionUID = 42L;

    // Number guessed by user, number of guesses, random number
    private int numGuessed, numGuesses, secretNumber, score, highestScore;
    private Random random; // Instance of the Random class    
    private String username; // User's score and name

    /**
     * Default no-arg constructor.
     */
    public RandomNumGuessSrv() {
        super();
    }

    /**
     * Override the parent's init() method. Use it for initializing of variables
     * needed for the game.
     *
     * @throws ServletException if a servlet-specific error occurs
     */
    @Override
    public void init() throws ServletException {
        // Generate a random number between 1 and 10
        random = new Random();
        secretNumber = random.nextInt(10) + 1;
        // Keep track of the number of guesses the user has made
        numGuesses = 0;
        numGuessed = 100;
        username = "";
        score = 0;
        highestScore = 0;
    }

    /**
     * Override the parent's destroy() method. Shown here only for demonstration
     * purposes. Perform cleanup tasks - we don't have to here, since Java has
     * garbage collection.
     */
    @Override
    public void destroy() {
    }

    /**
     * Processes requests for HTTP <code>GET</code>, <code>POST</code>,
     * <code>PUT</code> and <code>DELETE</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String uname = request.getParameter("uname");
        if (uname != null && !uname.isEmpty()) {
            response.addCookie(new Cookie("uname", uname));
            username = uname;
        } else {
            Cookie cookies[] = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    switch (cookie.getName()) {
                        case "uname":
                            username = cookie.getValue();
                            break;
                        case "uscore":
                            score = Integer.parseInt(cookie.getValue());
                            break;
                        case "uhscore":
                            highestScore = Integer.parseInt(cookie.getValue());
                            break;
                    }
                }
            }
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link href="
                    + "\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2"
                    + "/dist/css/bootstrap.min.css\" rel=\"stylesheet\" "
                    + "integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQ"
                    + "TwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">");
            out.println("<title>Random Number Guesser</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"d-flex flex-column justify-content-center\">");

            out.println("<div class=\"card font-weight-bold p-2 mx-auto w-50\"><h1>Random Number Guesser Game</h1>");
            out.println("<h5>Guess random number from 1 to 10, you win if you guess it correctly "
                    + "in 3 tries.</h5>");

            out.println("<form action=\"/servlet_jsp_example/ExampleServlet\" method=\"POST\">");

            if (username.equals("")) {
                out.println("<label for=\"uname\">Username:</label>");
                out.println("<input required=\"true\" type=\"text\" id=\"uname\" name=\"uname\"><br><br>");
            } else {
                out.println("<label> Hello " + username + " your highest score is: [" + highestScore + "]<br><br>");
            }

            out.println("<label for=\"unum\">Number guessed:</label>");
            out.println("<input required=\"true\" type=\"text\" id=\"unum\" name=\"unum\"><br><br>");
            out.println("<button class=\"btn btn-primary\" type=\"submit\">GUESS</button>");
            out.println("</form>");
            switch (request.getMethod()) {
                case "DELETE":
                    out.println("<h1>Game has been forcefully restarted. "
                            + "All cookies have been deleted.</h1>");
                    out.println("<h1>Secret number was " + secretNumber + "</h1>");
                    break;
                case "PUT":
                    out.println("<h1>Game has been forcefully restarted.");
                    out.println("<h1>Secret number was " + secretNumber + "</h1>");
                    break;
                case "POST":
                    runGame(request, response);
                    break;
                default:
                    break;
            }
            out.println("<hr class=\"hr\" /><h5 class=\"text-center\">Number of "
                    + "guesses " + numGuesses + " of 3 </h5><hr class=\"hr\" />");
            out.println("</div></div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the game logic.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void runGame(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        numGuessed = Integer.parseInt(request.getParameter("unum"));
        PrintWriter writer = response.getWriter();
        // Increment the number of guesses
        numGuesses++;

        if (numGuesses > 3) {
            writer.println("You ran out of guesses. The game "
                    + "has been restarted.");
            init();
            // Restart the score.
            response.addCookie(new Cookie("uscore", Integer.toString(score)));
            return;
        }

        // Check if the guess is correct
        if (numGuessed == secretNumber) {
            writer.println("Congratulations! You guessed "
                    + "the secret number " + secretNumber + " in " + numGuesses + " guesses.");
            writer.println("Restarting the game.");
            score += 1;
            response.addCookie(new Cookie("uscore", Integer.toString(score)));
            if (score > highestScore) {
                response.addCookie(new Cookie("uhscore", Integer.toString(score)));
            }
            writer.println("<h4>Current score is:"
                    + " [" + score + "] </h4></label><br><br>");
            init();
        } else if (numGuessed < secretNumber) {
            writer.println("Your guess " + numGuessed + " is too low. Try again.");
            writer.println("<h4>Current score is:"
                    + " [" + score + "] </h4></label><br><br>");
        } else {
            writer.println("Your guess  " + numGuessed + " is too high. Try again.");
            writer.println("<h4>Current score is:"
                    + " [" + score + "] </h4></label><br><br>");

        }
    }

    /**
     * Handles the HTTP <code>GET</code> method. Draw the "index" webpage of the
     * game.
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
     * Handles the HTTP <code>POST</code> method. Handle the input from user
     * based on the cookies and his inputs.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>PUT</code> method. Restart the game while leaving
     * cookies.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        init();
    }

    /**
     * Handles the HTTP <code>DELETE</code> method. Clear cookies and restart
     * the game to the original state. Remove all cookies.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        init();
        Cookie cookie = new Cookie("uname", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        cookie = new Cookie("uscore", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        cookie = new Cookie("uhscore", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Random number guessing game using Cookies for saving session info.";
    }
}
