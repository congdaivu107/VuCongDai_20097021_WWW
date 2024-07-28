<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Tạo Tài Khoản</title>
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
    <body class="templatemo-bg-image-2" style="background-image: url(${background})">
        <div class="container">
            <div class="col-md-12">			
                <form:form modelAttribute="dangKy" class="form-horizontal templatemo-contact-form-1" action="${pageContext.request.contextPath}/register/addRegister" method="post">
                    <div class="form-group">
                        <div class="col-md-12">
                            <h1 class="margin-bottom-15">Đăng Ký Khách Hàng</h1>
                            <!-- Check for registration error -->
                            <c:if test="${registrationError != null}">
                                <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                    ${registrationError}
                                </div>
                            </c:if>
                        </div>
                    </div>				
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-7">		          	
                                <label for="name" class="control-label">Họ: *</label>
                                <div class="templatemo-input-icon-container">
                                    <i class="fa fa-user"></i>
                                    <form:input class="form-control" path="lastName" />
                                </div>		            		            		            
                            </div>
                            <div class="col-md-5">		          	
                                <label for="name" class="control-label">Tên: *</label>
                                <div class="templatemo-input-icon-container">
                                    <i class="fa fa-user"></i>
                                    <form:input class="form-control" path="firstName" />
                                </div>		            		            		            
                            </div>
                        </div>

                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="subject" class="control-label">Tai Khoan: *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-info-circle"></i>
                                <form:input path="userName" class="form-control"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="subject" class="control-label">Mat Khau: *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-info-circle"></i>
                                <form:password path="password" class="form-control"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="subject" class="control-label">Ngày sinh: *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-info-circle"></i>
                                <form:input type="date" class="form-control" path="birthDate"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="email" class="control-label">Email *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-envelope-o"></i>
                                <form:input type="email" class="form-control" path="email"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="name" class="control-label">Địa Chỉ *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-info-circle"></i>
                                <form:input type="text" class="form-control" path="address"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="name" class="control-label">Điện thoại: *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-phone"></i>
                                <form:input type="number" class="form-control" path="phone"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="message" class="control-label">Thông tin khác: </label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <textarea rows="8" cols="50" class="form-control" id="message" placeholder="" style="resize: vertical"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="submit" value="Tạo Tài Khoản" class="btn btn-success pull-right">
                        </div>
                    </div>		    	
                    </form:form>		      
                </div>
            </div>
        </body>
    </html>
