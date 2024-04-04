const products = Array.from({ length: 40 }, (_, i) => ({
    id: i,
    name: `Product ${i + 1}`,
    image: `https://source.unsplash.com/random/300x300/?model&sig=${Math.floor(Math.random() * 1000)}`,
    price: (Math.random() * 100).toFixed(2)
}));

document.addEventListener("DOMContentLoaded", function() {
    const productContainer = document.querySelector(".flex-wrap");
    
    products.forEach(product => {
        const productCard = document.createElement("div");
        productCard.classList.add("p-4", "md:w-1/4", "sm:w-1/2", "w-full");

        const productImageContainer = document.createElement("div");
        productImageContainer.classList.add("border-2", "border-gray-200", "border-opacity-60", "rounded-lg", "overflow-hidden");

        const productImage = document.createElement("img");
        productImage.classList.add("lg:h-48", "md:h-36", "w-full", "object-cover", "object-center");
        productImage.src = product.image;
        productImage.alt = "product";

        productImageContainer.appendChild(productImage);
        productCard.appendChild(productImageContainer);
        productContainer.appendChild(productCard);
    });
});

