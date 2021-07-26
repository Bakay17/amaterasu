package com.exam4.task2.dao.impl;

import com.exam4.task2.dao.BaseDao;
import com.exam4.task2.dao.NewsDao;
import com.exam4.task2.model.News;

import java.sql.*;

public class NewsDaoImpl extends BaseDao implements NewsDao {
    public static final String insert = "insert into news (id, heading, text_of, time)\\n\" +\n" + "" +
                                         "\" values(?, ?, ?, ?)";
    @Override
    public News create(News news) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            news.setDateOf((Date) new java.util.Date());
            connection = connect();
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, news.getId());
            preparedStatement.setString(2, news.getHeading());
            preparedStatement.setString(3, news.getText());
            preparedStatement.setDate(4, new Date(news.getDateOf().getTime()));
            preparedStatement.executeUpdate();
            resultSet =preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                news.setId(resultSet.getInt(1));
            }
            return news;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
