window.onload = () => {
    GetListRequestTest(`/api/GET/productList`);
}

function redirectTo(id){
    location.href=`/product/?id=${id}`;
}

function GetListRequestTest(url) {
    const headers = {
        'Content-Type': 'application/json',
    };
    fetch(url, {
        method: 'POST',
        headers: headers
    })
        .then(response => response.json())
        .then(data => {
            const productDataContainer = document.getElementById('field')

            let productsHtml = data.map(item => {
                return `
                <article class="bg-white shadow-md rounded overflow-hidden">
                    <img src="/IMG/thanks.gif"
                         alt="Fashion item"
                         class="w-full h-64 object-cover"
                     onclick=redirectTo(${item.product_id})>
                         
                    <div class="p-4">
                        <h3 class="font-semibold">브랜드명 : ${item.product_id}</h3>
                        <h3 class="font-semibold">상품명 : ${item.pd_name}</h3>
                        <p class="text-gray-600">${item.pd_price}원</p>
                        <p class="text-gray-600" >${item.count_love}</p>
                    </div>
                </article>`
            }).join('');
            productDataContainer.innerHTML = productsHtml

        })
        .catch(error=>{
            console.error('Error fetching user data:', error);
        })
}