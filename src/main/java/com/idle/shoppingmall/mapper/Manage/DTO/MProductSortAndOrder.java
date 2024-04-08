package com.idle.shoppingmall.mapper.Manage.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MProductSortAndOrder {
    String where;
    String order;
    int paging;
    int pagingSize;
}

