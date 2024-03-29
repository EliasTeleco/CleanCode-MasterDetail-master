package es.ulpgc.eite.cleancode.catalog.product;

import java.lang.ref.WeakReference;

interface ProductDetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayProductDetailData(ProductDetailViewModel viewModel);
    void editToolbar(float option);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    //void injectRouter(Router router);

    void fetchProductDetailData();
  }

  interface Model {

  }

//  interface Router {
//
//    ProductItem getDataFromProductListScreen();
//  }
}