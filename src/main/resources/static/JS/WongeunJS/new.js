window.onload = () => {
    GetListRequestByCreatedAt(`/view/GET/CreatedAt?page=1`);
    console.log('DOM fully loaded and parsed'); // DOM 로딩 확인
}

function redirectTo(id){
    location.href = `/product/?id=${id}`;
}

let page = 1;
console.log('DOM fully loaded and parsed'); // DOM 로딩 확인
GetListRequest(`/view/GET/productLatest?page=${page}`);

function GetListRequestByCreatedAt(url){

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

            // 데이터 배열을 순회하면서 각 항목을 HTML로 변환

            const LatestViewController = document.getElementById('field');

            let productsHtml = data.map(item => {
                return `
                        <article class="product-item bg-white shadow-md rounded overflow-hidden">
                            <img src="https://source.unsplash.com/random/300x300?clothes&sig=${item.product_id}"
                                 alt="Fashion item"
                                 onclick="redirectTo(${item.product_id})"
                                 onmouseover="scaleImage(this, 1.2)" 
                                 onmouseout="scaleImage(this, 1)">
                            <div class="p-4">
                                 <h3 class="font-semibold">브랜드명 : ${item.product_id}</h3>
                                <h3 class="font-semibold">상품명 : ${item.pd_name}</h3>
                                <p class="text-gray-600">${item.pd_price}원</p>                 
                                <p class="text-gray-600" >${item.product_id}</p>
                                
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

function scaleImage(img, scale) {
    img.style.transform = `scale(${scale})`;
}