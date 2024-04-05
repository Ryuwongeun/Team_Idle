package com.idle.shoppingmall.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Love {

    private Long product_id;
    private Long created_who;
    private LocalDateTime created_at;

} // end class
