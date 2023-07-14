package com.mohnish.sportyshoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")
public class UserController 
{
	
	@Autowired
	private UserService service;
	
	
	@Autowired
	private UserRepository repo;
	
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		
		return service.findAll();
	}
	
	
	@GetMapping("/api/admin/users/{id}")
	public ResponseEntity<Object> findUsersById(@PathVariable("id") int id)
	{
		
		User data = service.getUserById(id);
		if(data!=null)
		return new ResponseEntity<Object>(data,HttpStatus.OK);
		else
		return new ResponseEntity<Object>("User not found",HttpStatus.NOT_FOUND);	
		
	}
	

	@PostMapping("/join")
    public String joinGroup(@RequestBody User user) {
        user.setRole(UserConstant.DEFAULT_ROLE);//USER
        String encryptedPwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPwd);
        repo.save(user);
        return "Hi"+ user.getUserName()+" welcome to group !";
    }
	
	
	@PostMapping("/change-password")
	public String changePassword(@RequestBody PasswordRequestUtil requestUtil)
	{
		
		User user = service.findByEmail(requestUtil.getEmail()).get();
		
		if(!service.oldPasswordIsValid(user,requestUtil.getOldPassword()))
		return "Incorrect old password";
		
		service.changePassword(user,requestUtil.getNewPassword());
		
		return "Password changed successfully";
	}
	

	
	
}	
	
	
	
	
	


