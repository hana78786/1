<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<button onclick="test();">test1</button>

<script type="text/javascript">
function test(){
	$.ajax({
		url:"/test.do",
		type:"get",
		success:function(data){
			for(var i =0; i<data.length;i++){
			console.log(data[i].mebmerId);
			}
		}
	})
	
	
	
	
}

</script>
</body>
</html>
