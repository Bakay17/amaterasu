package com.exam4.task2;

import com.exam4.task2.dao.NewsDao;
import com.exam4.task2.dao.impl.NewsDaoImpl;
import com.exam4.task2.model.News;


public class Main {

    public static void main(String[] args) {
        NewsDao newsDao = new NewsDaoImpl();
        News[] news = new News[3];
        news[0].setId(1);
        news[0].setHeading("News1");
        news[0].setText("Lorem bla bla bla bla bla");
        news[1].setId(2);
        news[1].setHeading("News2");
        news[1].setText("Lorem bla bla bla bla bla222");
        news[2].setId(3);
        news[2].setHeading("News3");
        news[2].setText("Lorem bla bla bla bla bla333");

        for (int i = 0; i < news.length; i++) {
            newsDao.create(news[i]);
        }
    }
}
