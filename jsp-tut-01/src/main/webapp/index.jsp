<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bootstrap</title>
	<!-- bootstrap -->
	<link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" />
	<script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<!--  jQuery-->
	<script type="text/javascript" src="webjars/jquery/3.6.0/jquery.min.js"></script>
	<!-- font awesome -->
	<link rel="stylesheet" href="webjars/font-awesome/6.1.0/css/fontawesome.min.css" />
</head>
<body>
	<div class="container">
		<h3 class="mt-2">Register Form</h3>
		<hr />
		<div class="row">
			<form action="register" class="form row" method="post">
					<div class="col-6">
						<div class="mb-3">
							<label for="name" class="form-label">User Name</label>
							<input name="username" id="name" type="text" class="form-control" placeholder="username" />
						</div>
						<div class="mb-3"> 
							<label for="" class="form-label">Email</label>
							<input name="email" type="email" class="form-control" placeholder="example@gmail.com" required="required"/>
						</div>
						<div class="mb-3"> 
							<label for="" class="form-label">Age</label>
							<input name="age" type="number" class="form-control" placeholder="age" required="required"/>
						</div>
						<div class="mb-3"> 
							<label for="" class="form-label">Birthday</label>
							<input name="dob" type="date" class="form-control" placeholder="choose birthday" />
						</div>
						<div class="mb-3"> 
							<label for="" class="form-label">Region</label>
							<select name="region" id="" class="form-select">
								<option value="mandalay">Mandalay</option>
								<option value="yangon">Yangon</option>
								<option value="sagaing">Sagaing</option>
							</select>
						</div>
						<div class="row mb-3">
							<div class="col-2"> <span>Gender</span> </div>
							<div class="col-2">
								<div class="form-check">
									<input name="gender" value="male" type="radio" class="form-check-input" checked="checked" id="male"/>
									<label for="male" class="form-check-label" >Male</label>
								</div>
							</div>
							<div class="col">
								<div class="form-check">
									<input name="gender" value="female" type="radio" class="form-check-input" id="female"/>
									<label for="female" class="form-check-label">Female</label>
								</div>
							</div>
						</div>
					</div>
					<div class="col-6">
						<div class="mb-3">
							<label for="" class="form-label">Address</label>
							<textarea name="address" id="" placeholder="Enter address detail" class="form-control"></textarea>
						</div>
						<div class="mb-3 form-check">
							<input name="old_student" type="checkbox" class="form-check-input" id="chk" />
							<label for="chk" class="form-check-label">Old Student</label>
						</div>
						<div class="row">
							<div class="col">
								<button class="btn btn-danger w-100" type="reset">Reset</button>
							</div>
							<div class="col">
								<button class="btn btn-success w-100" type="submit"> <i class="fa-solid fa-plus"></i> Register</button>
							</div>
						</div>
					</div>
			</form>
		</div>
	</div>
</body>
</html>