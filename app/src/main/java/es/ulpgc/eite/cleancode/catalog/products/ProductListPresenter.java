package es.ulpgc.eite.cleancode.catalog.products;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.app.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.app.ProductItem;


public class ProductListPresenter implements ProductListContract.Presenter {

  public static String TAG = ProductListPresenter.class.getSimpleName();

  private WeakReference<ProductListContract.View> view;
  private ProductListState state;
  private ProductListContract.Model model;
  //private ProductListContract.Router router;
  private CatalogMediator mediator;


  public ProductListPresenter(CatalogMediator mediator) {
    this.mediator = mediator;
    state = mediator.getProductListState();
  }

//  public ProductListPresenter(ProductListState state) {
//    this.state = state;
//  }

  @Override
  public void injectView(WeakReference<ProductListContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ProductListContract.Model model) {
    this.model = model;
  }

//  @Override
//  public void injectRouter(ProductListContract.Router router) {
//    this.router = router;
//  }

  private void passDataToProductDetailScreen(ProductItem item) {
    mediator.setProduct(item);
  }

  @Override
  public void fetchProductListData() {
    // Log.e(TAG, "fetchProductListData()");

    ProductItem product = getDataFromCategoryListScreen();
    String content = product.getContent();
    Log.e(TAG, "Content " + content);
    int index = Integer.parseInt(content.substring(9));
    Log.e(TAG, "Indice " + index);

    model.setCategoryElegida(index);

    // call the model
    state.products = model.fetchProductListData();
    view.get().editToolbar(index);
    view.get().displayProductListData(state);

  }

  @Override
  public void selectProductListData(ProductItem item) {
    // Log.e(TAG, "fetchProductListData()");
    passDataToProductDetailScreen(item);
    //router.navigateToProductDetailScreen();
    view.get().navigateToProductDetailScreen();
  }

  private ProductItem getDataFromCategoryListScreen() {
    ProductItem product = mediator.getProduct();
    return product;
  }


}
