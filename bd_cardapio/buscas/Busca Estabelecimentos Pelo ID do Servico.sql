SELECT estabelecimento.*
FROM bd_cardapio.estabelecimento, bd_cardapio.estabelecimento_servicos, bd_cardapio.servicos 
WHERE estabelecimento.id = estabelecimento_servicos.id_estabelecimento 
AND estabelecimento_servicos.id_servico = servicos.id AND estabelecimento_servicos.id_servico = 1

