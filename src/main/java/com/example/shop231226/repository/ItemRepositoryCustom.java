package com.example.shop231226.repository;

import com.example.shop231226.dto.ItemSearchDto;
import com.example.shop231226.dto.MainItemDto;
import com.example.shop231226.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemRepositoryCustom {

    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getMainItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
}
