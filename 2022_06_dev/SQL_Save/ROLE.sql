

-- ROLE
SELECT * FROM ROLE_SYS_PRIVS
WHERE ROLE = 'DBA';

GRANT CONNECT, RESOURCE TO KH; -- ���� �ο��ߴ� ���� ROLE ��ü�� ���� ������ �ο��ߴ���

CREATE ROLE EMP_ROLE;
-- ������ ROLE��ü�� ����
--EMP_ROLE�̶�� ROLE��ü ����
GRANT SELECT ON KH.EMPLOYEE TO EMP_ROLE;
-- �ش� ROLE��ü�� ������ �ο��ϰ�
--EMP_ROLE�� KH.EMPLOYEE�� SELECT�Ҽ��ִ� ������ �ο�
GRANT EMP_ROLE TO KHUSER;
-- ������ ROLE�� ����� ������ ���Ѻο��� �غ�.
-- EMP_ROLE�� KHUSER�� �ο�
REVOKE EMP_ROLE FROM KHUSER;
--KHUSER���� �־��� EMP_ROLE�� ������ ����
