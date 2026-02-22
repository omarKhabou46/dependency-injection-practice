package ma.enset.presentation;

import ma.enset.dao.IDao;
import ma.enset.dao.daoImpl.DaoImpl1;
import ma.enset.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Presentation3 {
    public static void main(String[] args) {
        ApplicationContext context = new  ClassPathXmlApplicationContext("configuration.xml");
        System.out.println("before getBean IDao class");
        DaoImpl1 dao = (DaoImpl1) context.getBean(IDao.class);
        DaoImpl1 dao2 = (DaoImpl1) context.getBean(IDao.class);

        // dao.a = 30;
        // System.out.println(dao2.a);


        // IMetier metier = context.getBean(IMetier.class);
        // System.out.println(dao.getData());
        // System.out.println(metier.calcul());
    }
}
