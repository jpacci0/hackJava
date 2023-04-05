SELECT orders.id, SUM(order_details.price) AS order_total
FROM orders
JOIN order_details ON orders.id = order_details.order_id
GROUP BY orders.id;



