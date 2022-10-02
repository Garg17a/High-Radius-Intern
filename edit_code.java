package dumb.servlet;

import java.sql.PreparedStatement;
import dumb.jdbc.jdbc_code;
import java.sql.Connection;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
@WebServlet({ "/EditInvoice" })
public class edit_code extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
}
	 protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
	        try {
	            final String fieldValue = request.getParameter("sl_no");
	            final int field = Integer.parseInt(fieldValue);
	            final String invoice_currency = request.getParameter("invoice_currency");
	            final String cust_payment_terms = request.getParameter("cust_payment_terms");
	            Connection con = jdbc_code.initializeDatabase();
	            final String query = "UPDATE winter_internship SET invoice_currency = ?, cust_payment_terms = ? WHERE sl_no = ?";
	            final PreparedStatement st = con.prepareStatement(query);
	            st.setString(1, invoice_currency);
	            st.setString(2,cust_payment_terms );
	            st.executeUpdate();
	            con.close();
	            
	        }
	        catch (Exception ex) {
	        	
	        
	        }
	    }
	}
