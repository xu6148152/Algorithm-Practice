SELECT email as `Email` FROM Person GROUP BY email HAVING count(*) > 1

SELECT DISTINCT a.Email FROM Person a
LEFT JOIN (SELECT Id, Email from Person GROUP BY Email) b
ON (a.email = b.email) AND (a.Id = b.Id)
WHERE b.Email IS NULL

SELECT DISTINCT a.Email
FROM Person a
WHERE EXISTS(
    SELECT 1
    FROM Person b
    WHERE a.Email = b.Email
    LIMIT 1, 1
)

SELECT DISTINCT a.Email
FROM Person a JOIN Person b
ON (a.Email = b.Email)
WHERE a.Id <> b.Id

