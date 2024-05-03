let timeout;
let pd_category = '국내브랜드'; // '여기에_카테고리명_입력'을 실제 카테고리 이름으로 바꿔주세요.

window.onload = () => {
    const urlParams = new URLSearchParams(window.location.search);
    const category = urlParams.get('category');
    GetListRequestCategory(`/view/GET/category?category=${pd_category}&page=1`);
}
let page =1;//현재 페이지 번호
function redirectTo(id){
    location.href=`/product/?id=${id}`;
}

//스크롤 이벤트 리스너 추가
window.addEventListener('scroll', function() {
    // 이전에 설정된 타임아웃이 있다면 취소
    if (timeout) {
        clearTimeout(timeout);
    }
    timeout = setTimeout(function() {
        let documentHeight = document.body.scrollHeight;
        let viewportHeight = window.innerHeight;
        let currentScroll = window.scrollY;
        let triggerPoint = documentHeight - viewportHeight - 2000;

        if (currentScroll >= triggerPoint) {
            GetListRequestCategory(`/view/GET/category?=${pd_category}&page=${++page}`);//다음 페이지 데이터 로드
        }
        console.log(page);
    },500);
});

function GetListRequestCategory(url){
    const headers = {
        'Content-Type': 'application/json',
    };
    fetch(url, {
        method: 'GET',
        headers: headers
    })
        .then(response => response.json())
        .then(data => {
            const LatestViewController = document.getElementById('field');
            let productsHtml = data.map(item => {
                return `
                    <article class="bg-white shadow-md rounded overflow-hidden product-item">
                        <div class="product-image-container">
                            <img src="https://source.unsplash.com/random/300x300?clothes&sig=${item.product_id}"
                                 alt="Fashion item"
                                 onclick="redirectTo(${item.product_id})">
                        </div>
                        <div class="p-4">
                            <h3 class="font-semibold">브랜드명 : ${item.product_id}</h3>
                            <h3 class="font-semibold">상품명 : ${item.product_name}</h3>
                            <p class="text-gray-600">${item.product_name}원</p>
                            <p class="text-gray-600">좋아요 ${item.count_love}</p>
                        </div>
                    </article>
                `;
            }).join('');
            LatestViewController.innerHTML += productsHtml;
        })
        .catch(error => {
            console.error('Error fetching user data:', error);
        });
}