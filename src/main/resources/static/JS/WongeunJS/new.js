// let timeout;
//
// window.onload = () => {
//     GetListRequestLatest(`/view/GET/Latest?page=1`);
// }
//
// let page = 1; // 현재 페이지 번호
//
// function redirectTo(id) {
//     location.href = `/product/?id=${id}`;
// }
//
// window.addEventListener('scroll', function() {
//     // 이전에 설정된 타임아웃이 있다면 취소
//     if (timeout) {
//         clearTimeout(timeout);
//     }
//
// <<<<<<< HEAD
// function GetListRequest(url){
// =======
//     timeout = setTimeout(function() {
//         let documentHeight = document.body.scrollHeight;
//         let viewportHeight = window.innerHeight;
//         let currentScroll = window.scrollY;
//         let triggerPoint = documentHeight - viewportHeight - 10;
//
//         if (currentScroll >= triggerPoint) {
//             GetListRequestLatest(`/view/GET/Latest?page=${++page}`);//다음 페이지 데이터 로드
//         }
//         console.log(page);
//     },1000);
// });
//
// //스크롤 이벤트 리스너 추가
// // window.onscroll=()=>{
// //     //사용자가 페이지 하단에 도달했는지 확인
// //     if(window.innerHeight + window.scrollY >=document.body.offsetHeight){
// //         GetListRequestLatest(`/view/GET/Latest?page=${++page}`);//다음 페이지 데이터 로드
// //     }
// //     console.log(page)
// // };
//
// function GetListRequestLatest(url){
// >>>>>>> 0f2323219d282fd9727c63005a6260b308ac1b44

    const headers = {
        'Content-Type': 'application/json',
    };

    fetch(url, {
        method: 'POST',
        headers: headers
    })
        .then(response => response.json())
        .then(data => {
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
                </article>`;
            }).join('');
            LatestViewController.innerHTML += productsHtml;
        })
        .catch(error => {
            console.error('Error fetching user data:', error);
        });
}

function scaleImage(img, scale) {
    img.style.transform = `scale(${scale})`;
}
