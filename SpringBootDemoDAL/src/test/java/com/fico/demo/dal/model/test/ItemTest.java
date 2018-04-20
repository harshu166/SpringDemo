package com.fico.demo.dal.model.test;

import java.util.Date;

import com.fico.demo.dal.model.Item;

public class ItemTest {

  private static final Date now = new Date();

  public static final Item ITEM_1 = new Item().withCategory(CategoryTest.CATEGORY_1).withDescription("ITEM_1")
      .withDueDate(now).withFinished(false).withId(100L).withWhenCreated(now)
      .withWhenLastUpdated(now);
  public static final Item ITEM_2 = new Item().withCategory(CategoryTest.CATEGORY_2).withDescription("ITEM_2")
      .withDueDate(now).withFinished(false).withId(100L).withWhenCreated(now)
      .withWhenLastUpdated(now);
  public static final Item ITEM_3 = new Item().withCategory(CategoryTest.CATEGORY_3).withDescription("ITEM_3")
      .withDueDate(now).withFinished(false).withId(100L).withWhenCreated(now)
      .withWhenLastUpdated(now);
  public static final Item ITEM_4 = new Item().withCategory(CategoryTest.CATEGORY_4).withDescription("ITEM_4")
      .withDueDate(now).withFinished(false).withId(100L).withWhenCreated(now)
      .withWhenLastUpdated(now);
  public static final Item ITEM_5 = new Item().withCategory(CategoryTest.CATEGORY_5).withDescription("ITEM_5")
      .withDueDate(now).withFinished(false).withId(100L).withWhenCreated(now)
      .withWhenLastUpdated(now);
  public static final Item ITEM_6 = new Item().withCategory(CategoryTest.CATEGORY_6).withDescription("ITEM_6")
      .withDueDate(now).withFinished(false).withId(100L).withWhenCreated(now)
      .withWhenLastUpdated(now);
  public static final Item ITEM_7 = new Item().withCategory(CategoryTest.CATEGORY_7).withDescription("ITEM_7")
      .withDueDate(now).withFinished(false).withId(100L).withWhenCreated(now)
      .withWhenLastUpdated(now);
  public static final Item ITEM_8 = new Item().withCategory(CategoryTest.CATEGORY_8).withDescription("ITEM_8")
      .withDueDate(now).withFinished(false).withId(100L).withWhenCreated(now)
      .withWhenLastUpdated(now);
  public static final Item ITEM_9 = new Item().withCategory(CategoryTest.CATEGORY_9).withDescription("ITEM_9")
      .withDueDate(now).withFinished(false).withId(100L).withWhenCreated(now)
      .withWhenLastUpdated(now);
  public static final Item ITEM_10 =
      new Item().withCategory(CategoryTest.CATEGORY_10).withDescription("ITEM_10")
          .withDueDate(now).withFinished(false).withId(100L).withWhenCreated(now)
          .withWhenLastUpdated(now);
}
