package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.ItemRepository;
import com.example.demo.model.Item;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class ItemServiceApplication {
	private final ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);

	}

	@PostConstruct
	public void initData() {
		List<Item> items = Stream.of(new Item(1, "Pen"), new Item(2, "Pencil"), new Item(3, "Laptop"))
				.collect(Collectors.toList());
		itemRepository.saveAll(items);
	}

}
