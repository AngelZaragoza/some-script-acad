/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function saludo() {
    let fecha = new Date();
    let hora = fecha.getHours();
    let haySaludo = document.getElementById("saludo");
    let texto = "";

    //Si hay un id "saludo" en la página, escribe el Saludo
    if (haySaludo !== null) {
        if (hora >= 5 && hora <= 12) {
            texto = "Buenos días";
        } else if (hora > 12 && hora < 20) {
            texto = "Buenas tardes";
        } else {
            texto = "Buenas noches";
        }
        haySaludo.innerHTML = texto;
    }

    //Recupera nombre del formulario para aplicar la validación que corresponda
    let formulario = document.getElementsByTagName("form")[0];

    switch (formulario.getAttribute("id")) {
        case "inscripciones":
            formulario.addEventListener("submit", validaInscripcion);
            break;
    }

}

function validaInscripcion(e) {
    validaCombos(e);
}

function validaCombos(e) {
    let combos = document.getElementsByTagName("select");
    for (let i = 0; i < combos.length; i++) {
        if (combos[i].value == 0) {
            alert('Debe seleccionar ' + combos[i].getAttribute("id"));
            e.preventDefault();
        }
    }
}
