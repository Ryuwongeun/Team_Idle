window.onload = () => {
    GetListRequest(`/view/POST/productLatest`);
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
            // Thymeleaf로 직접 데이터 추가
            const LatestViewController = document.getElementById('field');
            // 데이터 배열을 순회하면서 각 항목을 HTML로 변환
            let productsHtml = data.map(item => {
                return `
                <article class="bg-white shadow-md rounded overflow-hidden">
                    <img src="https://source.unsplash.com/random/300x300?clothes&sig=${item.product_id}"
                         alt="Fashion item" class="w-full h-64 object-cover"
                         onclick=redirectTo(${item.product_id})>
                    <div class="p-4">
                        <h3 class="font-semibold">브랜드명 : ${item.product_id}</h3>
                        <h3 class="font-semibold">상품명 : ${item.pd_name}</h3>
                        <p class="text-gray-600">${item.pd_price}원</p>
                        <p class="text-gray-600" >${item.count_love}</p>
                    </div>
                </article>
            `;
            }).join(''); // 배열의 모든 항목을 하나의 문자열로 결합
            LatestViewController.innerHTML = productsHtml;
        })
        .catch(error => {
            console.error('Error fetching user data:', error);
        }
        );
}