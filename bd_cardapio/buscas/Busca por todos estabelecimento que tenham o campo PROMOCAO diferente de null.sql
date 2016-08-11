SELECT estabelecimento.* 
FROM bd_cardapio.estabelecimento, bd_cardapio.cardapio, bd_cardapio.secao_cardapio, bd_cardapio.item_cardapio
WHERE estabelecimento.id = cardapio.id_estabelecimento AND cardapio.id = secao_cardapio.id_cardapio
      AND secao_cardapio.id = item_cardapio.id_secao_cardapio AND item_cardapio.percentual_desconto IS NOT NULL
