package com.usermanagement.controller;

import com.usermanagement.modelentity.Item;
import com.usermanagement.modelrequest.AddItem;
import com.usermanagement.modelresponse.ItemResponse;
import com.usermanagement.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {"http://localhost:3000", "https://shopwithzosh.vercel.app"})
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/getAllItems")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }



    @PostMapping("/addItem")
    public ResponseEntity<ItemResponse> addItem(@Valid @RequestBody AddItem addItem){
        return new ResponseEntity<>(itemService.save(addItem),HttpStatus.OK);
    }

    @GetMapping("getItemById/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable("id") Long id) {
        Item item = itemService.getItemById(id);
        if (item != null) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/search")
    public ResponseEntity<List<Item>> searchItems(@RequestParam("keywords") List<String> keywords) {
        List<Item> searchResults = itemService.searchItems(keywords);
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }


    // Other controller methods as needed
}

