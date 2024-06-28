package com.example.MobileShop.PhoneVariable;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PhoneVariableRepository  extends JpaRepository<PhoneVariable, UUID> {

    @Query("SELECT pv FROM PhoneVariable pv WHERE pv.phone = :id")
    List<PhoneVariable> getAllPhoneChildrenByPhoneMainId(@Param("id") UUID id);


//    @Query(value = "SELECT pv.phone_variable_id, pv.common_product_id, pv.color, pv.ram, pv.rom, pv.disk, " +
//            "pv.internal_storage, pv.release_date, pv.battery_capacity, pv.camera, pv.is_show, pv.created_at, " +
//            "pv.updated_at, cdp.description, cdp.price, cdp.quantity_of_goods, cdp.title, cdp.warranty, " +
//            "cdp.code, im.url " +
//            "FROM phone_variable pv " +
//            "INNER JOIN common_detail_product cdp ON pv.common_product_id = cdp.common_product_id " +
//            "INNER JOIN images im ON im.image_id = cdp.image_id " +
//            "WHERE pv.phone_variable_id = :id",
//            nativeQuery = true)
//    ResponsePhoneVariable findPhoneVariableAndCommonDetailProductById(@Param("id") UUID id);



    @Transactional
    @Query(value = "SELECT * FROM phone_variable pv " +
            "WHERE (:color IS NULL OR pv.color = :color) " +
            "AND (:ram IS NULL OR pv.ram = :ram) " +
            "AND (:internal_storage IS NULL OR pv.internal_storage = :internal_storage) " +
            "AND (:battery_capacity IS NULL OR pv.battery_capacity = :battery_capacity)",
            countQuery = "SELECT count(*) FROM phone_variable pv " +
                    "WHERE (:color IS NULL OR pv.color = :color) " +
                    "AND (:ram IS NULL OR pv.ram = :ram) " +
                    "AND (:internal_storage IS NULL OR pv.internal_storage = :internal_storage) " +
                    "AND (:battery_capacity IS NULL OR pv.battery_capacity = :battery_capacity)",
            nativeQuery = true)
    Page<PhoneVariable> findAllByFilters(
            @Param("color") String color,
            @Param("ram") String ram,
            @Param("internal_storage") String internal_storage,
            @Param("battery_capacity") Double battery_capacity,
            Pageable pageable);
}
