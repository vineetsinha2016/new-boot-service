package com.vin.learn.service;

import com.vin.learn.entities.mysql.Items;
import com.vin.learn.model.Item;
import com.vin.learn.model.UserInfo;
import com.vin.learn.repositories.mysql.ItemsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional("mysqlTransactionManager")
public class ItemService {
    final ItemsRepository itemsRepository;

    public ItemService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }
    public List<Item> getItems(HttpHeaders headers) {
        List<Items> items = itemsRepository.findAll();
        return convertEntityToModel(items);
    }
    private List<Item> convertEntityToModel(List<Items> items) {
        List<Item> itemList = new ArrayList<>();
        for (Items i : items) {
            if (i!=null) {
                Item item = convertEntityToModel(i);
                itemList.add(item);
            }
        }
        return itemList;
    }

    private Item convertEntityToModel(Items i) {

        return new Item(i.getItemName(), i.getItemDescription(), i.getItemUid(), i.getCategory().getCategoryName(),
                i.getCategory().getCategoryCode(), i.getFrequency().getFrequencyName(),
                i.getCompletionFlag().equals("Y"), i.getSourceApplication(), i.getAddByUser(), i.getRecordUpdatedTime(),
                (i.getUser()!=null ? new UserInfo(i.getUser().getEmail(), i.getUser().getName()) : null));
    }
}
