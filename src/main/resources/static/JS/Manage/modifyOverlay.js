const modifyBtn = document.querySelector("#modifyBtn");
const closeBtn = document.querySelector(".close-btn");
const modify = document.querySelector(".modify-overlay");
modifyBtn.addEventListener("click", function () {
    modify.classList.add("open-modal");
    console.log(login.classList);
});
closeBtn.addEventListener("click", function () {
    modify.classList.remove("open-modal");
});