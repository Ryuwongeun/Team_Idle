package com.idle.shoppingmall.Entity;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class Brand {

    private Long brand_id;
    private String brand_name;
    private Long created_who;
    private String created_at;

    public Brand(Long brand_id, String brand_name, Long created_who, String created_at) {

        this.brand_id = brand_id;
        this.brand_name = brand_name;
        this.created_who = created_who;
        this.created_at = created_at;

    } // Constructor

} // end class
