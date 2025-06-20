use quanlysinhvien;
select *
from subject 
where Credit = (
select max(Credit)
from subject
);

select sub.*
from subject sub 
join mark m on sub.subId = m.SubId
where m.mark = (
select max(mark)
from mark
);

select s.studentId, s.StudentName,avg(m.mark) as avgMark
from student s
join mark m on s.StudentID = m.StudentId
group by s.StudentID, s.StudentName
order by avgMark desc;

select s.StudentId, s.StudentName, avg(m.mark) as avgMark
from student s
join mark m on s.StudentID= m.StudentId
group by s.StudentID, s.studentName
order by avgmark desc;

