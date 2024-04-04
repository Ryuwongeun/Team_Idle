function buyNow() {
    window.open('buy.html', 'popup', 'width=600,height=400');
}

function addToCart() {
    window.location.href = "cart.html";
}
function changeColor() {
var button = document.getElementById("loveButton");
button.classList.toggle("bg-pink-600");
button.classList.toggle("bg-lime-500");
}
