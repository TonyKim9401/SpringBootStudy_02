package com.example.spring02;

import exam.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationContextExam {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Book book1 = context.getBean("book1", Book.class);
        book1.setTitle("java");
        book1.setPrice(5000);

        System.out.println(book1.getTitle());
        System.out.println(book1.getPrice());

        Book book2 = context.getBean("book2", Book.class);
        System.out.println(book2.getTitle());
    }
}
