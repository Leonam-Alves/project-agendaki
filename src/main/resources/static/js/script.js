function aplicarValidacaoBasica(formId, campoIds) {
    const formulario = document.getElementById(formId);
    if (!formulario) {
        return;
    }

    const campos = campoIds.map((id) => document.getElementById(id));
    const mensagem = document.getElementById("mensagem-erro");

    formulario.addEventListener("submit", function (event) {
        let formularioValido = true;

        campos.forEach((campo) => {
            if (campo.value.trim() === "") {
                campo.classList.add("campo-erro");
                formularioValido = false;
            } else {
                campo.classList.remove("campo-erro");
            }
        });

        if (!formularioValido) {
            event.preventDefault();
            if (mensagem) {
                mensagem.textContent = "Preencha os campos obrigatórios.";
                mensagem.classList.add("mensagem-erro");
            }
        } else {
            const confirmarEnvio = confirm("Deseja realmente salvar este registro?");

            if (confirmarEnvio === false) {
                event.preventDefault();
                if (mensagem) {
                    mensagem.classList.remove("mensagem-erro");
                    mensagem.textContent = "";
                }
            }
        }
    });
}

aplicarValidacaoBasica("form-agendamento", ["clienteId", "profissionalId", "categoriaId", "data", "hora"]);
aplicarValidacaoBasica("form-categoria", ["nome"]);
aplicarValidacaoBasica("form-profissional", ["nome", "registroProfissional", "telefone", "categoriaId"]);
aplicarValidacaoBasica("form-cliente", ["nome", "telefone"]);
