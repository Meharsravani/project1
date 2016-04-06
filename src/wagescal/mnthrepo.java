package wagescal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;
import java.text.*;

public class mnthrepo {
	
	 public static void main(String []args){
			
		 Scanner s=new Scanner(System.in) ;
		
		 Connection c = null; 
		    
		    ResultSet rs;
		   
		    Statement   stmt; 
		  
		    ResultSet rs1;
			   
		  
		    SimpleDateFormat sdf= new SimpleDateFormat("MM-dd-yyyy");
		 
		 
		 
		 
	
try{
	
	Class.forName("org.sqlite.JDBC");
    c= DriverManager.getConnection("jdbc:sqlite:E:\\mydatabase\\mydatabase.sqlite");
     stmt= c.createStatement();
   
	    	   System.out.println("enter employee id:");
	           int id=s.nextInt();
	    	System.out.println("enter for which mnth you want in numerical:");
	    	int month1=s.nextInt();
	    	rs = stmt.executeQuery("SELECT date FROM emp2 WHERE    eid="+id);
	    	java.sql.Date d	=rs.getDate("date");
	    	java.util.Date d1=(java.util.Date) d;
	    	
	  
	  
	    
	         int month2 = d1.getMonth();
	    	
           
            System.out.println(month1+","+month2); 
            
            
            
            

          
            
            
            
            
            
            
            
            
            
            
            
	    	
            if((month1-1)==month2){
	    		
	    		rs1 = stmt.executeQuery("SELECT sum(dailyhours) AS thrs FROM emp2 WHERE eid="+id);
	    		
	    	//	int totalhrs=0;
	    		
	    		while(rs1.next()){
	    		 
	    			int k=rs1.getInt("thrs");
	    			//k=+k;
	    		 System.out.println(k);	
	    		}
	    	}
	    	else{
	    		System.out.println("data doesnot exists");		
	    	}
	    	
	      s.close();
	       }catch( Exception e ){
			      System.err.println(e);
			    }
	       
			   
	    //   }
		 
	 }
	 }//class
