function  getAge() {
    let birthday = document.getElementById('birthday').value;
    let date = new Date(birthday);

//     get year
    let year = date.getFullYear();

    // get year cua nam htai
    let currentDate = new Date();
    let currentYear = currentDate.getFullYear();
    let age = currentYear - year;
    
    document.getElementById('result').innerHTML = "Nam nay ban "+ age + " tuoi";

}