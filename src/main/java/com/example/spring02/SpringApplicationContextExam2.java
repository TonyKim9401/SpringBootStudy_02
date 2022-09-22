package com.example.spring02;

import com.example.spring02.component.MyDao;
import com.example.spring02.component.MyService;
import exam.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationContextExam2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyService myService = context.getBean("myService", MyService.class);
        MyDao myDao = context.getBean("myDao", MyDao.class);
        myService.setMyDao(myDao);

    }
}
