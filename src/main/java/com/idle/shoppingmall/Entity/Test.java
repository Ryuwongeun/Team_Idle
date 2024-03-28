package com.idle.shoppingmall.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class Test {
    private String id;
    private String name;

    public Test(String id, String name){
        this.id = id;
        this.name = name;
    }
}
