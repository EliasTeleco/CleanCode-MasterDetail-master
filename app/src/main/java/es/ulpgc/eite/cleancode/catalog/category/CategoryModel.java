package es.ulpgc.eite.cleancode.catalog.category;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.CategoryItem;


public class CategoryModel implements CategoryContract.Model {

    public static String TAG = CategoryModel.class.getSimpleName();
    private final List<CategoryItem> itemList = new ArrayList<>();
    private final int COUNT = 20;

    private String data;

    public CategoryModel() {
        for (int index = 1; index <= COUNT; index++) {
            addProduct(createProduct(index));
        }
    }
    private void addProduct(CategoryItem item) {
        itemList.add(item);
    }
    private CategoryItem createProduct(int position) {
        String content = "Category " + position;

        return new CategoryItem(
                position, content, fetchProductDetails(position)
        );

    }

    private String fetchProductDetails(int position) {
        String content = "Details about Product:  " + position;
        StringBuilder builder = new StringBuilder();
        builder.append(content);

        for (int index = 0; index < position; index++) {
            builder.append("\nMore details information here.");
        }

        return builder.toString();
     }


    @Override
    public List<CategoryItem> fetchProductListData() {
        Log.e(TAG, "fetchProductListData()");
        return itemList;
    }


    @Override
    public String getStoredData() {
        // Log.e(TAG, "getStoredData()");
        return data;
    }

    @Override
    public void onRestartScreen(String data) {
        // Log.e(TAG, "onRestartScreen()");
    }

    @Override
    public void onDataFromNextScreen(String data) {
        // Log.e(TAG, "onDataFromNextScreen()");
    }

    @Override
    public void onDataFromPreviousScreen(String data) {
        // Log.e(TAG, "onDataFromPreviousScreen()");
    }
}
