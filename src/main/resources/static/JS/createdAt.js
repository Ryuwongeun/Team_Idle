const createdAtBtn = document.getElementById('createdAt');
let page1 = 1;

createdAtBtn.addEventListener('click', () => {
    console.log('DOM fully loaded and parsed'); // DOM 로딩 확인
    console.log('createdAt clicked'); // 'createdAtBtn' 클릭 확인
    GetListRequestByCreatedAt(`/view/GET/CreatedAt?page=${page1}`);
});


function GetListRequestByCreatedAt(url){
    const headers = {
        'Content-Type': 'application/json',
    };
    fetch(url, {
        method:'POST',
        headers: {'Content-Type': 'application/json',}
    })

        .then(response => {
            if(!response.ok){
                throw new Error(`HTTP error ! status: ${response.status}`);
            }
            return response.json();
        })
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
                     
                        <p class="text-gray-600" >${item.product_id}</p>
                        <p class="text-gray-600" >${item.created_at}</p>



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
