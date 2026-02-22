package ma.enset.presentation;

import ma.enset.dao.IDao;
import ma.enset.dao.daoImpl.DaoImpl1;
import ma.enset.metier.IMetier;
import ma.enset.metier.metierImpl.MetierImpl1;

public class Persentation1 {

    public static void main(String[] args) {
        IDao dao = new DaoImpl1();
        IMetier metier = new MetierImpl1(dao);

        System.out.println("Res = "+metier.calcul());
    }
}
