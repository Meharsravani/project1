package wagescal;
import javax.servlet.*;

import java.sql.DriverManager;
//import java.util.*;
import java.text.*;
import java.sql.*;
import java.io.*;
public class empreport extends GenericServlet
{
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException , IOException	{
		
	String str1= request.getParameter("ename");
	String str2= request.getParameter("eid");
	String str3= request.getParameter("prj");	
	String str4= request.getParameter("dt");	
	String str5= request.getParameter("noh");	
	String str6= request.getParameter("button");	
	int eid= Integer.parseInt(str2);
	int dh= Integer.parseInt(str5);
	PrintWriter out=response.getWriter();
	
	SimpleDateFormat sdf= new SimpleDateFormat("mm/dd/yyyy");
	
	java.util.Date d1= sdf.parse(str4);
	
	 long ms=d1.getTime();
	java.sql.Date d2= new java.sql.Date(ms);
	Connection c;
	PreparedStatement pstmt;
	if(str6.equals("button"))
			{
		
		 try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:E:\\mydatabase\\mydatabase.sqlite");
		      pstmt = c.prepareStatement("INSERT INTO TABLE "+"VALUES( ?,?,?,?,?)");	
		
		pstmt.setInt(1,eid);
		pstmt.setString(2,str3);
		pstmt.setInt(3,dh);
		if (dh<= 8){
		
		pstmt.setDate(4,d2);}
		else{
		out.println("enter the date in the form of mm/dd/yyyy")	;
		}
		
		 }catch( Exception e ){
		      System.err.println(e);
			 
		 }
	}//if
	
	
	}//service()
		
	}//class
