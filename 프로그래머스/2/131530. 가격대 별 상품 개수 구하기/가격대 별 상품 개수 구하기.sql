select TRUNC(price, -4) as PRICE_GROUP,
       count(*) as PRODUCTS
from product
group by TRUNC(price, -4) 
order by TRUNC(price, -4) asc
;