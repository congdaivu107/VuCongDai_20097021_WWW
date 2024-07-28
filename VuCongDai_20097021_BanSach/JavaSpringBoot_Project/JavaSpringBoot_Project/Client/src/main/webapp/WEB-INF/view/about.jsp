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
        <!-- Banner -->
        <section class="bg-success py-5">
            <div class="container">
                <div class="row align-items-center py-5">
                    <div class="col-md-8 text-white">
                        <h1>Về Chúng Tôi</h1>
                        <p>
                            <b>Book shop</b> là trang thương mại điện tử của <b>Nhà Sách Book shop</b>, hệ thống nhà sách thân thuộc của nhiều gia đình Việt.
                        </p>
                        <p>
                            Đến với không gian mua sắm trực tuyến <b>Book shop</b>, khách hàng có thể dễ dàng tìm thấy những cuốn sách hay, đa thể loại của nhiều nhà xuất bản, công ty sách trong và ngoài nước cùng nhiều dụng cụ học tập, văn phòng phẩm, quà lưu niệm, đồ chơi giáo dục chính hãng của những thương hiệu uy tín. Cùng tiêu chí không ngừng hoàn thiện, nâng cao chất lượng sản phẩm, dịch vụ, <b>Book shop</b> cam kết mang đến cho khách hàng trải nghiệm mua sắm trực tuyến an toàn, tiện lợi: cách đặt hàng đơn giản, phương thức thanh toán đa dạng, dịch vụ chăm sóc khách hàng tận tình, chu đáo. 
                        </p>
                    </div>
                    <div class="col-md-4">
                        <img src="${LOGO}" alt="About Hero" class="AnhSinhVien">
                    </div>
                </div>
            </div>
        </section>
        <!-- Close Banner -->
        <!-- Start Section -->
        <section class="container py-5">
            <div class="row text-center pt-5 pb-3">
                <div class="col-lg-6 m-auto">
                    <h1 class="h1">Dịch Vụ Của Chúng Tôi</h1>
                    <p>
                        Danh mục hàng hóa phong phú, nhiều sản phẩm độc quyền, được chọn lọc kỹ càng đã tạo nên sự khác biệt của <b>Book shop</b> và tạo dựng được lòng tin yêu từ khách hàng.
                    </p>
                </div>
            </div>
            <div class="row">

                <div class="col-md-6 col-lg-3 pb-5">
                    <div class="h-100 py-5 services-icon-wap shadow">
                        <div class="h1 text-success text-center"><i class="fa fa-truck fa-lg"></i></div>
                        <h2 class="h5 mt-4 text-center">Vận Chuyển</h2>
                    </div>
                </div>

                <div class="col-md-6 col-lg-3 pb-5">
                    <div class="h-100 py-5 services-icon-wap shadow">
                        <div class="h1 text-success text-center"><i class="fas fa-exchange-alt"></i></div>
                        <h2 class="h5 mt-4 text-center">Nhận - Trả Hàng</h2>
                    </div>
                </div>

                <div class="col-md-6 col-lg-3 pb-5">
                    <div class="h-100 py-5 services-icon-wap shadow">
                        <div class="h1 text-success text-center"><i class="fa fa-percent"></i></div>
                        <h2 class="h5 mt-4 text-center">Khuyến Mại</h2>
                    </div>
                </div>

                <div class="col-md-6 col-lg-3 pb-5">
                    <div class="h-100 py-5 services-icon-wap shadow">
                        <div class="h1 text-success text-center"><i class="fa fa-user"></i></div>
                        <h2 class="h5 mt-4 text-center">Phục Vụ 24h</h2>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Section -->
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
                                <a class="text-decoration-none" href="mailto:congdaivu107@gmail.com">congdaivu107@gmail.com</a>
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
                    <!-- <div class="col-auto">
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
                                Copyright &copy; 2024 | Thiết Kế Bởi <a rel="sponsored" href="https://www.facebook.com" target="_blank">Vũ Công Đại </a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- End Footer -->
    </body>
</html>
