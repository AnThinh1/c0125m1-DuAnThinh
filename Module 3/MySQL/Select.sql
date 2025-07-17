USE QuanLySinhVien;
SELECT * FROM Student WHERE Status = true;

SELECT *
FROM Subject
WHERE Credit < 10;

SELECT * FROM Mark;
SELECT * FROM Class;
SELECT * FROM Student;
SELECT * FROM Subject;

SELECT S.StudentID, S.StudentName, C.ClassName 
From Student S join Class C on S.ClassID=C.ClassID;

SELECT S.StudentId, S.StudentName, C.ClassName
FROM Student S join Class C on S.ClassId = C.ClassID
WHERE C.ClassName = 'A1';

SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM Student S join Mark M on S.StudentId = M.StudentId join Subject Sub on M.SubId = Sub.SubId;

SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM Student S join Mark M on S.StudentId = M.StudentId join Subject Sub on M.SubId = Sub.SubId
WHERE Sub.SubName = 'CF';