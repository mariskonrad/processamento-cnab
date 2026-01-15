CREATE TABLE IF NOT EXISTS transacao (
    id SERIAL primary key,
    tipo int,
    data date,
    valor decimal,
    cpf bigint,
    cartao varchar(255),
    hora time,
    dono_da_loja varchar(255),
    nome_da_loja varchar(255)
);