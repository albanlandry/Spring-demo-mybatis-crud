package demo.crud.web.form;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import demo.crud.domain.User;

@Component
public class UserForm {
	private static final String FIELD_ID = "id";
	private static final String FIELD_NAME = "name";
	private static final String FIELD_EMAIL = "email";
	private static final String FIELD_GENDER = "gender";
	private static final String FIELD_ADDRESS = "address";
	
	private String result;
	private Map<String, String> errors = new HashMap<String,String>();
	
	
	public User createUser(WebRequest request) {
		String name = getFieldValue( request, FIELD_NAME );
		String email = getFieldValue( request, FIELD_EMAIL );
		String gender = getFieldValue( request, FIELD_GENDER );
		String address = getFieldValue( request, FIELD_ADDRESS );
		
		User usr = new User();
		
		usr.setName(name);
		usr.setEmail(email);
		usr.setGender(gender.trim().charAt(0));
		usr.setAddress(address);
				
		return usr;
	}
	
	public User createUser(WebRequest request, long id) {
		String name = getFieldValue( request, FIELD_NAME );
		String email = getFieldValue( request, FIELD_EMAIL );
		String gender = getFieldValue( request, FIELD_GENDER );
		String address = getFieldValue( request, FIELD_ADDRESS );
		
		User usr = new User();
		
		usr.setId(id);
		usr.setName(name);
		usr.setEmail(email);
		usr.setGender(gender.trim().charAt(0));
		usr.setAddress(address);
				
		return usr;
	}
	
	public String getResult() {
		return result;
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	/**
	 * return the value of a http request attribute
	 * */
	private static String getFieldValue( WebRequest request, String nomChamp ) {
		String valeur = request.getParameter( nomChamp );
			
		if ( valeur == null || valeur.trim().length() == 0 ) {
			return null;
		} else {
			return valeur.trim();
		}
	}
}
