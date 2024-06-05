const form = document.querySelector('#form');
const sendButton = document.querySelector('#Send');
let out = document.getElementById("result");
const resetButton = document.querySelector('#Reset');

resetButton.addEventListener('click', function () {
    out.textContent = "";
});


sendButton.addEventListener('click', () => {

    const data = {
        kalium: document.getElementById("kaliumInput").value,
        weight: document.getElementById("weightInput").value,
    };
    fetch('/medicine-calculator/calculator/kalium-medicine/result', {
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
    if(document.getElementById("kaliumInput").value===""||document.getElementById("weightInput").value===""){
        alert("Заполните все поля!");
    }else{
        sendButton.click();}
});
function checkKalium(input) {
    if (input.value < 0.1) {
        input.value = 0.1;
    } else if (input.value > 4.999) {
        input.value = 4.999;
    }
}
function checkWeight(input) {
    if (input.value < 10) {
        input.value = 10;
    } else if (input.value > 800) {
        input.value =800;
    }
}