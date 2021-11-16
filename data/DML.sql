INSERT INTO gestor.endereco(logradouro, bairro, cep, numero, complemento) VALUES 
('Avenida Luís Viana Filho', 'Centro Administrativo da Bahia', '41745900', 600, '6ª Avenida');

INSERT INTO gestor.pessoa(nome, email, cpf, id_endereco) VALUES 
('Pessoa Inema', 'teste@inema.ba.gov.br', '45525148795', (SELECT id FROM gestor.endereco WHERE logradouro = 'Avenida Luís Viana Filho'));
