package com.usermanagement.service.impl;



import com.usermanagement.modelentity.Item;
import com.usermanagement.modelrequest.AddItem;
import com.usermanagement.modelresponse.ItemResponse;
import com.usermanagement.repository.ItemRepository;
import com.usermanagement.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {


    @Autowired
    private ItemRepository itemRepository;
    @Override
    public ItemResponse save(AddItem addItem) {

        Item newItem = saveItem(addItem);
        return itemToItemResponse(newItem);
    }
    private ItemResponse itemToItemResponse(Item item) {

        return ItemResponse.builder().id(item.getId()).brand(item.getBrand()).title(item.getTitle()).description(item.getDescription()).price(item.getPrice()).imageUrls(item.getImageUrls())
                .name(item.getName())
                .date(item.getDate())
                .location(item.getLocation())
                .phoneNumber(item.getPhoneNumber())
                .build();

        // .roles(u.getRoles()).build()).toList();
    }




    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public List<Item> searchItems(List<String> keywords) {
        List<Item> searchResults = new ArrayList<>();
        for (String keyword : keywords) {
            searchResults.addAll(itemRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword));
        }
        return searchResults;
    }
    private Item saveItem(AddItem addItem) {

        Item item = Item.builder()
                .brand(addItem.getBrand())
                .title(addItem.getTitle())
                .description(addItem.getDescription())
                .price(addItem.getPrice())
                .imageUrls(addItem.getImageUrls())
                .name(addItem.getName())
                .date(addItem.getDate())
                .location(addItem.getLocation())
                .phoneNumber(addItem.getPhoneNumber())
                .build();

        itemRepository.save(item);
        return item;
    }
}