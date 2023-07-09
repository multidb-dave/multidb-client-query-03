--- select distinct b.*, a.Category_Name
select b.*, a.Category_Name
from northwind_a.Categories a 
inner join northwind_b.Products b on a.Category_ID = b.CategoryID
where b.Discontinued = 0
order by b.ProductName
