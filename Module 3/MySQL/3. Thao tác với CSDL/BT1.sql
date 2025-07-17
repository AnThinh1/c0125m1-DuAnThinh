USE QuanLySinhVien;
SELECT * FROM Student WHERE StudentName Like "h%";
--
SELECT * FROM QuanLySinhVien.Class WHERE MONTH(StartDate) = 12;
--
SELECT * FROM QuanLySinhVien.Subject WHERE Credit BETWEEN "3" and "5";
--
UPDATE Student
SET ClassId = 2
WHERE StudentName = "Hung" and StudentId = "1";
--
select S.StudentName, B.SubName, M.Mark
from Student S join Mark M on S.StudentId = M.StudentId
join Subject B on M.SubId= B.SubId
Order by M.Mark ASC;




