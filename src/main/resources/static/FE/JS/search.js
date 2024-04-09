function searchItem() {
    var input = document.getElementById('searchInput').value;
    var resultsDiv = document.getElementById('searchResults');

    // 예시 데이터
    var items = ['상품1', '상품2', '상품3', '상품4'];

    // 검색 결과를 담을 배열
    var searchResults = [];

    // 검색어와 일치하는 항목 찾기
    for (var i = 0; i < items.length; i++) {
        if (items[i].toLowerCase().includes(input.toLowerCase())) {
            searchResults.push(items[i]);
        }
    }

    // 검색 결과 표시
    resultsDiv.innerHTML = searchResults.join('<br>');
}