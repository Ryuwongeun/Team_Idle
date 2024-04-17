/*


function generatePagination(totalPages) {
    const paginationContainer = document.querySelector('.pagination-container');
    for (let i = 1; i <= totalPages; i++) {
        const pageLink = document.createElement('button');
        pageLink.textContent = i;
        pageLink.addEventListener('click', () => handlePageClick(i));
        paginationContainer.appendChild(pageLink);
    }
}


function handlePageClick(pageNumber) {
    const paginationLinks = document.querySelectorAll('.pagination-container button');
    GetListRequestByLatest(`/view/GET/Latest?page=${pageNumber}`);
    GetListRequest(`/view/GET/commentLatest?page=${pageNumber}`);
    // 페이지 링크에 "active" 클래스를 추가하기 전에 페이지 번호의 유효성을 검사합니다.
    if (pageNumber >= 1 && pageNumber <= paginationLinks.length) {
        paginationLinks.forEach(link => link.classList.remove('active'));
        // 페이지 번호가 0부터 시작하지 않고 1부터 시작하므로 -1을 해줍니다.
        paginationLinks[pageNumber - 1].classList.add('active');
    }
    console.log('Clicked page:', pageNumber);
}

// 전체 제품 수와 한 페이지당 보여줄 제품 수를 이용하여 전체 페이지 수를 계산합니다.
const totalProducts = 160; // 예를 들어 160개의 제품이 있다고 가정합니다.
const productsPerPage = 40; // 한 페이지당 40개의 제품을 표시합니다.
const totalPages = Math.ceil(totalProducts / productsPerPage);

generatePagination(totalPages);

function goToProductInfo(productId) {
window.location.href = `product_info.html?id=${productId}`;
}


*/
