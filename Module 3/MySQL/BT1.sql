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
SELECT S.StudentName, SU.SubName, M.Mark
From Student S join 