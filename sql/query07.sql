--- https://github.com/ChickenLeg05/Northwind-Database
--- database sources: MySQL, PostgreSQL
--- virtual schemas: northwind_c, northwind_c
SELECT s.SupplierID, p.Product_Name, S.CompanyName
FROM northwind_c.suppliers s
JOIN northwind_c.products p
ON s.SupplierID = p.Supplier_ID
WHERE s.CompanyName IN ('Exotic Liquids','Specialty Biscuits, Ltd.','Escargots Nouveaux')
ORDER BY s.SupplierID
