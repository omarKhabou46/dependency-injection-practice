package ma.enset.metier.metierImpl;

import ma.enset.dao.IDao;
import ma.enset.dao.daoImpl.DaoImpl1;
import ma.enset.metier.IMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl1 implements IMetier {
    /**
     * vous avez 3 methodes pour faire l'injection de dependances
     * - utilisant autowired ce n'est pas recommende
     * - utilisant setter injection
     * - utilisant constructor
     */
    // @Autowired
    private IDao dao;
    @Autowired
    public MetierImpl1(IDao dao) {
        this.dao = dao;
    }

    public MetierImpl1(){}

    @Override
    public double calcul() {
        double t = dao.getData();
        return t * 43/3;
    }



    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
