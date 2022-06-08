Python 3.9.13 (tags/v3.9.13:6de2ca5, May 17 2022, 16:36:42) [MSC v.1929 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
>>> def quadratic(a, b, c, x):
	quad_term = a * x ** 2
	lin_term = b * x
	return quad_term + lin_term + c

>>> print (quadratic(2,1,4,3))
25
>>> a = "Letter a"
>>> def f(a):  # 함수 f에서만 쓰이는 매개변수 a
	print("A = ", a)

	
>>> def g(): 
	a = 7  #함수 g에서만 쓰이는 지역변수 a
	f(a + 1)
	print("A = ", a)

	
>>> print("A = ", a)
A =  Letter a
>>> f(3.14)
A =  3.14
>>> print("A = ", a)
A =  Letter a
>>> g()
A =  8
A =  7
>>> print("A = ", a)
A =  Letter a
>>> 