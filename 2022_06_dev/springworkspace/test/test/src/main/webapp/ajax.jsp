<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>

	<span id="result">test</span>
	<button onclick="test1();">�׽�Ʈ ��ư</button>
	<button onclick="test2();">�׽�Ʈ ��ư</button>
	
	<input type="text" id="resultId">
	<button onclick="test3();">�׽�Ʈ ��ư</button>
	<span id="pass"></span>
	
	
	<script type="text/javascript">
			var test= document.querySelector('#result').innerHTML;
	
		function test1() {
			var xhttp=new XMLHttpRequest();
			xhttp.open("get","/ajax/ajax.do?test="+test,true);
			xhttp.onreadystatechange=function(){
				if(this.readyState==4&&this.status==200){
					alert("����")
				}else if(this.readyState==4&&this.status==400){
					alert("����")
				}
			}
		xhttp.send();
		}
		
		
		
		function test2(){
			$.ajax({
				url:"/ajax/ajax.do",
				type:"get",
				data:{"test":test},
				success:function(){
					alert("����");
				},
				error:function(){
					alert("����")
					
				}
			})
		}
		
			
		function test3(){
			var id = $('#resultId').val();
			$.ajax({
				url:"/ajax/ajax3.do",
				type:"get",
				data:{"id":id},
				success:function(data){
					var str = "";
					for(var i=0;i<data.length;i++){
						str += data[i].memberId+", "+data[i].memberPwd+"<br>";
						
					}
					$('#pass').html(str);
					
					
				},
				error:function(){
					$('#pass').html("��������");
					
				}
			})
		}
		
	</script>

</body>
</html>