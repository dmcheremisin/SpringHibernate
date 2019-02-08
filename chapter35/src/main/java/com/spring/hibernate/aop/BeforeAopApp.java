package com.spring.hibernate.aop;

import com.spring.hibernate.DemoConfig;
import com.spring.hibernate.dao.AccountDAO;
import com.spring.hibernate.dao.MembershipDAO;
import com.spring.hibernate.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Dmitrii on 07.02.2019.
 */
public class BeforeAopApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        accountDAO.addAccount();
        accountDAO.addAccount(new Account());
        accountDAO.addAccount(new Account(), true);

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        membershipDAO.addMemberAccount();
        membershipDAO.cancelMembership(new Account());

        context.close();
    }

    //======>>> Executing @Before advice on addAccount()
    //class com.spring.hibernate.dao.AccountDAO: Doing my db work : adding account
    //
    //======>>> Executing @Before advice on addAccount()
    //class com.spring.hibernate.dao.MembershipDAO: Doing stuff : adding a membership account
}