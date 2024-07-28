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
        <c:url var="addPhoto" value="/Resources/img/add-photo.png"/>
        <c:url var="LOGO" value="/Resources/img/LOGO.png"/>
        <link rel="apple-touch-icon" href="${LOGO}">
        <link rel="shortcut icon" type="image/x-icon" href="${LOGO}">
    </head>
    <body id="reportsPage">
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
                            <a class="nav-link active" href="/Client/ADMIN/accounts">
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
                <div class="col-12 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                        <h2 class="tm-block-title">Danh sách tài khoản</h2>
                        <p class="text-white">Tài khoản</p>
                        <form action="/Client/ADMIN/accounts/taikhoan" method="GET" >
                            <select class="custom-select" name="maTaiKhoan" onchange="this.form.submit()">
                                <c:if test="${taiKhoaned.idTaiKhoan == null}">
                                    <option disabled selected value> -- Chọn Tài Khoản -- </option>
                                </c:if>                                
                                <c:forEach var="taiKhoan" items="${listTaiKhoan}">                                                                      
                                    <option value="${taiKhoan.idTaiKhoan}" <c:if test="${taiKhoan.idTaiKhoan == taiKhoaned.idTaiKhoan}">selected="selected"</c:if>  >
                                        Username:${taiKhoan.taiKhoan}  (${taiKhoan.role} - Status:${taiKhoan.status ? "Enable":"Disable"})
                                    </option>
                                </c:forEach>
                            </select>
                        </form>
                    </div>
                </div>
            </div>
            <c:if test="${listPhoto != null}">
                <div class="row tm-content-row">
                    <div class="col-12 tm-block-col">
                        <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                            <h2 class="tm-block-title">Danh sách Photo</h2>
                            <div style="display: flex; justify-content: center; align-items: center; overflow-x: scroll;">
                                <c:forEach var="photo" items="${listPhoto}">
                                    <div class="tm-avatar-container" style="min-width: 200px; margin-left: 10px; margin-right: 10px;">
                                        <img src="/Client${photo.getPhotosImagePath()}" alt="Avatar" class="tm-avatar img-fluid mb-4" style="color: #fff"/>
                                        <a href="/Client/photo/delete/${photo.idPhoto}" class="tm-avatar-delete-link">
                                            <i class="far fa-trash-alt tm-product-delete-icon"></i>
                                        </a>
                                    </div> 
                                </c:forEach>                            
                            </div>                        
                        </div>
                    </div>
                </div>
            </c:if>
            <!-- row -->
            <div class="row tm-content-row">
                <div class="tm-block-col tm-col-avatar">
                    <div class="tm-bg-primary-dark tm-block tm-block-avatar">
                        <h2 class="tm-block-title">THÊM ẢNH ĐẠI DIỆN</h2>
                        <label class="tm-avatar-container" for="fileImage">
                            <img src="${addPhoto}" id="ImageBox" alt="Avatar" class="tm-avatar img-fluid mb-4" style="color: #fff"/>
                        </label>
                        <form:form action="/Client/photo/save?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" method="POST">
                            <div class="custom-file">
                                <input class="custom-file-input" accept="image/png, image/jpeg" type="file" name="fileImage" id="fileImage"/>
                                <label class="custom-file-label" for="fileImage">Chọn File </label>
                            </div>
                            <input type="hidden" name="idTaiKhoan" value="${taiKhoaned.idTaiKhoan}" />
                            <input type="submit" id="btnThemSach" disabled="true" value="Tải Ảnh Lên" class="btn btn-primary btn-block text-uppercase"/>
                        </form:form>
                        <script>
                            function enableBtn() {
                                document.getElementById("btnThemSach").disabled = false;
                            }
                            $(document).ready(function () {
                                $('#fileImage').change(function () {
                                    showImageBox(this);
                                    enableBtn();
                                })
                            })
                            function showImageBox(fileInput) {
                                file = fileInput.files[0];
                                reader = new FileReader();
                                reader.onload = function (e) {
                                    $('#ImageBox').attr('src', e.target.result);
                                };
                                reader.readAsDataURL(file);
                            }
                        </script>
                    </div>
                </div>
                <div class="tm-block-col tm-col-account-settings">
                    <div class="tm-bg-primary-dark tm-block tm-block-settings">
                        <h2 class="tm-block-title">Cài đặt tài khoản</h2>
                        <form action="/Client/ADMIN/accounts/update" class="tm-signup-form row" method="POST">
                            <div class="form-group col-lg-6">
                                <label for="name">Cài đặt tài khoản</label>
                                <input type="hidden" name="idTaiKhoan" value="${taiKhoaned.idTaiKhoan}" />
                                <input type="hidden" name="idKhachHang" value="${taiKhoaned.khachHang.maKhachHang}" />
                                <input value="${taiKhoaned.taiKhoan}" id="name" name="name" type="text" class="form-control validate" />
                            </div>
                            <div class="form-group col-lg-6">
                                <label for="role">ROLE tài khoản</label>
                                <select id="role" class="custom-select form-control validate" name="role">
                                    <c:if test="${taiKhoaned.role == null}">
                                        <option disabled selected value> -- Chọn ROLE -- </option>
                                    </c:if>  
                                    <option value="ROLE_ADMIN" <c:if test="${taiKhoaned.role == 'ROLE_ADMIN'}">selected="selected"</c:if> >ROLE_ADMIN</option>
                                    <option value="ROLE_CUSTOMER" <c:if test="${taiKhoaned.role == 'ROLE_CUSTOMER'}">selected="selected"</c:if>>ROLE_CUSTOMER</option>
                                    <option value="ROLE_SELLER"<c:if test="${taiKhoaned.role == 'ROLE_SELLER'}">selected="selected"</c:if> >ROLE_SELLER</option>
                                    </select>
                                </div>
                                <div class="form-group col-lg-6">
                                    <label for="password">Mật khẩu</label>
                                    <input id="password" onkeyup="checkKey()" name="password" type="password" class="form-control validate" />
                                </div>
                                <div class="form-group col-lg-6">
                                    <label for="password2">Nhập lại mật khẩu</label>                                
                                    <input id="password2" onkeyup="checkKey()" name="password2" type="password" class="form-control validate" />
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            </div>
                            <div class="form-group col-lg-6">
                                <label for="status">Trạng thái</label>
                                <select id="status" class="custom-select form-control validate" name="status">
                                    <option value="true">TRUE</option>
                                    <option value="false">FALSE</option>
                                </select>
                            </div>
                            <div class="form-group col-lg-6">
                                <label class="tm-hide-sm">&nbsp;</label>
                                <input type="submit" id="btnSub" disabled="true" name="update" class="btn btn-primary btn-block text-uppercase" value="Cập nhật hồ sơ của bạn"/>
                            </div>
                            <div class="col-12">
                                <input type="submit" name="delete" class="btn btn-primary btn-block text-uppercase" value="Xóa tài khoản của bạn"/>
                            </div>
                        </form>
                        <script type="text/javascript">
                            function checkKey() {
                                if (document.getElementById("password").value === "" || document.getElementById("password2").value === "") {
                                    document.getElementById('btnSub').disabled = true;
                                } else {
                                    document.getElementById('btnSub').disabled = false;
                                }
                            }
                        </script>
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
