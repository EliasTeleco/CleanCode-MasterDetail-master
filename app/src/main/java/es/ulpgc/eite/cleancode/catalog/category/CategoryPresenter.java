package es.ulpgc.eite.cleancode.catalog.category;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.app.CategoryItem;

public class CategoryPresenter implements CategoryContract.Presenter {

    public static String TAG = CategoryPresenter.class.getSimpleName();

    private WeakReference<CategoryContract.View> view;
    private CategoryState state;
    private CategoryContract.Model model;
    private CatalogMediator mediator;

    public CategoryPresenter(CatalogMediator mediator) {
        this.mediator = mediator;
        state = mediator.getCategoryState();
    }

    @Override
    public void fetchCategoryData() {
        state.category = model.fetchProductListData();
        view.get().onDataUpdated(state);

    }

    @Override
    public void selectProductListData(CategoryItem item) {
        passDataToNextScreen(item);
        view.get().navigateToNextScreen();
    }

    private void passDataToNextScreen(CategoryItem item){
        mediator.setCategory(item);
   }

    @Override
    public void injectView(WeakReference<CategoryContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(CategoryContract.Model model) {
        this.model = model;
    }


}
