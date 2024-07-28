<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Đăng Nhập</title>
        <!--FONT-->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <!--ICON-->
        <link href="${pageContext.request.contextPath}/Resources/css/font-awesome.min_1.css"  rel="stylesheet">
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <!--LINL CSS-->
        <link href="${pageContext.request.contextPath}/Resources/css/bootstrap.min.css"  rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/Resources/css/bootstrap-theme.min.css"  rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/Resources/css/bootstrap-social.css"  rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/Resources/css/templatemo_style.css"  rel="stylesheet" type="text/css">
        <!--IMG-->
        <c:url var="LOGO" value="/Resources/img/LOGO.png"/>
        <link rel="apple-touch-icon" href="${LOGO}">
        <link rel="shortcut icon" type="image/x-icon" href="${LOGO}">
        <c:url var="background" value="/Resources/img/backgroundLogin.png"/>
    </head>
    <body class="templatemo-bg-image-1" style="background-image: url(${background});">
        <div class="container">
            <div class="col-md-12">
                <form class="form-horizontal templatemo-login-form-2" action="/Client/perform_login" method="POST">
                    <div class="row">
                        <div class="col-md-12">
                            <h1>Form Đăng Nhập</h1>
                            <c:if test="${error != null}">
                                <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                    Tài khoản hoặc mật khẩu không hợp lệ. ${param.error}
                                </div>
                            </c:if>
                            <!-- Check for logout -->
                            <c:if test="${param.logout != null}">
                                <div class="alert alert-success col-xs-offset-1 col-xs-10">
                                    Bạn đã được đăng xuất. ${param.logout}
                                </div>
                            </c:if>
                        </div>
                    </div>
                    <div class="row">
                        <div class="templatemo-one-signin col-md-6">
                            <div class="form-group">
                                <div class="col-md-12">		          	
                                    <label for="username" class="control-label">Tài khoản:</label>
                                    <div class="templatemo-input-icon-container">
                                        <i class="fa fa-user"></i>
                                        <input type="text" name="username" placeholder="username" class="form-control">
                                    </div>		            		            		            
                                </div>              
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <label for="password" class="control-label">Mật khẩu:</label>
                                    <div class="templatemo-input-icon-container">
                                        <i class="fa fa-lock"></i>
                                        <input type="password" name="password" placeholder="password" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox"> Khi nhớ đăng nhập
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <input type="submit" value="Đăng Nhập" class="btn btn-warning">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                        <a href="forgot-password.html" class="text-center">Quên mật khẩu?</a>
                                </div>
                                <div class="col-md-12">
                                    <a href="${pageContext.request.contextPath}/register/show" class="text-center">Tạo tài khoản?</a>
                                </div>
                            </div>
                        </div>
                        <div class="templatemo-other-signin col-md-6">
                            <label class="margin-bottom-15">
                                Đăng nhập từ nguồn khác, mạng xã hội.... Hãy đăng nhập bằng các nút này.
                                Đăng Nhập Bằng: 
                            </label>
                            <a class="btn btn-block btn-social btn-facebook margin-bottom-15">
                                <i class="fa fa-facebook"></i> Facebook
                            </a>
                            <a class="btn btn-block btn-social btn-twitter margin-bottom-15">
                                <i class="fa fa-twitter"></i> Twitter
                            </a>
                            <a class="btn btn-block btn-social btn-google-plus">
                                <i class="fa fa-google-plus"></i> Google
                            </a>
                        </div>   
                    </div>				 	
                </form>		      		      
            </div>
        </div>
    </body>
</html>
