let books = [];
function isBookCode(code) {
    return /^[1-5][0-9]{4}$/.test(code);
}
function isYear(year) {
    return /^\d{4}$/.test(year);
}
function showBooks() {
    const tbody = document.querySelector("tbody");
    tbody.innerHTML = '';

    for (let i = 0; i < books.length; i++) {
        const book = books[i];
        const statusText = book.quantity > 0 ? "true" : "false";

        const tr = document.createElement("tr");
        tr.innerHTML = `
            <td>${book.code}</td>
            <td>${book.name}</td>
            <td>${book.year}</td>
            <td>${book.quantity}</td>
            <td>${statusText}</td>
        `;

        tbody.appendChild(tr);
    }
}

function addNewBook() {
    let book = {
        code: prompt("Nhập mã sách:"),
        name: prompt("Nhập tên sách:"),
        year: prompt("Nhập năm xuất bản:"),
        quantity: parseInt(prompt("Nhập số quyển:"))
    };

    if (!isBookCode(book.code)) return alert("Mã sách không hợp lệ.");
    if (!book.name.trim()) return alert("Tên sách không được để trống.");
    if (!isYear(book.year)) return alert("Năm xuất bản không hợp lệ.");
    if (isNaN(book.quantity) || book.quantity < 0) return alert("Số quyển không hợp lệ.");

    books.push(book);
    alert("Đã thêm sách!");
    showBooks();
}
function addBook() {
    let code = prompt("Nhập mã sách cần thêm số quyển:");
    let found = false;

    for (let i = 0; i < books.length; i++) {
        if (books[i].code === code) {
            let addQty = parseInt(prompt("Nhập số quyển muốn thêm:"));
            if (!isNaN(addQty) && addQty > 0) {
                books[i].quantity += addQty;
                alert("Đã thêm số lượng sách.");
                showBooks();
            } else {
                alert("Số lượng không hợp lệ.");
            }
            found = true;
            break;
        }
    }

    if (!found) {
        alert("Không tìm thấy mã sách.");
    }
}

function borrowBook() {
    let code = prompt("Nhập mã sách muốn mượn:");
    let found = false;

    for (let i = 0; i < books.length; i++) {
        if (books[i].code === code) {
            found = true;

            if (books[i].quantity <= 0) {
                alert("Sách đã hết.");
                return;
            }

            books[i].quantity--;
            alert("Mượn sách thành công!");
            showBooks();
            return;
        }
    }

    if (!found) {
        alert("Không tìm thấy mã sách.");
    }
}
function showMaxBook() {
    if (books.length === 0) {
        alert("Danh sách rỗng.");
        return;
    }

    let maxBook = books[0];

    for (let i = 1; i < books.length; i++) {
        if (books[i].quantity > maxBook.quantity) {
            maxBook = books[i];
        }
    }

    alert("Sách có nhiều quyển nhất:" +
        `${maxBook.name} (${maxBook.quantity} quyển)`);
}



