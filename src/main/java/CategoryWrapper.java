import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
public class CategoryWrapper {
    @JsonProperty("category")
    private List<Category> categoryList;

    public CategoryWrapper(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public CategoryWrapper() {
    }

    @XmlElement(name = "category")
    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
