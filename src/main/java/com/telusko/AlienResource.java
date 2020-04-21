package com.telusko;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AlienResource {

	@Autowired
	AlienRepository repo;

	@RequestMapping("hello")
	public String SayIt()
	{
		return "Hi";
	}
	
	
	 
	
	@GetMapping("aliens")
	public List<Alien> getAliens() {

		List<Alien> aliens = (List<Alien>) repo.findAll();
		/*
		 * List<Alien> aliens = new ArrayList<>(); Alien a1 = new Alien();
		 * 
		 * a1.setId(101); a1.setName("alex"); a1.setPoints(70);
		 * 
		 * Alien a2 = new Alien(); a2.setId(102); a2.setName("ko"); a2.setPoints(80);
		 * 
		 * aliens.add(a1); aliens.add(a2);
		 */

		return aliens;
	}

	@GetMapping("aliens/{id}")
	    public Alien getAlienById(@PathVariable("id") int id)
	    {
	    	Alien alien = repo.findOne(id);
	    	return alien;
	    }

  
	@PostMapping("aliens")
	    public Alien newAlien(@RequestBody Alien alien) {
	    	//TODO: process POST request
	    	Alien newAlien = repo.save(alien);
	    		    	
	    	return newAlien;
	    } 
	
		  
		@DeleteMapping("aliens/{id}")
		public void deleteAlien (@PathVariable("id") int id) {
			repo.delete(id);
		
		}		
 
		@PutMapping("aliens/{id}")
		public Alien updateAlien (@PathVariable("id") int id,	@RequestBody Alien alienDetail) 
		{
			Alien alien = repo.findOne(id);
			alien.setName(alienDetail.getName());
 			System.out.println(alienDetail.getName());
			
			alien.setPoints(alienDetail.getPoints());
			System.out.println(alienDetail.getPoints());
			repo.save(alien);
			return alien;
		
		}	
		
		@GetMapping("aliens/{name}")
		public Alien findByName(@PathVariable("name") String name ){
			return findByName(name);
		}

}
	    


