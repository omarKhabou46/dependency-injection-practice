package ma.enset.dao.daoImpl;

import ma.enset.dao.IDao;
import org.springframework.stereotype.Component;

@Component("dao1")
public class DaoImpl1 implements IDao {

    public int a = 40;

    public DaoImpl1() {
        System.out.println("instantiation de dao");
    }

    @Override
    public double getData() {
        System.out.println("Version base de donnee");
        double temp = 23;
        return temp;
    }
}
