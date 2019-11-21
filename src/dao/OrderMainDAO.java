package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.OrderMain;
import model.Usr;

public class OrderMainDAO implements DBConfig{

    public OrderMain create(OrderMain orderMain) {
        Connection conn = null;
        Integer po_id=null;


        try {
            conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

            String sql = "INSERT INTO order_main(user_id,order_date,delivery_date) VALUES (?,CURRENT_DATE,null);";


            PreparedStatement pStmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            pStmt.setString(1,orderMain.getUser_id());


                  System.out.println(pStmt.executeUpdate());


            ResultSet rs=pStmt.getGeneratedKeys();

                while (rs.next()) {
                      java.math.BigDecimal idColVar = rs.getBigDecimal(1);
                      po_id =idColVar.intValue();
                }
                    rs.close();                           // Close ResultSet
                    pStmt.close();                         // Close Statement

                    orderMain.setPo_id(po_id);

                    return orderMain;

        }catch(SQLException e){
            e.printStackTrace();
                    return orderMain;
        }finally {
            if(conn !=null) {
                try {
                    conn.close();

                }catch(SQLException e) {
                    e.printStackTrace();
                    return orderMain;
                }
            }


        }

        }



    public List<OrderMain> findAllByUserId(Usr loginUsr){
        Connection conn = null;
        List<OrderMain> orderMainList= new ArrayList<OrderMain>();

        try {
            Class.forName(DRIVER_NAME);
            conn=DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            String sql="SELECT * FROM order_main WHERE user_id=? ORDER BY order_date DESC;";

            PreparedStatement pStmt=conn.prepareStatement(sql);
            pStmt.setString(1,loginUsr.getUser_id());

            ResultSet rs=pStmt.executeQuery();

            System.out.println(rs);

                while(rs.next()) {

                    Integer po_id = rs.getInt("po_id");
                    String user_id = rs.getString("user_id");
                    String order_date = rs.getString("order_date");
                    String delivery_date = rs.getString("delivery_date");

                    //System.out.println(p_id+";"+p_name+";"+price+";");

                    OrderMain orderMainResult = new OrderMain(
                            po_id,
                            user_id,
                            order_date,
                            delivery_date
                            );

                    orderMainList.add(orderMainResult);

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

                return orderMainList;

            }



    public List<OrderMain> selectByPoId(Integer po_id){
        Connection conn = null;
        List<OrderMain> orderMainList= new ArrayList<OrderMain>();

        try {
            Class.forName(DRIVER_NAME);
            conn=DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            String sql="SELECT * FROM order_main WHERE po_id=?;";

            PreparedStatement pStmt=conn.prepareStatement(sql);
            pStmt.setInt(1,po_id);

            ResultSet rs=pStmt.executeQuery();

            System.out.println(rs);

                while(rs.next()) {

                    po_id = rs.getInt("po_id");
                    String user_id = rs.getString("user_id");
                    String order_date = rs.getString("order_date");
                    String delivery_date = rs.getString("delivery_date");

                    //System.out.println(p_id+";"+p_name+";"+price+";");

                    OrderMain orderMainResult = new OrderMain(
                            po_id,
                            user_id,
                            order_date,
                            delivery_date
                            );

                    orderMainList.add(orderMainResult);

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

                return orderMainList;

            }




    }

