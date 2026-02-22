SELECT e.name AS Employee,
e.salary AS Salary,
d.name AS Department 
FROM Employee e, Department d
WHERE e.departmentId = d.id
AND e.salary = (
    SELECT MAX(salary)
    FROM Employee
    WHERE departmentId = e.departmentId
);
