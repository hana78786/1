Python 3.9.13 (tags/v3.9.13:6de2ca5, May 17 2022, 16:36:42) [MSC v.1929 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
>>> 
countries = [ "Australia", "Austria", "Belarus", "Canada",
              "China", "Croatia", "Czech Republic", "Estonia",
              "Finland", "France", "Germany", "Great Britain",
              "Italy", "Japan", "Kazakhstan", "Korea", "Latvia",
              "Netherlands", "Norway", "Poland", "Russian Federation",
              "Slovakia", "Slovenia", "Sweden", "Switzerland",
              "United States" ]
>>> countries.sort()
>>> countires
Traceback (most recent call last):
  File "<pyshell#2>", line 1, in <module>
    countires
NameError: name 'countires' is not defined
>>> countries
['Australia', 'Austria', 'Belarus', 'Canada', 'China', 'Croatia', 'Czech Republic', 'Estonia', 'Finland', 'France', 'Germany', 'Great Britain', 'Italy', 'Japan', 'Kazakhstan', 'Korea', 'Latvia', 'Netherlands', 'Norway', 'Poland', 'Russian Federation', 'Slovakia', 'Slovenia', 'Sweden', 'Switzerland', 'United States']
>>> 
================================ RESTART: Shell ================================
>>> countries = [ "Australia", "Austria", "Belarus", "Canada",
              "China", "Croatia", "Czech Republic", "Estonia",
              "Finland", "France", "Germany", "Great Britain",
              "Italy", "Japan", "Kazakhstan", "Korea", "Latvia",
              "Netherlands", "Norway", "Poland", "Russian Federation",
              "Slovakia", "Slovenia", "Sweden", "Switzerland",
              "United States" ]
>>> totals=[]
>>> gold = [2, 4, 1, 14, 5, 0, 2, 0, 0, 2, 10, 1, 1, 
        0, 0, 6, 0, 4, 9, 1, 3, 1, 0, 5, 6, 9]
>>> silver = [1, 6, 1, 7, 2, 2, 0, 1, 1, 3, 13, 0, 1, 3, 1, 
          6, 2, 1, 8, 3, 5, 1, 2, 2, 0, 15]
>>> bronze = [0, 6, 1, 5, 4, 1, 4, 0, 4, 6, 7, 0, 3, 2, 0, 
          2, 0, 3, 6, 2, 7, 1, 1, 4, 3, 13]
>>> for i in range(len(countries)): #2
	medals=gold[i]+silver[i]+bronze[i] #3
	totals.append((medals,countries[i])) #4

	
>>> totals.sort()
>>> totals
[(1, 'Estonia'), (1, 'Great Britain'), (1, 'Kazakhstan'), (2, 'Latvia'), (3, 'Australia'), (3, 'Belarus'), (3, 'Croatia'), (3, 'Slovakia'), (3, 'Slovenia'), (5, 'Finland'), (5, 'Italy'), (5, 'Japan'), (6, 'Czech Republic'), (6, 'Poland'), (8, 'Netherlands'), (9, 'Switzerland'), (11, 'China'), (11, 'France'), (11, 'Sweden'), (14, 'Korea'), (15, 'Russian Federation'), (16, 'Austria'), (23, 'Norway'), (26, 'Canada'), (30, 'Germany'), (37, 'United States')]
>>> total.reverse()
Traceback (most recent call last):
  File "<pyshell#13>", line 1, in <module>
    total.reverse()
NameError: name 'total' is not defined
>>> totals.reverse()
>>> totals
[(37, 'United States'), (30, 'Germany'), (26, 'Canada'), (23, 'Norway'), (16, 'Austria'), (15, 'Russian Federation'), (14, 'Korea'), (11, 'Sweden'), (11, 'France'), (11, 'China'), (9, 'Switzerland'), (8, 'Netherlands'), (6, 'Poland'), (6, 'Czech Republic'), (5, 'Japan'), (5, 'Italy'), (5, 'Finland'), (3, 'Slovenia'), (3, 'Slovakia'), (3, 'Croatia'), (3, 'Belarus'), (3, 'Australia'), (2, 'Latvia'), (1, 'Kazakhstan'), (1, 'Great Britain'), (1, 'Estonia')]
>>> top_ten=totals[:10]
>>> for p in top_ten:
	medals,country=p
	print(medas,country)

	
Traceback (most recent call last):
  File "<pyshell#20>", line 3, in <module>
    print(medas,country)
NameError: name 'medas' is not defined
>>> country=countries
>>> top_ten=totals[:10]
>>> for p in top_ten:
	medals,country=p
	print(medals,country)

	
37 United States
30 Germany
26 Canada
23 Norway
16 Austria
15 Russian Federation
14 Korea
11 Sweden
11 France
11 China
>>> for medals, country in top_ten:
	print(medals,country)

	
37 United States
30 Germany
26 Canada
23 Norway
16 Austria
15 Russian Federation
14 Korea
11 Sweden
11 France
11 China
>>> top_ten
[(37, 'United States'), (30, 'Germany'), (26, 'Canada'), (23, 'Norway'), (16, 'Austria'), (15, 'Russian Federation'), (14, 'Korea'), (11, 'Sweden'), (11, 'France'), (11, 'China')]
>>> for p in top_ten:
	medals=p
	print (medals)

	
(37, 'United States')
(30, 'Germany')
(26, 'Canada')
(23, 'Norway')
(16, 'Austria')
(15, 'Russian Federation')
(14, 'Korea')
(11, 'Sweden')
(11, 'France')
(11, 'China')
>>> print medals
SyntaxError: Missing parentheses in call to 'print'. Did you mean print(medals)?
>>> print (medals)
(11, 'China')
>>> medals
(11, 'China')
>>> medals[5]
Traceback (most recent call last):
  File "<pyshell#38>", line 1, in <module>
    medals[5]
IndexError: tuple index out of range
>>> medals[1]
'China'
>>> medals[2]
Traceback (most recent call last):
  File "<pyshell#40>", line 1, in <module>
    medals[2]
IndexError: tuple index out of range
>>> medals
(11, 'China')
>>> country
'China'
>>> 
>>> table=[]
>>> countries = [ "Australia", "Austria", "Belarus", "Canada",
              "China", "Croatia", "Czech Republic", "Estonia",
              "Finland", "France", "Germany", "Great Britain",
              "Italy", "Japan", "Kazakhstan", "Korea", "Latvia",
              "Netherlands", "Norway", "Poland", "Russian Federation",
              "Slovakia", "Slovenia", "Sweden", "Switzerland",
              "United States" ]
>>> for i in range(len(countries)):
	table.append((gold[i],silver[i],bronze[i],countries[i]))

	
>>> table.sort()
>>> top_ten=table[-10:]
>>> top_ten.reverse()
>>> for g,s,b,country in top_ten:
	pirnt(cpuntry,g,s,b)

	
Traceback (most recent call last):
  File "<pyshell#54>", line 2, in <module>
    pirnt(cpuntry,g,s,b)
NameError: name 'pirnt' is not defined
>>> for g,s,b,country in top_ten:
	print(cpuntry,g,s,b)

	
Traceback (most recent call last):
  File "<pyshell#56>", line 2, in <module>
    print(cpuntry,g,s,b)
NameError: name 'cpuntry' is not defined
>>> for g,s,b,country in top_ten:
	print(country,g,s,b)

	
Canada 14 7 5
Germany 10 13 7
United States 9 15 13
Norway 9 8 6
Korea 6 6 2
Switzerland 6 0 3
Sweden 5 2 4
China 5 2 4
Austria 4 6 6
Netherlands 4 1 3
>>> def no_medals(countries, al, bl):
    result = []
    for i in range(len(countries)):
        if al[i] == 0 and bl[i] == 0:
            result.append(countries[i])
    return result

>>> only_gold = no_medals(countries, silver, bronze)
>>> only_silver = no_medals(countries, gold, bronze)
>>> only_bronze = no_medals(countries, gold, silver)
>>> only_one = only_gold + only_silver + only_bronze
>>> table
[(0, 1, 0, 'Estonia'), (0, 1, 0, 'Kazakhstan'), (0, 1, 4, 'Finland'), (0, 2, 0, 'Latvia'), (0, 2, 1, 'Croatia'), (0, 2, 1, 'Slovenia'), (0, 3, 2, 'Japan'), (1, 0, 0, 'Great Britain'), (1, 1, 1, 'Belarus'), (1, 1, 1, 'Slovakia'), (1, 1, 3, 'Italy'), (1, 3, 2, 'Poland'), (2, 0, 4, 'Czech Republic'), (2, 1, 0, 'Australia'), (2, 3, 6, 'France'), (3, 5, 7, 'Russian Federation'), (4, 1, 3, 'Netherlands'), (4, 6, 6, 'Austria'), (5, 2, 4, 'China'), (5, 2, 4, 'Sweden'), (6, 0, 3, 'Switzerland'), (6, 6, 2, 'Korea'), (9, 8, 6, 'Norway'), (9, 15, 13, 'United States'), (10, 13, 7, 'Germany'), (14, 7, 5, 'Canada')]
>>> al
Traceback (most recent call last):
  File "<pyshell#66>", line 1, in <module>
    al
NameError: name 'al' is not defined
>>> print(al)
Traceback (most recent call last):
  File "<pyshell#67>", line 1, in <module>
    print(al)
NameError: name 'al' is not defined
>>> print(al)
Traceback (most recent call last):
  File "<pyshell#68>", line 1, in <module>
    print(al)
NameError: name 'al' is not defined
>>> print(only_one)
['Great Britain', 'Estonia', 'Kazakhstan', 'Latvia']
>>> result
Traceback (most recent call last):
  File "<pyshell#70>", line 1, in <module>
    result
NameError: name 'result' is not defined
>>> result
Traceback (most recent call last):
  File "<pyshell#71>", line 1, in <module>
    result
NameError: name 'result' is not defined
>>> a="CS101"
>>> a[-1]
'1'
>>> a[2:]
'101'
>>> for i in a:
	print(i)

	
C
S
1
0
1
>>> t=("CS101","A+",13)
>>> t[0]
'CS101'
>>> t[-1]
13
>>> t[1:]
('A+', 13)
>>> for i in t:
	print (i)

	
CS101
A+
13
>>> def histogram():  
    t = [0] * 13
    for item in medals:
        total = sum(item[1:])
        t[total // 3] += 1
    for i in range(13):
        print (str(3*i) + "~" + str(3*i+2)+":\t"+("*"* t[i]))

        
>>> histogram()
Traceback (most recent call last):
  File "<pyshell#87>", line 1, in <module>
    histogram()
  File "<pyshell#86>", line 4, in histogram
    total = sum(item[1:])
TypeError: 'int' object is not subscriptable
>>>  histogram()
 
SyntaxError: unexpected indent
>>> histogram()
Traceback (most recent call last):
  File "<pyshell#89>", line 1, in <module>
    histogram()
  File "<pyshell#86>", line 4, in histogram
    total = sum(item[1:])
TypeError: 'int' object is not subscriptable
>>> 
>>> medals = [ ( 'Australia', 2, 1, 0 ),
           ( 'Austria', 4, 6, 6 ),
           ( 'Belarus', 1, 1, 1 ),
           ( 'Canada', 14, 7, 5 ),
           ( 'China', 5, 2, 4 ),
           ( 'Croatia', 0, 2, 1 ),
           ( 'Czech Republic', 2, 0, 4 ),
           ( 'Estonia', 0, 1, 0 ),
           ( 'Finland', 0, 1, 4 ),
           ( 'France', 2, 3, 6 ),
           ( 'Germany', 10, 13, 7 ),
           ( 'Great Britain', 1, 0, 0 ),
           ( 'Italy', 1, 1, 3 ),
           ( 'Japan', 0, 3, 2 ),
           ( 'Kazakhstan', 0, 1, 0 ),
           ( 'Korea', 6, 6, 2 ),
           ( 'Latvia', 0, 2, 0 ),
           ( 'Netherlands', 4, 1, 3 ),
           ( 'Norway', 9, 8, 6 ),
           ( 'Poland', 1, 3, 2 ),
           ( 'Russian Federation', 3, 5, 7 ),
           ( 'Slovakia', 1, 1, 1 ),
           ( 'Slovenia', 0, 2, 1 ),
           ( 'Sweden', 5, 2, 4 ),
           ( 'Switzerland', 6, 0, 3 ),
           ( 'United States', 9, 15, 13 ) ]
>>> histogram()
0~2:	****
3~5:	********
6~8:	***
9~11:	****
12~14:	*
15~17:	**
18~20:	
21~23:	*
24~26:	*
27~29:	
30~32:	*
33~35:	
36~38:	*
>>> a=[0]*13
>>> 
>>> a
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
>>> 10//3
3
>>> 8//3
2
>>> 6//3
2
>>> 7//6
1
>>> 7//3
2
>>> 9//3
3
>>> 1+=1
SyntaxError: 'literal' is an illegal expression for augmented assignment
>>> print(1+=1)
SyntaxError: invalid syntax
>>> c[3]+=1
Traceback (most recent call last):
  File "<pyshell#104>", line 1, in <module>
    c[3]+=1
NameError: name 'c' is not defined
>>> c=[1,2,3,4]
>>> c[3]+=1
>>> c
[1, 2, 3, 5]
>>> SyntaxError: invalid syntax
SyntaxError: invalid syntax
>>> L.append[13]
Traceback (most recent call last):
  File "<pyshell#109>", line 1, in <module>
    L.append[13]
NameError: name 'L' is not defined
>>> L.append(13)
Traceback (most recent call last):
  File "<pyshell#110>", line 1, in <module>
    L.append(13)
NameError: name 'L' is not defined
>>> L={}
>>> L=[]
>>> L.append(13)
>>> L
[13]
>>> R=[]
>>> R+[13]
[13]
>>> r
Traceback (most recent call last):
  File "<pyshell#117>", line 1, in <module>
    r
NameError: name 'r' is not defined
>>> R
[]
>>> R+[13]
[13]
>>> R
[]
>>> 1//3
0
>>> 2//3
0
>>> 4//3
1
>>> 5//3
1
>>> 