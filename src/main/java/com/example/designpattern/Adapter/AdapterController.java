package com.example.designpattern.Adapter;

import com.example.designpattern.Adapter.implementing.Print;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class AdapterController {

	@Resource
	private Print print;

	@GetMapping("/adapter")
	public String adapter(){
		print.setString("hello");
		print.printWeak();
		print.printStrong();
		return "success";
	}

//FileIO f = new FileProperties();
//		try {
//		f.readFromFile("file.txt");
//		f.setValue("year", "2018");
//		f.setValue("month", "4");
//		f.setValue("day", "1");
//		f.writeToFile("newFile.html");
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
}
