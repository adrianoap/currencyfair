package com.test.currencyfair.service;

import java.util.List;

import com.test.currencyfair.model.Trade;

public interface CurrencyFairService {

	public abstract void processTrade(Trade trade);

	public abstract List<Trade> getAllTrades();
	
	public abstract List<Object[]> getTradesByCurrencyFrom();
	
	public abstract List<Object[]> getTradesByCurrencyTo();
}