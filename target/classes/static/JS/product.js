// const products = Array.from({ length: 40 }, (_, i) => ({
//     id: i + 1, // 각 제품에 고유한 ID를 부여합니다.
//     name: `Product ${i + 1}`,
//     image: `https://source.unsplash.com/random/300x300/?model&sig=${Math.floor(Math.random() * 1000)}`,
//     price: (Math.random() * 100).toFixed(2)
// }));
//
// document.querySelector('.flex.flex-wrap.-m-1').innerHTML = products.map(product => `
//     <div class="p-4 md:w-1/4 sm:w-1/2 w-full" onclick="redirectToProductInfo(${product.id})" onmouseover="this.style.transform='scale(1.05)'" onmouseout="this.style.transform='scale(1)'">
//         <div class="border-2 border-gray-200 border-opacity-60 rounded-lg overflow-hidden">
//             <img class="lg:h-48 md:h-36 w-full object-cover object-center" src="${product.image}" alt="product">
//             <div class="p-6">
//                 <h2 class="tracking-widest text-xs title-font font-medium text-gray-500 mb-1">CATEGORY</h2>
//
//                 <p class="leading-relaxed mb-3">$${product.price}</p>
//                 <div class="flex items-center flex-wrap ">
//                     <a class="text-indigo-500 inline-flex items-center md:mb-2 lg:mb-0">Learn More
//                         <svg fillㄴ="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="w-4 h-4 ml-2" viewBox="0 0 24 24">
//                             <path d="M5 12h14M12 5l7 7-7 7"></path>
//                         </svg>
//                     </a>
//                     <span class="text-gray-400 inline-flex items-center lg:ml-auto md:ml-0 ml-auto leading-none text-sm pr-3 py-1 border-r-2 border-gray-200">
//                         <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="w-4 h-4 mr-1" viewBox="0 0 24 24">
//                             <path d="M1 21h22L12 2 1 21z"></path>
//                         </svg>1.2K
//                     </span>
//                     <span class="text-gray-400 inline-flex items-center leading-none text-sm">
//                         <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="w-4 h-4 mr-1" viewBox="0 0 24 24">
//                             <path d="M20 6L9 17l-5-5"></path>
//                         </svg>6
//                     </span>
//                 </div>
//             </div>
//         </div>
//     </div>
// `).join('');
const Btn = document.getElementById("imgBtn")



function redirectToProductInfo(productId) {
    window.location.href = `/product_info/?id=${productId}`; // 제품 ID를 파라미터로 전달하여 제품 정보 페이지로 이동합니다.
}
