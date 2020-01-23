package demo.crud.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import demo.crud.domain.User;
import demo.crud.service.UserService;
import demo.crud.web.form.UserForm;

@Controller
@RequestMapping("/")
public class UserController{
	private static String ATT_USER = "user";
	private static String ATT_URL = "url";
	private static String ATT_ACTION = "action";
	private static String ATT_ACTION_POST = "post";
	private static String ATT_USERS = "users";
	private static String URL = "./";
	
	@Autowired // Automatically instantiate a bean UserService and bind it to our variable
	private UserService userService;
	@Autowired
	private UserForm userForm;
	
	@GetMapping("/")
	public String defaultAction( Model m) {
		List<User> users = userService.getAllUsers();
		Map<Long, User> mapUsers = new HashMap<Long, User>();
		
		
		for(User user : users) {
			mapUsers.put(user.getId(), user);
		}
		
		m.addAttribute(ATT_USERS, mapUsers);
		
		return "userForm";
	}

	@GetMapping("/user/delete/{id}")
	public String delete(@PathVariable int id) {
		userService.deleteUser(id);
		return "redirect:/";
	} 

	@GetMapping("/user/update/{id}")
	public String update(@PathVariable int id, Model m) {
		User user = userService.getUserById(id);
		m.addAttribute(ATT_USER, user);
		m.addAttribute(ATT_URL, URL);
		m.addAttribute(ATT_ACTION, ATT_ACTION_POST);
		m.addAttribute(ATT_USER, user);
		
		return "userForm";
	} 
	
	@PostMapping("/user/update/")
	public String updateSave(WebRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		
		User user = userForm.createUser(request); //Create the user from the form data
		user.setId(id);
		userService.updateUser(user); // Update the current user
		
		return "redirect:/";
	} 
	
	@PostMapping("/user/add")
	public String add(WebRequest request) {
		User user = userForm.createUser(request);
		userService.insertUser(user);
		return "redirect:/";
	} 
	
	@GetMapping("/list")
	public String list() {
		
		return "userForm";
	} 
}