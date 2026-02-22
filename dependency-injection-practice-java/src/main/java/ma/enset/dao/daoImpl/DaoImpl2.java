package ma.enset.dao.daoImpl;

import ma.enset.dao.IDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("dao2")
@Primary
public class DaoImpl2 implements IDao {
    @Override
    public double getData() {
        System.out.println("version web service");
        double temp = 45;
        return temp;
    }
}
