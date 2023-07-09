--- https://github.com/ChickenLeg05/Northwind-Database
--- CSV
SELECT UPPER(FirstName) AS FirstName, UPPER(LastName) AS LastName, HireDate
FROM northwind_a.employees
ORDER BY HireDate
