package com.vladwick.web.logs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vladwick.repository.TransferLogRepository;
import com.vladwick.service.TransferLogService;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class LogWeb {
	
	@Autowired
	private TransferLogRepository transferLogRepository;
	
	@GetMapping("/logs")
	public String getLogsPage(Model model) {
		model.addAttribute("transfers", transferLogRepository.findAll());
		return "logs/logs";
	}
	
	
	
}
