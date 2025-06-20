use quanlysinhvien;
select Address, count(StudentId) as 'So luong sinh vien'
from Student
group by Address;

select s.StudentId, s.StudentName, AVG(mark)
from student s join mark m on s.StudentId = m.StudentId
group by s.StudentID, s.StudentName;

select s.StudentId, s.StudentName, AVG(mark)
from student s join mark m on s.StudentId = m.StudentId
group by s.StudentID, s.StudentName
having avg(mark) >15;

select s.StudentId, s.StudentName, AVG(mark)
from student s join mark m on s.StudentId = m.StudentId
group by s.StudentID, s.StudentName
having avg(mark) >= all(
select avg(mark)
from Mark
group by Mark.StudentId
);