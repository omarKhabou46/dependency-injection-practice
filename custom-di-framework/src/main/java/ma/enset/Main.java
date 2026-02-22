package ma.enset;

import conf.Config;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;




//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        Config context = Config.createBeans("src/main/resources/conf.xml");
         Book book = (Book) context.getBean("book");
         ClassRoom classRoom =(ClassRoom) context.getBean("classRoom");
         classRoom.setName("classe1");
        System.out.println(classRoom.getName());


    }
}