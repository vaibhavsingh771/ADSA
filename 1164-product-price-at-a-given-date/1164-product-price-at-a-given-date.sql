# Write your MySQL query statement below
select product_id,ifnull(
    (
    select new_price from products p2
    where p1.product_id = p2.product_id
        and change_date <= '2019-08-16'
    order by change_date desc limit 1
),10) AS price from products p1
group by product_id;

-- SELECT product_id, IFNULL(
--         (SELECT new_price FROM Products p2
--         WHERE p1.product_id = p2.product_id
--             AND change_date <= '2019-08-16'
--         ORDER BY change_date DESC LIMIT 1
--         ),10) AS price
-- FROM Products p1
-- GROUP BY product_id;