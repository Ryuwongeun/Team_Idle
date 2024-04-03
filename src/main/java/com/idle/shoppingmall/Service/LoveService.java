package com.idle.shoppingmall.Service;


import com.idle.shoppingmall.Entity.Key.LoveKey;
import com.idle.shoppingmall.Entity.Love;
import com.idle.shoppingmall.mapper.LoveMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoveService {

    private final LoveMapper mapper;

    @Transactional
    public Long addLove(Love loveDTO) {
        return mapper.addLove(loveDTO);
    } // addLove

    @Transactional
    public Love findLove(LoveKey loveKey) {
        return mapper.findLove(loveKey);
    } // findLove

    @Transactional
    public void loveList(Love loveDTO) {
        mapper.loveList(loveDTO);
    } // loveList

    @Transactional
    public void delLove(Love loveDTO) {
        mapper.deleteLove(loveDTO);
    } // delLove


} // end class
