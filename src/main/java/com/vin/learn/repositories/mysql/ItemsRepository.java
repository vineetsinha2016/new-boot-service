package com.vin.learn.repositories.mysql;

import com.vin.learn.entities.mysql.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemsRepository extends JpaRepository<Items, Integer> {
    Items findByItemUid(String uid);
    @Query(value = "select * from items where itm_nme LIKE :itemName%", nativeQuery = true)
    List<Items> findAllItemsByItemName(@Param("itemName") String itemName);
    List<Items> findAllByUsersId(String id);
}
