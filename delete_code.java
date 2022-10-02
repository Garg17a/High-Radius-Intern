package dumb.servlet;

import java.sql.PreparedStatement;

import dumb.jdbc.jdbc_code;

import java.sql.Connection;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
@WebServlet({ "/Delete" })
public class delete_code extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
	        response.getWriter().append("Served at: ").append(request.getContextPath());
	    }
	    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
	        try {
	            final String fieldValue = request.getParameter("sl_no");
	            final int field = Integer.parseInt(fieldValue);
	            Connection con = jdbc_code.initializeDatabase();
	            final String query = "DELETE FROM winter_internship WHERE sl_no = ?";
	            final PreparedStatement st = con.prepareStatement(query);
	            st.setInt(1, field);
	            st.executeUpdate();
	            con.close();
	        }
	        catch (Exception e) {
	        	e.printStackTrace();
	        }
	    }
}
