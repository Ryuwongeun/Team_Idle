const btn = document.querySelector("#btn");

btn.addEventListener('click', () => {
    const id = document.querySelector("#id").value;
    const name = document.querySelector("#name").value;
    const data = {
        id: id === '' ? null : id,
        name: name === '' ? null : name
    };
    sendData('/api/POST/addProduct', data);
});

function sendData(url, data) {
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}
