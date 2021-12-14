<%@page import="me.dannly.shop.domain.model.Product"%>
<%@include file="_inc/_check_session.jsp" %>
<%@include file="_inc/_header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean class="me.dannly.shop.data_source.ProductDAO" id="productDAO"/>
<jsp:useBean class="me.dannly.shop.data_source.CategoryDAO" id="categoryDAO"/>
<div class="container">
    <div class="row">
        <%@include file="_inc/_menu.jsp" %>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Products</h1>
                <a href="products.jsp" class="btn btn-primary">Return</a>
            </div>
            <%                pageContext.setAttribute("name", null);
                pageContext.setAttribute("description", null);
                pageContext.setAttribute("image", null);
                pageContext.setAttribute("weight", null);
                pageContext.setAttribute("highlighted", false);
                pageContext.setAttribute("active", false);
                pageContext.setAttribute("categoryId", null);
                if (request.getParameter("id") != null) {
                    final Product product = productDAO.getElementsByFilter("id = ?", Integer.parseInt(request.getParameter("id"))).get(0);
                    pageContext.setAttribute("name", product.getName());
                    pageContext.setAttribute("description", product.getDescription());
                    pageContext.setAttribute("image", product.getImage());
                    pageContext.setAttribute("extraInfo", product.getExtraInfo());
                    pageContext.setAttribute("weight", product.getWeight());
                    pageContext.setAttribute("highlighted", product.getHighlighted());
                    pageContext.setAttribute("active", product.getActive());
                    pageContext.setAttribute("categoryId", product.getCategoriesId());
                }
            %>
            <form action="product_processer" method="post">
                <c:if test="${param.id != null}">
                    <input type="hidden" value="${param.id}" name="id"/>
                </c:if>
                <div class="form-floating">
                    <input type="text" class="form-control" id="name" placeholder="Excalibur" name="name" required value='${fn:escapeXml(name)}'>
                    <label for="name">Name</label>
                </div>
                <br>
                <div class="form-floating">
                    <input type="text" class="form-control" id="description" placeholder="A legendary sword" name="description" value='${fn:escapeXml(description)}'>
                    <label for="description">Description</label>
                </div>
                <br>
                <div class="form-floating">
                    <input type="text" class="form-control" id="extraInfo" placeholder='"All shall tremble before its might!"' name="extraInfo" value='${fn:escapeXml(extraInfo)}'>
                    <label for="extraInfo">Extra info</label>
                </div>
                <br>
                <div class="form-floating">
                    <input type="number" class="form-control" id="weight" placeholder="750" name="weight" value='${weight}' required>
                    <label for="weight">Weight</label>
                </div>
                <br>
                <div class="checkbox mb-3">
                    <input type="checkbox" ${highlighted ? "checked" : ""} name="highlighted"> Highlighted
                </div>
                <br>
                <div class="checkbox mb-3">
                    <input type="checkbox" name="active" ${active ? "checked" : ""}> Active
                </div>
                <br>
                <div class="form-floating">
                    <input type="text" class="form-control" id="image" placeholder="https://www.yourwebsite.com/image/example.jpg" name="image" value='${fn:escapeXml(image)}' required>
                    <label for="image">Image URL</label>
                </div>
                <br>
                <div class="form-floating">
                    <input type="number" class="form-control" id="categoryId" placeholder="1" name="categoryId" value='${categoryId}' required>
                    <label for="categoryId">Category ID</label>
                </div>
                <br>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Submit</button>
            </form>
        </main>
    </div>
</div>
</body>
</html>
