function getMoney () {
    let money = +document.getElementById('money').value;
    let month = +document.getElementById('month').value;

    let total = money * month * 7/(100*12) + money;
    document.getElementById('result').innerHTML = total;
}

