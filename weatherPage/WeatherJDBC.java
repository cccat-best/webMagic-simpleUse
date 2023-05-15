package org.example;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WeatherJDBC {
    public void save(WeatherInfo weatherInfo) throws SQLException, ClassNotFoundException{
        String url = "jdbc:mysql:///weather";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url,username,password);
        //测试连接
//        System.out.println(connection);

        String sql = "insert into weather (area,element,temperature,tourismindex) VALUES (?,?,?,?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,weatherInfo.getArea());
        statement.setString(2,weatherInfo.getElement());
        statement.setString(3,weatherInfo.getTemperature());
        statement.setString(4,weatherInfo.getTourismindex());

        int count = statement.executeUpdate();
        System.out.println(count);
    }

    public static void main(String[] args) throws ClassNotFoundException,SQLException{

    }
}
