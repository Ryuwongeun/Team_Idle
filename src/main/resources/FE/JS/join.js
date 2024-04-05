   // 중복 체크를 위한 가짜 함수
   function checkDuplicateNickname(nickname) {
    // 여기에 실제 중복 체크 로직을 구현하면 됩니다.
    // 이 함수는 닉네임이 중복되면 true를 반환하고, 중복되지 않으면 false를 반환합니다.
    return Math.random() < 0.5; // 임의의 결과를 반환하는 가짜 로직입니다.
}

document.getElementById('checkDuplicate').addEventListener('click', function() {
    var nickname = document.getElementById('nickname').value.trim();
    var errorSpan = document.getElementById('nickname-error');

    if (nickname === '') {
        errorSpan.textContent = '닉네임을 입력하세요.';
        return;
    }

    if (!checkDuplicateNickname(nickname)) {
        errorSpan.textContent = '사용 가능한 닉네임입니다.';
        errorSpan.style.color = 'green';
    } else {
        errorSpan.textContent = '이미 사용 중인 닉네임입니다.';
        errorSpan.style.color = 'red';
    }
});

      // 이메일 도메인 선택 시 입력란 옆에 표시되도록 설정
      document.getElementById('email_sel').addEventListener('change', function() {
        var selectedDomain = this.value;
        var emailInput = document.getElementById('email_dns');
        if (selectedDomain === '') {
            emailInput.value = '';
            emailInput.removeAttribute('disabled'); // 이메일 도메인을 직접 입력할 수 있도록 활성화
        } else {
            emailInput.value = selectedDomain;
            emailInput.setAttribute('disabled', 'disabled'); // 이메일 도메인이 선택된 경우에는 입력란을 비활성화
        }
    });

    // 직접 입력 선택 시 이메일 도메인 입력란 활성화
    document.getElementById('email_sel').addEventListener('change', function() {
        var selectedOption = this.value;
        var emailDomainInput = document.getElementById('email_dns');
        if (selectedOption === '') {
            emailDomainInput.removeAttribute('disabled');
        } else {
            emailDomainInput.setAttribute('disabled', 'disabled');
        }
    });

// 유효성 검사
document.getElementById('btnJoin').addEventListener('click', function(event) {
    var emailId = document.getElementById('email_id').value.trim();
    var emailDns = document.getElementById('email_dns').value.trim();
    var password = document.getElementById('password').value.trim();
    var confirmPassword = document.getElementById('confirm_password').value.trim();
    var nickname = document.getElementById('nickname').value.trim();
    var errorSpan = document.getElementById('username-error');

    if (emailId === '' || emailDns === '' || password === '' || confirmPassword === '' || nickname === '') {
        errorSpan.textContent = '모든 필드를 입력하세요.';
        event.preventDefault(); // 폼 제출 방지
        return;
    }

    if (password !== confirmPassword) {
        document.getElementById('password-error').textContent = '비밀번호가 일치하지 않습니다.';
        document.getElementById('confirm-password-error').textContent = '비밀번호가 일치하지 않습니다.';
        event.preventDefault(); // 폼 제출 방지
    }
    
});

document.getElementById("email_sel").addEventListener("change", function() {
    const domain = this.value;
    if(domain) {
        document.getElementById("email_dns").value = domain;
    }
});

document.getElementById("checkDuplicate").addEventListener("click", function() {
    // 여기에서 이메일 중복 검사를 위한 요청을 서버로 보내세요.
    // 이 예제에서는 단순히 경고창을 띄우는 것으로 대체합니다.
    const emailId = document.getElementById("email_id").value;
    const emailDns = document.getElementById("email_dns").value;
    if(!emailId || !emailDns) {
        document.getElementById("email-error").textContent = "이메일 주소를 완성해주세요.";
        return;
    }
    const emailAddress = `${emailId}@${emailDns}`;
    // 서버로 이메일 주소를 보내서 중복 검사를 수행하는 로직을 여기에 추가하세요.
    alert(`중복 검사를 수행합니다: ${emailAddress}`);
    // 예시로, 항상 '사용 가능한 이메일 주소입니다.'라는 메시지를 표시합니다.
    document.getElementById("email-error").textContent = "사용 가능한 이메일 주소입니다.";
});

