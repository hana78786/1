<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<span id = "result"> test message</span>
<button onclick="test();">�׽�Ʈ</button>
<button onclick="test1();">�׽�Ʈ</button>

<script type="text/javascript">
	var result = document.querySelector('#result').innerHTML;
function test(){
	var xhttp = new XMLHttpRequest();
	xhttp.open("GET","/ajax/test.do?msg="+result,true);
	xhttp.onreadystatechange= function(){
		if(this.readyState==4&&this.status==200){
			alert("���ۼ���")
		}else if(this.readyState == 4 && this.status == 404){
			alert("���۽���")
		}
	}
	xhttp.send();
}

function test1() {
	$.ajax({
		url:"/ajax/test.do",
		type:"get",
		data:{"msg":result},
		success:function(result){
			alert(result);
			
		},
		error:function(){
			alert("���۽���");
			
		}
	})
	
}

</script>
</body>
</html>