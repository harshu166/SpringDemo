package com.fico.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.fico.demo.dal.business.CategoryService;
import com.fico.demo.dal.business.ItemService;

@RestController
public class RestServiceController {

  @Autowired
  private ItemService itemService;

  @Autowired
  private CategoryService categoryService;

  public ItemService getItemService() {
    if (itemService == null) {
      throw new RuntimeException("ItemService not configured. Cannot continue.");
    }
    return itemService;
  }

  public CategoryService getCategoryService() {
    if (categoryService == null) {
      throw new RuntimeException("CategoryService not configured. Cannot continue.");
    }
    return categoryService;
  }

}
