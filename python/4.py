Python 3.9.13 (tags/v3.9.13:6de2ca5, May 17 2022, 16:36:42) [MSC v.1929 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
>>> from cs1robots import *
>>> load_world()
Traceback (most recent call last):
  File "<pyshell#1>", line 1, in <module>
    load_world()
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1robots.py", line 288, in load_world
    filename = _easygui.fileopenbox("Select a Robot world",
AttributeError: module 'easygui' has no attribute 'fileopenbox'
>>> load_world("../worlds/harvest2.wld")
Traceback (most recent call last):
  File "<pyshell#2>", line 1, in <module>
    load_world("../worlds/harvest2.wld")
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1robots.py", line 292, in load_world
    txt = open(filename, 'r').read()
FileNotFoundError: [Errno 2] No such file or directory: '../worlds/harvest2.wld'
>>> from cs1robots import *
>>> load_world("./worlds/harvest2.wld")
Traceback (most recent call last):
  File "<pyshell#4>", line 1, in <module>
    load_world("./worlds/harvest2.wld")
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1robots.py", line 292, in load_world
    txt = open(filename, 'r').read()
FileNotFoundError: [Errno 2] No such file or directory: './worlds/harvest2.wld'
>>> load_world("/worlds/harvest2.wld")
Traceback (most recent call last):
  File "<pyshell#5>", line 1, in <module>
    load_world("/worlds/harvest2.wld")
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1robots.py", line 292, in load_world
    txt = open(filename, 'r').read()
FileNotFoundError: [Errno 2] No such file or directory: '/worlds/harvest2.wld'
>>> load_world("worlds/harvest2.wld")
Traceback (most recent call last):
  File "<pyshell#6>", line 1, in <module>
    load_world("worlds/harvest2.wld")
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1robots.py", line 292, in load_world
    txt = open(filename, 'r').read()
FileNotFoundError: [Errno 2] No such file or directory: 'worlds/harvest2.wld'
>>> load_world("../worlds/harvest2.wld")
Traceback (most recent call last):
  File "<pyshell#7>", line 1, in <module>
    load_world("../worlds/harvest2.wld")
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1robots.py", line 292, in load_world
    txt = open(filename, 'r').read()
FileNotFoundError: [Errno 2] No such file or directory: '../worlds/harvest2.wld'
>>> load_world("../worlds/harvest2.wld")
Traceback (most recent call last):
  File "<pyshell#8>", line 1, in <module>
    load_world("../worlds/harvest2.wld")
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1robots.py", line 292, in load_world
    txt = open(filename, 'r').read()
FileNotFoundError: [Errno 2] No such file or directory: '../worlds/harvest2.wld'
>>> load_world("../worlds/harvest2.wld")
Traceback (most recent call last):
  File "<pyshell#9>", line 1, in <module>
    load_world("../worlds/harvest2.wld")
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1robots.py", line 292, in load_world
    txt = open(filename, 'r').read()
FileNotFoundError: [Errno 2] No such file or directory: '../worlds/harvest2.wld'
>>> load_world("./worlds/harvest2.wld")
>>> def turn_right(robot):
	for i in range(3):
		robot.turn_left()

		
>>> ami=Robot("yellow")
>>> hubo=Robot("blue")
>>> turn_right(ami)
>>> turn_right(hubo)
>>> move(hubo)
Traceback (most recent call last):
  File "<pyshell#19>", line 1, in <module>
    move(hubo)
NameError: name 'move' is not defined
>>> hubo.move()
Traceback (most recent call last):
  File "<pyshell#20>", line 1, in <module>
    hubo.move()
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1robots.py", line 456, in move
    raise RobotError("That move really hurt!\n Please, make sure that " +
cs1robots.RobotError: That move really hurt!
 Please, make sure that there is no wall in front of me!
>>> hubo.move()
Traceback (most recent call last):
  File "<pyshell#21>", line 1, in <module>
    hubo.move()
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1robots.py", line 456, in move
    raise RobotError("That move really hurt!\n Please, make sure that " +
cs1robots.RobotError: That move really hurt!
 Please, make sure that there is no wall in front of me!
>>> ami.move()
Traceback (most recent call last):
  File "<pyshell#22>", line 1, in <module>
    ami.move()
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1robots.py", line 456, in move
    raise RobotError("That move really hurt!\n Please, make sure that " +
cs1robots.RobotError: That move really hurt!
 Please, make sure that there is no wall in front of me!
>>> robot.move()
Traceback (most recent call last):
  File "<pyshell#23>", line 1, in <module>
    robot.move()
NameError: name 'robot' is not defined
>>> hubo.turn_left
<bound method Robot.turn_left of <cs1robots.Robot object at 0x00000177606B6AF0>>
>>> hubo.turn_left()
>>> hubo.move()
>>> turn_right(ami)
>>> turn_right(ami)
>>> ami.move()
>>> 
================================ RESTART: Shell ================================
>>> from cs1robots import *
>>> load_world("./worlds/harvest2.wld")
>>> hubo=Robot("blue")
>>> for i rage(5):
	
SyntaxError: invalid syntax
>>> for i range(5)
SyntaxError: invalid syntax
>>> for i in range(5):
	hubo.move()

	
>>> hubo.turn_left()
>>> hubo.move()
>>> def mo1 :
	
SyntaxError: invalid syntax
>>> def turn_right():
	for i in range(3):
		robot.turn_left()

		
>>> turn_right()
Traceback (most recent call last):
  File "<pyshell#47>", line 1, in <module>
    turn_right()
  File "<pyshell#46>", line 3, in turn_right
    robot.turn_left()
NameError: name 'robot' is not defined
>>> def turn_right():
	for i in range(3):
		hubo.turn_left()

		
>>> turn_right()
>>> turn_right()
>>> turn_right()
>>> turn_right()
>>> def turn():
	
KeyboardInterrupt
>>> def turn():
	turn_right()
	turn_right()

	
>>> def mo4():
	hubo.pick_beeper()
	turn_right()
	hubo.turn_left()
	hubo.move()

	
>>> for i in range(5):
	mo4()

	
Traceback (most recent call last):
  File "<pyshell#67>", line 2, in <module>
    mo4()
  File "<pyshell#64>", line 2, in mo4
    hubo.pick_beeper()
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1robots.py", line 506, in pick_beeper
    raise RobotError("I must be on a beeper to pick it up.")
cs1robots.RobotError: I must be on a beeper to pick it up.
>>> turn_right()
>>> hubo.move()
>>> hubo.pick_beeper()
>>> hubo.move()
>>> hubo.turn_left()
>>> hubo.move()
>>> def mov4():
	hubo.pick_beeper()
	turn_right()
	hubo.move()
	hubo.turn_left()
	hubo.move()

	
>>> for i in range(3):
	mov4()

	
>>> def mov6():
	hubo.pick_beeper()
	hubo.move()
	hubo.turn_left()
	hubo.move()
	turn_right()

	
>>> for i in range(5)
SyntaxError: invalid syntax
>>> for i in range(5):
	mov6()

	
>>> hubo.turn_left()
>>> for i in range(5):
	mov6()

	
>>> hubo.turn_left()
>>> for i in range(5):
	mov6()

	
>>> turn()
>>> hubo.move()
>>> hubo.move()
>>> turn_right()
>>> for i in range(3):
	mov6()

	
>>> hubo.turn_left
<bound method Robot.turn_left of <cs1robots.Robot object at 0x0000017453C231F0>>
>>> hubo.turn_left()
>>> for i in range(3):
	mov6()

	
>>> hubo.turn_left()
>>> 
>>> for i in range(3):
	mov6()

	
>>> hubo.turn_left()
>>> for i in range(3):
	mov6()

	
>>> def mov24():
	mov6()
	hubo.turn_left()

	
>>> turn()
>>> move()
Traceback (most recent call last):
  File "<pyshell#119>", line 1, in <module>
    move()
NameError: name 'move' is not defined
>>> hubo.move()
>>> hubo.move()
>>> turn_right
<function turn_right at 0x00000174545041F0>
>>> turn_right()
>>> for i in range(3):
	move24()

	
Traceback (most recent call last):
  File "<pyshell#126>", line 2, in <module>
    move24()
NameError: name 'move24' is not defined
>>> for i in range(3):
	mov24()

	
>>> hubo.pick_beeper()
>>> 
================================ RESTART: Shell ================================
>>> from cs1robots import *
>>> load_world("./worlds/harvest2.wld")
>>> 
>>> hubo=Robot("blue")
>>> hubo.set_pause(0.05)
>>> hubo.set_trace("blue")
>>> def turn1(robot):
	for i in range(5):
		robot.move()
	robot.turn_left()
	robot.move()

	
>>> turn1(hubo)
>>> def gedan1(robot,n):
	for i in range(n):
		robot.pick_beeper()
		robot.move()
		turn_right(robot)
		robot.move()
		robot.turn_left()

		
>>> def turn_right(robot):
	for i in range(3):
		robot.turn_left()

		
>>> def gedan4(robot, n):
	for i in range(4):
		gedan1(robot, n)
		robot.turn_left()

		
>>> gedan4(hubo,1)
>>> hubo.set_pause(0.5)
>>> gedan4(hubo,1)
Traceback (most recent call last):
  File "<pyshell#163>", line 1, in <module>
    gedan4(hubo,1)
  File "<pyshell#160>", line 3, in gedan4
    gedan1(robot, n)
  File "<pyshell#151>", line 3, in gedan1
    robot.pick_beeper()
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1robots.py", line 506, in pick_beeper
    raise RobotError("I must be on a beeper to pick it up.")
cs1robots.RobotError: I must be on a beeper to pick it up.
>>> 
================================ RESTART: Shell ================================
>>> from cs1robots import *
>>> load_world("./worlds/harvest2.wld")
>>> def trun1(robot):
	for i in range(5):
		robot.move()
	robot.turn_left()
	move()

	
>>> def gedan(robot,n):
	robot.pick_beeper()
	robot.move()
	turn_right(robot)
	robot.move()
	robot.turn_left()

	
>>> def turn_right(robot):
	for i in range(3):
		robot.turn_left()

		
>>> def diamond(robot, n):
	for i in range(4):
		gedan(robot,n)
		robot.turn_left()

		
>>> def full(robot):
	for i in range(3):
		n=5-2*1
		diamond(robot,n)
		robot.move()
		robot.move()

		
>>> def dance(robot):
	for i in range(102)L
	
SyntaxError: invalid syntax
>>> def dance(robot):
	for i in range(102):
		robot.turn_left()

		
>>> hubo=Robot()
>>> hubo.set_trace("blue")
>>> hubo.set_pause(0.2)
>>> 
>>> trun1(hubo)
Traceback (most recent call last):
  File "<pyshell#208>", line 1, in <module>
    trun1(hubo)
  File "<pyshell#171>", line 5, in trun1
    move()
NameError: name 'move' is not defined
>>> def trun(robot):
	for i in range(5):
		robot.move()
	robot.turn_left()
	robot.move()

	
>>> hubo.move()
>>> full(hubo)
Traceback (most recent call last):
  File "<pyshell#212>", line 1, in <module>
    full(hubo)
  File "<pyshell#197>", line 4, in full
    diamond(robot,n)
  File "<pyshell#190>", line 3, in diamond
    gedan(robot,n)
  File "<pyshell#178>", line 2, in gedan
    robot.pick_beeper()
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1robots.py", line 506, in pick_beeper
    raise RobotError("I must be on a beeper to pick it up.")
cs1robots.RobotError: I must be on a beeper to pick it up.
>>> dance(hubo)
>>> 
>>> dance(hubo)
>>> 
================================ RESTART: Shell ================================
>>> from cs1robots import *
>>> load_world("./worlds/harvest2.wld")
>>> def turn_right(robot):
  for i in range(3):
    robot.turn_left()

    
>>> def goto_start(robot):
  for i in range(5):
    robot.move()
  robot.turn_left()
  robot.move()

  
>>> def stairs(robot, n):
  for i in range(n):
    robot.pick_beeper()
    robot.move()
    turn_right(robot)
    robot.move()
    robot.turn_left()

    
>>> hubo=Robot()
>>> goto_start(hubo)
>>> stairs(hubo,5)
>>> hubo.turn_left()
>>> stairs(hubo,5)
>>> def stairs1(robot,n):
	stairs(robot)
	robot.turn_left()

	
>>> stairs1
<function stairs1 at 0x00000274981BF820>
>>> stairs1(hubo,5)
Traceback (most recent call last):
  File "<pyshell#235>", line 1, in <module>
    stairs1(hubo,5)
  File "<pyshell#233>", line 2, in stairs1
    stairs(robot)
TypeError: stairs() missing 1 required positional argument: 'n'
>>> stairs1(hubo,5)
Traceback (most recent call last):
  File "<pyshell#236>", line 1, in <module>
    stairs1(hubo,5)
  File "<pyshell#233>", line 2, in stairs1
    stairs(robot)
TypeError: stairs() missing 1 required positional argument: 'n'
>>> def stairs2(robot,n):
	stairs(robot,n)
	tobot,turn_left()

	
>>> starirs2(hubo,5)
Traceback (most recent call last):
  File "<pyshell#241>", line 1, in <module>
    starirs2(hubo,5)
NameError: name 'starirs2' is not defined
>>> def stairs3(robot,n):
	stairs(robot,n)
	robot.turn_left()

	
>>> stairs3(hubo,5)
Traceback (most recent call last):
  File "<pyshell#244>", line 1, in <module>
    stairs3(hubo,5)
  File "<pyshell#243>", line 2, in stairs3
    stairs(robot,n)
  File "<pyshell#223>", line 6, in stairs
    robot.move()
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1robots.py", line 456, in move
    raise RobotError("That move really hurt!\n Please, make sure that " +
cs1robots.RobotError: That move really hurt!
 Please, make sure that there is no wall in front of me!
>>> hubo.turn_left
<bound method Robot.turn_left of <cs1robots.Robot object at 0x0000027498367E20>>
>>> hubo.turn_left()
>>> hubo.turn_left()
>>> hubo.move()
>>> 
================================ RESTART: Shell ================================
>>> from cs1robots import *
>>> load_world("./worlds/harvest2.wld")
>>> 
>>> hubo=Robot()
>>> def stairs(robot, n):
  for i in range(n):
    robot.pick_beeper()
    robot.move()
    turn_right(robot)
    robot.move()
    robot.turn_left()

    
>>> for i in range(5):
	hubo.move()

	
>>> hubo.turn_left()
>>> hubo.move()
>>> stairs(hubo,5)
Traceback (most recent call last):
  File "<pyshell#260>", line 1, in <module>
    stairs(hubo,5)
  File "<pyshell#254>", line 5, in stairs
    turn_right(robot)
NameError: name 'turn_right' is not defined
>>> stairs(hubo,1)
Traceback (most recent call last):
  File "<pyshell#261>", line 1, in <module>
    stairs(hubo,1)
  File "<pyshell#254>", line 3, in stairs
    robot.pick_beeper()
  File "C:\Users\user\AppData\Local\Programs\Python\Python39\lib\cs1robots.py", line 506, in pick_beeper
    raise RobotError("I must be on a beeper to pick it up.")
cs1robots.RobotError: I must be on a beeper to pick it up.
>>> hubo.turn_left()
>>> hubo.turn_left()
>>> hubo.turn_left()
>>> hubo.move()
>>> stairs(hubo,1)
Traceback (most recent call last):
  File "<pyshell#266>", line 1, in <module>
    stairs(hubo,1)
  File "<pyshell#254>", line 5, in stairs
    turn_right(robot)
NameError: name 'turn_right' is not defined
>>> hubo.turn_left()
>>> hubo.move()
>>> stairs(hubo,1)
Traceback (most recent call last):
  File "<pyshell#269>", line 1, in <module>
    stairs(hubo,1)
  File "<pyshell#254>", line 5, in stairs
    turn_right(robot)
NameError: name 'turn_right' is not defined
>>> turn_right(robot):
	
SyntaxError: invalid syntax
>>> def turn_right(robot):
	for i in range(3)
	
SyntaxError: invalid syntax
>>> def turn_right(robot):
	for i in range(3):
		robot.turn_left()

		
>>> turn_right(hubo)
>>> hubo.move()
>>> hubo.turn_left()
>>> stairs(hubo,1)
>>> stairs(hubo,1)
>>> hugo.turn_left()
Traceback (most recent call last):
  File "<pyshell#282>", line 1, in <module>
    hugo.turn_left()
NameError: name 'hugo' is not defined
>>> hubo.turn_left()
>>> def staris1(robot,n):
	staris(robot,n)
	robot.turn_left()

	
>>> staris1(hubo,5)
Traceback (most recent call last):
  File "<pyshell#288>", line 1, in <module>
    staris1(hubo,5)
  File "<pyshell#287>", line 2, in staris1
    staris(robot,n)
NameError: name 'staris' is not defined
>>> def stairs1(robot,n)
SyntaxError: invalid syntax
>>> def stairs1(robot,n):
	stairs(robot,n)
	robot.turn_left()

	
>>> stairs1(hubo,5)
>>> stairs1(hubo,5)
>>> stairs1(hubo,5)
>>> hubo.move()
>>> hubo.move()
>>> stairs1(hubo,4)
>>> move()
Traceback (most recent call last):
  File "<pyshell#300>", line 1, in <module>
    move()
NameError: name 'move' is not defined
>>> hubo.move()
>>> hubo.move()
>>> stairs1(hubo,2)
>>> stiars1(hubo,3)
Traceback (most recent call last):
  File "<pyshell#304>", line 1, in <module>
    stiars1(hubo,3)
NameError: name 'stiars1' is not defined
>>> stairs1(hubo,3)
>>> stairs1(hubo,3)
>>> hubo.move()
>>> hubo.move()
>>> for i in range(4)
SyntaxError: invalid syntax
>>> for i in range(4):
	stairs1(hubo,1)

	
>>> 