SELECT DISTINCT email AS Email
FROM person p1
WHERE(
    SELECT COUNT(*)
    FROM person p2
    WHERE P1.email = p2.email
) > 1;