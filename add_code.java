package dumb.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dumb.jdbc.jdbc_code;

@WebServlet("/add")
public class add_code extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doPost(HttpServletRequest request, 
			 HttpServletResponse response)
			         throws ServletException, IOException
			     {
			         try {
			        	 String business_code =  request.getParameter("business_code");
			             int  cust_number = Integer.valueOf(request.getParameter("cust_number"));
			             String clear_date = request.getParameter("clear_date");
			             int buisness_year = Integer.valueOf(request.getParameter("buisness_year"));
			             String doc_id = request.getParameter("doc_id");
			             String posting_date = request.getParameter("posting_date");
			             String document_create_date = request.getParameter("document_create_date");
			             String due_in_date = request.getParameter("due_in_date");


			             String invoice_currency = request.getParameter("invoice_currency");
			             String document_type = request.getParameter("document_type");
			             int posting_id = Integer.valueOf(request.getParameter("posting_id"));

			             double total_open_amount =Double.valueOf(request.getParameter("total_open_amount"));

			             String baseline_create_date = request.getParameter("baseline_create_date");
			             String cust_payment_terms = request.getParameter("cust_payment_terms");
			             int invoice_id = Integer.valueOf(request.getParameter("invoice_id"));

			   
			             
			             Connection con = jdbc_code.initializeDatabase();
			   
			             PreparedStatement st = con
			                    .prepareStatement("insert into winter_internship (business_code, cust_number, clear_date, buisness_year, doc_id, posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			   
			             // For the first parameter,
			             // get the data using request object
			             // sets the data to st pointer
			             st.setString(1, business_code);
			 			st.setInt(2,cust_number);
			 			st.setString(3, clear_date);
			 			
			 			st.setInt(4,buisness_year);

			 			st.setString(5, doc_id);
			 			st.setString(6,  posting_date);
			 			st.setString(7, document_create_date);
			 			st.setString(8, due_in_date);

			 			st.setString(9, invoice_currency);
			 			
			 			st.setString(10, document_type);
			 			st.setInt(11,posting_id);
			 			st.setDouble(12,total_open_amount);


			 			st.setString(13, baseline_create_date);
			 			st.setString(14, cust_payment_terms);
			 			st.setInt(15,invoice_id);



			             
			   
			             // Execute the insert command using executeUpdate()
			             // to make changes in database
			             st.executeUpdate();
			   
			             // Close all the connections
			             st.close();
			             con.close();
			   
			             // Get a writer pointer 
			             // to display the successful result
			             //System.out.println(l);
			             PrintWriter out = response.getWriter();
			             out.println("<html><body><b>Successfully Inserted"
			                         + "</b></body></html>");
			         }
			         catch (Exception e) {
			             e.printStackTrace();
			         }
			      
			     }
	
}
