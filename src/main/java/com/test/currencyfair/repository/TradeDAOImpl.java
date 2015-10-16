package com.test.currencyfair.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.currencyfair.model.Trade;

@Repository("tradeDao")
public class TradeDAOImpl implements TradeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * @see com.test.currencyfair.repository.TradeDAO#saveTrade(com.test.currencyfair.model.Trade)
	 */
	public void saveTrade(Trade trade){
		sessionFactory.getCurrentSession().saveOrUpdate(trade);
	}
	
	/* (non-Javadoc)
	 * @see com.test.currencyfair.repository.TradeDAO#getAllTrades()
	 */
	public List<Trade> getAllTrades() {
		return sessionFactory.getCurrentSession().createQuery("from Trade").list(); 
	}
	
	public List<Object[]> getTradesByCurrencyFrom() {
		String query = "select currencyFrom, count(t) from Trade t group by currencyFrom";
		return sessionFactory.getCurrentSession().createQuery(query).list(); 
	}
	
	public List<Object[]> getTradesByCurrencyTo() {
		String query = "select currencyTo, count(t) from Trade t group by currencyTo";
		return sessionFactory.getCurrentSession().createQuery(query).list(); 
	}	
}
