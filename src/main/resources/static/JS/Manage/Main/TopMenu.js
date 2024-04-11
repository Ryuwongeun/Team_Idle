const topProductBtn = document.getElementById('ProductTop');
const topOrderBtn = document.getElementById('OrderTop');
const topBrandBtn = document.getElementById('BrandTop');

function setTopBtn(i, value){
    const sortLabels = document.querySelectorAll('.sort-label')
    sortLabels.forEach(function(sortLabel) {
        sortLabel.addEventListener('click', function(){
            let toggle = parseInt(this.getAttribute('order'))
            this.setAttribute('order', i * -1)
            toggle = parseInt(this.getAttribute('order'))

            let val = this.getAttribute('value')
            let searchValue = document.getElementById('searchVal').value;
            val = parseInt(val) * toggle

            console.log(val)
            if(value == 1) {
                GetProductListRequest(`/GET/manage/product/search?id=${val}&name=${searchValue}`);
            }
            else if(value == 2){
                GetOrderListRequest(`/GET/manage/order/search?id=${val}&name=${searchValue}`);
            }
        });
    });
};


topProductBtn.addEventListener('click', function(){
    GetProductListRequest(`/GET/manage/product`);
});

topOrderBtn.addEventListener('click', function(){
    GetOrderListRequest(`/GET/manage/order`);
});

topBrandBtn.addEventListener('click', function(){
    GetListRequest(`/GET/manage/brand`);
});



