package com.opencmis.server;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * HelloWorldServlet class
 */
public class HelloWorldServlet extends HttpServlet {

    private final static Logger LOG = LoggerFactory.getLogger(HelloWorldServlet.class.getName());

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //Write to console
        System.out.println("Log4j DEBUG Level enabled: " + LOG.isDebugEnabled());
        System.out.println("Log4j TRACE Level enabled: " + LOG.isTraceEnabled());
        //Write error to console
        System.err.println("Write some error to the console...");

        //Log4j write to log message
        LOG.info("INFO doGet method '{}'.", LOG);
        LOG.warn("WARN doGet method '{}'.", LOG);
        LOG.error("ERROR doGet method '{}'.", LOG);
        LOG.debug("DEBUG doGet method '{}'.", LOG);
        LOG.trace("TRACE doGet method '{}'.", LOG);

        //get <init-param> from servlet configuration
        System.out.println("Context init param - \"email\": " + getServletContext().getInitParameter("email"));
        System.out.println("Servlet init param - \"name\": " + getServletConfig().getInitParameter("name"));

        try {
            throw new IOException();
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }

        // Set the response message's MIME type.
        response.setContentType("text/html;charset=UTF-8");
        // Allocate a output writer to write the response message into the network socket.
        PrintWriter out = response.getWriter();

        // Write the response message, in an HTML document.
        try {
            out.println("<!DOCTYPE html>");  // HTML 5
            out.println("<html><head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<title>Servlet 2.5 Example</title></head>");
            out.println("<body>");
            out.println("<h1>Hello World!</h1>");  // Prints "Hello, world!"
            // Set a hyperlink image to refresh this page
            out.println("<a href='" + request.getRequestURI() + "'><img src='images/return.gif'></a>");
            out.println("</body></html>");
        } finally {
            out.close();  // Always close the output writer
        }
    }

}
