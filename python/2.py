Python 3.9.13 (tags/v3.9.13:6de2ca5, May 17 2022, 16:36:42) [MSC v.1929 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
>>> 13//4
3
>>> 13.0//4.0
3.0
>>> 9/7
1.2857142857142858
>>> 9//7
1
>>> 2**16
65536
>>> 2*16
32
>>> 2*2*2*2*2*2*2*2*2*2*2*2*2*2*2
32768
>>> 2*2*2*2*2
32
>>> 2**5
32
>>> 2*2*2
8
>>> 2**3
8
>>> 7%3
1
>>> 7%-3
-2
>>> -7%3
2
>>> 7/-3
-2.3333333333333335
>>> -7/-3
2.3333333333333335
>>> -7%-3
-1
>>> -7/3
-2.3333333333333335
>>> 9//7
1
>>> 40/-2
-20.0
>>> 40%-2
0
>>> 45/2
22.5
>>> 45%-2
-1
>>> 45/-2
-22.5
>>> 2+3*4
14
>>> 5%-2
-1
>>> 5/2
2.5
>>> 5%2
1
>>> 10%2
0
>>> 11%2
1
>>> 1234%12
10
>>> "Hello"+"CS101"
'HelloCS101'
>>> "CS101"*8
'CS101CS101CS101CS101CS101CS101CS101CS101'
>>> 3<5
True
>>> 27<14
False
>>> 3.14!=3.14
False
>>> 3.14>=3.14
True
>>> "Cheong"<"Choe"
True
>>> a<b
Traceback (most recent call last):
  File "<pyshell#38>", line 1, in <module>
    a<b
NameError: name 'a' is not defined
>>> "a"<"b"
True
>>> 3="3"
SyntaxError: cannot assign to literal
>>> "3"=3
SyntaxError: cannot assign to literal
>>> "3" = 3
SyntaxError: cannot assign to literal
>>> "3" == 3
False
>>> (not True)==False
True
>>> (not False)==True
True
>>> (False and False)==False
True
>>> (False and True)==False
True
>>> (True and True)==True
True
>>> (True and False)==False
True
>>> (False or False)==False
True
>>> (False or True)==True
True
>>> (True or False)==True
True
>>> (True or True)==True
True
>>> a = 10
>>> def f() :
	global a
	a\0
	
SyntaxError: unexpected character after line continuation character
>>> def f() :
	global a
	a=0
KeyboardInterrupt
>>> def f() :
	global a
	a=0
	return True

>>> True or f()
True
>>> print(a)
10
>>> True and f()
True
>>> print(a)
0
>>> a=10
>>> def f() :
	global a
	a=0

	
>>> False and f()
False
>>> print(a)
10
>>> position = (3.14,-5,7.5)
>>> profs=("in-Yong Ko","Sunghee choi","Lee YoungHee","Duksan Ryu","Key-Sun Choi")
>>> print(position, type(position))
(3.14, -5, 7.5) <class 'tuple'>
>>> x,y,x = position
>>> print(x)
7.5
>>> print(y)
-5
>>> x,y,x=position
>>> print(x)
7.5
>>> x,y,z=position
>>> print(x)
3.14
>>> print(y)
-5
>>> print(z)
7.5
>>> a,b=("aa","bb")
>>> a,b=b,a
>>> print(b)
aa
>>> from cs1media import *
>>> img =create_picture(100,100,purple)
Traceback (most recent call last):
  File "<pyshell#86>", line 1, in <module>
    img =create_picture(100,100,purple)
NameError: name 'purple' is not defined
>>> img = create_picture(100, 100, purple)
Traceback (most recent call last):
  File "<pyshell#87>", line 1, in <module>
    img = create_picture(100, 100, purple)
NameError: name 'purple' is not defined
>>> purple = (128, 0, 128)
>>> img = create_picture(100, 100, purple)
>>> img.show()
Traceback (most recent call last):
  File "<pyshell#90>", line 1, in <module>
    img.show()
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1media.py", line 56, in show
    tool.run_tool()
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1media.py", line 354, in run_tool
    self.root.mainloop()
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\tkinter\__init__.py", line 1429, in mainloop
    self.tk.mainloop(n)
KeyboardInterrupt


>>> red = (255, 0, 0)

blue = (0, 0, 255)

white = (255, 255, 255)

black = (0, 0, 0)

yellow = (255, 255, 0)

purple = (128, 0, 128)
SyntaxError: multiple statements found while compiling a single statement
>>> red = (255, 0, 0)

>>> yellow = (255, 255, 0)
>>> img.set_pixels(yellow)
>>> img.show()
Traceback (most recent call last):
  File "<pyshell#95>", line 1, in <module>
    img.show()
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1media.py", line 56, in show
    tool.run_tool()
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1media.py", line 336, in run_tool
    self.draw_image(self.root.im)
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1media.py", line 378, in draw_image
    self.root.img = self.canvas1.create_image(0, 0, image=self.root.photo1,
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\tkinter\__init__.py", line 2790, in create_image
    return self._create('image', args, kw)
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\tkinter\__init__.py", line 2776, in _create
    return self.tk.getint(self.tk.call(
_tkinter.TclError: image "pyimage4" doesn't exist
>>> 
KeyboardInterrupt
>>> red = (255, 0, 0)
>>> white = (255, 255, 255)
>>> black = (0, 0, 0)
>>> yellow = (255, 255, 0)
>>> purple = (128, 0, 128)
>>> from cs1media import *
>>> img = create_picture(100, 100, purple)
>>> img.show()
img.set_pixels(yellow)
>>> img.set_pixels(yellow)
>>> img.show()
>>> for i in range(7) :
	pirnt("*" * i)

	
Traceback (most recent call last):
  File "<pyshell#108>", line 2, in <module>
    pirnt("*" * i)
NameError: name 'pirnt' is not defined
>>> for i in range(7) :
	print("*" * i)

	

*
**
***
****
*****
******
>>> for i in range(4):
	print("*")

	
*
*
*
*
>>> for i range(10):
	
SyntaxError: invalid syntax
>>> for i in range(4) :
	print(i)

	
0
1
2
3
>>> from cs1media import *
>>> img = load_picture("../photos/geowi.jpg")
Traceback (most recent call last):
  File "<pyshell#119>", line 1, in <module>
    img = load_picture("../photos/geowi.jpg")
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1media.py", line 111, in load_picture
    img = _Image.open(filename)
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\site-packages\PIL\Image.py", line 3068, in open
    fp = builtins.open(filename, "rb")
FileNotFoundError: [Errno 2] No such file or directory: '../photos/geowi.jpg'
>>> img = load_picture("./photos/geowi.jpg")
>>> w, h = img.size()
>>> for y in range(h):
	for x in range(w) :
		r,g,b=img.get(x,y)
		r,g,b=255-r,255-g,255-b
		img.set(x,y,(r,g,b))

		
>>> img.show
<bound method Picture.show of <cs1media.Picture object at 0x00000226F5432430>>
>>> 
>>> img.show()
>>> threshold=100
>>> shite=(255,255,255)
>>> white=(255,255,255)
>>> black=(0,0,0)
>>> img=load_picture("./photos/yuna1.jpg")
>>> w,h=img.size()
>>> for y in range(h):
	for x in range(w):
		v=(r+g+b)//3
		if v> threshold:
			img.set(x,y,white)
		else:
			img.set(x,y,black)

			
>>> img.show()
>>> 