/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Try.NonBlocking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author arungup
 */
@WebServlet(name = "TestClient", urlPatterns = {"/TestClient"})
public class TestClient extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException if a servlet-specific error occurs
     * @throws java.io.IOException            if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestClient</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestClient at " + request.getContextPath() + "</h1>");

            String path = "http://"
                    + request.getServerName()
                    + ":"
                    + request.getServerPort()
                    + request.getContextPath()
                    + "/ReadTestServlet";
            out.println("Invoking the endpoint: " + path + "<br>");
            out.flush();
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setChunkedStreamingMode(2);
            conn.setDoOutput(true);
            conn.connect();
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));

            out.println("Sending data ..." + "<br>");
            out.flush();
            output.write("Hello");
            output.flush();
            out.println("Sleeping ..." + "<br>");
            out.flush();
            Thread.sleep(5000);
            out.println("Sending more data ..." + "<br>");
            out.flush();
            output.write("World");
            output.flush();
            output.close();

            out.println("Check GlassFish server.log");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException ex) {
            Logger.getLogger(ReadTestServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ReadTestServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet TestClient</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet TestClient at " + request.getContextPath() + "</h1>");
//
//            String path = "http://"
//                    + request.getServerName()
//                    + ":"
//                    + request.getServerPort()
//                    + request.getContextPath()
//                    + "/ReadTestServlet";
//            out.println("Invoking the endpoint: " + path + "<br>");
//            out.flush();
//            URL url = new URL(path);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setChunkedStreamingMode(2);
//            conn.setDoOutput(true);
//            conn.connect();
//            try (BufferedWriter output = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()))) {
//                out.println("Sending data ..." + "<br>");
//                out.flush();
//                output.write("Hello");
//                output.flush();
//                out.println("Sleeping ..." + "<br>");
//                out.flush();
//                Thread.sleep(5000);
//                out.println("Sending more data ..." + "<br>");
//                out.flush();
//                output.write("World");
//                output.flush();
//                output.close();
//            }
//            out.println("Check GlassFish server.log");
//            out.println("</body>");
//            out.println("</html>");
//        } catch (InterruptedException | IOException ex) {
//            Logger.getLogger(ReadTestServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException if a servlet-specific error occurs
     * @throws java.io.IOException            if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException if a servlet-specific error occurs
     * @throws java.io.IOException            if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
