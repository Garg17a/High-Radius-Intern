package dumb.servlet;

import javax.servlet.ServletException;
import com.google.gson.Gson;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.IOException;
import com.google.gson.GsonBuilder;
import dumb.jdbc.jdbc_code;

import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import dumb.pojo.pojo_code;
@WebServlet({ "/SearchInvoice" })
public class search_code extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
	        try {
	        	 Connection con = jdbc_code.initializeDatabase();
	            final String searchInvoice = request.getParameter("searchInvoice");
	            final Statement st = con.createStatement();
	            final String sql_statement = "SELECT * FROM winter_internship WHERE invoice_id='" + searchInvoice + "'";
	            final ResultSet rs = st.executeQuery(sql_statement);
	            final ArrayList<pojo_code> data = new ArrayList<pojo_code>();
	            while (rs.next()) {
	                final pojo_code inv = new pojo_code();
	                
	             
	                data.add(inv);
	            }
	            final Gson gson = new GsonBuilder().serializeNulls().create();
	            final String invoices = gson.toJson((Object)data);
	            response.setContentType("application/json");
	            try {
	                response.getWriter().write(invoices);
	            }
	            catch (IOException e) {
	                e.printStackTrace();
	            }
	            rs.close();
	            st.close();
	            con.close();
	        }
	        catch (SQLException e2) {
	            e2.printStackTrace();
	        }
	        catch (Exception e3) {
	            e3.printStackTrace();
	        }
	    }
	    
	    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
	        this.doGet(request, response);
	    }
}
