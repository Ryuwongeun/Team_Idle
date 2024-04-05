package com.idle.shoppingmall.RequestDTO.User.김승원추가;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CheckNameDTO {
    @NotNull
    private String name;
}
