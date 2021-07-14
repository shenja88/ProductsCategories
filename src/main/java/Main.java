import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(
                    CategoryWrapper.class,
                    Category.class,
                    Product.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            CategoryWrapper categories = (CategoryWrapper) unmarshaller.unmarshal(new File("categories.xml"));
//            for check
            for (Category category : categories.getCategoryList()) {
                System.out.println(category.getListProduct());
            }
            ConverterToJSON.listForRecording(categories);
//            for check
            System.out.println();
            for (Category category1 : categories.getCategoryList()) {
                System.out.println(category1.getListProduct());
            }
            ConverterToJSON.toJSON(categories);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        
    }
}
