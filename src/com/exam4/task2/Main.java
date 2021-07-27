package com.exam4.task2;

import com.exam4.task2.dao.NewsDao;
import com.exam4.task2.dao.impl.NewsDaoImpl;
import com.exam4.task2.model.News;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NewsDao newsDao = new NewsDaoImpl();
//        News news1 = new News();
//        News news2 = new News();
//        News news3 = new News();
//        news1.setHeading("News1");
//        news1.setText("Lorem bla bla bla bla bla111");
//        news2.setHeading("News2");
//        news2.setText("Lorem bla bla bla bla bla222");
//        news3.setHeading("News3");
//        news3.setText("Lorem bla bla bla bla bla333");
//
//        newsDao.addNew(news1);
//        newsDao.addNew(news2);
//        newsDao.addNew(news3);


//        System.out.println("Enter the date (2020-02-22):");
//        String date = sc.nextLine();
//        newsDao.showNews(date);

//        System.out.println("Enter the id number to change heading and text:");
//        int id = sc.nextInt();
//        newsDao.changeNews(id);

        System.out.println("Enter the id number to delete news:");
        int id = sc.nextInt();
        newsDao.deleteNews(id);
    }
}
