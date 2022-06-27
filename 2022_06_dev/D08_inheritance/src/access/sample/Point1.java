package access.sample;

public class Point1 {
private int posX;
private int posY;

public void out() {
	System.out.println("["+posX+","+posY+"]");
}

public int getPosX(){
	return posX;
}
public int getPosY(){
	return posY;
}
public void setPosX(int posX) {
	this.posX=posX;
}
public void setPosY(int posY) {
	this.posY=posY;
}

public Point1() {
this (10, 20);
}
public Point1(int posX, int posY) {
	this.posX=posX;
	this.posY=posY;
}

}
