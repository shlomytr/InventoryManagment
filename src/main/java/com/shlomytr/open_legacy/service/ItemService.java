package com.shlomytr.open_legacy.service;

import com.shlomytr.open_legacy.model.ItemModel;
import com.shlomytr.open_legacy.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public List<ItemModel> getItems(){
        return repository.findAll();
    }

    public Optional<ItemModel> getItemById(int id) {
        return repository.findById(id);
    }

    public String withdraw(int id, int amount) throws Exception
    {
        if (amount<1)
            throw new Exception("Non positive amount inserted");
        ItemModel item = repository.findById(id).orElse(null);
        int currentAmount = item.getAmount();
        if (currentAmount - amount<0)
            throw new Exception("Can't have a negative amount!");
        currentAmount -= amount;
        item.setAmount(currentAmount);
        repository.save(item);
        return "Withdrawn " + amount + "out of the item with id number of " + id;
    }

    public String deposit(int id, int amount) throws Exception {
        if (amount<1)
            throw new Exception("Non positive amount inserted");
        ItemModel item = repository.findById(id).orElse(null);
        int currentAmount = item.getAmount();
        currentAmount += amount;
        item.setAmount(currentAmount);
        repository.save(item);
        return "Deposited " + amount + "to the item with id number of " + id;

    }

    public String addItem(ItemModel item) throws Exception {
        validateItem(item);
        repository.save(item);
        return "Added item " + item;
    }

    private void validateItem(ItemModel item) throws Exception{
        if (item == null)
            throw new Exception("The item is null");
        if (item.getName() == null)
            throw new Exception("The item does not have a name");
        if (item.getAmount() <0 )
            throw new Exception("Can't have a negative amount");
        if ( item.getInventoryCode() < 1)
            throw new Exception("Can't have a non positive inventory code");
    }

    public String deleteItem(int id) throws Exception {
        ItemModel item = repository.findById(id).orElse(null);
        if (item == null)
            throw new Exception("The item is null");
        repository.deleteById(id);
        return "Item deleted: "+item;
    }
}
