package com.idle.shoppingmall.ResponseDTO.Comment;

import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentImgAddResponse extends CommonResponse {
    private String img_name;

    public CommentImgAddResponse(int code,String msg,String img_name){
        super(code,msg);
        this.img_name = img_name;
    }
}
