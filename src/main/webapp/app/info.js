const sendButton = document.querySelector('#Send');
const resetButton = document.querySelector('#Reset');
const form = document.querySelector('#form');
let out = document.getElementById("result");

resetButton.addEventListener('click', function () {
    out.textContent = "";
});

sendButton.addEventListener('click', () => {
    let calculator_name = "kalium-calculator"; //
    const mySelect = document.querySelector('#mySelect1');

    if (mySelect.value === "Калькулятор расчета содержания вещества в растворе") {
        calculator_name = "fluids-calculator";
    } else if (mySelect.value === "Калькулятор расчета скорости внутривенного капельного введения препарата") {
        calculator_name = "speed-calculator";
    }

    fetch(`/medicine-calculator/calculator/${calculator_name}/info`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        },
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Ошибка HTTP: ' + response.status);
            }
        })
        .then(result => {
            out.textContent = result.info;
        })
        .catch(error => {
            out.textContent = error.message;
        });
});

form.addEventListener('submit', (event) => {
    event.preventDefault();
});