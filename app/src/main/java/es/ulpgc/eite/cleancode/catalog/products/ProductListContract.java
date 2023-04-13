package es.ulpgc.eite.cleancode.catalog.products;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.ProductItem;

public interface ProductListContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayProductListData(ProductListViewModel viewModel);

    void navigateToProductDetailScreen();

    void editToolbar(int option);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    //void injectRouter(Router router);

    void fetchProductListData();
    void selectProductListData(ProductItem item);
  }

  interface Model {
    List<ProductItem> fetchProductListData();

    void setCategoryElegida(int categoryElegida);
  }

//  interface Router {
//
//    void navigateToProductDetailScreen();
//    void passDataToProductDetailScreen(ProductItem item);
//  }
}