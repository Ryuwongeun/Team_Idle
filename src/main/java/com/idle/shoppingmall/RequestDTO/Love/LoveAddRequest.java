package com.idle.shoppingmall.RequestDTO.Love;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoveAddRequest {

    @NotNull
    private Long product_id;

    @NotNull
    private Boolean isLove; // 좋아요 추가는 true, 좋아요 취소는 false

    // 기존에 비어있던 isLove() 메서드를 수정합니다.
    public boolean isLove() {
        return isLove != null && isLove;
    }
} // end class
