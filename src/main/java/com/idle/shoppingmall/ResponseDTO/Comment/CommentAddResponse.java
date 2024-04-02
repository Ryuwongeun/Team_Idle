package com.idle.shoppingmall.ResponseDTO.Comment;

import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CommentAddResponse extends CommonResponse {
    private Long created_who;

    public CommentAddResponse(int code, String msg, Long created_who){
        super(code,msg);
        this.created_who = created_who;
    }
}
