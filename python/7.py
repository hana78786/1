Python 3.9.13 (tags/v3.9.13:6de2ca5, May 17 2022, 16:36:42) [MSC v.1929 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
>>> countries = [ "Australia", "Austria", "Belarus", "Canada",
              "China", "Croatia", "Czech Republic", "Estonia",
              "Finland", "France", "Germany", "Great Britain",
              "Italy", "Japan", "Kazakhstan", "Korea", "Latvia",
              "Netherlands", "Norway", "Poland", "Russian Federation",
              "Slovakia", "Slovenia", "Sweden", "Switzerland",
              "United States" ]
>>> gold = [2, 4, 1, 14, 5, 0, 2, 0, 0, 2, 10, 1, 1, 
        0, 0, 6, 0, 4, 9, 1, 3, 1, 0, 5, 6, 9]
>>> silver = [1, 6, 1, 7, 2, 2, 0, 1, 1, 3, 13, 0, 1, 3, 1, 
          6, 2, 1, 8, 3, 5, 1, 2, 2, 0, 15]
>>> bronze = [0, 6, 1, 5, 4, 1, 4, 0, 4, 6, 7, 0, 3, 2, 0, 
          2, 0, 3, 6, 2, 7, 1, 1, 4, 3, 13]


>>> xountires[0]
Traceback (most recent call last):
  File "<pyshell#4>", line 1, in <module>
    xountires[0]
NameError: name 'xountires' is not defined
>>> countries[0]
'Australia'
>>> countries[20]
'Russian Federation'
>>> gold[21]
1
>>> Korea=['korea','kr',3,3,2]
>>> len(korea)
Traceback (most recent call last):
  File "<pyshell#9>", line 1, in <module>
    len(korea)
NameError: name 'korea' is not defined
>>> len(Korea)
5
>>> contries[3]
Traceback (most recent call last):
  File "<pyshell#11>", line 1, in <module>
    contries[3]
NameError: name 'contries' is not defined

>>> contries[3]
Traceback (most recent call last):
  File "<pyshell#12>", line 1, in <module>
    contries[3]
NameError: name 'contries' is not defined
>>> countries[3]
'Canada'
>>> gold[3]
14
>>> len(countires)
Traceback (most recent call last):
  File "<pyshell#15>", line 1, in <module>
    len(countires)
NameError: name 'countires' is not defined
>>> len(countires)
Traceback (most recent call last):
  File "<pyshell#16>", line 1, in <module>
    len(countires)
NameError: name 'countires' is not defined
>>> len(countries)
26
>>> countries[-2]
'Switzerland'
>>> countries[-1]
'United States'
>>> countries[26-2]
'Switzerland'
>>> korea[2]
Traceback (most recent call last):
  File "<pyshell#21>", line 1, in <module>
    korea[2]
NameError: name 'korea' is not defined
>>> Korea[2]
3
>>> max(gold)
14
>>> sum(gold)
86
>>> min(gold)
0
>>> aba= ["k","ab",(123)]
>>> aba[2]
123
>>> aba=["a","b","c",(a,b,c)]
Traceback (most recent call last):
  File "<pyshell#28>", line 1, in <module>
    aba=["a","b","c",(a,b,c)]
NameError: name 'a' is not defined
>>> aba=["a","b","c",(1,2,3)]
>>> aba[3]
(1, 2, 3)
>>> aba[1]="d"
>>> print(aba)
['a', 'd', 'c', (1, 2, 3)]
>>> aba.append('apple')
>>> aba
['a', 'd', 'c', (1, 2, 3), 'apple']
>>> aba=apple
Traceback (most recent call last):
  File "<pyshell#36>", line 1, in <module>
    aba=apple
NameError: name 'apple' is not defined
>>> aba=add
Traceback (most recent call last):
  File "<pyshell#37>", line 1, in <module>
    aba=add
NameError: name 'add' is not defined
>>> add=aba
>>> add.append('apple1')
>>> aba
['a', 'd', 'c', (1, 2, 3), 'apple', 'apple1']
>>> for contry in countries:
	print(coutry)

	
Traceback (most recent call last):
  File "<pyshell#43>", line 2, in <module>
    print(coutry)
NameError: name 'coutry' is not defined
>>> for country in countries:
	print(country)

	
Australia
Austria
Belarus
Canada
China
Croatia
Czech Republic
Estonia
Finland
France
Germany
Great Britain
Italy
Japan
Kazakhstan
Korea
Latvia
Netherlands
Norway
Poland
Russian Federation
Slovakia
Slovenia
Sweden
Switzerland
United States
>>> rage(10)
Traceback (most recent call last):
  File "<pyshell#47>", line 1, in <module>
    rage(10)
NameError: name 'rage' is not defined
>>> range(10)
range(0, 10)
>>> type(range(10))
<class 'range'>
>>> list(rage(10))
Traceback (most recent call last):
  File "<pyshell#53>", line 1, in <module>
    list(rage(10))
NameError: name 'rage' is not defined
>>> list(range(10))
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
>>> totals=[]
>>> for i in range(len(countries)):
	medals=gold[i]+silver[i]+bronze[i]
	totals.append((medals,countries[i]))

	
>>> totals
[(3, 'Australia'), (16, 'Austria'), (3, 'Belarus'), (26, 'Canada'), (11, 'China'), (3, 'Croatia'), (6, 'Czech Republic'), (1, 'Estonia'), (5, 'Finland'), (11, 'France'), (30, 'Germany'), (1, 'Great Britain'), (5, 'Italy'), (5, 'Japan'), (1, 'Kazakhstan'), (14, 'Korea'), (2, 'Latvia'), (8, 'Netherlands'), (23, 'Norway'), (6, 'Poland'), (15, 'Russian Federation'), (3, 'Slovakia'), (3, 'Slovenia'), (11, 'Sweden'), (9, 'Switzerland'), (37, 'United States')]
>>> for c in countries[-5:]
SyntaxError: invalid syntax
>>> for c in countries[-5:]:
	print (c)

	
Slovakia
Slovenia
Sweden
Switzerland
United States
>>> list(range(5))
[0, 1, 2, 3, 4]
>>> list(range(3,8))
[3, 4, 5, 6, 7]
>>> for i in range(21,26):
	print(gold[i])

	
1
0
5
6
9
>>> 
