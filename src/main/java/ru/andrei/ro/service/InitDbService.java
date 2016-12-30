package ru.andrei.ro.service;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.andrei.ro.entity.Blog;
import ru.andrei.ro.entity.Item;
import ru.andrei.ro.entity.Role;
import ru.andrei.ro.entity.User;
import ru.andrei.ro.repository.BlogRepository;
import ru.andrei.ro.repository.ItemRepository;
import ru.andrei.ro.repository.RoleRepository;
import ru.andrei.ro.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@PostConstruct
	public void init() {
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setName("admin");
		List<Role> roles = new ArrayList<Role>(); 
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		Blog blogJavavids = new Blog();
		blogJavavids.setName("JavaVids");
		blogJavavids.setUrl("http://www.feedforall.com/sample.xml");
		blogJavavids.setUser(userAdmin);
		blogRepository.save(blogJavavids);
		
		Item item1 =  new Item();
		item1.setBlog(blogJavavids);
		item1.setTitle("first");
		item1.setLink("www.google.com");
		item1.setPublishedDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		itemRepository.save(item1);
		
		Item item2 =  new Item();
		item2.setBlog(blogJavavids);
		item2.setTitle("second");
		item2.setLink("www.google.com");
		item2.setPublishedDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		itemRepository.save(item2);
		
	}
}
