document.getElementById('payment').addEventListener('submit', function(event) {
    event.preventDefault(); // 폼의 기본 제출 동작을 방지

    // 간단한 카드 번호 유효성 검사 (16자리 숫자)
    const cardNumber = document.getElementById('cardNumber').value;
    if (!/^\d{16}$/.test(cardNumber)) {
        alert('유효한 카드 번호를 입력해주세요.');
        return;
    }

    // 유효 기간 유효성 검사 (MM/YY 형식)
    const expiryDate = document.getElementById('expiryDate').value;
    if (!/^(0[1-9]|1[0-2])\/\d{2}$/.test(expiryDate)) {
        alert('유효한 유효 기간을 입력해주세요 (MM/YY 형식).');
        return;
    }

    // CVV 유효성 검사 (3자리 숫자)
    const cvv = document.getElementById('cvv').value;
    if (!/^\d{3}$/.test(cvv)) {
        alert('유효한 CVV를 입력해주세요.');
        return;
    }

    alert('결제가 완료되었습니다.'); // 사용자에게 결제 완료 알림
    window.location.href = 'main.html'; // main.html로 리디렉션
});
