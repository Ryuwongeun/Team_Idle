<<<<<<< HEAD:src/main/java/com/idle/shoppingmall/RequestDTO/CartAddRequest.java
package com.idle.shoppingmall.RequestDTO;
=======
package com.idle.shoppingmall.RequestDTO.Product.Add;
>>>>>>> 3f46679d864c1e733ea0ab9d03d6c945baeab7b7:src/main/java/com/idle/shoppingmall/RequestDTO/Product/Add/ProductLogAddRequest.java

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ProductLogAddRequest {
    private Long product_id;
    private String size;
    private int count;
    private Long created_who;
}
