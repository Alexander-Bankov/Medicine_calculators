const form = document.querySelector('#form');
const sendButton = document.querySelector('#Send');
let out = document.getElementById("result");
const resetButton = document.querySelector('#Reset');

resetButton.addEventListener('click', function () {
    out.textContent = "";
});


sendButton.addEventListener('click', () => {
    let time_name = "minute";
    const mySelect = document.querySelector('#mySelect1');

    if (mySelect.value === "Часы") {
        time_name = "hours";
    }
    const data = {
        time_name: time_name,
        time: document.getElementById("timeInput").value,
        size: document.getElementById("sizeInput").value,

    };
    fetch('/medicine-calculator/calculator/speed-medicine/result', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if(response.ok){
                return  response.json()
            }else {
                throw new Error('Ошибка HTTP: ' + response.status);
            }
        })

        .then(result => {
                out.textContent = result.result;
        })
        .catch(error => {
            out.textContent=(error.message);
        });
});

form.addEventListener('submit', (event) => {
    event.preventDefault();
    if(document.getElementById("timeInput").value===""||document.getElementById("sizeInput").value===""){
        alert("Заполните все поля!");
    }else{
        sendButton.click();}
});
function checkTime(input) {
    if (input.value < 0.1) {
        input.value = 0.1;
}}
function checkSize(input) {
    if (input.value < 1) {
        input.value = 1;
    } else if (input.value > 100) {
        input.value =100;
    }
}