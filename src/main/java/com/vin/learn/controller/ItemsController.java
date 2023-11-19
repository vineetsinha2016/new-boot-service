package com.vin.learn.controller;

import com.vin.learn.model.Item;
import com.vin.learn.model.ServiceResponse;
import com.vin.learn.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/v1")
@Slf4j
public class ItemsController {

    private final ItemService itemService;

    public ItemsController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(value = "/items", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResponseEntity<?> getItem(@RequestHeader HttpHeaders headers)
            throws Exception
    {
        String userAgent = String.join("", headers.getValuesAsList("v-user-Agent"));
        log.info("userAgent in the header is -->{}",userAgent);
        List<Item> items = itemService.getItems(headers);
        ServiceResponse<List<Item>> response = new ServiceResponse<>();
        response.setData(items);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
