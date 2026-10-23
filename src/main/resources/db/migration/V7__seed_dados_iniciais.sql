INSERT INTO categorias (nome, descricao) VALUES
    ('Cardiologia', 'Diagnóstico e tratamento de doenças do coração.'),
    ('Pediatria', 'Cuidados médicos para crianças e adolescentes.'),
    ('Dermatologia', 'Diagnóstico e tratamento de doenças da pele.');

INSERT INTO profissionais (nome, registro_profissional, telefone, categoria_id) VALUES
    ('Dr. Carlos Lima', 'CRM-10234', '(11) 91234-1001', (SELECT id FROM categorias WHERE nome = 'Cardiologia')),
    ('Dra. Beatriz Nunes', 'CRM-20456', '(11) 91234-1002', (SELECT id FROM categorias WHERE nome = 'Pediatria')),
    ('Dr. Rafael Castro', 'CRM-30678', '(11) 91234-1003', (SELECT id FROM categorias WHERE nome = 'Dermatologia'));

INSERT INTO clientes (nome, telefone, email) VALUES
    ('Ana Paula Ferreira', '(11) 98888-2001', 'ana.ferreira@example.com'),
    ('Joao Vitor Almeida', '(11) 98888-2002', 'joao.almeida@example.com'),
    ('Camila Rocha', '(11) 98888-2003', 'camila.rocha@example.com');

INSERT INTO agendamentos (cliente_id, profissional_id, categoria_id, data, hora, status, descricao) VALUES
    (
        (SELECT id FROM clientes WHERE nome = 'Ana Paula Ferreira'),
        (SELECT id FROM profissionais WHERE registro_profissional = 'CRM-10234'),
        (SELECT id FROM categorias WHERE nome = 'Cardiologia'),
        '2026-11-10', '09:00', 'PENDENTE', 'Consulta de rotina.'
    ),
    (
        (SELECT id FROM clientes WHERE nome = 'Joao Vitor Almeida'),
        (SELECT id FROM profissionais WHERE registro_profissional = 'CRM-20456'),
        (SELECT id FROM categorias WHERE nome = 'Pediatria'),
        '2026-11-11', '14:30', 'CONFIRMADO', 'Consulta de acompanhamento.'
    );
