<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
		<link type="text/css" rel="stylesheet" href="<c:out value="${ css }" default="inc/style.css" />">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	</head>
	<body>
		<div class="container">
			<div class = "row">
				<div class = "col-lg-4">
					<form  method="post" action="<c:out value="${ url }" default="/user/add" />">
							<legend>Create/Update a user</legend>
							
							<c:if test="${ !empty user }">
								<input type="hidden" id="id" name="id" value="<c:out value="${ user.id }" default="" />" size="20" maxlength="20" />					
							</c:if>
							
							<!--  <label for="name">Name <span class="requis">*</span></label>  -->
							<input placeholder="Name" class="form-control" type="text" id="name" name="name" value="<c:out value="${ user.name }" default="" />" size="20" maxlength="20" />
						
							<!--  <label for="email">email </label>  --> 
							<input placeholder="Email" class="form-control" type="text" id="email" name="email" value="<c:out value="${ user.email }" default="" />" size="20" maxlength="20" />
						
							<!-- <label for="gender">Gender<span class="requis">*</span></label>  -->
							<input placeholder="Gender" class="form-control" type="text" id="gender" name="gender" value="<c:out value="${ user.gender }" default="" />" size="20" maxlength="20" />
						
							<!-- <label for="address">Address<span class="requis">*</span></label>  -->
							<input placeholder="Address" class="form-control" type="text" id="address" name="address" value="<c:out value="${ user.address }" default="" />" size="20" maxlength="20" />
							<input class="btn btn-primary mt-3" type="submit" value="validate" />
							<input class="btn btn-primary mt-3" type="reset" value="Reset" />
					</form>
				</div>
			</div>
			
			<div class="row" style="margin-top: 20px;">
				<div class = "col-lg-12">
					<c:if test="${ empty user eq true }">
						<table class="table table-striped">
							<tr>
								<th></th>
								<th>name</th>
								<th>email</th>
								<th>gender</th>
								<th>address</th>
								<th>actions</th>
							</tr>
							<c:choose>
								<c:when test="${!empty users }">
									<c:forEach var="user" items="${users}" varStatus="status">
										<tr>
											<td><c:out value="${ status.count}" default="User"/></td>
											<td><c:out value="${ user.value.name}" default="User"/></td>
											<td><c:out value="${ user.value.email}" default="User"/></td>
											<td><c:out value="${ user.value.gender}" default="User"/></td>
											<td><c:out value="${ user.value.address}" default="User"/></td>
											<td class="text-center">
												<a href="
												<c:url value="/user/delete/${ user.key }" /> ">
												delete
												</a>    												
												<a href="<c:url value="/user/update/${ user.key }"/> ">
												update
												</a>
											</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="6" style="padding: 0px auto; text-align: center;">
											<c:out value="No record found"></c:out>
										</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</table>
					</c:if>
				</div>
			</div>
		</div>
	</body>
</html>