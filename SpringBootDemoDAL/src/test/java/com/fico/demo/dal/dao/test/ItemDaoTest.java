package com.fico.demo.dal.dao.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fico.demo.dal.config.test.DatabaseConfigEmptySetUp;
import com.fico.demo.dal.config.test.DatabaseConfigSetUp;
import com.fico.demo.dal.dao.ItemDao;
import com.fico.demo.dal.model.Item;

@RunWith(JUnitPlatform.class)
@DisplayName("Testing ItemDao DAO class")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ItemDaoTest {

	private static final Logger log = LoggerFactory.getLogger(ItemDaoTest.class);

	@Autowired
	private ItemDao classUnderTest;

	@BeforeAll
	static void init() {
		log.info("All tests starting...");
	}

	@BeforeEach
	void setUp() {
		log.info("Test beginning...");
	}

	@AfterEach
	void tearDown() {
		log.info("Test complete.");
	}

	@AfterAll
	static void done() {
		log.info("All tests complete.");
	}

	
	@Nested
	@DisplayName("OPTIMISTIC Scenarios")
	
	class ItemDaoOptimisticScenariosTest {

		private ApplicationContext ctx = new AnnotationConfigApplicationContext(DatabaseConfigSetUp.class);

		@BeforeEach
		public void setUp() throws Exception {
			classUnderTest = ctx.getBean(ItemDao.class);
		}

		@AfterEach
		public void tearDown() throws Exception {
			//DataSource dataSource = (DataSource) ctx.getBean("dataSource");
			//if(null != dataSource) {
				//dataSource.getConnection().close();
			//}
			log.info("No action in tearDown");
		}

		@Test
		@DisplayName("Find All Items")
		public void testFindAll() {
			List<Item> items = classUnderTest.findAll();
			assertNotNull(items);
			assertAll(() -> assertFalse(items.isEmpty()), () -> assertEquals(7, items.size()));
			if (log.isDebugEnabled()) {
				log.debug("Items found: ");
				for (Item item : items) {
					log.debug(ReflectionToStringBuilder.toString(item, new RecursiveToStringStyle()));
				}
			}
		}

	}
	
	@Nested
	@DisplayName("Empty DB Scenarios")
	class ItemDaoEmptyDbScenariosTest {
		private ApplicationContext ctx = new AnnotationConfigApplicationContext(DatabaseConfigEmptySetUp.class);

		@BeforeEach
		public void setUp() throws Exception {
			classUnderTest = ctx.getBean(ItemDao.class);
		}

		@AfterEach
		public void tearDown() throws Exception {
			//DataSource dataSource = (DataSource) ctx.getBean("dataSource");
			//if(null != dataSource) {
				//dataSource.getConnection().
			//}
			log.info("No action in tearDown");
		}

		@Test

		@DisplayName("findAll() returns empty Item list")
		public void testFindAll() {
			List<Item> items = classUnderTest.findAll();
			assertNotNull(items);
			assertTrue(items.isEmpty());
		}
	}
}
