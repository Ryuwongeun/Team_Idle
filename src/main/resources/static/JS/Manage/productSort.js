let i = 1;

window.onload = () => {
    GetProductListRequest(`/GET/manage/product`);
}

function redirectTo(id) {
    location.href = `/manage/product/?id=${id}`;
}

function GetProductListRequest(url){
    const headers = {
        'Content-Type': 'application/json',
    };
    fetch(url, {
        method: 'POST',
        headers: headers
    })
        .then(response => response.json())
        .then(data => {
            // Thymeleaf로 직접 데이터 추가
            const dataContainer = document.getElementById('field');
            let manageHtml =
                `
            <thead>
                <tr class="table-header">
                    <th class=" px-4 py-2 text-left">일련번호</th>
                    <th class=" px-4 py-2 text-left">브랜드</th>
                    <th class=" px-4 py-2 text-left">이름</th>
                    <th order="1" class="sort-label px-4 py-2 text-left" value=1>가격</th>
                    <th order="1" class="sort-label px-4 py-2 text-left" value=2>재고수량</th>
                    <th order="1" class="sort-label px-4 py-2 text-left" value=3>총 판매량</th>
                    <th class="px-4 py-2 text-left">자세히</th>
                </tr>
            </thead>
            <tbody >`
            // 데이터 배열을 순회하면서 각 항목을 HTML로 변환
            manageHtml += data.map(item => {
                return `
                <!-- Repeat for each row -->
                    <tr class="table-row" >
                        <td class="px-4 py-2">${item.id}</td>
                        <td class="px-4 py-2">${item.brandName}</td>
                        <td class="px-4 py-2">${item.name}</td>
                        <td class="px-4 py-2">${item.price}</td>
                        <td class="px-4 py-2">${item.amount}</td>
                        <td class="px-4 py-2">${item.sales}</td>
                        <td class="px-4 py-2">
                            <button class="bg-green-500 hover:bg-green-700 text-white font-bold py-1 px-2 rounded" 
                            onclick=redirectTo(${item.id})>View</button>
                        </td>
                    </tr>
                <!-- ... more rows ... -->
            `;
            }).join(''); // 배열의 모든 항목을 하나의 문자열로 결합
            manageHtml+=`</tbody>`;
            dataContainer.innerHTML = manageHtml;
            i *= -1;
            setTopBtn(i,1);
        })
        .catch(error => {
            console.error('Error fetching user data:', error);
        });
}

function GetOrderListRequest(url){
    const headers = {
        'Content-Type': 'application/json',
    };
    fetch(url, {
        method: 'POST',
        headers: headers
    })
        .then(response => response.json())
        .then(data => {
                // Thymeleaf로 직접 데이터 추가
                const dataContainer = document.getElementById('field');
                let manageHtml =
                    `
            <thead>
                <tr class="table-header">
                    <th class=" px-4 py-2 text-left">일련번호</th>
                    <th class=" px-4 py-2 text-left">브랜드</th>
                    <th class=" px-4 py-2 text-left">이름</th>
                    <th order="1" class="sort-label px-4 py-2 text-left" value=1>가격</th>
                    <th order="1" class="sort-label px-4 py-2 text-left" value=2>재고수량</th>
                    <th order="1" class="sort-label px-4 py-2 text-left" value=3>총 판매량</th>
                    <th class="px-4 py-2 text-left">자세히</th>
                </tr>
            </thead>
            <tbody >`
                // 데이터 배열을 순회하면서 각 항목을 HTML로 변환
                manageHtml += data.map(item => {
                    return `
                <!-- Repeat for each row -->
                    <tr class="table-row" >
                        <td class="px-4 py-2">${item.id}</td>
                        <td class="px-4 py-2">${item.brandName}</td>
                        <td class="px-4 py-2">${item.name}</td>
                        <td class="px-4 py-2">${item.price}</td>
                        <td class="px-4 py-2">${item.amount}</td>
                        <td class="px-4 py-2">${item.sales}</td>
                        <td class="px-4 py-2">
                            <button class="bg-green-500 hover:bg-green-700 text-white font-bold py-1 px-2 rounded" 
                            onclick=redirectTo(${item.id})>View</button>
                        </td>
                    </tr>
                <!-- ... more rows ... -->
                
            `;
                }).join(''); // 배열의 모든 항목을 하나의 문자열로 결합
                manageHtml += `</tbody>`;
                dataContainer.innerHTML = manageHtml;
                i *= -1;
                setTopBtn(i);
            })
        .catch(error => {
            console.error('Error fetching user data:', error);
        });
}

