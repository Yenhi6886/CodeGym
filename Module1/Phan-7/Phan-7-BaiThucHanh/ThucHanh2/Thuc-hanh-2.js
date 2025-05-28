/* inputWidth = prompt ("Enter the width");
 inputHeight = prompt ("Enter the height");

 let width = parseInt(inputWidth);
let height = parseInt(inputHeight);
let area = width * height ;
document.write("The area is: " + area);*/
function getHcn() {
 let width = +document.getElementById("width").value;
 let height = +document.getElementById("height").value;
 let area = width * height;
document.write(area);
}

