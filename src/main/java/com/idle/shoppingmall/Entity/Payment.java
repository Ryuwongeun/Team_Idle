package com.idle.shoppingmall.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Payment {
    private Long payment_id;
    private Long created_who;
    private Long product_id;
    private int total_price;
    private String size;
    private int count;
    private DateTime created_at;

}
