package ma.enset.presentation;

import ma.enset.dao.IDao;
import ma.enset.metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Presentation2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("src/main/resources/config.txt"));

        String classNameDao = scanner.nextLine();

        Class<?> CDao = Class.forName(classNameDao);
        IDao dao = (IDao) CDao.getConstructor().newInstance();

        String classNameMetier = scanner.nextLine();
        Class<?> CMetier = Class.forName(classNameMetier);
        IMetier metier = (IMetier) CMetier.getConstructor(IDao.class).newInstance(dao);
        System.out.println(metier.calcul());



    }
}
