package com.exam4.task2.dao;

import com.exam4.task2.model.News;

public interface NewsDao {
//    boolean addNew(News news);
    void showNews(String date);
    boolean changeNews(int id);
    boolean deleteNews(int id);
}
