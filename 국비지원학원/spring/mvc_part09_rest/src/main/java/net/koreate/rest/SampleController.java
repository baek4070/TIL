package net.koreate.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.koreate.vo.SampleVO;

@Controller
public class SampleController {
	
	@GetMapping("/testJSON")
	public String toJSON(Model model) {
		model.addAttribute("Hello Word!!");
		return "JSON";
	}
	
	@GetMapping("/sendSampleVO")
	public String sendSampleVO(Model model) {
		SampleVO vo = new SampleVO();
		vo.setName("쉬면석");
		vo.setAge(70);
		model.addAttribute("sample",vo);
		return "JSON";
	}
	
	@GetMapping("/getSample")
	@ResponseBody
	public SampleVO getSample(SampleVO sample) {
		System.out.println("getSample GET 요청");
		System.out.println(sample);
		return sample;
	}
	
	
}








