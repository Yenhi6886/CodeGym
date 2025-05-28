let products = [];

// Khi bấm nút Thêm sản phẩm
document.getElementById("add-product-btn").onclick = function () {
    let name = document.getElementById("product-name").value;
    let image = document.getElementById("product-image");
    let price = document.getElementById("product-price").value;

    if (name === "" || image.files.length === 0 || Number(price) <= 0) {
        alert("Vui lòng nhập đầy đủ thông tin");
        return;
    }

    let file = image.files[0];
    let reader = new FileReader();

    reader.onload = function (e) {
        let imageUrl = e.target.result;

        let newProduct = {
            name: name,
            image: imageUrl,
            price: Number(price),
        }

        products.push(newProduct);

        resetForm();

        showProduct();

        showTotalProducts();

    };

    reader.readAsDataURL(file);
}

function resetForm() {
    document.getElementById("product-name").value = '';
    document.getElementById("product-image").value = '';
    document.getElementById("product-price").value = '';
}

// Hàm hiển thị danh sách sản phẩm
function showProduct() {
    let tableBody = document.getElementById("product-table-body");
    tableBody.innerHTML = "";

    for (let i = 0; i < products.length; i++) {
        let product = products[i];

        let row = `
            <tr>
                <td>${product.name}</td>
                <td><img src="${product.image}" width="80"></td>
                <td>${product.price} đ</td>
                <td>
                    <button onclick="editProduct(${i})">Sửa</button>
                    <button onclick="deleteProduct(${i})">Xóa</button>
                </td>
            </tr>
        `;

        tableBody.innerHTML += row;
    }
}

//Cập nhật số lượng món hiện có
function showTotalProducts() {
    document.getElementById("total-products").innerHTML = `
            <h2>Tổng số sản phẩm hiện tại: ${products.length} món</h2>
    `
}

//Xóa sản phẩm
function deleteProduct(i) {
    let confirmDelete = confirm(`Bạn có chắc chắn muốn xóa ${products[i].name} không ?`);
    if (confirmDelete) {
        products.splice(i, 1);
        showTotalProducts();
        showProduct();
    }
}

//Sửa sản phẩm
function editProduct(i) {
    let confirmEdit = confirm(`Bạn có chắc chắn muốn sửa ${products[i].name} không ?`);
    if (confirmEdit) {
        let newName = prompt("Sửa tên món: ", products[i].name);
        if (newName === null || newName.trim() === "") return;

        let newPrice = prompt("Sửa giá món: ", products[i].price);
        if (newPrice === null || Number(newPrice) <= 0) return;

        products[i].name = newName.trim();
        products[i].price = Number(newPrice);

        showProduct();
    }
}

//Tim theo tên sản phẩm
document.getElementById("search-name").oninput = function () {
    let searchValue = document.getElementById("search-name").value.trim().toLowerCase();
    let tableBody = document.getElementById("product-table-body");
    tableBody.innerHTML = "";

    for (let i = 0; i < products.length; i++) {
        let product = products[i];
        if (product.name.toLowerCase().includes(searchValue)) {
            let row = `
            <tr>
                <td>${product.name}</td>
                <td><img src="${product.image}" width="50"></td>
                <td>${product.price} đ</td>
                <td>
                    <button onclick="editProduct(${i})">Sửa</button>
                    <button onclick="deleteProduct(${i})">Xóa</button>
                </td>
            </tr>
        `;

            tableBody.innerHTML += row;
        }
    }
};

//Lọc sản phẩm
document.getElementById("filter-btn").onclick = function () {
    let min = document.getElementById("filter-min-price").value;
    let max = document.getElementById("filter-max-price").value;

    min = Number(min);
    max = Number(max);

    if (isNaN(min) || isNaN(max) || min < 0 || max < 0 || min > max) {
        alert("Vui lòng nhập giá hợp lệ!");
        return;
    }

    let tableBody = document.getElementById("product-table-body");
    tableBody.innerHTML = "";
    for (let i = 0; i < products.length; i++) {
        let product = products[i];

        if (product.price >= min && product.price <= max) {
            let row = `
                <tr>
                    <td>${product.name}</td>
                    <td><img src="${product.image}" width="50"></td>
                    <td>${product.price} đ</td>
                    <td>
                        <button onclick="editProduct(${i})">Sửa</button>
                        <button onclick="deleteProduct(${i})">Xóa</button>
                    </td>
                </tr>
            `;
            tableBody.innerHTML += row;
        }
    }
}


//Sắp xếp sản phẩm theo giá.
document.getElementById("sort-price").onchange = function () {
    let sort = this.value;
    if (sort === "asc") {
        products.sort((a, b) => a.price - b.price);
    } else if (sort === "desc") {
        products.sort((a, b) => b.price - a.price);
    }

    showProduct();
}
