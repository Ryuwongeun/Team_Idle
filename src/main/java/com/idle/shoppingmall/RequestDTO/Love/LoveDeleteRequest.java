package com.idle.shoppingmall.RequestDTO.Love;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoveDeleteRequest {

    @NotNull
    private Long product_id;

} // end class
