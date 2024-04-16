document.getElementById('sellCount');
let page = 1;
    console.log('DOM fully loaded and parsed'); // DOM 로딩 확인
    console.log('sellCount clicked'); // 'sellCount' 클릭 확인
    GetListRequestBySellCount(`/view/GET/sellCount?page=${page}`);

function GetListRequestBySellCount(url) {
    const headers = {
        'Content-Type': 'application/json',
    };
    fetch(url, {
        method: 'POST',
        headers: headers
    })
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {

            console.log(data); // 데이터 구조 확인을 위한 로그 출력

            const LatestViewController = document.getElementById('field');
            let productsHtml = data.map(item => {
                return `
                <article class="bg-white shadow-md rounded overflow-hidden">
                     <img src="https://source.unsplash.com/random/300x300?clothes&sig=${item.product_id}"
                         alt="Fashion item" class="w-full h-64 object-cover"
                         onclick=redirectTo(${item.product_id})>
                         
                    <div class="p-4">
                        <h3 class="font-semibold">상품명 : ${item.pd_name}</h3>
                        <p class="text-gray-600">${item.pd_price}원</p>
                        <p class="text-gray-600" >${item.count_love}</p>
                        <p class="text-gray-600" >${item.pd_sell_count}</p>
                        
                    </div>
                </article>`
            }).join('');
            LatestViewController.innerHTML = productsHtml
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });
}
