Python 3.9.13 (tags/v3.9.13:6de2ca5, May 17 2022, 16:36:42) [MSC v.1929 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
>>> (x0,x1,x2)=(1,2,3)
>>> print("%3d~%3d:%10g" % (x0,x1,x2))
  1~  2:         3
>>> print("-%3d~-%3d:-%10g" % (x0,x1,x2))
-  1~-  2:-         3
>>>  print("%-3d~%-3d:%1-0g" % (x0,x1,x2))
 
SyntaxError: unexpected indent
>>> print("%-3d~%-3d:%-10g" % (x0,x1,x2))
1  ~2  :3         
>>> def is_pailndrome(s):
	for i in range(len(s)):
		if s[i] != s[len(s)-i-1]:
			return False
	return True

>>> is_pailndrome(tomot)
Traceback (most recent call last):
  File "<pyshell#11>", line 1, in <module>
    is_pailndrome(tomot)
NameError: name 'tomot' is not defined
>>> is_pailndrome(tomuumot)
Traceback (most recent call last):
  File "<pyshell#12>", line 1, in <module>
    is_pailndrome(tomuumot)
NameError: name 'tomuumot' is not defined
>>> s="tomto"
>>> is_pailndrome(s)
False
>>> a="tommot"
>>> is_paildrome(a)
Traceback (most recent call last):
  File "<pyshell#16>", line 1, in <module>
    is_paildrome(a)
NameError: name 'is_paildrome' is not defined
>>> is_pailndrome(a)
True
>>> s="abcdef"
>>> s.upper()
'ABCDEF'
>>> s.lower()
'abcdef'
>>> s.capitalize()
'Abcdef'
>>> s.isalpha()
True
>>> s.isdegit()
Traceback (most recent call last):
  File "<pyshell#23>", line 1, in <module>
    s.isdegit()
AttributeError: 'str' object has no attribute 'isdegit'
>>> s.isdigit()
False
>>> s2="1234"
>>> s.isdegit()
Traceback (most recent call last):
  File "<pyshell#26>", line 1, in <module>
    s.isdegit()
AttributeError: 'str' object has no attribute 'isdegit'
>>> s.isdigit()
False
>>> s2.isdigit()
True
>>> s.startseith("ef")
Traceback (most recent call last):
  File "<pyshell#29>", line 1, in <module>
    s.startseith("ef")
AttributeError: 'str' object has no attribute 'startseith'
>>> s.startswith("ef")
False
>>> s.endwith("ef"_
	  
SyntaxError: invalid syntax
>>> s.endwith("ef")
Traceback (most recent call last):
  File "<pyshell#32>", line 1, in <module>
    s.endwith("ef")
AttributeError: 'str' object has no attribute 'endwith'
>>> s.endwith("ef")
Traceback (most recent call last):
  File "<pyshell#33>", line 1, in <module>
    s.endwith("ef")
AttributeError: 'str' object has no attribute 'endwith'
>>> s.endswith("ef")
True
>>> s.replace("de"/"123")
Traceback (most recent call last):
  File "<pyshell#35>", line 1, in <module>
    s.replace("de"/"123")
TypeError: unsupported operand type(s) for /: 'str' and 'str'
>>> s.replace("de"/"123")
Traceback (most recent call last):
  File "<pyshell#36>", line 1, in <module>
    s.replace("de"/"123")
TypeError: unsupported operand type(s) for /: 'str' and 'str'
>>> s
'abcdef'
>>> s.replace("de","123")
'abc123f'
>>> 
>>> s="12ab34de"
>>> s.find("ab")
2
>>> s.find("z")
-1
>>> s.find("ab",4)
-1
>>> s.find("ab",1)
2
>>> s.find("ab",1,6)
2
>>> s="  abd dfe   "
>>> s.rstrip()
'  abd dfe'
>>> s
'  abd dfe   '
>>> s.lstrip()
'abd dfe   '
>>> s.strip()
'abd dfe'
>>> s1=s.strip()
>>> s1
'abd dfe'
>>> s1.split()
['abd', 'dfe']
>>> s2="ab cd ef gh"
>>> 12= s2.split()
SyntaxError: cannot assign to literal
>>> L2=s2.split()
>>> L2
['ab', 'cd', 'ef', 'gh']
>>> s3="2019/12/13"
>>> s3.split
<built-in method split of str object at 0x00000236BBF413F0>
>>> s3.split()
['2019/12/13']
>>> s3.split("/")
['2019', '12', '13']
>>> s1="1234"
>>> s2="abc"
>>> s1.join(s2)
'a1234b1234c'
>>> gold=[1,2,3,4,5,5,6,2,2]
>>> godset=set(gold)
>>> godset
{1, 2, 3, 4, 5, 6}
>>> type(godset)
<class 'set'>
>>> set("Good morning")
{'i', 'G', 'g', 'n', 'r', 'm', 'd', 'o', ' '}
>>> odds[godset]
Traceback (most recent call last):
  File "<pyshell#70>", line 1, in <module>
    odds[godset]
NameError: name 'odds' is not defined
>>> godset[1]
Traceback (most recent call last):
  File "<pyshell#71>", line 1, in <module>
    godset[1]
TypeError: 'set' object is not subscriptable
>>> 3 in godset
True
>>> randomset {2,3,4,5,6,7}
SyntaxError: invalid syntax
>>> randomset={2,3,4,5,6,7}
>>> randomset.add(9)
>>> randomset
{2, 3, 4, 5, 6, 7, 9}
>>> randomset.remove(7)
>>> randomset
{2, 3, 4, 5, 6, 9}
>>> randomset.pop()
2
>>> randomset
{3, 4, 5, 6, 9}
>>> odds={1,3,5,7,9}
>>> randomset.intersection(odds)
{9, 3, 5}
>>> randomset,union(evens)
Traceback (most recent call last):
  File "<pyshell#83>", line 1, in <module>
    randomset,union(evens)
NameError: name 'union' is not defined
>>> evens={2,4,6,8,10}
>>> randomset,union(evens)
Traceback (most recent call last):
  File "<pyshell#85>", line 1, in <module>
    randomset,union(evens)
NameError: name 'union' is not defined
>>> randomset.union(evens)
{2, 3, 4, 5, 6, 8, 9, 10}
>>> randomset.differenco(odds)
Traceback (most recent call last):
  File "<pyshell#87>", line 1, in <module>
    randomset.differenco(odds)
AttributeError: 'set' object has no attribute 'differenco'
>>> randomset.difference(odds)
{4, 6}
>>> odds.difference(randomest)
Traceback (most recent call last):
  File "<pyshell#89>", line 1, in <module>
    odds.difference(randomest)
NameError: name 'randomest' is not defined
>>> odds.diffeerence(ranmoeset)
Traceback (most recent call last):
  File "<pyshell#90>", line 1, in <module>
    odds.diffeerence(ranmoeset)
AttributeError: 'set' object has no attribute 'diffeerence'
>>> odds.difference(randomset)
{1, 7}
>>> randomset.difference(odds,evens)
set()
>>> 