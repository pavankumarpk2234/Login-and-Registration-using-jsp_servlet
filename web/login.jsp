<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<input type="hidden" id = "status" value = "<%= request.getAttribute("status")%>">
    <div class="main">
        <!-- Sign in Form -->
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <a href="registration.jsp" class="signup-image-link">Create an account</a>
                    </div>
                    <div class="signin-form">
                        <h2 class="form-title">Sign in</h2>
                        <form method="post" action="login" class="register-form" id="login-form">
                            <div class="form-group">
                                <label for="username"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="username" id="username" placeholder="Email" required="required" />
                            </div>
                            <div class="form-group">
                                <label for="password"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="password" id="password" placeholder="Password" required="required" />
                            </div>
                            <div class="form-group">
                                <a href="forgotPassword.jsp">Forgot Password</a>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signin" id="signin" class="form-submit" value="Log in" />
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <script src="script.js"></script>
    
    <script src = "https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <link rel ="stylesheet" hreef = "alert/dist/sweetalert.css">
    
    <script type = "text/javascript">
            var status = document.getElementById("status").value;
            if(status === "failed")
            {
                swal("Sorry","Wrong Username or Password","error");
            }
            else if(status === "invalidEmail")
            {
                swal("Sorry","Please Enter Username","error");
            }
            else if(status === "invalidUpwd")
            {
                swal("Sorry","Please Enter Password","error");
            }
        </script>
</body>
</html>
