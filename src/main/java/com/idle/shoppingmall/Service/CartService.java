package com.idle.shoppingmall.Service;


import com.idle.shoppingmall.Entity.Cart;
import com.idle.shoppingmall.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartMapper cartMapper;

    @Transactional
    public void addCart(Cart cartDTO) {

        cartMapper.saveCart(cartDTO);

    } // addCart

} // end class
