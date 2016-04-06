package wagescal;
import java.util.*;
import java.text.*;
import java.sql.*;
public class wkmnthrepo {
	
	 public static void main(String []args){
			
		 Scanner s1=new Scanner(System.in) ;
		
		 Connection c1 = null; 
		    
		    ResultSet rs;
		   
		    Statement   stmt; 
		    SimpleDateFormat sdf= new SimpleDateFormat("MM-dd-yyyy");
		  
		 
		 
		 
		 
		 
	
try{
	
	Class.forName("org.sqlite.JDBC");
    c1 = DriverManager.getConnection("jdbc:sqlite:E:\\mydatabase\\mydatabase.sqlite");
	
	stmt= c1.createStatement();
	    	   System.out.println("enter employee id:");
	    	
	    	int id=s1.nextInt();
	    	System.out.println("enter from which date to which date you want:");
	    	String sdate1= s1.next();
	    			String sdate2=s1.next();
	    			java.util.Date d4= sdf.parse(sdate1); 
	    			java.util.Date d5= sdf.parse(sdate2); 
	    	long ms3=d4.getTime();
	    	long ms4=d5.getTime();
	    	java.sql.Date d6= new java.sql.Date(ms3);
	    	java.sql.Date d7= new java.sql.Date(ms4);
	    	 
	    	rs = stmt.executeQuery("SELECT sum(noh) AS totalhours FROM emp2 WHERE date BETWEEN "+d6+ "AND"+ d7+" AND eid="+id);
	   
	      int th= rs.getInt("totalhours");
	     System.out.println(th);
	      s1.close();
	       }catch( Exception e ){
			      System.err.println(e);
			    }
	       
			   
	   
		 
	 }
	 }//class
