grant create view to kh;

create user tester identified by tester;

create role role_pulbic_emp;

grant select on kh.v_emp_info to role_pulbic_emp; 

grant role_pulbic_emp to tester;

grant connect to tester;

revoke role_pulbic_emp from tester;