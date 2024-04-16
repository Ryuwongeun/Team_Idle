const addProductBtn = document.querySelector('#addProductBtn');
const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);

addProductBtn.addEventListener('click', () => {
    const id = parseInt(urlParams.get('id'));
    const size = document.querySelector('#sizeVal').value;
    const count = parseInt(document.querySelector('#pd_count').value);
    console.log("id : "+id)
    console.log("size : "+size)
    console.log("count : "+count)
    const data = {
        id : id,
        size : size,
        count : count
    };
    sendData('/api/POST/manage/productAdd',data);
})

const modiBtn = document.querySelector("#modiBtn");

modiBtn.addEventListener("click", () => {
    const id = parseInt(urlParams.get('id'));
    const name = document.querySelector("#modiName").innerHTML;
    const category = document.querySelector("#category").value;
    const price = parseInt(document.querySelector("#modiPrice").value);
    const data = {
        product_id : id,
        pd_name : name,
        pd_price : price,
        pd_category : category
    }
    console.log("click")
    sendData('/api/POST/updateProduct',data);
    console.log("click");
})