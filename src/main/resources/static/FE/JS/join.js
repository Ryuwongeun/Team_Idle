// 주소 검색 함수
function searchAddress() {
    new daum.Postcode({
        oncomplete: function(data) {
            var fullAddress = data.address; // 전체 주소
            var extraAddress = ''; // 상세 주소

            if (data.addressType === 'R') { // 지번 주소일 경우
                if (data.bname !== '') {
                    extraAddress += data.bname;
                }
                if (data.buildingName !== '') {
                    extraAddress += (extraAddress !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                fullAddress += (extraAddress !== '' ? ' (' + extraAddress + ')' : '');
            }

            document.getElementById('postalCode').value = data.zonecode; // 우편번호
            document.getElementById('addr1').value = fullAddress; // 기본주소
            document.getElementById('addr2').focus(); // 상세주소 입력란으로 포커스 이동
        }

    }).open();
}
// Daum 주소 API에서 주소를 클릭했을 때 실행될 함수
function setAddress(addr) {
    // 클릭한 주소를 회원가입 폼의 주소 필드에 채움
    document.getElementById('addr1').value = addr;
}

// 주소를 클릭했을 때 실행될 함수를 호출하는 함수
function searchAddress() {
    new daum.Postcode({
        oncomplete: function(data) {
            var fullAddr = data.address; // 클릭한 주소
            setAddress(fullAddr); // 클릭한 주소를 회원가입 폼의 주소 필드에 채움
        }
    }).open();
}

function setEmailDomain() {
    var emailSel = document.getElementById("email_sel");
    var emailDns = document.getElementById("email_dns");

    // Get selected option
    var selectedOption = emailSel.options[emailSel.selectedIndex].value;

    // Set email domain input value
    emailDns.value = selectedOption;
}

// Add event listener to email selection dropdown
document.getElementById("email_sel").addEventListener("change", setEmailDomain);

function validateForm() {
    // 폼 유효성 검사 로직 추가 (필요한 경우)
    return true; // 예시: 항상 true를 반환하도록 수정
}



// 유효성 체크 함수
function validateForm() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var confirm_password = document.getElementById("confirm_password").value;
    var email_id = document.getElementById("email_id").value;
    var email_dns = document.getElementById("email_dns").value;
    var gender = document.getElementById("gender").value;
    var birth = document.getElementById("birth").value;
    var mobile = document.getElementById("mobile").value;
    var postalCode = document.getElementById("postalCode").value;
    var addr1 = document.getElementById("addr1").value;

    // 각 필드의 유효성 검사
    if (username == "") {
        document.getElementById("username-error").innerHTML = "아이디를 입력하세요.";
        return false;
    }

    // 패스워드의 길이가 6자 이상인지 확인
    if (password.length < 6) {
        document.getElementById("password-error").innerHTML = "비밀번호는 6자 이상이어야 합니다.";
        return false;
    }

    // 패스워드와 확인용 패스워드가 일치하는지 확인
    if (password != confirm_password) {
        document.getElementById("confirm-password-error").innerHTML = "비밀번호가 일치하지 않습니다.";
        return false;
    }

    // 이메일 형식 검사
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email_id + "@" + email_dns)) {
        document.getElementById("email-error").innerHTML = "유효한 이메일 주소를 입력하세요.";
        return false;
    }


    // 성별 선택 여부 확인
    if (gender == "") {
        document.getElementById("gender-error").innerHTML = "성별을 선택하세요.";
        return false;
    }

    // 생년월일 입력 여부 확인
    if (birth == "") {
        document.getElementById("birth-error").innerHTML = "생년월일을 입력하세요.";
        return false;
    }

    // 전화번호 형식 확인
    var mobileRegex = /^[0-9]+$/;
    if (!mobileRegex.test(mobile)) {
        document.getElementById("mobile-error").innerHTML = "숫자만 입력하세요.";
        return false;
    }

    // 주소 입력 여부 확인
    if (postalCode == "" || addr1 == "") {
        document.getElementById("address-error").innerHTML = "주소를 입력하세요.";
        return false;
    }

    return true;
}


const btn = document.querySelector('#btnJoin')


btn.addEventListener('click', () => {

    let email1 = document.querySelector("#email_id").value
    let email2 = document.querySelector("#email_dns").value

    let user_email = email1 + "@" + email2;
    let user_password = document.querySelector("#password").value
    let user_pnum = document.querySelector("#mobile").value

    data = {
        user_email : user_email,
        user_password : user_password,
        user_pnum : user_pnum

    }

    sendData(`/addUserAccount`,data)

})

