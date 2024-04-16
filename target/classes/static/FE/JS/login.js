function validateForm() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    var isValid = true;

    // Validate username
    if (username === "") {
        document.getElementById("usernameError").style.display = "block";
        isValid = false;
    } else {
        document.getElementById("usernameError").style.display = "none";
    }

    // Validate password
    if (password === "") {
        document.getElementById("passwordError").style.display = "block";
        isValid = false;
    } else {
        document.getElementById("passwordError").style.display = "none";
    }

    return isValid;
}

