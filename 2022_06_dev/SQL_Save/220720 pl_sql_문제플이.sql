
    --���� 2)
--�����ȣ�� �Է� �޾Ƽ� ����� �����ȣ,�̸�,�޿�,�Ի����� ����Ͻÿ�

declare
vid employee.emp_id%type;
vname employee.emp_name%type;
vsal employee.salary%type;
vhire employee.hire_date%type;

begin
select emp_id, emp_name, salary, hire_date
into vid, vname, vsal, vhire
from employee
where emp_id = '&���';

dbms_output.put_line('���'||vid||'�̸�'||vname||'�޿�'||vsal||'�Ի���'||vhire);

end;
/


--����1)
--��� ��ȣ�� �Է� �޾Ƽ� ���� ����� �����ȣ,�̸�,�μ��ڵ�,�μ����� ����ϵ��� �Ͻÿ�

declare
vid employee.emp_id%type;
vname employee.emp_name%type;
vdcode EMPLOYEE.DEPT_CODE%type;
vdtitle DEPARTMENT.DEPT_TITLE%type;
begin
select
emp_id, emp_name, dept_code, 
(select dept_title from department where a.dept_code = dept_id)
into
vid, vname, vdcode, vdtitle
from
employee a
where
emp_id = '&���';

dbms_output.put_line('���'||vid||'�̸�'||vname||'�μ��ڵ�'||vdcode||'�μ���'||vdtitle);

end;
/


    
    
   /* ## ���� �ǽ� 1 ##
-- �ش� ����� �����ȣ�� �Է½�
-- �̸�,�μ��ڵ�,�����ڵ尡 ��µǵ��� PL/SQL�� ����� ���ÿ� 
*/


declare
vname employee.emp_name%type;
vdcode EMPLOYEE.DEPT_CODE%type;
vjcode EMPLOYEE.JOB_CODE%type;

begin
select
emp_name, dept_code, job_code
into
vname, vdcode, vjcode
from
EMPLOYEE
where
emp_id = &���;

dbms_output.put_line(vname||vdcode||vjcode);

end;
/
    


/*
## ���� �ǽ� 2 ##
-- �ش� ����� �����ȣ�� �Է½�
-- �̸�,�μ���,���޸��� ��µǵ��� PL/SQL�� ����� ���ÿ�
*/

declare
vname employee.emp_name%type;
vdtitle department.dept_title%type;
vjname job.job_name%type;

begin

select
emp_name, dept_title, job_name
into
vname, vdtitle, vjname

from employee a

left join department
on dept_id = dept_title
left join JOB
using (job_code)
where
emp_id = '&���';

dbms_output.put_line(vname||vdtitle||vjname);



end;
/

   
   
   --����) �����ȣ�� ������ ����� ���,�̸�,�޿�,���ʽ����� ����ϰ�
-- ���ʽ����� ������ '���ʽ��� ���޹��� �ʴ� ����Դϴ�' �� ����Ͻÿ�

declare
vid employee.emp_id%type;
vname employee.emp_name%type;
vsal employee.salary%type;
vbo employee.bonus%type;

begin
select emp_id, emp_name, salary, bonus
into vid, vname, vsal, vbo

from employee
where
emp_id = '&���';

dbms_output.put_line(vid||vname||vsal);
if(vbo is null)
then dbms_output.put_line('���ʽ� ����');
else dbms_output.put_line(vbo*100||'%');
end if;
end;
/


   
   --����) ��� �ڵ带 �Է� �޾����� ���,�̸�,�����ڵ�,���޸�,�Ҽ� ���� ����Ͻÿ�
    --�׶�,�ҼӰ��� J1,J2 �� �ӿ���,�׿ܿ��� �Ϲ��������� ��µǰ� �Ͻÿ�
declare
vid employee.emp_id%type;
vname employee.emp_name%type;
vjcode employee.job_code%type;
vjname job.job_name%type;
vin varchar2(20);

begin

select
emp_id, emp_name, job_code, job_name
into
vid, vname, vjcode,vjname
from
employee a
left join job
using (job_code)
where emp_id = '&���';

if(vjcode in ('J1','J2'))
then vin:= '�ӿ���';
else vin:= '�Ϲݻ��';
end if;

dbms_output.put_line(vid||vname||vjcode||vjname||vin);


end;
/

    
    

--## ���� �ǽ� 1 ##
-- ��� ��ȣ�� ������ �ش� ����� ��ȸ
-- �̶� �����,�μ��� �� ����Ͽ���.
-- ���� �μ��� ���ٸ� �μ����� ������� �ʰ�,
-- '�μ��� ���� ��� �Դϴ�' �� ����ϰ�
-- �μ��� �ִٸ� �μ����� ����Ͽ���.

declare
vid employee.emp_id%type;
vname employee.emp_name%type;
vdtitle department.dept_title%type;
vdcode employee.dept_code%type;

begin
select
emp_id, emp_name, dept_title, dept_code
into
vid, vname, vdtitle, vdcode
from
employee a
left join department
on dept_code=dept_id
where
emp_id = '&���';

if(vdcode is null)
then vdtitle:= '�μ�����';
end if;

dbms_output.put_line(vid||vname||vdtitle);

end;
/


   
   
   --## �ǽ� ���� ##
--����� �Է� ���� �� �޿��� ���� ����� ������ ����ϵ��� �Ͻÿ� 
--�׶� ��� ���� ���,�̸�,�޿�,�޿������ ����Ͻÿ�

--0���� ~ 99���� : F
--100���� ~ 199���� : E
--200���� ~ 299���� : D
--300���� ~ 399���� : C
--400���� ~ 499���� : B
--500���� �̻�(�׿�) : A

declare
vid  employee.emp_id%type;
vname employee.emp_name%type;
vsal employee.salary%type;
vsal_level char(1);

begin
select emp_id, emp_name,salary
into vid, vname, vsal
from employee
where emp_id = '&���';

case floor(vsal/1000000)
when 0 then vsal_level := 'f';
when 1 then vsal_level := 'e';
when 2 then vsal_level := 'd';
when 3 then vsal_level := 'c';
when 4 then vsal_level := 'b';
else vsal_level := 'a';
end case;

dbms_output.put_line (vid||vname||vsal||vsal_level);

end;
/



    

--ex) 200
--��� : 200
--�̸� : ������
--�޿� : 8000000
--��� : A


-- ���� ) 1~3������ ���� �Է¹ް� 1�� �Է¹����� 	'1�� �Է��Ͽ����ϴ�',2�� �Է� ������ '2�� �Է��Ͽ����ϴ�',
-- 3�� �Է¹����� '3�� �Է��Ͽ����ϴ�'�� ����Ͻÿ�. �׿� ���� �Է½� �߸� �Է��Ͽ����ϴٸ� ���

declare
no  number;
begin
no := &����;
case 
when  no between 1 and 3 then dbms_output.put_line(no);
else dbms_output.put_line('�߸��Է��ϼ̽��ϴ�');
end case;


end;
/



        
-- ����) 1~10 ���� �ݺ��Ͽ� TEST1 ���̺� �����Ͱ� ����ǰ� �Ͻÿ�
-- TEST1(BUNHO,B_DATE)
drop table test1;
create table test1(
bunho number,
b_date date);


begin

for n in 1..10 loop
insert into test1 values (n,sysdate);
end loop;

end;
/
select * from test1;



-- �ǽ�����
-- ����ڷκ��� 2~9������ ���� �Է¹޾� ������ ����Ͻÿ�

declare 
no number;
begin
no := &no;
for n in 2..9 loop
dbms_output.put_line(no*n);
end loop;
end;
/

declare 
no number;
n number := 1;
begin
no := &no;
if(no between 1 and 9)
then

while n<=9 loop

if(n=1) then dbms_output.put_line(no*n);
end if;
n:= n+1;
continue when not mod(n,2)=1;
dbms_output.put_line(no*n);

end loop;

else 
dbms_output.put_line('�Է¿���');

end if;
end;
/


-- ���� �� ���ڰ� �ƴϸ� �ٽ� �Է¹޾Ƽ� ������ ����




-- TOP N �м��� ���� PL/SQL�� ������
-- '�޿�' / '���ʽ�' / '�Ի���'
-- ������ 1��~5�� ������ ����ϴ� PL/SQL�� ������.

declare 
vname employee.emp_name%type;
vsal employee.salary%type;
vbonus employee.bonus%type;
vhire employee.hire_date%type;
vnum number;
a varchar2(30);

begin
for n in 1..5 loop
a := '&����';


if (a='����') then
select ��ũ, salary, bonus, hire_date, emp_name
into vnum, vsal, vbonus, vhire, vname
from (select salary, bonus, hire_date, emp_name,RANK() OVER (ORDER BY
salary DESC)"��ũ" from employee order by 1)
where ��ũ = n;

dbms_output.put_line('------'||a||n||'��-----');
if(vnum = n) then
dbms_output.put_line('�̸� '||vname);
dbms_output.put_line('�޿� '||vsal);
end if;
 
 elsif (a='���ʽ�') then
 select ��ũ, salary, bonus, hire_date, emp_name
into vnum, vsal, vbonus, vhire, vname
from (select salary, bonus, hire_date, emp_name,DENSE_RANK() OVER (ORDER BY
bonus desc,emp_name desc)"��ũ" from employee where bonus is not null)
where ��ũ = n;
dbms_output.put_line('------'||a||n||'��-----');
if(vnum = n) then
dbms_output.put_line('�̸� '||vname);
dbms_output.put_line('���ʽ� '||vbonus*100||'%');
end if;

elsif (a='�Ի���') then
 select ��ũ, salary, bonus, hire_date, emp_name
into vnum, vsal, vbonus, vhire, vname
from (select salary, bonus, hire_date, emp_name,RANK() OVER (ORDER BY
hire_date ASC)"��ũ" from employee order by 1)
where ��ũ = n;
dbms_output.put_line('------'||a||n||'��-----');
if(vnum = n) then
dbms_output.put_line('�̸� '||vname);
dbms_output.put_line('�Ի��� '||vhire);
end if;

end if;

end loop;
end;
/

select salary, bonus, hire_date, emp_name,DENSE_RANK() OVER (ORDER BY
bonus, salary desc)"��ũ" from employee where bonus is not null;


--no_data_found
--1. �޿�, �̸�, �̸��� ���

declare 
name employee.emp_name%type;

begin
select emp_name
into name
from employee
where emp_name = '&name';

dbms_output.put_line(name);

exception
 when no_data_found then dbms_output.put_line('�ڷ����');


end;
/



--2. �̹� �����ϴ� ����� �̿��ڸ� �߰��Ҷ� dup_val_on_index



begin

insert into employee (emp_id,emp_name,emp_no,job_code,sal_level)
values ('200', '�̿���','12345','j1','as');

exception
 when dup_val_on_index then dbms_output.put_line('�������ߺ�');
end;
/

set serveroutput on;

