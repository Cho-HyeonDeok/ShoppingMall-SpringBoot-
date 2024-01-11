package com.example.shop231226.dto;

import com.example.shop231226.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemSearchDto {

    private String searchDateType;
    private ItemSellStatus searchSellStatus;
    private String searchBy;
    private String searchQuery = "";
}
