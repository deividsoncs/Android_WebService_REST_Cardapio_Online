SELECT avaliacao.*
FROM bd_cardapio.avaliacao, bd_cardapio.estabelecimento
WHERE avaliacao.id_estabelecimento = estabelecimento.id AND estabelecimento.id = 2