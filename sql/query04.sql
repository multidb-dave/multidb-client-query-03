--- https://github.com/ChickenLeg05/Northwind-Database
--- MySQL
SELECT UPPER(FirstName) AS FirstName, UPPER(LastName) AS LastName, HireDate
FROM northwind_c.employees
ORDER BY HireDate
