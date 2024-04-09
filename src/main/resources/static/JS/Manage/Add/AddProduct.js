const AddBtn = document.getElementById('AddBtn');

AddBtn.addEventListener('click', () => {
    let name = document.getElementById('pd_name').value;
    const brand = document.getElementById('brandId').value;
    const category = document.getElementById('pd_category').value;
    let price = document.getElementById('pd_price').value;
    const sizeElements = document.querySelectorAll('.pd_size');
    const countElements = document.querySelectorAll('.pd_count');
    name = name === '' ? null : name;
    price = price === '' ? null : price;
    let sizes = [];
    for (let i = 0; i<sizeElements.length; i++) {
        sizes.push({
            size: sizeElements[i].value,
            count: parseInt(countElements[i].value)
        });
    }
    const data = {
        pd_name: name,
        brand: brand,
        pd_category: category,
        pd_price: price,
        sizes: sizes
    };
    sendData('/api/POST/manage/productAdd', data);
});