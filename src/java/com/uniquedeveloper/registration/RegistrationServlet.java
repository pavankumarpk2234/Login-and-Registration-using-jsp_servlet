/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uniquedeveloper.registration;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author pavan
 */
@WebServlet(name = "register", urlPatterns = {"/register"})
public class RegistrationServlet extends HttpServlet {

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
            out.println("<title>Servlet RegistrationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        
        String uname = request.getParameter("name");
        String uemail = request.getParameter("email");
        String upwd = request.getParameter("pass");
        String Reupwd = request.getParameter("re_pass");
        String umobile = request.getParameter("contact");
        
        RequestDispatcher dispatcher = null;
        Connection con = null;
        
        int if1=1, if2=1, if3=1, if4=1, if5=1, elif=1;
        if(uname == null || uname.equals(""))
        {
            request.setAttribute("status", "invalidName");
            dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response); 
            if1=0;
        }
        if(uemail == null || uemail.equals(""))
        {
            request.setAttribute("status", "invalidEmail");
            dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response); 
            if2=0;
        }
        if(upwd == null || upwd.equals(""))
        {
            request.setAttribute("status", "invalidUpwd");
            dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response); 
            if3=0;
        }
        else if(!upwd.equals(Reupwd))
        {
            request.setAttribute("status", "invalidConfirmPassword");
            dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response); 
            elif=0;
        }
        if(umobile == null || umobile.equals(""))
        {
            request.setAttribute("status", "invalidMobile");
            dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response); 
            if4=0;
        }
        else if(umobile.length() > 10)
        {
            request.setAttribute("status", "invalidMobileLength");
            dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response); 
            if5=0;
        }
        
        if(if1==1 && if2==1 && if3==1 && if4==1 && if5==1 && elif==1)
        {
            try
            {
                String url="jdbc:mysql://localhost:3306/school";
                // step-1: Resister the driver.
                Class.forName("com.mysql.cj.jdbc.Driver");

                // step-2: get the connections.
                con = DriverManager.getConnection(url,"root","2234");
                //System.out.println("Connection established.");

                // step-3: create the statement object.
                PreparedStatement pst = con.prepareStatement("insert into users(uname, upwd, uemail, umobile) values(?, ?, ?, ?)");

                // step-4: Execute the queries.

                pst.setString(1, uname);
                pst.setString(2, upwd);
                pst.setString(3, uemail);
                pst.setString(4, umobile);

                int rowCount = pst.executeUpdate();
                dispatcher = request.getRequestDispatcher("registration.jsp");
                if(rowCount > 0)
                {
                    request.setAttribute("status", "success");
                }
                else
                {
                    request.setAttribute("status", "failed");
                }
                dispatcher.forward(request, response);

            }
            catch(IOException | ClassNotFoundException | SQLException | ServletException e)
            {

                //System.out.println(e);
            }
            finally
            {
                try {
                    // step-5: close the connection.
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        

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

/*
if(isValid(password)){
    db.register(username,email,password);
    Toast.makeText(getApplicationContext(), "Record inserted", Toast.LENGTH_SHORT).show();
    startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
}

public static boolean isValid(String passwordhere){
        int f1=0,f2=0,f3=0;
        if(passwordhere.length() < 8)
            return false;
        else{
            for(int p=0; p < passwordhere.length(); p++){
                if(Character.isLetter(passwordhere.charAt(p))){
                    f1=1;
                }
            }
            for(int r=0; r < passwordhere.length(); r++){
                if(Character.isDigit(passwordhere.charAt(r))){
                    f2=1;
                }
            }
            for(int s = 0; s < passwordhere.length(); s++){
                char c = passwordhere.charAt(s);
                if(c >= 33 && c <= 46 || c == 64){
                    f3=1;
                }
            }
            if(f1 == 1 && f2 ==1 && f3 == 1)
                return true;
            return false;
        }
    }
*/