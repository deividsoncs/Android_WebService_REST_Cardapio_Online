SELECT servicos.*
FROM bd_cardapio.servicos, bd_cardapio.estabelecimento_servicos
WHERE servicos.id = estabelecimento_servicos.id_servico AND estabelecimento_servicos.id_estabelecimento = 1