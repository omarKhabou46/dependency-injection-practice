package conf;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "beans")
public class BeanConfig {

    private List<Bean> beanList = new ArrayList<>();

    public void addBean(Bean b) {
        beanList.add(b);
    }

    @XmlElement(name = "bean")
    public List<Bean> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<Bean> beanList) {
        this.beanList = beanList;
    }
}
