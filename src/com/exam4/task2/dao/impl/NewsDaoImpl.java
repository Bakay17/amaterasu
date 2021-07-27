package com.exam4.task2.dao.impl;

import com.exam4.task2.dao.BaseDao;
import com.exam4.task2.dao.NewsDao;
import com.exam4.task2.model.News;

import java.util.Date;
import java.sql.*;
import java.util.Scanner;

public class NewsDaoImpl extends BaseDao implements NewsDao {
    public static final String insert = "insert into news (heading, text_of, date_of) \n values(?, ?, ?); \n commit;";

//    @Override
//    public boolean addNew(News news) {
//
//        try (Connection connection = connect()) {
//            PreparedStatement preparedStatement = connection.prepareStatement(insert);
//
//            Date date = new Date();
//            news.setDateOf(new Timestamp(date.getTime()));
//
//            preparedStatement.setString(1, news.getHeading());
//            preparedStatement.setString(2, news.getText());
//            preparedStatement.setTimestamp(3, news.getDateOf());
//
//            return preparedStatement.executeUpdate() > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

    @Override
    public void showNews(String date) {
        String select = "select n.heading, n.text_of from news n\n where n.date_of::date = '" + date + "'";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = connect();
            preparedStatement = connection.prepareStatement(select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getString("heading") +
                        "\n" + resultSet.getString("text_of") + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public boolean changeNews(int id) {
        String change = "update news\n" +
                "set heading = ?, text_of = ?\n" +
                "where id = ?;";

        try (Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(change)){
            System.out.println("Enter the heading to change: ");
            preparedStatement.setString(1, new Scanner(System.in).nextLine());
            System.out.println("Enter tne text to change: ");
            preparedStatement.setString(2, new Scanner(System.in).nextLine());
            preparedStatement.setInt(3, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteNews(int id) {
        String delete = "delete from news\n" +
                "where id > ?";

        try (Connection connection = connect();
                    PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
