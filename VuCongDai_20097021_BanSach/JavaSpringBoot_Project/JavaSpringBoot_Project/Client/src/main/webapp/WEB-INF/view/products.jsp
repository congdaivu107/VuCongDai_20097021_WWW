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
        <script src="<c:url value='/Resources/js/custom.js' />" ></script>
        <!--ING-->
        <c:url var="VuCongDai" value="/Resources/img/.jpg"/>
        <c:url var="LOGO" value="/Resources/img/LOGO.png"/>
        <link rel="apple-touch-icon" href="${LOGO}">
        <link rel="shortcut icon" type="image/x-icon" href="${LOGO}">
    </head>
    <body>
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
                            <a class="nav-link active" href="/Client/ADMIN/books">
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
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <form:form action="/Client/ADMIN/logoutAdmin" method="POST">
                                <button type="submit" class="nav-link d-block" style="background-color: #4a4a4a">
                                    ${userLogin}, <b>Đăng Xuất</b>
                                </button>
                            </form:form>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!--Container-->
        <div class="container mt-5">
            <div class="row tm-content-row">
                <div class="col-sm-12 col-md-12 col-lg-8 col-xl-8 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block tm-block-products">
                        <div class="tm-product-table-container">
                            <table class="table table-hover tm-table-small tm-product-table">
                                <thead>
                                    <tr>
                                        <th scope="col">&nbsp;</th>
                                        <th scope="col">TÊN SÁCH</th>
                                        <th scope="col">GIÁ BÁN</th>
                                        <th scope="col">ĐÁNH GIÁ</th>
                                        <th scope="col">TÁC GIẢ</th>
                                        <th scope="col">&nbsp;</th>
                                    </tr>
                                </thead>
                                <tbody>                                
                                    <c:forEach var="sach" items="${listSach}">
                                        <tr>
                                            <th scope="row">
                                                <input type="checkbox" class="checkBoxSach" value="${sach.maSach}" onclick="getCheckBox()"/>
                                            </th>
                                            <td class="tm-product-name">${sach.tenSach}</td>
                                            <td>${sach.giaSach}VND</td>
                                            <td>${sach.danhGia}</td>
                                            <td>${sach.tacGia}</td>
                                            <td>
                                                <a href="/Client/ADMIN/books/view/${sach.maSach}" class="tm-product-delete-link">
                                                    <i class="far fa-eye tm-product-delete-icon"></i>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                            <script>
                                function getCheckBox() {
                                    var checkedValue = [];
                                    $('.checkBoxSach:checked').each(function () {
                                        checkedValue.push($(this).val());
                                    });
                                    $('#listCheck').val(checkedValue);
                                }
                            </script>
                        </div>
                        <!-- table container -->
                        <form action="/Client/ADMIN/books/deletelist" method="POST">
                            <input id="listCheck" name="listCheck" type="hidden"/>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <a href="/Client/ADMIN/books/add" class="btn btn-primary btn-block text-uppercase mb-3">Thêm Sách Mới</a>
                            <input type="submit" class="btn btn-primary btn-block text-uppercase" value="Xóa các sách đã chọn"/>  
                        </form>

                    </div>
                </div>
                <div class="col-sm-12 col-md-12 col-lg-4 col-xl-4 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block tm-block-product-categories">
                        <h2 class="tm-block-title">Mục Lục Tác Giả</h2>
                        <div class="tm-product-table-container">
                            <table class="table tm-table-small tm-product-table">
                                <tbody>
                                    <c:forEach var="tacGia" items="${listTacGia}">
                                        <tr>
                                            <td class="tm-product-name">${tacGia}</td>
                                            <td class="text-center">
                                                <a href="/Client/ADMIN/books/${tacGia}" class="tm-product-delete-link">
                                                    <i class="fas fa-search tm-product-delete-icon"></i>
                                                </a>
                                            </td>
                                        </tr>   
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- table container -->
                        <a class="btn btn-primary btn-block text-uppercase mb-3" href="/Client/ADMIN/books">
                            Bỏ Tìm Kiếm theo Tác Giả
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <!--footer-->
        <footer class="tm-footer row tm-mt-small">
            <div class="col-12 font-weight-light">
                <p class="text-center text-white mb-0 px-4 small">
                    Copyright &copy; 2024 | Thiết Kế Bởi <a rel="sponsored" href="https://www.facebook.com" target="_blank" style="color: #fff">Vũ Công Đại  </a>
                </p>
            </div>
        </footer>
    </body>
</html>
