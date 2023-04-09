package es.ulpgc.eite.cleancode.catalog.app;

import es.ulpgc.eite.cleancode.catalog.category.CategoryState;
import es.ulpgc.eite.cleancode.catalog.product.ProductDetailState;
import es.ulpgc.eite.cleancode.catalog.products.ProductListState;

public class CatalogMediator {

  private ProductListState productListState = new ProductListState();
  private ProductDetailState productDetailState = new ProductDetailState();
  private CategoryState categoryState = new CategoryState();
  private ProductItem product;
  private CategoryItem categoryItem;

  private static CatalogMediator INSTANCE;


  private CatalogMediator() {

  }

  public static void resetInstance() {
    INSTANCE = null;
  }


  public static CatalogMediator getInstance() {
    if(INSTANCE == null){
      INSTANCE = new CatalogMediator();
    }

    return INSTANCE;
  }


  public ProductListState getProductListState() {
    return productListState;
  }

  public ProductDetailState getProductDetailState() {
    return productDetailState;
  }

  public ProductItem getProduct() {
    ProductItem item = product;
    return item;
  }


  public void setProduct(ProductItem item) {
    product = item;
  }

  public void setCategory(CategoryItem item) {
    categoryItem = item;
  }
  public CategoryState getCategoryState() {
    return categoryState;
  }


  public CategoryItem getCategoryItem(){
    CategoryItem item = categoryItem;
    return item;
  }
}
