package com.idle.shoppingmall.ResponseDTO.Manage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MCSListRepsonse {
    private Long cs_id;
    private Long created_who;
    private String created_at;
    private String state;
}
