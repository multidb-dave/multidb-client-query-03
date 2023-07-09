--- https://github.com/ChickenLeg05/Northwind-Database
--- database sources: MySQL, CSV
--- virtual schemas: northwind_b, northwind_c
SELECT s.SupplierID, p.ProductName, S.CompanyName
FROM northwind_c.suppliers s
JOIN northwind_b.products p
ON s.SupplierID = p.SupplierID
WHERE s.CompanyName IN ('Exotic Liquids','Specialty Biscuits, Ltd.','Escargots Nouveaux')
ORDER BY s.SupplierID
