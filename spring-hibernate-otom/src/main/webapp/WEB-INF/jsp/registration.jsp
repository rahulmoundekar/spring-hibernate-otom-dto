<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<div class="container">
	<form:form class="form-horizontal" method="POST" action="register"
		modelAttribute="customerForm">
		<fieldset>
			<!-- Form Name -->
			<legend>Form Name</legend>

			<form:hidden path="id" />

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="name">Enter Name</label>
				<div class="col-md-4">
					<form:input id="name" path="name" type="text"
						placeholder="Enter Name" class="form-control input-md" />

				</div>
			</div>

			<c:forEach items="${customerForm.addressesDto}" var="address"
				varStatus="row">
				<!-- Text input-->
				<form:hidden path="addressesDto[${row.index}].id" />
				<div class="form-group">
					<label class="col-md-4 control-label" for="addresses">Address
						${row.count}</label>
					<div class="col-md-4">
						<form:input id="street" path="addressesDto[${row.index}].street"
							type="text" placeholder="Enter Street"
							class="form-control input-md" />

					</div>
					<div class="col-md-4">
						<form:input id="landmark"
							path="addressesDto[${row.index}].landmark" type="text"
							placeholder="Enter Landmark" class="form-control input-md" />

					</div>
					<div class="col-md-4">
						<form:input id="city" path="addressesDto[${row.index}].city"
							type="text" placeholder="Enter City"
							class="form-control input-md" />

					</div>
				</div>
			</c:forEach>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for=""></label>
				<div class="col-md-4">
					<input type="submit" class="btn btn-primary" value="Save">
				</div>
			</div>

		</fieldset>
	</form:form>


	<h2>Employee List</h2>

	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>Address</th>
				<th>Modify</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="customer">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.name}</td>

					<td> <c:forEach items="${customer.addressesDto}" var="address">
							${address.street},${address.landmark}, ${address.city}<br>
						</c:forEach>
					</td>

					<td><a href="index?id=${employee.id}">Modify</a></td>
					<td><a href="deleteEmployee?id=${employee.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>