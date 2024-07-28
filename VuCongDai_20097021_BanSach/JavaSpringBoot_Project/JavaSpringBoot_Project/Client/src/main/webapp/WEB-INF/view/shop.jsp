<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>BOOK SHOP</title>
        <!--LINL CSS-->
        <link href="${pageContext.request.contextPath}/Resources/css/bootstrap.min.css"  rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/Resources/css/templatemo.css"  rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/Resources/css/custom.css"  rel="stylesheet" type="text/css">
        <!--FONT-->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <!--ICON-->
        <link href="${pageContext.request.contextPath}/Resources/css/fontawesome.css"  rel="stylesheet">
        <!--LINK JS-->
        <script src="<c:url value='/Resources/js/jquery-1.11.0.min.js' />" ></script>
        <script src="<c:url value='/Resources/js/jquery-migrate-1.2.1.min.js' />" ></script>
        <script src="<c:url value='/Resources/js/bootstrap.bundle.min.js' />" ></script>
        <script src="<c:url value='/Resources/js/templatemo.js' />" ></script>
        <script src="<c:url value='/Resources/js/custom.js' />" ></script>
        <!--LINK IMG-->
        <c:url var="LOGO" value="/Resources/img/LOGO.png"/>
        <c:url var="sachDEMO" value="/Resources/img/songThucTeGiuaDoiThucDung.jpg"/>
        <c:url value="/Resources/img/cambridge.jpg" var="NhaCungCap1"/>
        <c:url value="/Resources/img/cengage.jpg" var="NhaCungCap2"/>
        <c:url value="/Resources/img/hachette.jpg" var="NhaCungCap3"/>
        <c:url value="/Resources/img/Harper-Collins.jpg" var="NhaCungCap4"/>
        <c:url value="/Resources/img/macgrawhill.jpg" var="NhaCungCap5"/>
        <c:url value="/Resources/img/macmillan.jpg" var="NhaCungCap6"/>
        <c:url value="/Resources/img/oxford.jpg" var="NhaCungCap7"/>
        <c:url value="/Resources/img/sterling.jpg" var="NhaCungCap8"/>
        <c:url value="/Resources/img/paragon.jpg" var="NhaCungCap9"/>
        <c:url value="/Resources/img/PearsonLogo_Avatar.png" var="NhaCungCap10"/>
        <c:url value="/Resources/img/penguin.jpg" var="NhaCungCap11"/>
        <c:url value="/Resources/img/Scholastic-bar-logo.png" var="NhaCungCap12"/>

        <!--ICON LOGO-->
        <link rel="apple-touch-icon" href="${LOGO}">
        <link rel="shortcut icon" type="image/x-icon" href="${LOGO}">
    </head>
    <body>
        <!-- Start Top Nav -->
        <nav class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block" id="templatemo_nav_top">
            <div class="container text-light">
                <div class="w-100 d-flex justify-content-between">
                    <div>
                        <i class="fa fa-envelope mx-2"></i>
                        <a class="navbar-sm-brand text-light text-decoration-none" href="mailto:congdaivu107@gmail.com">congdaivu107@gmail.com</a>
                        <i class="fa fa-phone mx-2"></i>
                        <a class="navbar-sm-brand text-light text-decoration-none" href="tel:034-432-5820">034-432-5820</a>
                    </div>
                    <div>
                        <a class="text-light" href="https://fb.com/congdaivu107@gmail.com" target="_blank" rel="sponsored"><i class="fab fa-facebook-f fa-sm fa-fw me-2"></i></a>
                        <a class="text-light" href="https://www.instagram.com/congdaivu107@gmail.com" target="_blank"><i class="fab fa-instagram fa-sm fa-fw me-2"></i></a>
                        <a class="text-light" href="https://twitter.com/" target="_blank"><i class="fab fa-twitter fa-sm fa-fw me-2"></i></a>
                        <a class="text-light" href="https://www.linkedin.com/" target="_blank"><i class="fab fa-linkedin fa-sm fa-fw"></i></a>
                    </div>
                </div>
            </div>
        </nav>
        <!-- Close Top Nav -->
        <!-- Header -->
        <nav class="navbar navbar-expand-lg navbar-light shadow">
            <div class="container d-flex justify-content-between align-items-center">

                <a class="navbar-brand text-success logo h1 align-self-center" href="http://localhost:8080/Client/home">
                    Book Shop
                </a>

                <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between" id="templatemo_main_nav">
                    <div class="flex-fill">
                        <ul class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="http://localhost:8080/Client/home">Trang Chủ</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="http://localhost:8080/Client/about">Dịch Vụ</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="http://localhost:8080/Client/sach/shop">Cửa Hàng</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="http://localhost:8080/Client/contact">Liên Hệ</a>
                            </li>
                        </ul>
                    </div>
                    <div class="navbar align-self-center d-flex">
                        <div class="d-lg-none flex-sm-fill mt-3 mb-4 col-7 col-sm-auto pr-3">
                            <div class="input-group">
                                <input type="text" class="form-control" id="inputMobileSearch" placeholder="Search ...">
                                <div class="input-group-text">
                                    <i class="fa fa-fw fa-search"></i>
                                </div>
                            </div>
                        </div>
                        <a class="nav-icon d-none d-lg-inline" href="#" data-bs-toggle="modal" data-bs-target="#templatemo_search">
                            <i class="fa fa-fw fa-search text-dark mr-2"></i>
                        </a>
                        <a class="nav-icon position-relative text-decoration-none" href="http://localhost:8080/Client/cart/show">
                            <i class="fa fa-fw fa-cart-arrow-down text-dark mr-1"></i>
                            <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark">1</span>
                        </a>
                        <a class="nav-icon position-relative text-decoration-none" href="http://localhost:8080/Client/profile/show">
                            <i class="fa fa-fw fa-user text-dark mr-3"></i>
                            <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark">+99</span>
                        </a>
                    </div>
                </div>

            </div>
        </nav>
        <!-- Close Header -->
        <!-- Modal Search -->
        <div class="modal fade bg-white" id="templatemo_search" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="w-100 pt-1 mb-5 text-right">
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form action="/Client/sach/search" method="get" class="modal-content modal-body border-0 p-0">
                    <div class="input-group mb-2">
                        <input type="text" class="form-control" id="inputModalSearch" name="q" placeholder="Tìm Kiếm...">
                        <button type="submit" class="input-group-text bg-success text-light">
                            <i class="fa fa-fw fa-search text-white"></i>
                        </button>
                    </div>
                </form>
            </div>
        </div>
        <!-- Close Modal Search -->
        <!-- Start Content -->
        <div class="container py-5">
            <div class="row">

                <div class="col-lg-3">
                    <h1 class="h2 pb-4">Danh Mục</h1>
                    <ul class="list-unstyled templatemo-accordion">
                        <li class="pb-3">
                            <a class="collapsed d-flex justify-content-between h3 text-decoration-none" href="/Client/sach/search?q=gioi+tinh">
                                Giới Tính
                                <i class="fa fa-fw fa-chevron-circle-down mt-1"></i>
                            </a>
                            <ul class="collapse show list-unstyled pl-3">
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=con+trai">Con Trai</a></li>
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=con+gai">Con Gái</a></li>
                            </ul>
                        </li>
                        <li class="pb-3">
                            <a class="collapsed d-flex justify-content-between h3 text-decoration-none" href="/Client/sach/search?q=do+tuoi">
                                Độ Tuổi
                                <i class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i>
                            </a>
                            <ul id="collapseTwo" class="collapse list-unstyled pl-3">
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=3+">3+</a></li>
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=16+">16+</a></li>
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=18+">18+</a></li>
                            </ul>
                        </li>
                        <li class="pb-3">
                            <a class="collapsed d-flex justify-content-between h3 text-decoration-none" href="/Client/sach/search?q=the+loai">
                                Thể Loại
                                <i class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i>
                            </a>
                            <ul id="collapseThree" class="collapse list-unstyled pl-3">
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=thieu+nhi">Thiếu Nhi</a></li>
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=giao+khoa+-+tham+khao">Giáo Khoa - Tham Khảo</a></li>
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=van+hoc">Văn Học</a></li>
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=tam+ly+-+ky+nang+song">Tâm Lý - Kỹ Năng Sống</a></li>
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=manga+-+comic">Manga - Comic</a></li>
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=sach+hoc+ngoai+ngu">Sách Học Ngoại Ngữ</a></li>
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=kinh+te">Kinh Tế</a></li>
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=khoa+hoc+ky+thuat">Khoa Học Kỹ Thuật</a></li>
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=lich+su+-+dia+ly">Lịch Sử - Địa Lý - Tôn Giáo</a></li>
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=nuoi+day+con">Nuôi Dạy Con</a></li>
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=chinh+tri+-+phap+ly+-+triet+hoc">Chính Trị - Pháp Lý - Triết Học</a></li>
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=nu+cong+gia+chanh">Nữ Công Gia Chánh</a></li>
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=tieu+su+hoi+ky">Tiểu Sử Hồi Ký</a></li>
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=phong+thuy+-+kinh+dich">Phong Thủy - Kinh Dịch</a></li>
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=van+hoa+nghe+thuat+du+lich">Văn Hóa - Nghệ Thuật - Du Lịch</a></li>
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=tu+dien">Từ Điển</a></li>
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=am+nhac+-+my+thuat+-+thoi+trang">Âm Nhạc - Mỹ Thuật - Thời Trang</a></li>
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=the+duc+-+the+thao+-+gia+tri">Thể Dục Thể Thao - Giải Trí</a></li>
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=bao+-+tap+chi">Báo - Tạp Chí</a></li>
                                <li><a class="text-decoration-none" href="/Client/sach/search?q=giao+trinh">Giáo Trình</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>

                <div class="col-lg-9">
                    <div class="row">
                        <div class="col-md-6">
                            <ul class="list-inline shop-top-menu pb-3 pt-1">
                                <li class="list-inline-item">
                                    <a class="h3 text-dark text-decoration-none mr-3" href="/Client/sach/shop">Tất Cả</a>
                                </li>
                                <li class="list-inline-item">
                                    <a class="h3 text-dark text-decoration-none mr-3" href="/Client/sach/search?q=english">English</a>
                                </li>
                                <li class="list-inline-item">
                                    <a class="h3 text-dark text-decoration-none" href="/Client/sach/search?q=tieng+viet">Tiếng Việt</a>
                                </li>
                                <li class="list-inline-item">
                                    <a class="h3 text-dark text-decoration-none" href="/Client/sach/search?q=trung">中国人</a>
                                </li>
                            </ul>
                        </div>
                        <div class="col-md-6 pb-4">
                            <div class="d-flex">
                                <select class="form-control">
                                    <option>Sản Phẩm Mới</option>
                                    <option>A đến Z</option>
                                    <option>Z đến A</option>
                                    <option>Giá Tăng Dần</option>
                                    <option>Giá Giảm Dần</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <c:forEach var="item" items="${listItemHomePage}">                              
                            <div class="col-md-4">
                                <div class="card mb-4 product-wap rounded-0">
                                    <div class="card rounded-0">
                                        <img class="card-img rounded-0 img-fluid" src="/Client${item.image.getPhotosImagePath()}">
                                        <div class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
                                            <ul class="list-unstyled">                                                
                                                <li><a class="btn btn-success text-white" href="book?id=${item.sach.maSach}"><i class="far fa-heart"></i></a></li>
                                                <li><a class="btn btn-success text-white mt-2" href="book?id=${item.sach.maSach}"><i class="far fa-eye"></i></a></li>
                                                <li><a class="btn btn-success text-white mt-2" href="book?id=${item.sach.maSach}"><i class="fas fa-cart-plus"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="card-body">
                                        <a href="book?id=${item.sach.maSach}" class="h3 text-decoration-none">${item.sach.tenSach}</a>
                                        <ul class="w-100 list-unstyled d-flex justify-content-between mb-0">
                                            <li>${sach.tacGia}</li>
                                            <li class="pt-2">
                                                <span class="product-color-dot color-dot-red float-left rounded-circle ml-1"></span>
                                                <span class="product-color-dot color-dot-blue float-left rounded-circle ml-1"></span>
                                                <span class="product-color-dot color-dot-black float-left rounded-circle ml-1"></span>
                                                <span class="product-color-dot color-dot-light float-left rounded-circle ml-1"></span>
                                                <span class="product-color-dot color-dot-green float-left rounded-circle ml-1"></span>
                                            </li>
                                        </ul>
                                        <ul class="list-unstyled d-flex justify-content-center mb-1">
                                            <li>
                                                <fmt:parseNumber var="n" type="number" value="${item.sach.danhGia/10}"/>                                                
                                                <c:forEach var="i" begin = "1" end = "5">
                                                    <c:if test="${i <= n}">
                                                        <i class="text-warning fa fa-star"></i>
                                                    </c:if>
                                                    <c:if test="${i > n}">
                                                        <i class="text-muted fa fa-star"></i>
                                                    </c:if>  
                                                </c:forEach>
                                            </li>
                                        </ul>
                                        <p class="text-center mb-0">${item.sach.giaSach}₫</p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div div="row">
                        <ul class="pagination pagination-lg justify-content-end">
                            <li class="page-item">
                                <a class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 text-dark" href="#">
                                    <i class="fas fa-chevron-left"></i>
                                </a>
                            </li>
                            <li class="page-item disabled">
                                <a class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 text-dark" href="#">${numPage}</a>
                            </li>
                            <li class="page-item">
                                <a class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 text-dark" href="#">
                                    <i class="fas fa-chevron-right"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>
        <!-- End Content -->
        <!-- Start Brands -->
        <section class="bg-light py-5">
            <div class="container my-4">
                <div class="row text-center py-3">
                    <div class="col-lg-6 m-auto">
                        <h1 class="h1">Nhà Cung Cấp</h1>
                        <p>
                            Trong chuỗi cung ứng, nhà cung cấp hoặc người bán là doanh nghiệp đóng góp hàng hóa hoặc dịch vụ.
                        </p>
                    </div>
                    <div class="col-lg-9 m-auto tempaltemo-carousel">
                        <div class="row d-flex flex-row">
                            <!--Controls-->
                            <div class="col-1 align-self-center">
                                <a class="h1" href="#multi-item-example" role="button" data-bs-slide="prev">
                                    <i class="text-light fas fa-chevron-left"></i>
                                </a>
                            </div>
                            <!--End Controls-->

                            <!--Carousel Wrapper-->
                            <div class="col">
                                <div class="carousel slide carousel-multi-item pt-2 pt-md-0" id="multi-item-example" data-bs-ride="carousel">
                                    <!--Slides-->
                                    <div class="carousel-inner product-links-wap" role="listbox">

                                        <!--First slide-->

                                        <div class="carousel-item active">
                                            <div class="row">
                                                <div class="col-3 p-md-5">
                                                    <a href="#"><img class="img-fluid brand-img" src="${NhaCungCap1}" alt="Brand Logo"></a>
                                                </div>
                                                <div class="col-3 p-md-5">
                                                    <a href="#"><img class="img-fluid brand-img" src="${NhaCungCap2}" alt="Brand Logo"></a>
                                                </div>
                                                <div class="col-3 p-md-5">
                                                    <a href="#"><img class="img-fluid brand-img" src="${NhaCungCap3}" alt="Brand Logo"></a>
                                                </div>
                                                <div class="col-3 p-md-5">
                                                    <a href="#"><img class="img-fluid brand-img" src="${NhaCungCap4}" alt="Brand Logo"></a>
                                                </div>
                                            </div>
                                        </div>
                                        <!--End First slide-->

                                        <!--Second slide-->
                                        <div class="carousel-item">
                                            <div class="row">
                                                <div class="col-3 p-md-5">
                                                    <a href="#"><img class="img-fluid brand-img" src="${NhaCungCap5}" alt="Brand Logo"></a>
                                                </div>
                                                <div class="col-3 p-md-5">
                                                    <a href="#"><img class="img-fluid brand-img" src="${NhaCungCap6}" alt="Brand Logo"></a>
                                                </div>
                                                <div class="col-3 p-md-5">
                                                    <a href="#"><img class="img-fluid brand-img" src="${NhaCungCap7}" alt="Brand Logo"></a>
                                                </div>
                                                <div class="col-3 p-md-5">
                                                    <a href="#"><img class="img-fluid brand-img" src="${NhaCungCap8}" alt="Brand Logo"></a>
                                                </div>
                                            </div>
                                        </div>
                                        <!--End Second slide-->

                                        <!--Third slide-->
                                        <div class="carousel-item">
                                            <div class="row">
                                                <div class="col-3 p-md-5">
                                                    <a href="#"><img class="img-fluid brand-img" src="${NhaCungCap9}" alt="Brand Logo"></a>
                                                </div>
                                                <div class="col-3 p-md-5">
                                                    <a href="#"><img class="img-fluid brand-img" src="${NhaCungCap10}" alt="Brand Logo"></a>
                                                </div>
                                                <div class="col-3 p-md-5">
                                                    <a href="#"><img class="img-fluid brand-img" src="${NhaCungCap11}" alt="Brand Logo"></a>
                                                </div>
                                                <div class="col-3 p-md-5">
                                                    <a href="#"><img class="img-fluid brand-img" src="${NhaCungCap12}" alt="Brand Logo"></a>
                                                </div>
                                            </div>
                                        </div>
                                        <!--End Third slide-->

                                    </div>
                                    <!--End Slides-->
                                </div>
                            </div>
                            <!--End Carousel Wrapper-->

                            <!--Controls-->
                            <div class="col-1 align-self-center">
                                <a class="h1" href="#multi-item-example" role="button" data-bs-slide="next">
                                    <i class="text-light fas fa-chevron-right"></i>
                                </a>
                            </div>
                            <!--End Controls-->
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--End Brands-->
        <!-- Start Footer -->
        <footer class="bg-dark" id="tempaltemo_footer">
            <div class="container">
                <div class="row">

                    <div class="col-md-4 pt-5">
                        <h2 class="h2 text-success border-bottom pb-3 border-light logo">Book Shop</h2>
                        <ul class="list-unstyled text-light footer-link-list">
                            <li>
                                <i class="fas fa-map-marker-alt fa-fw"></i> Hồ Chí Mình, Việt Nam
                            </li>
                            <li>
                                <i class="fa fa-phone fa-fw"></i>
                                <a class="text-decoration-none" href="tel:034-432-5820">034-432-5820</a>
                            </li>
                            <li>
                                <i class="fa fa-envelope fa-fw"></i>
                                <a class="text-decoration-none" href="mailto:tnhatlong2000@gmail.com">dvwnmark2002@gmail.com</a>
                            </li>
                        </ul>
                    </div>

                    <div class="col-md-4 pt-5">
                        <h2 class="h2 text-light border-bottom pb-3 border-light">Các Loại Sách</h2>
                        <ul class="list-unstyled text-light footer-link-list">
                            <li><a class="text-decoration-none" href="/Client/sach/search?q=chinh+tri+phap+luat">Sách Chính trị – pháp luật</a></li>
                            <li><a class="text-decoration-none" href="/Client/sach/search?q=khoa+hoc+cong+nghe+kinh+te">Sách Khoa học công nghệ – Kinh tế</a></li>
                            <li><a class="text-decoration-none" href="/Client/sach/search?q=van+hoc+nghe+thuat">Sách Văn học nghệ thuật</a></li>
                            <li><a class="text-decoration-none" href="/Client/sach/search?q=van+hoa+xa+hoi+lich+su">Sách Văn hóa xã hội – Lịch sử</a></li>
                            <li><a class="text-decoration-none" href="/Client/sach/search?q=giao+trinh">Sách Giáo trình</a></li>
                            <li><a class="text-decoration-none" href="/Client/sach/search?q=truyen+tieu+thuyet">Sách Truyện, tiểu thuyết</a></li>
                            <li><a class="text-decoration-none" href="/Client/sach/search?q=sach+thieu+nhi">Sách thiếu nhi</a></li>
                        </ul>
                    </div>

                    <div class="col-md-4 pt-5">
                        <h2 class="h2 text-light border-bottom pb-3 border-light">Thông Tin Thêm</h2>
                        <ul class="list-unstyled text-light footer-link-list">
                            <li><a class="text-decoration-none" href="http://localhost:8080/Client/home">Trang Chủ</a></li>
                            <li><a class="text-decoration-none" href="http://localhost:8080/Client/contact">Liên Hệ</a></li>
                            <li><a class="text-decoration-none" href="http://localhost:8080/Client/contact">Vị Trí</a></li>
                            <li><a class="text-decoration-none" href="http://localhost:8080/Client/contact">Đặc Câu Hỏi</a></li>
                            <li><a class="text-decoration-none" href="http://localhost:8080/Client/contact">Liên Lạc</a></li>
                        </ul>
                    </div>

                </div>

                <div class="row text-light mb-4">
                    <div class="col-12 mb-3">
                        <div class="w-100 my-3 border-top border-light"></div>
                    </div>
                    <div class="col-auto me-auto">
                        <ul class="list-inline text-left footer-icons">
                            <li class="list-inline-item border border-light rounded-circle text-center">
                                <a class="text-light text-decoration-none" target="_blank" href="http://facebook.com/"><i class="fab fa-facebook-f fa-lg fa-fw"></i></a>
                            </li>
                            <li class="list-inline-item border border-light rounded-circle text-center">
                                <a class="text-light text-decoration-none" target="_blank" href="https://www.instagram.com/"><i class="fab fa-instagram fa-lg fa-fw"></i></a>
                            </li>
                            <li class="list-inline-item border border-light rounded-circle text-center">
                                <a class="text-light text-decoration-none" target="_blank" href="https://twitter.com/"><i class="fab fa-twitter fa-lg fa-fw"></i></a>
                            </li>
                            <li class="list-inline-item border border-light rounded-circle text-center">
                                <a class="text-light text-decoration-none" target="_blank" href="https://www.linkedin.com/"><i class="fab fa-linkedin fa-lg fa-fw"></i></a>
                            </li>
                        </ul>
                    </div>
                  <!--   <div class="col-auto">
                        <label class="sr-only" for="subscribeEmail">Đăng Ký</label>
                        <div class="input-group mb-2">
                            <input type="text" class="form-control bg-dark border-light" id="subscribeEmail" placeholder="Nhập Mail Ở Đây">
                            <div class="input-group-text btn-success text-light">Đăng Ký</div>
                        </div>
                    </div> -->
                </div>
            </div>

            <div class="w-100 bg-black py-3">
                <div class="container">
                    <div class="row pt-2">
                        <div class="col-12">
                            <p class="text-left text-light">
                                Copyright &copy; 2024 | Thiết Kế Bởi <a rel="sponsored" href="https://www.facebook.com" target="_blank"> Vũ Công Đại </a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>

        </footer>
        <!-- End Footer -->
    </body>
</html>
