-- entità con 1 a molti, devo inserire la foreign key sull'entità N
-- <campo> references orders(id)
-- foreign key (order_id) references orders(id) (altro modo di scriverlo rispetto la riga sopra)


CREATE TABLE orders (
    id bigint auto_increment primary key,
    customer_id bigint,
    order_date date
);

CREATE TABLE order_details (
    id bigint auto_increment primary key,
    order_id bigint,
    foreign key (order_id) references orders(id),
    product_name varchar(100),
    price int check (price > 0)
);