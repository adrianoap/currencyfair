package com.test.currencyfair.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.currencyfair.model.Trade;
import com.test.currencyfair.service.CurrencyFairService;

@Controller
public class CurrencyFairController {
	
	@Autowired
	private CurrencyFairService service;
	
	private SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy HH:mm:ss");
	
	@RequestMapping(value="/allTrades", method = RequestMethod.GET)
	public String getAllTrades(ModelMap model) {
		model.addAttribute("alltrades", formatDate(service.getAllTrades()));
		model.addAttribute("tradesByCurrencyFrom", service.getTradesByCurrencyFrom());
		model.addAttribute("tradesByCurrencyTo", service.getTradesByCurrencyTo());
		return "listTrades";
	}	

	@RequestMapping(value="/trade", method=RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Trade addTrade(@RequestBody Trade trade) {
		service.processTrade(trade);
		return trade;
	}	
	
	@RequestMapping(value="/allTradesJson", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Trade> getAllTradesJson() {
		return service.getAllTrades();
	}		
    
	private Object formatDate(List<Trade> allTrades) {
		for (Trade trade : allTrades) {
			Date date = trade.getTimePlaced();
			trade.setFormattedDate(formatter.format(date));			
		}
		return allTrades;
	}    
 
}
