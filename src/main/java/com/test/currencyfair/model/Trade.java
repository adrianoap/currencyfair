package com.test.currencyfair.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Trade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private int id; 
	
	@Column(name = "USER_ID", nullable = false)
	public String userId;
	
	@Column(name = "CURRENCY_FROM", nullable = false)
	public String currencyFrom;
	
	@Column(name = "CURRENCY_TO", nullable = false)
	public String currencyTo; 
	
	@Column(name = "AMOUNT_SELL", nullable = false)	
	public Double amountSell;
	
	@Column(name = "AMOUNT_BUY", nullable = false)	
	public Double amountBuy;
	
	@Column(name = "RATE", nullable = false)	
	public Double rate;
	
	@Column(name = "DATE", nullable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MMM-yy HH:mm:ss")	
	public Date timePlaced;
	
	@Column(name = "COUNTRY", nullable = false)	
	public String originatingCountry;

	@Transient
	public String formattedDate;
	
	public Trade(){
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCurrencyFrom() {
		return currencyFrom;
	}

	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	public String getCurrencyTo() {
		return currencyTo;
	}

	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}

	public Double getAmountSell() {
		return amountSell;
	}

	public void setAmountSell(Double amountSell) {
		this.amountSell = amountSell;
	}

	public Double getAmountBuy() {
		return amountBuy;
	}

	public void setAmountBuy(Double amountBuy) {
		this.amountBuy = amountBuy;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Date getTimePlaced() {
		return timePlaced;
	}

	public void setTimePlaced(Date timePlaced) {
		this.timePlaced = timePlaced;
	}

	public String getOriginatingCountry() {
		return originatingCountry;
	}

	public void setOriginatingCountry(String originatingCountry) {
		this.originatingCountry = originatingCountry;
	}

	public String getFormattedDate() {
		return formattedDate;
	}

	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
	}

	@Override
	public String toString() {
		return "Trade [userId=" + userId + ", currencyFrom=" + currencyFrom
				+ ", currencyTo=" + currencyTo + ", amountSell=" + amountSell
				+ ", amountBuy=" + amountBuy + ", rate=" + rate
				+ ", timePlaced=" + timePlaced + ", originatingCountry="
				+ originatingCountry + "]";
	}

}
