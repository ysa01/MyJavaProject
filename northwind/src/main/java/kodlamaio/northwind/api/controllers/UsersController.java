package kodlamaio.northwind.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;

@RestController
@RequestMapping(value ="/api/users")
public class UsersController {
	
	private UserService userService;
	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody User user) {// T yerine neden ? kullandık çünkü data eklenmezse ve error dönersek bunu frontend çiye göstermek lazım
		return ResponseEntity.ok(this.userService.add(user));
	}
//.Net de typeOf olarak geçer MethodArgumentNotValidException
	@ExceptionHandler(MethodArgumentNotValidException.class)// tüm validation kuralları notNull , required , email gibi alanlar MethodArgumentNotValidException olarak geçer
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){	//Object tüm classların basedir ilkel type (primitive) bile base dir.
	//Dictionary olarak geçer Map	
		Map<String,String> validationErrors = new HashMap<String, String>();//hashmap bir map implementasyonu
		//ilk string örnek email , hatası string gibi ikiside string
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}//Methodun asıl yaptığı iş annotasyonla hatayı yakalayıp parametre olarak methoda atıyor biz ordan alıp for la mapin içine basıyoruz.ve map formatında kullanıyoruz.
		//Bu validation errorları bizim error nesnesmize çeviricez
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama Hataları");
		return errors;
	}
}
