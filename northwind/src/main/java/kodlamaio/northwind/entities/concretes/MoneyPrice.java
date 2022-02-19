package kodlamaio.northwind.entities.concretes;

import java.math.BigDecimal;
import java.util.Date;


public class MoneyPrice {
	private Date date;
	private BigDecimal tP_DK_USD_A;
	private BigDecimal tP_DK_EUR_A;
	private BigDecimal tP_DK_CHF_A;
	private BigDecimal tP_DK_GBP_A;
	private BigDecimal tP_DK_JPY_A;
	private UnixTime unixTime;
	public UnixTime getUnixTime() {
		return unixTime;
	}
	public void setUnixTime(UnixTime unixTime) {
		this.unixTime = unixTime;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public BigDecimal gettP_DK_USD_A() {
		return tP_DK_USD_A;
	}
	public void settP_DK_USD_A(BigDecimal tP_DK_USD_A) {
		this.tP_DK_USD_A = tP_DK_USD_A;
	}
	public BigDecimal gettP_DK_EUR_A() {
		return tP_DK_EUR_A;
	}
	public void settP_DK_EUR_A(BigDecimal tP_DK_EUR_A) {
		this.tP_DK_EUR_A = tP_DK_EUR_A;
	}
	public BigDecimal gettP_DK_CHF_A() {
		return tP_DK_CHF_A;
	}
	public void settP_DK_CHF_A(BigDecimal tP_DK_CHF_A) {
		this.tP_DK_CHF_A = tP_DK_CHF_A;
	}
	public BigDecimal gettP_DK_GBP_A() {
		return tP_DK_GBP_A;
	}
	public void settP_DK_GBP_A(BigDecimal tP_DK_GBP_A) {
		this.tP_DK_GBP_A = tP_DK_GBP_A;
	}
	public BigDecimal gettP_DK_JPY_A() {
		return tP_DK_JPY_A;
	}
	public void settP_DK_JPY_A(BigDecimal tP_DK_JPY_A) {
		this.tP_DK_JPY_A = tP_DK_JPY_A;
	}
	
}
