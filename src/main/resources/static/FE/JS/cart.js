function calculateTotalPrice() {
    let totalPrice = 0;
    const checkboxes = document.querySelectorAll('.item-checkbox:checked');
    checkboxes.forEach(function(checkbox) {
      const price = parseFloat(checkbox.dataset.price);
      const quantity = parseFloat(checkbox.dataset.quantity);
      totalPrice += price * quantity;
    });
    document.getElementById('totalPrice').innerText = '총 가격: $' + totalPrice.toFixed(2);
  }

  function redirectToBuyPage() {
    window.location.href = 'buy.html';
  }

  document.querySelectorAll('.item-checkbox').forEach(function(checkbox) {
    checkbox.addEventListener('change', calculateTotalPrice);
  });