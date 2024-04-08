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
    sendData("/api/POST/addProductDetail", data);
})