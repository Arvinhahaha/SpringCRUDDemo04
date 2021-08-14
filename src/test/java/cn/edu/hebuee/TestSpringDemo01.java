package cn.edu.hebuee;

import cn.edu.hebuee.domain.Account;
import cn.edu.hebuee.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Random;

/**
 * @Classname TestSpringDemo01
 * @Description TODO
 * @Date 2021/8/14 23:27
 * @Created by 杨军望
 */
public class TestSpringDemo01 {
    ApplicationContext ac ;
    IAccountService as;
    @Before
    public void init(){
        //得到业务层对象
        ac = new ClassPathXmlApplicationContext("bean.xml");
        as = ac.getBean("accountService",IAccountService.class);
    }
    @Test
    public void testfindll() {
        List<Account> accounts = as.findAllAcount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testfindOne() {
        Account account = as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave() {
        Account account = new Account(null,"杨军望"+new Random().nextInt(5000),5000.0f);
        as.saveAccount(account);
    }
    @Test
    public void testUpdate() {
        Account account = new Account(null,"杨军望"+new Random().nextInt(5000),5000.0f);
        account.setId(4);
        as.updateAccount(account);
    }
    @Test
    public void testDelete() {
        as.deleteAccount(4);
    }
}
