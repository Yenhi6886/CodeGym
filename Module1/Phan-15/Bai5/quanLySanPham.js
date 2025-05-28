let listProducts = [
    ["Iphone", 25000000, 25],
    ["Samsung", 25781000, 31],
    ["Oppo", 11800000, 12],
    ["Xiaomi", 19200000, 25],
    ["Vivo", 33000000, 18],
];

//Hiển thị sản phẩm
function displayProductList() {
    let html = "";
    listProducts.forEach((item, index) => {
        html += `
        <tr>
            <td>${index}</td>
            <td>${item[0]}</td>
            <td>${item[1]}</td>
            <td>${item[2]}</td>
            <td><button onclick="deleteProduct(${index})">Xóa</button></td>  
        </tr>
        `
    })
    document.getElementById("productBody").innerHTML = html;
}

displayProductList();

//Xóa sản phẩm
function deleteProduct($index) {
    if(confirm(`Bạn có muốn xóa không?`)) {
        listProducts.splice(index,1);
        displayProductList();
    }
}

//Thêm sản phẩm
function addProduct() {

}