const CartBtn = document.getElementById('cartBtn');

CartBtn.addEventListener('click', () => {
    const id = queryParam.get('id');
    console.log("click")
    console.log(id)
    let count = parseInt(document.getElementById('quantity').value);
    console.log(count)
    console.log(typeof count)
    console.log(getSelectedSize());
    const data = {
        product_id: id,
        count: count,
        size: getSelectedSize()
    }
    sendData("/api/POST/addCart", data);
});

function getSelectedSize() {
    // 'size'라는 name 속성을 가진 모든 라디오 버튼을 가져옵니다.
    const sizeRadios = document.getElementsByName('size');

    // 가져온 라디오 버튼들을 반복하면서 체크된 항목을 찾습니다.
    for(let i = 0; i < sizeRadios.length; i++) {
        if(sizeRadios[i].checked) { // 만약 현재 항목이 체크되어 있다면
            return sizeRadios[i].value; // 해당 항목의 value를 반환합니다.
        }
    }

    // 체크된 항목이 없으면 null을 반환합니다.
    return null;
}