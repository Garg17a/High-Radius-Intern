package dumb.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import dumb.jdbc.jdbc_code;
import dumb.pojo.pojo_code;
public class crud_code {
	public ArrayList<pojo_code> getData()
	{
		ArrayList<pojo_code> ALLpojo_code =new ArrayList<pojo_code>();
		int sl_no;
	    String business_code;
	    int cust_number;
	    String clear_date;
	    int buisness_year;
	    String doc_id;
	    String posting_date;
	    String document_create_date;
	    String document_create_date1;
	    String due_in_date;
	    String invoice_currency;
	    String document_type;
	    int posting_id;
	    String area_business;
	    double total_open_amount;
	    String baseline_create_date;
	    String cust_payment_terms;
	    int invoice_id;
	    int isOpen;
	    String aging_bucket;
	    int is_deleted;
		try {
		 Connection con = jdbc_code.initializeDatabase();
		 String sql_query="SELECT * from winter_internship";
		 PreparedStatement pst = con.prepareStatement(sql_query);
		 //System.out.println(pst);
		 
		 ResultSet rs = pst.executeQuery();
		
		 while(rs.next())
		 {
				pojo_code s = new pojo_code();
				sl_no = rs.getInt("sl_no");
		          business_code = rs.getString("business_code");
		          cust_number = rs.getInt("cust_number");
		          clear_date = rs.getString("clear_date");
		          buisness_year = rs.getInt("buisness_year");
		          doc_id = rs.getString("doc_id");
		          posting_date = rs.getString("posting_date");
		          document_create_date = rs.getString("document_create_date");
		          document_create_date1 = rs.getString("document_create_date1");
		          due_in_date = rs.getString("due_in_date");
		          invoice_currency = rs.getString("invoice_currency");
		          document_type = rs.getString("document_type");
		          posting_id = rs.getInt("posting_id");
		          area_business = rs.getString("area_business");
		          total_open_amount = rs.getDouble("total_open_amount");
		          baseline_create_date = rs.getString("baseline_create_date");
		          cust_payment_terms = rs.getString("cust_payment_terms");
		          invoice_id = rs.getInt("invoice_id");
		          isOpen = rs.getInt("isOpen");
		          aging_bucket = rs.getString("aging_bucket");
		          is_deleted = rs.getInt("is_deleted");
		         
		         //System.out.println("ID is "+id+" "+"Name is "+Name);
		         
		         s.setSl_no(sl_no);
		         s.setBusiness_code(business_code);
		         s.setCust_number(cust_number);
		         s.setClear_date(clear_date);
		         s.setBuisness_year(buisness_year);
		         s.setDoc_id(doc_id);
		         s.setPosting_date(posting_date);
		         s.setDocument_create_date(document_create_date);
		         s.setDocument_create_date1(document_create_date1);
		         s.setDue_in_date(due_in_date);
		         s.setInvoice_currency(invoice_currency);
		         s.setDocument_type(document_type);
		         s.setPosting_id(posting_id);
		         s.setArea_business(area_business);
		         s.setTotal_open_amount(total_open_amount);
		         s.setBaseline_create_date(baseline_create_date);
		         s.setCust_payment_terms(cust_payment_terms);
		         s.setInvoice_id(invoice_id);
		         s.setIsOpen(isOpen);
		         s.setAging_bucket(aging_bucket);
		         s.setIs_deleted(is_deleted);
				
				ALLpojo_code.add(s);
				
				
		 }
		 
		 for(pojo_code stud: ALLpojo_code)
		 {
			 System.out.println(stud.toString());
		 }
		 
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception occur");
		}
		
		return ALLpojo_code;
		
	
	}
}
