SELECT cardapio.*
FROM bd_cardapio.cardapio, bd_cardapio.estabelecimento 
WHERE cardapio.id_estabelecimento =  estabelecimento.id = 1
