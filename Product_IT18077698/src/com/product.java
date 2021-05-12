package com;
import java.sql.* ;

public class product
{ 
	
    
	private Connection connect()
	 {
		Connection con = null;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");

	 //--------------DATABASE CONNECTION-----------------------
				
				
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paf_project", "root", "");
			}
			catch (Exception e)
			{e.printStackTrace();}
				return con;
	 }

//    ----------------------INS-----------------------------------------------------------------------------
	
	
	
    public String insertproduct(String id, String name, String amount, String des) 
             { 
             String output = ""; 
             try
             { 
             Connection con = connect(); 
             if (con == null) 
             { 
             return "Error while connecting to the database for inserting."; 
             } 
             //---------------PREPARE STATEMENT------------------------
             String query = " insert into product(`id`,`name`,`amount`,`des`)"+ " VALUES (?, ?, ?, ?)";
             PreparedStatement preparedStmt = con.prepareStatement(query); 
                     
                     // ------------FETCH VALUES-----------
                     
                     preparedStmt.setString(1, id); 
                     preparedStmt.setString(2, name); 
                     preparedStmt.setDouble(3, Double.parseDouble(amount)); 
                     preparedStmt.setString(4, des); 
                    
                     
                     
                     // -----------------EXECUTE STATEMENT--------------
                     preparedStmt.execute(); 
                     con.close(); 
                     String newproduct = readproduct(); 
                     output = "{\"status\":\"success\", \"data\": \"" + newproduct + "\"}"; 
                     } 
                     catch (Exception e) 
                     { 
                     output = "{\"status\":\"error\", \"data\": \"Error while inserting the product.\"}"; 
                     System.err.println(e.getMessage()); 
                     } 
                     return output; 
                     } 

    
    
    
 
//------------READ----------------------------------------------------------------------
    
    
public String readproduct()
{ 
 String output = ""; 
try
 { 
 Connection con = connect(); 
 if (con == null) 
 { 
 return "Error while connecting to the database for reading."; 
 } 
 // ----------------HTML TABALE PREPARE------------
 
 
 output = "<table border='1'><tr><th> Code</th>" 
 + "<th>Name</th><th>Price</th>"
 + "<th>Description</th>" 
 + "<th>Update</th><th>Remove</th></tr>"; 
 String query = "select * from product"; 
 Statement stmt = con.createStatement(); 
 ResultSet rs = stmt.executeQuery(query); 
 
 
 
 // -------------INSERT THE ROWS---------------------
 while (rs.next()) 
 { 

 String id = rs.getString("id"); 
 String name = rs.getString("name"); 
 String amount = Double.toString(rs.getDouble("amount")); 
 String des = rs.getString("des");
 
 
 
 
 
//---------------------------ADD TO THE HTML TABLE---------------------.
 
 
output += "<tr><td>" + id + "</td>"; 
output += "<td>" + name + "</td>"; 
output += "<td>" + amount + "</td>"; 
output += "<td>" + des + "</td>"; 

 


//---------------------------BUTTONS--------------------------------------



output += "<td><input name='btnUpdate' type='button' value='Update' "
+ "class='btnUpdate btn btn-secondary' data-code='" + id + "'></td>"
+ "<td><input name='btnRemove' type='button' value='Remove' "
+ "class='btnRemove btn btn-danger' data-code='" + id + "'></td></tr>"; 
} 
con.close(); 

 

// --------------------------------------COMPLETE HTML TBL----------------------------------------



output += "</table>"; 
} 
catch (Exception e) 
{ 
output = "Error while reading the product."; 
System.err.println(e.getMessage()); 
} 
return output; 
}

 

 
//---------------------------------UPDATE--------------------------------------------------------------


    public String updateproduct(String id, String name, String amount, String des) 
     { 
     String output = ""; 
     try
     { 
     Connection con = connect(); 
     if (con == null) 
     { 
     return "Error while connecting to the database for updating."; 
     } 
     // -------------------CREATE PREPARE STATEMENT-------------------------------------------
     String query = "UPDATE `product` SET `name`=?,`amount`=?,`des`=? WHERE `id`=?"; 
     PreparedStatement preparedStmt = con.prepareStatement(query);
     
     
     //--------------FETCH VALUES---------------------------
     
     preparedStmt.setString(1, name); 
     preparedStmt.setDouble(2, Double.parseDouble(amount)); 
     preparedStmt.setString(3, des);
     preparedStmt.setString(4, id);
    
     
    // ----------------------STATEMENT EXECUTE---------------------------------
     
     
     preparedStmt.execute(); 
     con.close(); 
     String newproduct = readproduct(); 
     output = "{\"status\":\"success\", \"data\": \"" + newproduct + "\"}"; 
     } 
     catch (Exception e) 
     { 
     output = "{\"status\":\"error\", \"data\": \"Error while updating the product.\"}"; 
     System.err.println(e.getMessage()); 
     } 
     return output; 
     }
  
    
//    -----------------------------------------------DELETE-----------------------------------------
    
    
    
    public String deleteproduct(String id) 
     { 
     String output = ""; 
     try
     { 
     Connection con = connect(); 
     if (con == null) 
     { 
     return "Error while connecting to the database for deleting."; 
     } 
     //----------------------------PRAPARE STATEMENT----------------------
     String query = "delete from product where id=?"; 
     PreparedStatement preparedStmt = con.prepareStatement(query); 
     // ---------------------------FETCH VALUES----------------------------------
     preparedStmt.setString(1, id);  
     
     
     // ------------------------------STATEMENT EXECUTE-------------------------------------
     
     
     preparedStmt.execute(); 
     con.close(); 
     String newproduct = readproduct(); 
     output = "{\"status\":\"success\", \"data\": \"" + newproduct + "\"}"; 
     } 
     catch (Exception e) 
     { 
     output = "{\"status\":\"error\", \"data\": \"Error while deleting the product.\"}"; 
     System.err.println(e.getMessage()); 
     } 
     return output; 
     } 
    }
