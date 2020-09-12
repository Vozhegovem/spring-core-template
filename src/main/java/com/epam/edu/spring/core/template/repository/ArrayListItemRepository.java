package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {


    @Override
    public Item getById(long id) {
        for(Item item: holder) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        for (Item itemIteration: holder) {
            if(itemIteration.equals(item)) {
                return false;
            }
        }
        holder.add(item);
        return true;
    }

    void setInitialSequence(@Value("${initial.sequence}")int val) {
        initialSequence = val;
    }

    void setHolder() {
        holder = new ArrayList<>();
    }
}
