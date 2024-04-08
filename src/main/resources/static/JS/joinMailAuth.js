const mailBtn = document.getElementById("sendEmailBtn");
mailBtn.addEventListener('click',function() {
    const email_id = document.getElementById("email_id").value;
    const email_dns = document.getElementById("email_dns").value;
    const email = email_id + "@" + email_dns;
    console.log("email: ", email);
    const data = {
        "email": email
    }
    fetch("/login/mailConfirm", {
        method: "POST", // 요청 방식
        headers: {
            'Content-Type': 'application/json', // 내용 유형 지정
        },
        body: JSON.stringify(data) // body에 JSON 데이터를 전송
    })
        .then(response => response.json()) // 응답을 JSON으로 파싱
        .then(data => {
            alert("해당 이메일로 인증번호 발송이 완료되었습니다. \n 확인부탁드립니다.");
            console.log("data: ", data);
        })
        .catch((error) => {
            console.error('Error:', error);
        });
})