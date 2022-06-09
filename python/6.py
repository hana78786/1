Python 3.9.13 (tags/v3.9.13:6de2ca5, May 17 2022, 16:36:42) [MSC v.1929 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
>>> help(”cs1graiphics”)
SyntaxError: invalid character '”' (U+201D)
>>> help("cs1graiphics”)
     
SyntaxError: EOL while scanning string literal
>>> help("cs1graiphics")
No Python documentation found for 'cs1graiphics'.
Use help() to get the interactive help utility.
Use help(str) for help on the str class.

>>> from math impotr*
SyntaxError: invalid syntax
>>> from math improt*
SyntaxError: invalid syntax
>>> from math import *
>>> print(pi)
3.141592653589793
>>> print(math.pi)
Traceback (most recent call last):
  File "<pyshell#7>", line 1, in <module>
    print(math.pi)
NameError: name 'math' is not defined
>>> 
================================== RESTART: Shell =================================
>>> from math improt sin
SyntaxError: invalid syntax
>>> from math import sin
>>> pirnt(sin(3.14))
Traceback (most recent call last):
  File "<pyshell#10>", line 1, in <module>
    pirnt(sin(3.14))
NameError: name 'pirnt' is not defined
>>> print (sin(3.14))
0.0015926529164868282
>>> pirnt (pi)
Traceback (most recent call last):
  File "<pyshell#12>", line 1, in <module>
    pirnt (pi)
NameError: name 'pirnt' is not defined
>>> print(math.pi)
Traceback (most recent call last):
  File "<pyshell#13>", line 1, in <module>
    print(math.pi)
NameError: name 'math' is not defined
>>> 
================================== RESTART: Shell =================================
>>> from cs1graphics import*
>>> canvas=canvas(400,300)
Traceback (most recent call last):
  File "<pyshell#15>", line 1, in <module>
    canvas=canvas(400,300)
NameError: name 'canvas' is not defined
>>> canvas=Canvas(400,300)
>>> canvas.setBackgroundColor("light blue") #캠버스의 배경을 rightblue로 지정한다
>>> canvas.setTitle("CS101 Drawing exercise") #타이틀 지정
>>> sq=Square(100)
>>> cavas.add(sq)
Traceback (most recent call last):
  File "<pyshell#20>", line 1, in <module>
    cavas.add(sq)
NameError: name 'cavas' is not defined
>>> canvas.add(sq)
>>> sq.setFillColor("blue")
>>> sq.setBorderColor("red")
>>> sq.setBoerderWidth(5)
Traceback (most recent call last):
  File "<pyshell#24>", line 1, in <module>
    sq.setBoerderWidth(5)
AttributeError: 'Square' object has no attribute 'setBoerderWidth'
>>> sq.setBorderWidth(5)
>>> sq.moveTo(200,200)
>>> for i in range(100):
	sq.move(1,0)
	time.sleep(0.1)

	
Traceback (most recent call last):
  File "<pyshell#30>", line 3, in <module>
    time.sleep(0.1)
NameError: name 'time' is not defined
>>> for i in range(100):
	sq.move(1,0)
	time.sleep(0.1)

	
Traceback (most recent call last):
  File "<pyshell#32>", line 3, in <module>
    time.sleep(0.1)
NameError: name 'time' is not defined
>>> import time
>>> 
>>> for i in range(100):
	sq.move(1,0)
	time.sleep(0.1)

	
>>> r=Rectangle(150,75)
>>> canvas.add(r)
>>> r.setFillColor("yellow")
>>> r.moveTo(280,150)
>>> sq.setDepth(10)
>>> r.setDepth(20)
>>> sq.rotate(45)
>>> sq.scale(1.5)
>>> r.scale(0.5)
>>> for i in range(80):
	sq.scale(0.95)
	time.sleep(0.1)
canvas.remove(sq)
SyntaxError: invalid syntax
>>> for i in range(80):
	sq.scale(0.95)
	time.sleep(0.1)

	
canvas.remove(sq)
>>> canvas.remove(sq)
>>> canvas.add(sq)
>>> sq.scale(100)
>>> canvas.remove(sq,r)
Traceback (most recent call last):
  File "<pyshell#55>", line 1, in <module>
    canvas.remove(sq,r)
TypeError: remove() takes 2 positional arguments but 3 were given
>>> canvas.remove(sq)
>>> canvas.remove(r)
>>> car=Layer()
>>> tirel=Circle(10,point(-20-10))
Traceback (most recent call last):
  File "<pyshell#60>", line 1, in <module>
    tirel=Circle(10,point(-20-10))
NameError: name 'point' is not defined
>>> tirel=Circle(10,point(-20,-10))
Traceback (most recent call last):
  File "<pyshell#61>", line 1, in <module>
    tirel=Circle(10,point(-20,-10))
NameError: name 'point' is not defined
>>> tirel=Circle(10,Point(-20,-10))
>>> tirel.setFillColor(black)
Traceback (most recent call last):
  File "<pyshell#63>", line 1, in <module>
    tirel.setFillColor(black)
NameError: name 'black' is not defined
>>> tirel.setFillColor('black')
>>> car.add(tirel)
>>> tire2=Circle(10,Point(20,-10))
>>> tire2.setFillColor('black')
>>> car.add(tire2)
>>> bady=Rectangle(70,30,point(0,-25))
Traceback (most recent call last):
  File "<pyshell#69>", line 1, in <module>
    bady=Rectangle(70,30,point(0,-25))
NameError: name 'point' is not defined
>>> body=Rectangle(70,90,Point(0,-25))
>>> body.setFillColor('blue')
>>> body.setDepth(60)
>>> car.add(body)
>>> car.moveTo(50,150)
>>> canvas.add(car)
>>> canvas.remove(car)
>>> car = Layer()
tire1 = Circle(10, Point(-20,-10))
tire1.setFillColor('black')
car.add(tire1)
tire2 = Circle(10, Point(20,-10))
tire2.setFillColor('black')
car.add(tire2)
body = Rectangle(70, 30, Point(0, -25))
body.setFillColor('blue')
body.setDepth(60)
car.add(body)
SyntaxError: multiple statements found while compiling a single statement
>>> car = Layer()
>>> tire1 = Circle(10, Point(-20,-10))
>>> canvas.add(car)
>>> 
>>> car.moveTo(50,150)
>>> canvas.add(car)
Traceback (most recent call last):
  File "<pyshell#83>", line 1, in <module>
    canvas.add(car)
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1graphics.py", line 3473, in add
    raise ValueError('object already on the Canvas')
ValueError: object already on the Canvas
>>> car = Layer()
>>> tire1 = Circle(10, Point(-20,-10))
>>> tire1.setFillColor('black')
>>> 

>>> car.add(tire1)
>>> tire2 = Circle(10, Point(20,-10))
>>> ire2.setFillColor('black')
Traceback (most recent call last):
  File "<pyshell#90>", line 1, in <module>
    ire2.setFillColor('black')
NameError: name 'ire2' is not defined
>>> tire2.setFillColor('black')
>>> ar.add(tire2)
Traceback (most recent call last):
  File "<pyshell#92>", line 1, in <module>
    ar.add(tire2)
NameError: name 'ar' is not defined
>>> car.add(tire2)
>>> body = Rectangle(70, 30, Point(0, -25))
>>> body.setFillColor('blue')
>>> body.setDepth(60)
>>> car.add(body)
>>> car.moveTo(50, 150)
>>> canvas.add(car)
>>> canvas.wait()
Traceback (most recent call last):
  File "<pyshell#100>", line 1, in <module>
    canvas.wait()
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1graphics.py", line 1944, in wait
    return _graphicsManager.wait(self)
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1graphics.py", line 1826, in wait
    self.mainLoop(waiter, True)
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1graphics.py", line 1852, in mainLoop
    _time.sleep(.1)
KeyboardInterrupt
>>> time.sleep(0.1)
>>> for i in range(50):
	car.move(2,0)

	
>>> for i in range(22):
	car.rotate(-1)

	
>>> for i in range(50):
	car.move(2,-1)

	
>>> for i in range(22)
SyntaxError: invalid syntax
>>> for i in range(252):
	car.rotate(1)

	
>>> for i in range(50):
	car.rotate(1)

	
>>> for i in range(90)
SyntaxError: invalid syntax
>>> for i in range(90)
SyntaxError: invalid syntax
>>> for i in range(90):
	car.rotate(1)

	
>>> for i in range(12)
SyntaxError: invalid syntax
>>> for i in range(12):
	car.rotate(-1)

	
>>> car.rotate(1)
>>> 
>>> car.rotate(2)
>>> car.rotate(-1)
>>> for i in range(10):
	car.scale(1.05)

	
>>> 