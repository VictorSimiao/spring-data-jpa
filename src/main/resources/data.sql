INSERT INTO Cargos (descricao) values ('Programador Java Web');
INSERT INTO Cargos (descricao) values ('Programador Front-end');
INSERT INTO Cargos (descricao) values ('DBA');


INSERT INTO FUNCIONARIOS (nome, cpf, salario,data_contratacao,cargo_id )values('Victor','888.595.127-94',2500.32,'2021-02-20',1);
INSERT INTO FUNCIONARIOS (nome, cpf, salario,data_contratacao,cargo_id )values('Maria','366.618.182-12',2200,'2021-12-19',2);
INSERT INTO FUNCIONARIOS (nome, cpf, salario,data_contratacao,cargo_id )values('Tiago','693.753.703-48',3000,'2021-01-21',3);


INSERT INTO UNIDADES_TRABALHO (descricao, endereco)values('TI','Colatina-ES');



INSERT INTO FUNCIONARIOS_UNIDADES (fk_funcionario,fk_unidade) values (1,1);
INSERT INTO FUNCIONARIOS_UNIDADES (fk_funcionario,fk_unidade) values (2,1);
INSERT INTO FUNCIONARIOS_UNIDADES (fk_funcionario,fk_unidade) values (3,1);