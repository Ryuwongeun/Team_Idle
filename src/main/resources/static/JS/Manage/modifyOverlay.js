const openBtn = document.querySelector("#searchBrand");
const closeBtn = document.querySelector(".close-btn");
const modify = document.querySelector(".modify-overlay");
openBtn.addEventListener("click", function () {
    modify.classList.add("open-modal");
});
closeBtn.addEventListener("click", function () {
    modify.classList.remove("open-modal");
});


