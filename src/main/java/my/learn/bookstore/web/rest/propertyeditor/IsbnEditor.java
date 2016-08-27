package my.learn.bookstore.web.rest.propertyeditor;

import my.learn.bookstore.domain.Isbn;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

public class IsbnEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.hasText(text)) {
            setValue(new Isbn(text.trim()));
        }
        else {
            setValue(null);
        }
    }

    @Override
    public String getAsText() {
        Isbn isbn = (Isbn) getValue();
        if (isbn != null) {
            return isbn.getIsbn();
        }
        else {
            return "";
        }
    }
}