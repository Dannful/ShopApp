<%@include file="_inc/_header.jsp"%>
<%@include file="_inc/_menu.jsp" %>
<jsp:useBean class="me.dannly.shop.data_source.ProductDAO" id="productDAO"/>
<c:forEach items='${productDAO.getElementsByFilter("id = ?", param.pid)}' var="product">
    <div class="container px-4 py-5" id="custom-cards">
        <h2 class="pb-2 border-bottom">${product.name}</h2>
        <small class="text-muted"><i>${product.extraInfo}</i></small><br>
        <div class="row row-cols-1 row-cols-lg-3 align-items-stretch">
            <img class="img-thumbnail rounded" src="${product.image}"/>
            <div>
                <h3><i>${product.description}</i></h3>
                <br>
                <h4><b>Weight</b>: ${product.weight}</h4>
                <br>
                <small>Category: ${categoryDAO.getElementsByFilter("id = ?", product.categoriesId).get(0).name}</small>
            </div>
        </div>
    </div>
</c:forEach>
</main>
<footer>
    <%@include file="_inc/_footer.jsp" %>
</footer>
<script src="./assets/js/bootstrap.bundle.min.js"></script>
