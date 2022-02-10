package net.koreate.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.koreate.vo.ProductVO;

@Controller
public class SampleController {
	
	public SampleController() {
		System.out.println("SampleController 기본생성자 생성");
	}
	
	@RequestMapping("product")
	public void product(Model model) {
		ProductVO productVO = new ProductVO("TV",100);
		model.addAttribute("product",productVO);
		
		ProductVO productVO2 = new ProductVO("car",200);
		//productVO 로 키값이 자동설정됨
		model.addAttribute(productVO2);
		model.addAttribute("product2",productVO2);

	}
	
	@RequestMapping("doH")
	public ModelAndView doH() {
		ModelAndView mav = new ModelAndView();
		//productVO 로 키값이 자동설정됨
		mav.addObject(new ProductVO("sample1",1000));
		ProductVO product = new ProductVO("smaple2",2000);
		mav.addObject("product",product);
		mav.setViewName("product");
		return mav;
	}
	
	@RequestMapping(value="productWrite", method=RequestMethod.POST)
	public ModelAndView productWrite(
			ModelAndView mav,
			String name,
			int price,
			ProductVO product) {
		System.out.println("name :" + name);
		System.out.println("age : " + price);
		mav.addObject(new ProductVO(name, price));
		System.out.println(product);
		mav.addObject("product",product);
		mav.setViewName("product");
		return mav;
	}
	
}
