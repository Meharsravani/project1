package wagescal;

import java.sql.*;

public class Wages
{
  public static void main( String args[] )
  {
    Connection c = null; 
    Statement stmt = null;
    Statement stmt1;
   // PreparedStatement pstmt=null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:E:\\mydatabase\\mydatabase.sqlite");
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT eid,ename,noh FROM emp_details;" );
      stmt1 = c.createStatement();
      while ( rs.next() ) {
          int id = rs.getInt("eid");
          String  name = rs.getString("ename"); System.out.println( "employee ID = " + id );
          System.out.println( "employee NAME = " + name );
          int noh=rs.getInt("noh");
          int salary;
          if (noh>52){
        	  salary=(40*100+(noh-40)*150);
        	  } else {
        		 salary= (noh*100);
        		  }
         
          System.out.println( "employee salary = " + salary);
          
       int i= stmt1.executeUpdate("UPDATE emp_details SET sal = "+salary+" WHERE eid="+id+";");
          
       System.out.println(i); 
         //rs.next(); 
      }
    } catch ( Exception e ){
      System.err.println(e);
    }
    System.out.println("Opened database successfully"); 
    
    
    
    
    
    
  }
}
