package es.ulpgc.eite.cleancode.catalog.app;

public class CategoryItem {
    public final int id;
    public final String content;
    public final String details;

    public CategoryItem(int id, String content, String details) {
        this.id = id;
        this.content = content;
        this.details = details;
    }

    @Override
    public String toString() {
        return content;
    }
}