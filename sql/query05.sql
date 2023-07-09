--- https://github.com/ChickenLeg05/Northwind-Database
--- SQL Server, CSV
SELECT s.SupplierID, p.ProductName, S.CompanyName
FROM northwind_b.suppliers s
JOIN northwind_b.products p
ON s.SupplierID = p.SupplierID
WHERE s.CompanyName IN ('Exotic Liquids','Specialty Biscuits, Ltd.','Escargots Nouveaux')
ORDER BY s.SupplierID
