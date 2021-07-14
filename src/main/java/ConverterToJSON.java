import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConverterToJSON {
    private final static String BASICFILE = "categoriesJSON.json";

    public static void listForRecording(CategoryWrapper categoryWrapper) {
        List<Integer> indexForRemove = new ArrayList<>();
        for (int i = 0; i < categoryWrapper.getCategoryList().size(); i++) {
            int sum = 0;
            for (int j = 0; j < categoryWrapper.getCategoryList().get(i).getListProduct().size(); j++) {
                sum += categoryWrapper.getCategoryList().get(i).getListProduct().get(j).getPrice();
            }
            sum /= categoryWrapper.getCategoryList().get(i).getListProduct().size();
            if (sum < 300) {
                indexForRemove.add(i);
            }
        }
        for (Integer i : indexForRemove) {
            int j = i;
            categoryWrapper.getCategoryList().remove(j);
        }
    }

    public static void toJSON(CategoryWrapper categoryWrapper) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File(BASICFILE), categoryWrapper);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
