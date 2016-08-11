SELECT item_cardapio.*
FROM bd_cardapio.item_cardapio, bd_cardapio.secao_cardapio 
WHERE item_cardapio.id_secao_cardapio = secao_cardapio.id AND secao_cardapio.id_cardapio = 1