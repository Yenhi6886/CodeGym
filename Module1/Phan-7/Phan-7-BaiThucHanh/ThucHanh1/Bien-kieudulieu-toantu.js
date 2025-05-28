//Bai 1

let a = 10;
let b = 20.8;
let c = true;
let d = 'Ha Noi';

document.write('a = '+a)
document.write('<br>')
document.write('b = '+b)
document.write('<br>')
document.write('c = '+c)
document.write('<br>')
document.write('d = '+d)
document.write('<br>')



//Bai 2

let width = 20;
let height = 40;
let area = width * height;
document.write('Are = '+area)

// Bai 3

let e = prompt("a = ");
let f = prompt("b = ");

if ( f===0 ) {
    alert("Không chia được cho 0 ");
} else if (e % f ===0) {
    alert("a là bội của b");
} else {
    alert("a không phải là bội của b");
}