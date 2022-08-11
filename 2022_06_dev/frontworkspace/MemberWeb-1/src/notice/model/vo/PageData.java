package notice.model.vo;

import java.util.ArrayList;

public class PageData {
	
 private	ArrayList<Notice> nList;
 private String Pagenavi;
public ArrayList<Notice> getnList() {
	return nList;
}
public void setnList(ArrayList<Notice> nList) {
	this.nList = nList;
}
public String getPagenavi() {
	return Pagenavi;
}
public void setPagenavi(String pagenavi) {
	Pagenavi = pagenavi;
}
 
}
