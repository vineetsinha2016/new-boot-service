package com.vin.learn.model;

import java.util.Date;

public record Item(
        String itemName,
        String itemDescription,
        String itemUid,
        String category,
        String categoryCode,
        String frequency,
        boolean finished,
        String sourceApplication,
        String addByUser,
        Date lastUpdatedTimeStamp,
        UserInfo user) { }
