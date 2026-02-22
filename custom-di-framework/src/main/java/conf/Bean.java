package conf;

import jakarta.xml.bind.annotation.XmlAttribute;

public class Bean {
    private String id;
    private Class<?> aClass;

    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlAttribute(name = "class")
    public Class<?> getaClass() {
        return aClass;
    }

    public void setaClass(Class<?> aClass) {
        this.aClass = aClass;
    }
}
