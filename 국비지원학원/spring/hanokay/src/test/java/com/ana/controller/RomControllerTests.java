package com.ana.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class RomControllerTests {

	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testList() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/rom/list")
				.param("acmNum", "A4")
				.param("person", "3")
				).andReturn().getModelAndView().getModelMap());
	}
	
	@Test
	public void testAll() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/rom/all")
				.param("acmNum", "A9999")
				).andReturn().getModelAndView().getModelMap());
	}

	@Test
	public void testGet() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/rom/get")
				.param("romNum", "R10"))
				.andReturn()
				.getModelAndView().getModelMap());
	}
}

//******** REST ********
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
//		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
//@Log4j
//public class RomControllerTests {
//	@Setter(onMethod_ = { @Autowired })
//	private WebApplicationContext ctx;
//
//	private MockMvc mockMvc;
//
//	@Before
//	public void setup() {
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
//	}
//
//	@Test
//	public void testConvert1() throws Exception {
//		RomVO rom = new RomVO();
//		rom.setAcmNum("A123");
//		rom.setRoomName("test");
//		rom.setCapacity(99);
//		rom.setBedType("???????????????");
//		rom.setBedCnt(1);
//		rom.setRomSize(1);
//		rom.setPrice(99999);
//		rom.setRomUrl("test");
//		rom.setRomLocainfo("test");
//		String jsonStr = new Gson().toJson(rom);
//		log.info(jsonStr);
//		mockMvc.perform(post("/accommodation/new").contentType(MediaType.APPLICATION_JSON).content(jsonStr))
//				.andExpect(status().is(200));
//	}
//}
