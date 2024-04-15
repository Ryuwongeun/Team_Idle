window.onload = () => {
    GetListRequest(`/view/GET/sellCount`);
}

function redirectTo(id){
    location.href=`/product/?id=${id}`;
}

function GetListRequest(url){
    const headers = {
        'Content-Type': 'application/json',
    };
    fetch(url, {
        method: 'GET', // 'POST'에서 'GET'으로 변경
        headers: headers
    })
        .then(response => response.json())
        .then(data => {
            console.log(data); // 데이터 구조 확인을 위한 로그 출력

            const LatestViewController = document.getElementById('sellCount');
            let productsHtml = data.map(item => {
                return `
            <article class="bg-white shadow-md rounded overflow-hidden">
                <img src="https://source.unsplash.com/random/300x300?clothes&sig=${item.product_id}"
                     alt="Fashion item" class="w-full h-64 object-cover"
                     onclick="redirectTo(${item.product_id})"> <!-- 인용부호 추가 -->
                <div class="p-4">
                    <h3 class="font-semibold">브랜드명 : ${item.product_id}</h3>
                    <h3 class="font-semibold">상품명 : ${item.pd_name}</h3>
                    <p class="font-semibold">가격 : ${item.pd_price}원</p>
                    <p class="font-semibold">좋아요 : ${item.count_love}</p>
                    <p class="font-semibold">카테고리 : ${item.pd_category}</p>
                    <p class="font-semibold">판매수 : ${item.pd_sell_count}</p>
                </div>
            </article>
            `;
            }).join('');
            LatestViewController.innerHTML = productsHtml;
        })
        .catch(error => {
                console.error('Error fetching user data:', error);
            }
        );
}
