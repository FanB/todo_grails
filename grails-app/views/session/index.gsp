<!doctype html>
<html>
	<head>
    	<meta name="layout" content="main"/>
    	<title>Welcome to Grails</title>
    	<asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
	</head>
	<body>
		<div id="container">
			<g:if test="${flash.error}">
  				<div class="alert alert-danger">${flash.error}</div>
			</g:if>
			<g:if test="${flash.message}">
  				<div class="alert alert-success">${flash.message}</div>
			</g:if>
			<g:form controller="session" action="create" method="POST" class="form-signin">
				<h2 class="form-signin-heading">Please sign in</h2>
				<label for="login" class='sr-only'>Login</label>
				<g:textField name="login" value="${login}" class="form-control"/>
				<label for="password" class='sr-only'>Password</label>
				<g:passwordField name="password" value="${password}" class="form-control"/>
				<g:submitButton name="submit" value="Sign in" class='btn btn-lg btn-primary btn-block' />
			</g:form>
 		</div>
	</body>
<body> 