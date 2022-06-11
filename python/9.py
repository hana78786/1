Python 3.9.13 (tags/v3.9.13:6de2ca5, May 17 2022, 16:36:42) [MSC v.1929 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
>>> def bubbleSort(a) :
	sorted = False
	while(nat sotred) :
		
SyntaxError: invalid syntax
>>> def bubbleSort(a):
	sorted=False
	while(net sorted)
	
SyntaxError: invalid syntax
>>> def bubbleSort(a):
	sorted=False
	while(net sorted):
		
SyntaxError: invalid syntax
>>> def bubbleSort(a):
	sorted=False
	while(not sorted):
		sorted=True
		for i in range(1,len(a)):
			if(a[i-1]>a[i]):
				a[i-1],a=a[i],a[i-1]
				sorted=False

				
>>> df=[5,6,8,4,2,0]
>>> d[0-1]
Traceback (most recent call last):
  File "<pyshell#16>", line 1, in <module>
    d[0-1]
NameError: name 'd' is not defined
>>> d(0-1)
Traceback (most recent call last):
  File "<pyshell#17>", line 1, in <module>
    d(0-1)
NameError: name 'd' is not defined
>>> d[1]
Traceback (most recent call last):
  File "<pyshell#18>", line 1, in <module>
    d[1]
NameError: name 'd' is not defined
>>> df[0-1=
   
SyntaxError: invalid syntax
>>> df[0-1]
0
>>> df[0-2]
2
>>> def bubbleSort(df)
SyntaxError: invalid syntax
>>> bubleSort(df)
Traceback (most recent call last):
  File "<pyshell#24>", line 1, in <module>
    bubleSort(df)
NameError: name 'bubleSort' is not defined
>>> bubbleSort(df)
Traceback (most recent call last):
  File "<pyshell#25>", line 1, in <module>
    bubbleSort(df)
  File "<pyshell#14>", line 6, in bubbleSort
    if(a[i-1]>a[i]):
TypeError: 'int' object is not subscriptable
>>> a=[8,4,9,5,0,1,2,6]
>>> bubbleSort(a)
Traceback (most recent call last):
  File "<pyshell#27>", line 1, in <module>
    bubbleSort(a)
  File "<pyshell#14>", line 6, in bubbleSort
    if(a[i-1]>a[i]):
TypeError: 'int' object is not subscriptable
>>> bubbleSort()
Traceback (most recent call last):
  File "<pyshell#28>", line 1, in <module>
    bubbleSort()
TypeError: bubbleSort() missing 1 required positional argument: 'a'
>>> bubbleSort(a)
Traceback (most recent call last):
  File "<pyshell#29>", line 1, in <module>
    bubbleSort(a)
  File "<pyshell#14>", line 6, in bubbleSort
    if(a[i-1]>a[i]):
TypeError: 'int' object is not subscriptable
>>> def bubbleSort(a):
    sorted = False
    while(not sorted):
        sorted = True
        for i in range(1,len(a)):
            if(a[i-1] > a[i]):
                a[i-1],a[i]=a[i],a[i-1]
                sorted = False

                
>>> bubbleSort(df)
>>> df
[0, 2, 4, 4, 5, 6]
>>> rage(1,len(a))
Traceback (most recent call last):
  File "<pyshell#34>", line 1, in <module>
    rage(1,len(a))
NameError: name 'rage' is not defined
>>> range(1,len(a))
range(1, 8)
>>> bubleSort(df)
Traceback (most recent call last):
  File "<pyshell#37>", line 1, in <module>
    bubleSort(df)
NameError: name 'bubleSort' is not defined
>>> bubbleSort(df)
>>> df
[0, 2, 4, 4, 5, 6]
>>> bubbleSort(a)
>>> a
[0, 1, 2, 4, 4, 5, 5, 6]
>>> 
================================ RESTART: Shell ================================
>>> a=[1,9,8,7,5,1]
>>> def bubbleSort(a):
    sorted = False #1
    while(not sorted): #2
        sorted = True #3
        for i in range(1,len(a)): #4
            if(a[i-1] > a[i]): #5
                a[i-1],a[i]=a[i],a[i-1] #6
                sorted = False #7

                
>>> bubbleSort(a)
>>> a
[1, 1, 5, 7, 8, 9]
>>> def sieve(n):
	candidates=list(range(2,n))
	i=0
	while i<len(candidates):
		prime=candidates[i]
		j=i+1
		while j<len(candidates):
			if candidates[j]%prime==0:
				candidates.pop(j)
			else:
				j=j+1
		i=i+1
	return candidates

>>> sieve(26)
[2, 3, 5, 7, 11, 13, 17, 19, 23]
>>> hello(rage(0.8))
Traceback (most recent call last):
  File "<pyshell#63>", line 1, in <module>
    hello(rage(0.8))
NameError: name 'hello' is not defined
>>> hello(range(0,8))
Traceback (most recent call last):
  File "<pyshell#64>", line 1, in <module>
    hello(range(0,8))
NameError: name 'hello' is not defined
>>> hello=[]
>>> hello(range(0,8))
Traceback (most recent call last):
  File "<pyshell#66>", line 1, in <module>
    hello(range(0,8))
TypeError: 'list' object is not callable
>>> list(rage(0,8))
Traceback (most recent call last):
  File "<pyshell#67>", line 1, in <module>
    list(rage(0,8))
NameError: name 'rage' is not defined
>>> list(range(0,8))
[0, 1, 2, 3, 4, 5, 6, 7]
>>> heool.(1)
SyntaxError: invalid syntax
>>> hello.(1)
SyntaxError: invalid syntax
>>> 