package com.usermanagement.service;

import com.usermanagement.modelentity.Item;
import com.usermanagement.modelrequest.AddItem;
import com.usermanagement.modelrequest.UserSignUp;
import com.usermanagement.modelresponse.ItemResponse;
import com.usermanagement.modelresponse.UserResponse;

import java.util.List;

public interface ItemService {
    ItemResponse save(AddItem addItem);
    List<Item> getAllItems();
    Item addItem(Item item);
    Item getItemById(Long id);
    List<Item> searchItems(List<String>keywords);
}