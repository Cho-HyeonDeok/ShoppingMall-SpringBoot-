package com.example.shop231226.entity;

import com.example.shop231226.dto.ItemFormDto;
import com.example.shop231226.constant.ItemSellStatus;
import com.example.shop231226.exception.OutOfStockException;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@Entity
@Table(name="item")
@NoArgsConstructor
public class Item extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long id;

    @Column(nullable = false, length = 50)
    private String itemNm;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(nullable = false)
    private int stockNumber;

    @Lob
    @Column(nullable = false)
    private String itemDetail;

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;

    @Column
    private LocalDateTime regTime;

    @Column
    private LocalDateTime updateTime;

    @Builder
    public Item(String itemNm, int price, int stockNumber, String itemDetail, ItemSellStatus itemSellStatus, LocalDateTime regTime, LocalDateTime updateTime) {
        this.itemNm = itemNm;
        this.price = price;
        this.stockNumber = stockNumber;
        this.itemDetail = itemDetail;
        this.itemSellStatus = itemSellStatus;
        this.regTime = regTime;
        this.updateTime = updateTime;
    }

    public void updateItem(ItemFormDto itemFormDto) {
        this.itemNm = itemFormDto.getItemNm();
        this.price = itemFormDto.getPrice();
        this.stockNumber = itemFormDto.getStockNumber();
        this.itemDetail = itemFormDto.getItemDetail();
        this.itemSellStatus = itemFormDto.getItemSellStatus();
    }

    public void removeStock(int stockNumber) {

        int restStock = this.stockNumber - stockNumber;
        if(restStock<0) {
            throw new OutOfStockException("상품의 재고가 부족 합니다. (현재 재고 수량: " + this.stockNumber + ")");
        }
        this.stockNumber = restStock;
    }

    public void addStock(int stockNumber) {
        this.stockNumber += stockNumber;
    }
}
