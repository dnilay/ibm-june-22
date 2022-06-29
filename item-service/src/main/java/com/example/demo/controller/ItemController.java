package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ItemRepository;
import com.example.demo.model.Item;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ItemController {
	
	private final ItemRepository itemRepository;
	
	@PostMapping("/items")
	public Item createItem(@RequestBody Item item)
	{
		return itemRepository.save(item);
	}
	
	@GetMapping("/items")
	public Iterable<Item> fetchItems()
	{
		return itemRepository.findAll();
	}
	
}
