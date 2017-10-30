<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"	href="dependency/css/style.css">
<link rel="stylesheet"	href="dependency/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="dependency/jquery-3.2.1.min.js"></script>
<script src="dependency/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="dependency/script/script.js"></script>
<script src="dependency/script/jPages.min.js"></script>
<style type="text/css">
.holder {
    margin:15px 0;
}
.holder a {
    font-size:12px;
    cursor:pointer;
    margin:0 5px;
    color:#333;
}
.holder a:hover {
    background-color:#222;
    color:#fff;
}
.holder a.jp-previous {
    margin-right:15px;
}
.holder a.jp-next {
    margin-left:15px;
}
.holder a.jp-current,a.jp-current:hover {
    color:#FF4242;
    font-weight:bold;
}
.holder a.jp-disabled,a.jp-disabled:hover {
    color:#bbb;
}
.holder a.jp-current,a.jp-current:hover,.holder a.jp-disabled,a.jp-disabled:hover {
    cursor:default;
    background:none;
}
.holder span {
    margin: 0 5px;
}
</style>
</head>
<body>

	<div class="container-fluid">
		<header> <nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				
				<a class="navbar-brand" href="#">Movies</a>
			</div>

			
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid --> </nav>

		<form action="MyServlet" method="post">
			<div class="row">
			<div class="col-md-3">
				
				 <label for="sel1" class="btn btn-default">Language:</label>
				  <select class="form-control " id="sel1">
				    <option value="novalue">select</option>
				    <option value="Hindi">Hindi</option>
				    <option value="Marathi">Marathi</option>
				    <option value="English">English</option>
				    
				  </select>
			</div>

			<div class="dropdown col-md-3">
				
				<label for="sel2" class="btn btn-default">Genre:</label>
				  <select class="form-control " id="sel2">
				    <option value="novalue">select</option>
					<option value="Horror">Horror</option>
				    <option value="Action">Action</option>
				    <option value="Fantacy">Fantacy</option>
				    <option value="Science Fiction">Science Fiction</option>
				    <option value="Mystery">Mystery</option>
				    <option value="Romance">Romance</option>
				    <option value="Drama">Drama</option>
				    <option value="Family">Family</option>
				    <option value="Thriller">Thriller</option>
				  </select>
			</div>
			</div>
		</form>
		<div  class="container" style="margin-top:20px;">
			<div id="movie-wrapper" class="row">
			</div>
		</div>
		</header>

		<footer> <nav aria-label="Page navigation" class="pull-right footer">
		<div class="holder"></div>
</footer>
	</div>




</body>
</html>