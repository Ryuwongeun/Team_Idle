window.onload = () => {
    GetListRequest(`/view/GET/love`);
}

function redirectTo(id){
    location.href=`/product/?id=${id}`;
}

function GetListRequest(url){
    const headers = {
        'Content-Type': 'application/json',
    };
    fetch(url, {
        method: 'POST',
        headers: headers
    })
        .then(response => response.json())
        .then(data => {
            const LatestViewController = document.getElementById('field');
            let productsHtml = data.map(item => {
                return `
                <article class="bg-white shadow-md rounded overflow-hidden product-item">
                    <img src="https://source.unsplash.com/random/300x300?clothes&sig=${item.product_id}"
                         alt="Fashion item" class="w-full h-64 object-cover"
                         onclick="redirectTo(${item.product_id})">
                    <div class="p-4">
                        <h3 class="font-semibold">브랜드명 : ${item.product_id}</h3>
                        <h3 class="font-semibold">상품명 : ${item.pd_name}</h3>
                        <p class="text-gray-600">${item.pd_price}원</p>
                        <p class="text-gray-600">좋아요 ${item.count_love}</p>
                        <p class="text-gray-600">댓글 ${item.comment_count}</p>
                    </div>
                </article>
            `;
            }).join('');
            LatestViewController.innerHTML = productsHtml;
        })
        .catch(error => {
            console.error('Error fetching user data:', error);
        });
}
