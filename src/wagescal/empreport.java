package wagescal;
import java.util.*;
import java.text.*;
import java.sql.*;


public class empreport {
	
	    
	  
	 public static void main(String []args){
		
		 Scanner s=new Scanner(System.in) ;
		 Connection c = null; 
		
		    PreparedStatement pstmt = null;
		  
		   
		    SimpleDateFormat sdf= new SimpleDateFormat("MM-dd-yyyy");
		  
		   
		
		
		try{
			  Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:E:\\mydatabase\\mydatabase.sqlite");
			   
		System.out.println("enter employee id:");
		 int eid=s.nextInt();
		 System.out.println("enter no of working hours:");
		 int noh=s.nextInt();
		 System.out.println("enter the project:");
		 String proname=s.next();
		System.out.println("enter date (mm/dd/yyyy):");
		 String sdate=s.next(); 
		
			java.util.Date d1= sdf.parse(sdate); 
			
			
			long ms1= d1.getTime();
			java.sql.Date d2= new java.sql.Date(ms1);
			
			
			
	pstmt= c.prepareStatement("INSERT INTO emp2 VALUES(?,?,?,?)");
	
	pstmt.setInt(1, eid);
	
	pstmt.setString(2, proname);
	if(noh<=8){
	pstmt.setInt(3, noh);}
	else{
		System.out.println("should not enter more than 8 hours");	
	}
	java.util.Date d3=new java.util.Date();
	                                   d3= sdf.parse(sdf.format(d3)); 
	                                   long ms2= d3.getTime();          
	 
	                                   
	                                   if( ms1<=ms2)
	                                   
	   {                              
	      pstmt.setDate(4,d2);
	
	   }else{
		   System.out.println("dont enter future dates");	
	   }
           int i=pstmt.executeUpdate();
	       System.out.println(i + "row inserted successfully");
	  
	       s.close();
	 }catch( Exception e ){
			      System.err.println(e);
			    }  
		
		 
	 

	
		
	}//main
	}//class