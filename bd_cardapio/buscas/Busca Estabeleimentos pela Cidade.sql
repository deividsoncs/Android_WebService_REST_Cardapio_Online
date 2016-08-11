SELECT estabelecimento.* FROM bd_cardapio.estabelecimento, bd_cardapio.endereco
WHERE estabelecimento.id = endereco.id_estabelecimento AND endereco.cidade = "Vitória"