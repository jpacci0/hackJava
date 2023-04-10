SELECT * 
FROM prodotti p
left JOIN varianti v on p.id = v.prodotto_id
WHERE v.attributo = 'colore';