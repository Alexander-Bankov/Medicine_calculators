const form = document.querySelector('#form');
const sendButton = document.querySelector('#Send');
let out = document.getElementById("result");
const resetButton = document.querySelector('#Reset');

resetButton.addEventListener('click', function () {
    out.textContent = "";
});




sendButton.addEventListener('click', () => {

    const data = {
        percent: document.getElementById("percentInput").value,
        size: document.getElementById("sizeInput").value,
    };
    fetch('/medicine-calculator/calculator/fluids-medicine/result', {
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
    if(document.getElementById("percentInput").value===""||document.getElementById("sizeInput").value===""){
        alert("Заполните все поля!");
    }else{
        sendButton.click();}
});
function checkPercent(input) {
    if (input.value < 1) {
        input.value = 1;
    } else if (input.value > 90) {
        input.value = 90;
    }
}
function checkSize(input) {
    if (input.value < 1) {
        input.value = 1;
    } else if (input.value > 30) {
        input.value =30;
    }
}