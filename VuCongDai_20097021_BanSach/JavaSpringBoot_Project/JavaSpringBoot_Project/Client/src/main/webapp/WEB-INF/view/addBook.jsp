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
        <c:url var="addPhoto" value="/Resources/img/add-photo.png"/>
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
        <div class="container mt-5">
            <c:if test="${listImage != null}">
                <div class="row tm-content-row">
                    <div class="col-12 tm-block-col">
                        <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                            <h2 class="tm-block-title">DANH SÁCH ẢNH SÁCH </h2>
                            <div style="display: flex; justify-content: center; align-items: center; overflow-x: scroll;">
                                <c:forEach var="image" items="${listImage}">
                                    <div class="tm-avatar-container" style="min-width: 200px; margin-left: 10px; margin-right: 10px;">
                                        <img src="/Client${image.getPhotosImagePath()}" alt="Avatar" class="tm-avatar img-fluid mb-4" style="color: #fff"/>
                                        <a href="/Client/image/delete/${image.idPhoto}/${itemBooks.maSach}" class="tm-avatar-delete-link">
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
                    <c:if test="${itemBooks.maSach != 0}">
                        <div class="tm-bg-primary-dark tm-block tm-block-avatar">
                            <h2 class="tm-block-title">THÊM ẢNH SẢN PHẨM ${itemBooks.maSach}</h2>
                            <label class="tm-avatar-container" for="fileImage">
                                <img src="${addPhoto}" id="ImageBox" alt="Avatar" class="tm-avatar img-fluid mb-4" style="color: #fff"/>
                            </label>
                            <form:form action="/Client/image/save?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" method="POST">
                                <div class="custom-file">
                                    <input class="custom-file-input" accept="image/png, image/jpeg" type="file" name="fileImage" id="fileImage"/>
                                    <label class="custom-file-label" for="fileImage">Chọn File </label>
                                </div>
                                <input type="hidden" name="idSach" value="${itemBooks.maSach}" />
                                <input id="btnThemSach" disabled="true" type="submit" value="Tải Ảnh Lên" class="btn btn-primary btn-block text-uppercase"/>
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
                    </c:if>
                </div>
                <div class="tm-block-col tm-col-account-settings">
                    <div class="tm-bg-primary-dark tm-block tm-block-settings">
                        <h2 class="tm-block-title">THÔNG TIN SẢN PHẨM</h2>
                        <form:form modelAttribute="itemBooks" action="/Client/ADMIN/books/update/" class="tm-signup-form row" method="POST">
                            <div class="form-group col-lg-6">
                                <label for="name">Tên sách</label>
                                <form:input path ="maSach" type="hidden" value="${itemBooks.maSach}"/>
                                <form:input id="name" path="name" type="text" class="form-control validate" />
                            </div>
                            <div class="form-group col-lg-6">
                                <label for="auth">Tác giả</label>
                                <form:input id="auth" path="auth" type="text" class="form-control validate" />
                            </div>
                            <div class="form-group col-lg-6">
                                <label for="money">Giá</label>
                                <form:input id="money" path="money" type="number" min="0" step="1000" class="form-control validate" />
                            </div>
                            <div class="form-group col-lg-6">
                                <label for="rate">Đánh giá</label>
                                <form:input id="rate" path="rate" type="number" min="0" step="1" max="5" class="form-control validate" />
                            </div>
                            <div class="form-group col-lg-12">
                                <label for="decriber">Mô tả</label>
                                <form:textarea id="decriber" path="decriber" type="text" class="form-control validate" style="height: 100px;"/>
                            </div>
                            <div class="form-group col-lg-6">
                                <label for="datePub">Ngày xuất bản</label>
                                <form:input id="datePub" path="datePub" type="date" class="form-control validate" />
                            </div>
                            <div class="form-group col-lg-6">
                                <label for="infor1">Gợi ý thông tin thêm</label>
                                <select id="infor1" class="form-control validate custom-select" onchange="addThonTinThem();removeOptions()">
                                    <option disabled selected>Nhấn để chọn thêm thông tin khác</option>
                                    <option value="Con Trai">Con Trai</option>
                                    <option value="Con Gai">Con Gái</option>
                                    <option value="3+">3+</option>
                                    <option value="16+">16+</option>
                                    <option value="18+">18+</option>
                                    <option value="Thieu Nhi">Thiếu Nhi</option>
                                    <option value="Giao Khoa - Tham Khao">Giáo Khoa - Tham Khảo</option>
                                    <option value="Van Hoc">Văn Học</option>
                                    <option value="Tam Ly - Ky Nang Song">Tâm Lý - Kỹ Năng Sống</option>
                                    <option value="Manga - Comic">Manga - Comic</option>
                                    <option value="Sach Hoc Ngoai Ngu">Sách Học Ngoại Ngữ</option>
                                    <option value="Kinh Te">Kinh Tế</option>
                                    <option value="Khoa Hoc Ky Thuat">Khoa Học Kỹ Thuật</option>
                                    <option value="Lich Su - Dia Ly - Ton Giao">Lịch Sử - Địa Lý - Tôn Giáo</option>
                                    <option value="Nuoi Day Con">Nuôi Dạy Con</option>
                                    <option value="Chinh Tri - Phap Ly - Triet Hoc">Chính Trị - Pháp Lý - Triết Học</option>
                                    <option value="Nu Cong Gia Chanh">Nữ Công Gia Chánh</option>
                                    <option value="Tieu Su Hoi Ky">Tiểu Sử Hồi Ký</option>
                                    <option value="Phong Thuy - Kinh Dich">Phong Thủy - Kinh Dịch</option>
                                    <option value="Van Hoa - Nghe Thuat - Du Lich">Văn Hóa - Nghệ Thuật - Du Lịch</option>
                                    <option value="Tu Dien">Từ Điển</option>
                                    <option value="Am Nhac - Mỹ Thuat - Thoi Trang">Âm Nhạc - Mỹ Thuật - Thời Trang</option>
                                    <option value="The Duc - The Thao - Giai Tri">Thể Dục Thể Thao - Giải Trí</option>
                                    <option value="Bao - Tap Chi">Báo - Tạp Chí</option>
                                    <option value="Giao Trinh">Giáo Trình</option>
                                </select>
                            </div>
                            <div class="form-group col-lg-12">
                                <label for="infor">Thông tin khác</label>
                                <form:textarea id="infor" path="infor" type="text" class="form-control validate" style="height: 100px;" />
                            </div>                                
                            <div class="col-12">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                <input type="submit" class="btn btn-primary btn-block text-uppercase" value="${chucNang}"/>
                            </div>
                        </form:form>
                        <script>

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
