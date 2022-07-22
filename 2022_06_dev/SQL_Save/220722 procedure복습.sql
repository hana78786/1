create table emp_dup
as select * from employee;

create procedure del_all_emp
is
begin
    delete from emp_dup;
    commit;
end;
/
execute del_all_emp;
set serveroutput on;

delete emp_dup
where emp_id = 212;

ROLLBACK;

select * from emp_dup;

drop table emp_dup;

create procedure proc_del_emp_id (p_emp_id emp_dup.emp_id%type)
is
begin
    delete emp_dup where emp_id = p_emp_id;
    commit;
    dbms_output.put_line(p_emp_id||'번 사원을 삭제했습니다');
end;
/

execute proc_del_emp_id(&사원번호);
    