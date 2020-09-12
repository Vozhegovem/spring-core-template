package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;

import java.util.LinkedList;
import java.util.Random;

/**
 * Репозиторий, основанный на классе LinkedList.
 * initialSequence должен случайно генерироваться из диапазона от 1 до 100
 */
public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    @Override
    public Item getById(long id) {
        for(Item item: holder){
            if(item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        for(Item itemIteration: holder) {
            if(itemIteration.equals(item)){
                return false;
            }
        }
        holder.add(item);
        return true;
    }

    void setInitialSequence(int val) {
        initialSequence = new Random().nextInt(100);
    }

    void setHolder() {
        holder = new LinkedList<>();
    }
}
