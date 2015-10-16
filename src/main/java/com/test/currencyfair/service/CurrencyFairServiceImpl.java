package com.test.currencyfair.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.currencyfair.model.Trade;
import com.test.currencyfair.repository.TradeDAO;

@Service("currencyFairService")
public class CurrencyFairServiceImpl implements CurrencyFairService {

	@Autowired
	private TradeDAO tradeDao;
	
	/* (non-Javadoc)
	 * @see com.test.currencyfair.service.CurrencyFairService#processTrade(com.test.currencyfair.model.Trade)
	 */
	@Async
	@Transactional
	public void processTrade(Trade trade) {
		System.out.println("New Trade = " + trade);	
		tradeDao.saveTrade(trade);
	}
	
	@Transactional
	public List<Trade> getAllTrades() {
		return tradeDao.getAllTrades();
	}
	
	@Transactional
	public List<Object[]> getTradesByCurrencyFrom() {
		return tradeDao.getTradesByCurrencyFrom();
	}	
	
	@Transactional
	public List<Object[]> getTradesByCurrencyTo() {
		return tradeDao.getTradesByCurrencyTo();
	}		
}
