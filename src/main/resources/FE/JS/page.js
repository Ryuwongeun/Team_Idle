function generatePagination(totalPages) {
    const paginationContainer = document.querySelector('.pagination-container');
    for (let i = 1; i <= totalPages; i++) {
        const pageLink = document.createElement('a');
        pageLink.href = '#';
        pageLink.textContent = i;
        pageLink.addEventListener('click', () => handlePageClick(i));
        paginationContainer.appendChild(pageLink);
    }
}

function handlePageClick(pageNumber) {
    const paginationLinks = document.querySelectorAll('.pagination-container a');
    paginationLinks.forEach(link => link.classList.remove('active'));
    paginationLinks[pageNumber - 1].classList.add('active');
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