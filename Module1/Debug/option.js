function testDebug() {
    /*let a = prompt("a: ");
    let b = prompt("b");
    /!*let c = a + b *!/ // ra ab ( nay la cong 2 chuoi )
    let c = Number (a) + Number (b);
    */

    let a = document.getElementById("a").value;
    let b= document.getElementById("b").value;
    let c = Number (a) + Number (b);

    document.getElementById("output").innerHTML = c;

    console.log("Value a: ", a);
    console.log("Value b: ", b);

    alert("Bắt đầu tính toán: ");

    debugger;

    let sum = a + b;
    console.log("Tổng a + b =", sum);

    alert("Ket qua: "+sum);
}

/*
function do_something() {
    var selectedValue = document.getElementById("mySelect").value;
    alert(selectedValue);
}*/

var selectedElement = document.getElementById("mySelect");
selectedElement.addEventListener("change",changeFunction);
function changeFunction() {
    var selectedValue = document.getElementById("mySelect").value;
    alert(selectedValue);
}