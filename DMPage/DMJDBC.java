package dongman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DMJDBC  {
    public void save(DMInfo dmInfo) throws SQLException,ClassNotFoundException{
        String url="jdbc:mysql:///dm";
        String username="root";
        String password="123456";
        Connection connection = DriverManager.getConnection(url,username,password);
        String sql="insert into dm(name,author,ticket) VALUES(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,dmInfo.getName());
        statement.setString(2,dmInfo.getAuthor());
        statement.setString(3,dmInfo.getTicket());
        int count=statement.executeUpdate();
        System.out.println(count);
    }
    public static void main(String[] args)throws ClassNotFoundException,SQLException{
        String url="jdbc:mysql:///dm";
        String username="root";
        String password="123456";
        Connection connection = DriverManager.getConnection(url,username,password);
        String sql="insert into dm(name,author,ticket) VALUES(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        int count=statement.executeUpdate();
        System.out.println(count);
    }

    }

