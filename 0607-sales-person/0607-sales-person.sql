# Write your MySQL query statement below
Select name from salesperson
where sales_id not in
(
    Select sales_id from orders  where com_id IN
    (Select com_id from company WHERE name='RED')
   

)