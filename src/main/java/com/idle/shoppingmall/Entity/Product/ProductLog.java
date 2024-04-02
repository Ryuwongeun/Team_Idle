package com.idle.shoppingmall.Entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ProductLog {
    private Long product_id;
    private String size;
    private int count;
    private Long created_who;
    private DateTime created_at;

}
