<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>ADMIN BOOK SHOP</title>
        <!--FONT-->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <!--ICON-->
        <link href="${pageContext.request.contextPath}/Resources/css/fontawesome.min_1.css"  rel="stylesheet">
        <!--BOOTSTRAP-->
        <link href="${pageContext.request.contextPath}/Resources/css/bootstrap.min_1.css"  rel="stylesheet">
        <!--CSS-->
        <link href="${pageContext.request.contextPath}/Resources/css/templatemo-style_1.css"  rel="stylesheet">
        <link href="${pageContext.request.contextPath}/Resources/css/custom.css"  rel="stylesheet">
        <!--JS-->
        <script src="<c:url value='/Resources/js/jquery-3.3.1.min.js' />" ></script>
        <script src="<c:url value='/Resources/js/bootstrap.min.js' />" ></script>
        <script src="<c:url value='/Resources/js/tooplate-scripts.js' />" ></script>
        <!--ING-->
        <c:url var="VuCongDai" value="/Resources/img/.jpg"/>
        <c:url var="LOGO" value="/Resources/img/LOGO.png"/>
        <link rel="apple-touch-icon" href="${LOGO}">
        <link rel="shortcut icon" type="image/x-icon" href="${LOGO}">
    </head>
    <body>
        <!--Header-->
        <nav class="navbar navbar-expand-xl">
            <div class="container h-100">
                <a class="navbar-brand" href="index.html">
                    <h1 class="tm-site-title mb-0">ADMIN BOOK SHOP</h1>
                </a>
                <button class="navbar-toggler ml-auto mr-0" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fas fa-bars tm-nav-icon"></i>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mx-auto h-100">
                        <li class="nav-item">
                            <a class="nav-link" href="/Client/ADMIN/home">
                                <i class="fas fa-tachometer-alt"></i>
                                Điều Khiển
                                <span class="sr-only">(Hiện Hành)</span>
                            </a>
                        </li>
                        <li class="nav-item dropdown">

                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                <i class="far fa-file-alt"></i>
                                <span>
                                    Báo Cáo <i class="fas fa-angle-down"></i>
                                </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Ngày Report</a>
                                <a class="dropdown-item" href="#">Tuần Report</a>
                                <a class="dropdown-item" href="#">Năm Report</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/Client/ADMIN/books">
                                <i class="fas fa-shopping-cart"></i>
                                Sản Phẩm
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link " href="/Client/ADMIN/accounts">
                                <i class="far fa-user"></i> 
                                Tài Khoản
                            </a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-cog"></i>
                                <span>
                                    Cài Đặt <i class="fas fa-angle-down"></i>
                                </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Hồ Sơ</a>
                                <a class="dropdown-item" href="#">Thanh Toán</a>
                                <a class="dropdown-item" href="#">Tùy Chỉnh</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!--Container-->
        <div class="container tm-mt-big tm-mb-big">
            <div class="row">
                <div class="col-12 mx-auto tm-login-col">
                    <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                        <div class="row">
                            <div class="col-12 text-center">
                                <h2 class="tm-block-title mb-4">Chào mừng bạn đến trang Quản Lý<br> --< ĐĂNG NHẬP >--</h2>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                <form action="/Client/ADMIN/perform_login" method="POST" class="tm-login-form">
                                    <div class="form-group">
                                        <label for="username">Tài khoản</label>
                                        <input name="username" type="text" class="form-control validate" id="username" value="" required/>
                                    </div>
                                    <div class="form-group mt-3">
                                        <label for="password">Mật khẩu</label>
                                        <input name="password" type="password" class="form-control validate" id="password" value="" required />
                                    </div>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                    <div class="form-group mt-4">
                                        <button type="submit" class="btn btn-primary btn-block text-uppercase" >
                                            Đăng Nhập
                                        </button>
                                    </div>
                                    <button class="mt-5 btn btn-primary btn-block text-uppercase">
                                        Quên Mật Khẩu?
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--footer-->
        <footer class="tm-footer row tm-mt-small">
            <div class="col-12 font-weight-light">
                <p class="text-center text-white mb-0 px-4 small">
                    Copyright &copy; 2024 | Thiết Kế Bởi <a rel="sponsored" href="https://www.facebook.com/" target="_blank" style="color: #fff">Vũ Công Đại  </a>
                </p>
            </div>
        </footer>
    </body>
</html>
