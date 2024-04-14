package com.jbk.RevisionAngular;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")  // agar post, get method ke liye request aa rahi hai to usko accepet kro reject mt kro
public class RagistrationController {

	@Autowired
	SessionFactory sf;
	
	@PostMapping("saveData")
	public void saveData(@RequestBody User user) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.persist(user);
		tr.commit();
		
	}
	@GetMapping("getUser/{username}")
	public User getUser(@PathVariable String username) {
		
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		User user=session.get(User.class, username);
		System.out.println(user);
		tr.commit();
		return user;
	}
	
	
	@DeleteMapping("deleteUser/{username}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable String username) {
		try {
			Session session=sf.openSession();
			Transaction tr=session.beginTransaction();
			User user=session.get(User.class, username);
			session.delete(user);
			tr.commit();
			System.out.println(user);
			ResponseEntity<Boolean> responseentity=new ResponseEntity<Boolean>(true,HttpStatus.OK);
			return responseentity;
		}catch(Exception e) {
			ResponseEntity<Boolean> responseentity=new ResponseEntity<Boolean>(false,HttpStatus.OK);
			return responseentity;
		}
		}
	
	@GetMapping("getAllUser")
	public List<User> getAllUser() {
		Session session=sf.openSession();
		return session.createQuery("from User").list();
		}
	
	
	
	
	
	
	
}