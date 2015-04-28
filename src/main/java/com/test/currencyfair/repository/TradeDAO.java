package com.test.currencyfair.repository;

import java.util.List;

import com.test.currencyfair.model.Trade;

public interface TradeDAO {

	public abstract void saveTrade(Trade trade);

	public abstract List<Trade> getAllTrades();

	public abstract List<Object[]> getTradesByCurrencyFrom();
	
	public abstract List<Object[]> getTradesByCurrencyTo();
}