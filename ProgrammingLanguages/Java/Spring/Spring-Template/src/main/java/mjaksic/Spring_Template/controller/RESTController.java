package mjaksic.Spring_Template.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mjaksic.Spring_Template.response.ResponseData;
import mjaksic.Spring_Template.response.ResponseSuccess;

/*
 * RestController -> registers a REST class
 * XMapping -> maps resources and HTTP methods
 * RequestParam -> parameter in the URI
 * RequestBody -> JSON body that has to be passed in the HTTP request
 */
@RestController
public class RESTController {
	private Map<String, ResponseData> value_store = new HashMap<String, ResponseData>();
	
	
	
	@PutMapping("/data/{id}")
	public ResponseSuccess CreateData(@RequestParam(value = "id") String id, @RequestBody ResponseData data) {
		value_store.put(id, data);
		return new ResponseSuccess(true);
	}
	
	@GetMapping("/data/{id}")
	public ResponseData ReadData(@RequestParam(value = "id") String id) {
		if (this.value_store.containsKey(id)) {
			return this.value_store.get(id);
		}
		return new ResponseData(0, null);
	}

	@DeleteMapping("/data/{id}")
	public ResponseSuccess DeleteData(@RequestParam(value = "id") String id) {
		if (this.value_store.containsKey(id)) {
			value_store.remove(id);
			return new ResponseSuccess(true);
		}
		return new ResponseSuccess(false);
	}
}
