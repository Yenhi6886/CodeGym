use quanlysinhvien;

select *
from Subject
where Credit between 3 and 5;


select s.StudentName, sub.SubName,m.Mark
from Student s join Mark m on s.StudentID = m.StudentID
			   join Subject sub on m.SubID = sub.SubID
order by m.Mark desc,
         s.StudentName asc;

select * 
from student
where StudentName like 'h%'; 
-- WHERE LOWER(StudentName) LIKE 'h%'; 

select *
from class
where month(StartDate)=12;

update student
set ClassID = 2
where StudentName = 'Hung' limit 1;
