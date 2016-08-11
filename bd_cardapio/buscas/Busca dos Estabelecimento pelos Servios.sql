SELECT estabelecimento.*
FROM bd_cardapio.estabelecimento, bd_cardapio.estabelecimento_servicos 
WHERE estabelecimento.id = estabelecimento_servicos.id_estabelecimento and  estabelecimento_servicos.id_servico = 2