package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDAO implements DBConfig{
	
	public int countProducts() {
        Connection conn = null;
        Integer count = 0;
        try {
            Class.forName(DRIVER_NAME);
            conn=DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            String countSql = "SELECT COUNT(*) as count FROM product";
            PreparedStatement pStmtCount=conn.prepareStatement(countSql);
            ResultSet rsCount = pStmtCount.executeQuery();
        	while(rsCount.next()) {
        		count = rsCount.getInt("count");
        	}
        }catch(SQLException e){
            e.printStackTrace();
            return 0;
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
            return count;
        }finally {
        }
    	return count;
	}

    public List<Product> findAllProducts(int fromIndex, int limit){
        Connection conn = null;
        List<Product> productList= new ArrayList<Product>();

        try {
            Class.forName(DRIVER_NAME);
            conn=DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            //"SELECT * FROM table LIMIT $offset, $no_of_records_per_page";
            String sql="SELECT * FROM product ORDER BY p_id LIMIT "+fromIndex+", "+limit+"";
            System.out.println(sql);
            PreparedStatement pStmt=conn.prepareStatement(sql);
            
            ResultSet rs=pStmt.executeQuery();
            	
            

                while(rs.next()) {

                    String p_id = rs.getString("p_id");
                    String p_name = rs.getString("p_name");
                    Integer price = rs.getInt("price");

                    //System.out.println(p_id+";"+p_name+";"+price+";");

                    Product productResult = new Product(
                            p_id,
                            p_name,
                            price
                            );

                    productList.add(productResult);

                }
            }catch(SQLException e){
                e.printStackTrace();
                return null;
            }catch(ClassNotFoundException e) {
                e.printStackTrace();
                return null;

            }finally {
                if(conn !=null) {
                    try {
                        conn.close();

                    }catch(SQLException e) {
                        e.printStackTrace();
                        return null;
                    }
                }


            }

                return productList;

            }




}
