package com.shlomytr.open_legacy.controller;

import com.shlomytr.open_legacy.model.ItemModel;
import com.shlomytr.open_legacy.service.ItemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemController {

    @Autowired
    ItemService service;

    @GetMapping(path = "/items")
    @ApiOperation(value = "View a list of all the items in the database", response = List.class)
    public List<ItemModel> getItems(){
        return service.getItems();
    }

    @GetMapping(path = "/items/{id}")
    @ApiOperation("Gets the item with the entered id")
    public Optional<ItemModel> getItemById(@PathVariable int id){
        return service.getItemById(id);
    }

    @PutMapping(path = "/withdraw/{id}")
    @ApiOperation("Withdraws amount from item with the entered id")
    public String withdraw(@PathVariable int id, int amount) throws Exception{
        return service.withdraw(id, amount);
    }

    @PutMapping(path = "/deposit/{id}")
    @ApiOperation("Deposits amount from item with the entered id")
    public String deposit(@PathVariable int id, int amount) throws Exception {
        return service.deposit(id, amount);
    }

    @PostMapping(path = "/add")
    @ApiOperation("Add a new item to the database")
    public String addItem(@RequestBody ItemModel item) throws Exception{
        return service.addItem(item);
    }

    @DeleteMapping(path = "/items/{id}")
    @ApiOperation("Delete an item with the entered id")
    public String deleteItem (@PathVariable int id)throws Exception{
        return service.deleteItem(id);
    }



}
