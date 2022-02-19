package kodlamaio.northwind.api.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.concretes.BitcoinManager;
import kodlamaio.northwind.entities.concretes.AvgPrice;


@RestController
@RequestMapping(value = "/template")
public class BourseWebService {

	@Autowired
	private BitcoinManager bitcoinManager;
	
	@GetMapping(value = "/money/{symbl}")
	public ResponseEntity<AvgPrice> getMoneyList( @PathVariable String symbl) {
		AvgPrice avgPrice = bitcoinManager.getEmployees(symbl);
		avgPrice.setSymbol(symbl);
	 return ResponseEntity.ok(avgPrice);
	}
}
