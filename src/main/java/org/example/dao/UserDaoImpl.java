package org.example.dao;

import org.example.config.DbConfig;
import org.example.model.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl extends DbConfig implements UserDao {

    @Override
    public boolean save(UserModel userModel) {
        String sql = "insert into user_exam(name, birth_year, gender, request_date_time) values (?, ?)";
        try (Connection connection = DbConfig.connect();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            Date date = new Date();
            userModel.setRequestDateTime(new Timestamp(date.getTime()));
            statement.setString(1, userModel.getName());
            statement.setDate(2, userModel.getBirthYear());
            statement.setString(3, userModel.getGender());
            statement.setTimestamp(4, userModel.getRequestDateTime());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<UserModel> getAll() {
        String sql = "select * from user_exam";
        List<UserModel> userModelList = null;

        try (Connection connection = DbConfig.connect();
              PreparedStatement statement = connection.prepareStatement(sql);
              ResultSet set = statement.executeQuery()) {
            userModelList = new ArrayList<>();

            while (set.next()) {
                UserModel userModel = new UserModel();
                userModel.setId(set.getInt("id"));
                userModel.setName(set.getString("name"));
                userModel.setBirthYear(set.getDate("birth_year"));
                userModel.setGender(set.getString("gender"));
                userModel.setRequestDateTime(set.getTimestamp("request_date_time"));
                userModelList.add(userModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserModel delete(String name) {
        String sql = "delete from user_exam where name = ?";
        ResultSet resultSet = null;

        try (Connection connection = DbConfig.connect();
              PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                UserModel userModel= new UserModel();
                userModel.setId(resultSet.getInt("id"));
                userModel.setName(resultSet.getString("name"));
                userModel.setBirthYear(resultSet.getDate("birth_year"));
                userModel.setGender(resultSet.getString("gender"));
                userModel.setRequestDateTime(resultSet.getTimestamp("request_date_time"));
                return userModel;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public UserModel getByGender(String gender) {
        String sql = "select * from user_exam where gender = ?";
        ResultSet resultSet = null;

        try (Connection connection = DbConfig.connect();
              PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, gender);
            resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                UserModel userModel = new UserModel();
                userModel.setId(resultSet.getInt("id"));
                userModel.setName(resultSet.getString("name"));
                userModel.setBirthYear(resultSet.getDate("birth_year"));
                userModel.setGender(resultSet.getString("gender"));
                userModel.setRequestDateTime(resultSet.getTimestamp("request_date_time"));
                return userModel;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
