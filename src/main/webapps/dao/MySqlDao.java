package dao;

import entity.NiuZa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by zzy on 2017/9/14.
 */
public class MySqlDao {
       private static Connection getConn(){
           String diver="com.mysql.cj.jdbc.Driver";
           String url="jdbc:mysql://localhost:3306/niuza?autoReconnect=true&useSSL=false&characterEncoding=utf8&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
           String username="root";
           String password="";
           Connection connection=null;
           try{
               Class.forName(diver);
               connection=(Connection) DriverManager.getConnection(url,username,password);
           }catch(Exception e){
               e.printStackTrace();
           }
           return connection;
       }

       public static int insert(NiuZa niuZa){
           Connection connection=getConn();
           int i=0;
           String sql="insert into goods(productname,price,buylink,couponlink,insertdate) values (?,?,?,?,?)";
           PreparedStatement preparedStatement;
           try{
               preparedStatement=(PreparedStatement)connection.prepareStatement(sql);
               preparedStatement.setString(1,niuZa.getProductname());
               preparedStatement.setDouble(2,niuZa.getPrice());
               preparedStatement.setString(3,niuZa.getBuylink());
               preparedStatement.setString(4,niuZa.getCouponlink());
               /*Timestamp inserttime = new Timestamp(niuZa.getInsertdate().getTime());

               preparedStatement.setTimestamp(5,inserttime);*/
               DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
               String inserttime = df.format(niuZa.getInsertdate());
               preparedStatement.setString(5, inserttime);

               i = preparedStatement.executeUpdate();
               preparedStatement.close();
               connection.close();
           }catch (Exception e){
               e.printStackTrace();
           }
           return i;
       }
}
