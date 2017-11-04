package pl.kodolamacz.spring.dao.repository.impl;

import org.springframework.stereotype.Repository;
import pl.kodolamacz.spring.dao.model.User;
import pl.kodolamacz.spring.dao.repository.UserDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by acacko on 29.10.17
 */
@Repository
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {

    @Override
    public User findUser(String email) {

        User ret = null;

        try(Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement()){

            String sql;
            sql = "SELECT * FROM Users WHERE email = '" + email + "'";
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()){
                ret = new User(
                        rs.getLong("id"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }
            rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }

        return ret;
    }

}
