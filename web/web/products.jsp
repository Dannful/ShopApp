<%@include file="_inc/_header.jsp"%>
<%@include file="_inc/_menu.jsp" %>
<div class="container px-4 py-5" id="custom-cards">
    <h2 class="pb-2 border-bottom">Products</h2>
    <div class="row row-cols-1 row-cols-lg-3 align-items-stretch g-4 py-5">
        <c:if test="${param.cid != null}">
            <c:set var="filter" value="categories_id = ?"/>
            <c:set var="parameter" value="${param.cid}"/>
        </c:if>
        <c:if test="${param.q != null}">
            <c:set var="filter" value="name LIKE ?"/>
            <c:set var="parameter" value="%${param.q}%"/>
        </c:if>
        <jsp:useBean class="me.dannly.shop.data_source.ProductDAO" id="productDAO"/>
        <c:forEach items="${productDAO.getElementsByFilter(filter, parameter)}" var="product">
            <a style="text-decoration:none;" href="details.jsp?pid=${product.id}"><div class="col">
                    <div class="card card-cover h-100 overflow-hidden text-white bg-dark rounded-5 shadow-lg" style="background-image: url('${product.image}');">
                        <div class="d-flex flex-column h-100 p-5 pb-3 text-white text-shadow-1">
                            <h2 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">${product.name}</h2>
                            <ul class="d-flex list-unstyled mt-auto">
                                <li class="me-auto">
                                    ${product.extraInfo}
                                </li>
                                <li class="d-flex align-items-center me-3">
                                    <small>${categoryDAO.getElementsByFilter("id = ?", product.categoriesId).get(0).name}</small>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </a>
        </c:forEach>
    </div>
</div>
</main>
<footer>
    <%@include file="_inc/_footer.jsp" %>
</footer>
<script src="./assets/js/bootstrap.bundle.min.js"></script>
