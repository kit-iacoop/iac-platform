function changePrice() {
    var priceElement = document.getElementById("annual-fee-for-grade");
    var price = priceElement.options[priceElement.selectedIndex].value;
    var originalPrice = document.getElementsByClassName("original-price")[0];
    var salePrice = document.getElementsByClassName("sale-price")[0];
    originalPrice.innerHTML="<p id=\"original-price\">"+ price + "<p>원";
    salePrice.innerHTML="<p id=\"sale-price\">"+ price + "<p>원";
}

function allUseDiscount() {
    var myPoint = document.getElementById("my-point").textContent;
    var salePrice = document.getElementById("sale-price");
    $('#use-point').val(myPoint);
    salePrice.innerHTML= salePrice.textContent - myPoint;
}

function discount() {
    var usingPoint = document.getElementById("use-point").value;
    var salePrice = document.getElementById("sale-price");
    salePrice.innerHTML= salePrice.textContent - usingPoint;
}
