/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liquormgmtsystem.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import liquormgmtsystem.Model.Product;

/**
 *
 * @author dell
 */
public class ProductDao {
  public static final  String Driver="com.mysql.jdbc.Driver";
   public static final String URL="jdbc:mysql://localhost:3306/liquor_db";
   public static final String user="root";
   public static final String pass="";
   
   public static boolean addProduct(Product p){
    boolean status = false;
    Connection conn = null;
    PreparedStatement ps = null;
    String sql = "insert into liquor_tbl (name,distributors,date,quantity) values(?,?,?,?)";
    try{
        Class.forName(Driver);
        conn=DriverManager.getConnection(URL, user, pass);
        ps=conn.prepareStatement(sql);
        
        ps.setString(1, p.getName());
        ps.setString(2, p.getDistributors());
        ps.setDate(3,Date.valueOf(p.getDate()));
        ps.setInt(4,p.getQuantity());
        
        
        if(ps.executeUpdate()==1){
            status=true;
        }
         
        
    }catch(Exception e){
        System.out.println("Exception: "+e);
    }finally{
        try{
        if(conn!=null) conn.close();
        if(ps!=null) ps.close();
    }catch(SQLException ex){
        System.out.println(ex);
    }
    }
    
    return status;
    
}
   
   
 public ArrayList<Product> selectAllProduct(){
        ArrayList<Product> a1=new ArrayList();
        
        Connection con=null;
        PreparedStatement ps=null;
        
        try{
            Class.forName(Driver);
            con=DriverManager.getConnection(URL,user, pass);
            String sql="select * from liquor_tbl";
            ps=con.prepareStatement(sql);
            
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Product p=new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDistributors(rs.getString("distributors"));
                
                p.setDate(rs.getDate("date").toLocalDate());
                p.setQuantity(rs.getInt("quantity"));
                
                a1.add(p);
                
            }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            
        }
        return a1;
    }
 
  public ArrayList<Product> selectAllProductByName(String name){
        ArrayList<Product> a1=new ArrayList();
        
        Connection con=null;
        PreparedStatement ps=null;
        
        try{
            Class.forName(Driver);
            con=DriverManager.getConnection(URL, user, pass);
            String sql="select * from liquor_tbl where name=?";
           
            ps=con.prepareStatement(sql);
             ps.setString(1, name);
            
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Product p=new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
               p.setDistributors(rs.getString("distributors"));
                p.setDate(rs.getDate("date").toLocalDate());
                p.setQuantity(rs.getInt("quantity"));
                
                a1.add(p);
                
            }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            
        }
        return a1;
    }
  
   public boolean deleteProductById(int id) {
        boolean status=false;
        Connection con=null;
        PreparedStatement ps=null;
        
        try{
            Class.forName(Driver);
            con=DriverManager.getConnection(URL, user, pass);
            String sql="delete from liquor_tbl where id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            int i=ps.executeUpdate();
            if(i==1){
                status=true;
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        return status;
    }
   
   // select all inventory information in a given range of date
 
public static ArrayList<Product> getProductInfoByDate(LocalDate date1,LocalDate date2) {
        ArrayList<Product> p1=new ArrayList(); 
        Connection con=null;
        PreparedStatement ps=null;
        
        try{
            Class.forName(Driver);
            con=DriverManager.getConnection(URL, user, pass);
            String sql="select * from liquor_tbl where date >= ? and date < ?";
            ps=con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(date1));
           ps.setDate(2, Date.valueOf(date2));
            ResultSet rs=ps.executeQuery();
            
             while(rs.next()){
               Product p=new Product();
                p.setName(rs.getString("name"));
                p.setDistributors(rs.getString("distributors"));
                p.setDate(rs.getDate("date").toLocalDate());
                p.setQuantity(rs.getInt("quantity"));
                
                p1.add(p);
                
            }
            
        }
        catch(Exception ex){
            //JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex);
        }
        finally{
    try{
        if(con!=null) con.close();
        if(ps!=null) ps.close();
    }catch(SQLException ex){
        System.out.println(ex);
    }
}
        return p1;
    }
       
    
}
