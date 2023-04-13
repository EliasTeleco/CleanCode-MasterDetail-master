package es.ulpgc.eite.cleancode.catalog.category;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.app.ProductItem;
import es.ulpgc.eite.cleancode.catalog.products.ProductListActivity;


public class CategoryActivity
        extends AppCompatActivity implements CategoryContract.View {

    public static String TAG = CategoryActivity.class.getSimpleName();

    private CategoryContract.Presenter presenter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        //getSupportActionBar().setTitle(R.string.app_name);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.category_title));
        }

        listView = findViewById(R.id.product_list);

        CategoryScreen.configure(this);
        presenter.fetchCategoryData();

    }


    @Override
    public void onDataUpdated(CategoryViewModel viewModel) {
        Log.e(TAG, "onDataUpdated()");

        // deal with the data
        listView.setAdapter(new CategoryAdapter(
                        this, viewModel.products, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ProductItem item = (ProductItem) view.getTag();
                        presenter.selectProductListData(item);
                    }
                })
        );
    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, ProductListActivity.class);
        startActivity(intent);
    }
    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void injectPresenter(CategoryContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
