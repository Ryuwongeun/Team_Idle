const AddBtn = document.getElementById('AddBtn');

AddBtn.addEventListener('click', () => {
    let name = document.getElementById('pd_name').value;
    const brand = document.getElementById('brandId').value;
    const category = document.getElementById('pd_category').value;
    let price = document.getElementById('pd_price').value;
    const sizeElements = document.querySelectorAll('.pd_size');
    const countElements = document.querySelectorAll('.pd_count');
    const images = document.querySelector('#imgList');
    name = name === '' ? null : name;
    price = price === '' ? null : price;

    const formData = new FormData();
    formData.append('pd_name', name);
    formData.append('brand', brand);
    formData.append('pd_category', category);
    formData.append('pd_price', price);

    sizeElements.forEach((sizeElement, index) => {
        formData.append(`sizes[${index}].size`, sizeElement.value);
        formData.append(`sizes[${index}].count`, countElements[index].value);
    });
    alert(formData.get('sizes')+formData.get('sizes[0].size')+formData.get('sizes[0].count'));
    for (let i=0; i<images.files.length; i++){
        formData.append('images', images.files[i]);
    }
    fetch('/api/POST/manage/productAdd', {
        method: 'POST',
        body: formData
    })
        .then(response => response.json())
        .then(data => {
            console.log(data);
            location.reload(true);
        })
        .catch(error => {
            console.error('There was a problem with your fetch operation:', error);
        });
    console.log("click")
});