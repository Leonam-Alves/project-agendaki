const formulario = document.getElementById("form-agendamento");
const campoNome = document.getElementById("nome");
const campoTelefone = document.getElementById("telefone");
const campoData = document.getElementById("data");
const campoHora = document.getElementById("hora");
const mensagem = document.getElementById("mensagem-erro");

formulario.addEventListener("submit",
    function (event) {
        let formularioValido = true;

        if (campoNome.value.trim() === "") {
            campoNome.classList.add("campo-erro");
            formularioValido = false;
        } else {
            campoNome.classList.remove("campo-erro");
        }


        if (campoTelefone.value.trim() === "") {
            campoTelefone.classList.add("campo-erro");
            formularioValido = false;
        } else {
            campoTelefone.classList.remove("campo-erro");
        }


        if (campoData.value === "") {
            campoData.classList.add("campo-erro");
            formularioValido = false;
        } else {
            campoData.classList.remove("campo-erro");
        }


        if (campoHora.value === "") {
            campoHora.classList.add("campo-erro");
            formularioValido = false;
        } else {
            campoHora.classList.remove("campo-erro");
        }


        if (formularioValido === false) {
            event.preventDefault();
            mensagem.textContent = "Preencha os campos obrigatórios.";
            mensagem.classList.add("mensagem-error");
        } else {
            const confirmarEnvio = confirm("Deseja realmente salvar este agendamento?");
            
            if (confirmarEnvio === false) {
                event.preventDefault();
                mensagem.classList.remove("mensagem-error");
                mensagem.textContent = "";
            }
        }
    });