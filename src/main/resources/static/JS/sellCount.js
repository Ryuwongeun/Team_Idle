window.onload = () => {
    GetListRequest(`/view/GET/sellCount`);
}

function redirectTo(id){
    location.href = `/product/?id=${id}`;
}

let page = 1;
GetListRequest(`/view/GET/sellCount?page=${page}`);

function GetListRequest(url) {
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
            console.log(data);
            const LatestViewController = document.getElementById('field');
            let productsHtml = data.map(item => {
                return `
                    <article class="bg-white shadow-md rounded overflow-hidden product-item">
                        <img src="https://source.unsplash.com/random/300x300?clothes&sig=${item.product_id}"
                             alt="Fashion item"
                             onclick="redirectTo(${item.product_id})"
                             onmouseover="scaleImage(this, 1.1)" 
                             onmouseout="scaleImage(this, 1)">
                        <div class="p-4">
                            <h3 class="font-semibold">상품명 : ${item.pd_name}</h3>
                            <p class="text-gray-600">${item.pd_price}원</p>
                            <p class="text-gray-600" >${item.count_love}</p>
                            <p class="text-gray-600" >${item.pd_sell_count}</p>
                        </div>
                    </article>`;
            }).join('');
            LatestViewController.innerHTML = productsHtml;
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });
}

function scaleImage(img, scale) {
    img.style.transform = `scale(${scale})`;
}