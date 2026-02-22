package ma.enset.metier.metierImpl;

import ma.enset.dao.IDao;
import ma.enset.metier.IMetier;

public class MetierImpl1 implements IMetier {

    private IDao dao;

    public MetierImpl1(IDao dao) {
        this.dao = dao;
    }

    public MetierImpl1(){}

    @Override
    public double calcul() {
        double t = dao.getData();
        return t * 43/3;
    }

    public IDao getDao() {
        return dao;
    }
}
