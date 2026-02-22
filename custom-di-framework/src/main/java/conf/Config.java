package conf;

import exception.BeanNotFoundException;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Config {

    public static Map<String, Object> mapOfObjects = new HashMap<>();

    public static Config createBeans(String path) throws Exception{
        JAXBContext context = JAXBContext.newInstance(BeanConfig.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        BeanConfig beanConfig = (BeanConfig) unmarshaller.unmarshal(new File(path));
        List<Bean> list = beanConfig.getBeanList();
        list.forEach(b -> {
            try {
                mapOfObjects.put(b.getId(), b.getaClass().getConstructor().newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });
        return new Config();
    }

    public Object getBean(String id) throws BeanNotFoundException {
        if (mapOfObjects.containsKey(id)) {
            return mapOfObjects.get(id);
        }else {
            throw new BeanNotFoundException("bean not found");
        }
    }
}
