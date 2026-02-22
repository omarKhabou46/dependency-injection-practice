package ma.enset.dao.daoImpl;

import ma.enset.dao.IDao;

public class DaoImpl1 implements IDao {
    @Override
    public double getData() {
        System.out.println("Version base de donnee");
        double temp = 23;
        return temp;
    }
}
