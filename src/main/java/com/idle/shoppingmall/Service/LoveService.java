package com.idle.shoppingmall.Service;


import com.idle.shoppingmall.Entity.Key.LoveKey;
import com.idle.shoppingmall.Entity.Love;
import com.idle.shoppingmall.mapper.LoveMapper;
import com.idle.shoppingmall.mapper.Product.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoveService {

    private final LoveMapper loveMapper;
    private final ProductMapper productMapper;

    public Long addLove(Love loveDTO) {
        // 이미 좋아요를 했는지 확인
        Love existingLove = loveMapper.findLove(new LoveKey(loveDTO.getProduct_id(), loveDTO.getCreated_who())).orElse(null);
        if (existingLove == null) {
            long result = loveMapper.addLove(loveDTO);
            productMapper.increaseLoveCount(loveDTO.getProduct_id()); // count_love 증가
            return result;
        }
        return null; // 이미 좋아요를 한 경우, 추가 작업을 하지 않음
    }

    @Transactional
    public void delLove(Love loveDTO) {
        // 실제로 좋아요를 했는지 확인
        Love existingLove = loveMapper.findLove(new LoveKey(loveDTO.getProduct_id(), loveDTO.getCreated_who())).orElse(null);
        if (existingLove != null) {
            loveMapper.deleteLove(loveDTO);
            productMapper.decreaseLoveCount(loveDTO.getProduct_id()); // count_love 감소, 0 이하로 내려가지 않도록 ProductMapper에서 처리 필요
        }
    }


    @Transactional
    public Love findLove(LoveKey loveKey) {
        return loveMapper.findLove(loveKey).orElse(null);
    } // findLove

    @Transactional
    public void loveList(Love loveDTO) {
        loveMapper.loveList(loveDTO);
    } // loveList


} // end class
