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
        <link href="${pageContext.request.contextPath}/Resources/css/slick.css"  rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/Resources/css/slick-theme_1.css"  rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/Resources/css/templatemo-style.css"  rel="stylesheet" type="text/css">
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
        <script src="<c:url value='/Resources/js/custom.js' />" ></script>
        <script src="<c:url value='/Resources/js/jquery-3.2.1.slim.min.js' />" ></script>
        <script src="<c:url value='/Resources/js/slick.min.js' />" ></script>

        <!--LINK IMG-->
        <c:url var="VuCongDai" value="/Resources/img/.jpg"/>
        <c:url var="LOGO" value="/Resources/img/LOGO.png"/>
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
                            <!--<span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark">+99</span>-->
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
        <!-- Welcome section -->
        <section class="tm-welcome">

            <div class="tm-welcome-left">
                <!-- Logo -->
                <div class="tm-logo">
                    <h1 class="tm-site-name">HỒ SƠ</h1>
                </div>
                <div class="tm-welcome-content">
                    <!-- fa icons -->
                    <div class="tm-welcome-icons-container">
                        <i class="fas fa-crown fa-5x tm-welcome-icon"></i>
                        <i class="fas fa-heart fa-5x tm-welcome-icon"></i>
                    </div>

                    <h2 class="tm-mb-25">Chào mừng bạn đến Hồ Sơ</h2>
                    <p class="tm-font-big">một tài liệu mô tả các đặc điểm về tâm lý, nhân khẩu học, địa lý, cũng như các điểm đau, sở thích, kiểu cách mua hàng của khách hàng hoặc một nhóm khách hàng tiềm năng của công ty.</p>
                    <!--<a href="<c:url value="/logout" />" class="tm-welcome-link tm-font-big"><b>LOGOUT...</b></a>-->
                    <!-- Add a logout button -->
                    <form:form action="${pageContext.request.contextPath}/logout" method="POST" class="tm-welcome-link tm-font-big">
                        <button type="submit" class="custButton">
                            <span class="tm-welcome-link tm-font-big"></span> LOGOUT...
                        </button>
                    </form:form>
                </div>
            </div>
            <div class="tm-welcome-right"></div>

        </section>
        <div class="tm-bar-2"></div>

        <section class="row tm-section-mb tm-section-2">
            <div class="col-md-12 tm-section-2-inner">
                <div class="tm-section-2-left">
                    <div class="tm-img-container tm-img-container-1" style="background-image: url(/Client${phot1.getPhotosImagePath()});"></div>
                    <div class="tm-img-container tm-img-container-2" style="background-image: url(/Client${phot2.getPhotosImagePath()});"></div>
                </div>
                <div class="tm-section-2-right tm-bg-primary">
                    <div class="tm-section-2-text">
                        <h2 class="tm-section-2-header tm-mb-45">Thông tin cá nhân</h2>
                        <p>Tên: ${khachHang.lastName} ${khachHang.firstName}</p>
                        <p>Email: ${khachHang.email}</p>
                        <p>Địa chỉ: ${khachHang.address}</p>
                        <p class="tm-p-ml">Ngày sinh: ${khachHang.birthDate}</p>
                        <p class="tm-p-ml">Số điện thoại: ${khachHang.phone}</p>
                        <p class="tm-p-ml">............</p>
                        <a href="changeProfile" class="d-block tm-welcome-link">Thay đổi thông tin...</a>
                    </div>
                </div>
            </div>
        </section>

        <section class="row tm-section-3">
            <div class="col-md-12 tm-section-3-inner">
                <div class="tm-section-3-left tm-bg-primary">
                    <div class="tm-section-3-text">
                        <i class="fas fa-shield-alt fa-5x tm-welcome-icon d-block text-center ml-0"></i>
                        <h2 class="tm-section-3-header tm-mb-35">Thông tin bảo mật</h2>
                        <p>tránh được hoặc bền bỉ trước các mối đe dọa tiềm tàng từ kẻ khác, nói cách khác là bảo đảm được sự an toàn trước các mối đe dọa.</p>
                        <a href="changePass" class="d-block tm-welcome-link">Thay đổi mật khẩu...</a>
                    </div>
                </div>
                <div class="tm-section-3-right">
                    <div class="tm-img-container-3" style="background-image: url(/Client${phot3.getPhotosImagePath()});"></div>
                </div>
            </div>
        </section>

        <section class="row tm-section-pt tm-section-pb">
            <div class="col-md-6 mx-auto text-center">
                <h2 class="tm-text-dark tm-mb-50">VỀ BOOK SHOP</h2>
                <p class="tm-text-light-dark tm-font-big">Đến với không gian mua sắm trực tuyến Book shop, khách hàng có thể dễ dàng tìm thấy những cuốn sách hay, đa thể loại của nhiều nhà xuất bản, công ty sách trong và ngoài nước cùng nhiều dụng cụ học tập, văn phòng phẩm, quà lưu niệm, đồ chơi giáo dục chính hãng của những thương hiệu uy tín.</p>
            </div>
        </section>

        <section class="row tm-section-pb">
            <div class="col-md-12 tm-bg-accent tm-gallery-pad tm-gallery-container mx-auto">
                <h2 class="text-center tm-mb-45">Thư Viện Ảnh</h2>
                <div class="grid tm-gallery">
                    <c:forEach var="photo" items="${listPhoto}">
                        <figure class="effect-lexi tm-gallery-item">
                            <img src="/Client${photo.getPhotosImagePath()}" alt="Image" class="">
                            <figcaption>
                                <p>${photo.photo}</p>
                            </figcaption>
                        </figure>
                    </c:forEach>                    
                </div>
            </div>
        </section>
        <script>
            $(function () {
                $('.tm-gallery').slick({
                    dots: true,
                    infinite: true,
                    slidesToShow: 4,
                    slidesToScroll: 2,
                    responsive: [{
                            breakpoint: 991,
                            settings: {
                                slidesToShow: 3,
                                slidesToScroll: 2
                            }
                        }, {
                            breakpoint: 767,
                            settings: {
                                slidesToShow: 2,
                                slidesToScroll: 1
                            }
                        }, {
                            breakpoint: 480,
                            settings: {
                                slidesToShow: 1,
                                slidesToScroll: 1
                            }
                        }
                    ]
                });
            });
        </script>

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
                                Copyright &copy; 2024 | Thiết Kế Bởi <a rel="sponsored" href="https://www.facebook.com" target="_blank">Vũ Công Đại  </a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>

        </footer>
        <!-- End Footer -->
    </body>
</html>
