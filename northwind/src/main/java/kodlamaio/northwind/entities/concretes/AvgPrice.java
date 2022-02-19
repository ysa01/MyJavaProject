package kodlamaio.northwind.entities.concretes;

import java.math.BigDecimal;

import lombok.var;

public class AvgPrice {
	private int mins;
	private BigDecimal price;
	private String symbol;
	public int getMins() {
		return mins;
	}
	public void setMins(int mins) {
		this.mins = mins;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	
}
