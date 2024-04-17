let IMP = window.IMP;
IMP.init('imp76806111') // 예: 'imp00000000a'

const payBtn = document.getElementById('payBtn');

payBtn.addEventListener('click', function (){
    requestPay()
});

function generateUniqueNumber() {
    // 현재 시간을 이용하여 고유한 숫자 생성
    const timestamp = Date.now();

    // Math.random()을 이용하여 무작위 숫자 생성
    const randomValue = Math.random();

    // 위의 두 값을 조합하여 고유한 일련번호 생성
    const uniqueNumber = `${timestamp}-${randomValue}`;

    return uniqueNumber;
}


function requestPay() {
    let product_id = document.getElementById('price-id').value;
    let prices = document.querySelectorAll('.price');
    let amount= 0;
    prices.forEach(price => {
        amount += data
    })


    let buyer_email = document.getElementById('email').value;
    let buyer_phone = document.getElementById('phone-num').value;
    let buyer_name = document.getElementById('name').value;
    let address = document.getElementById('address').value;
    let detailAddress = document.getElementById('detailAddress').value;
    let fullAddress = address + ' ' + detailAddress;

    console.log(amount)
    IMP.request_pay({
            pg: "kcp.{상점ID}",
            pay_method: "card",
            merchant_uid: generateUniqueNumber(),   // 주문번호
            name: name,
            amount: amount,                         // 숫자 타입
            buyer_email: buyer_email,
            buyer_name: buyer_name,
            buyer_tel: buyer_phone,
            buyer_addr: fullAddress,
            buyer_postcode: "01181"
        },
        function (rsp) { // callback
            if (rsp.success) {
                console.log(rsp);

                // 결제가 성공하면 API로 POST 요청을 보냅니다.
                const data = JSON.stringify({
                    result : true,
                    total_price : amount,
                    address : address,
                    phone : buyer_phone,
                    // 다른 필요한 데이터를 API로 보내려면 여기에 추가하세요.
                });
                console.log(data);
                sendData("/api/POST/payment", data)
            } else {
                console.log(rsp);
            }
        });
}