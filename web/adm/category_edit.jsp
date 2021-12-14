<%@page import="me.dannly.shop.domain.model.Category"%>
<%@include file="_inc/_check_session.jsp" %>
<%@include file="_inc/_header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean class="me.dannly.shop.data_source.CategoryDAO" id="categoryDAO"/>
<div class="container">
    <div class="row">
        <%@include file="_inc/_menu.jsp" %>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Categories</h1>
                <a href="categories.jsp" class="btn btn-primary">Return</a>
            </div>
            <%                String name = "", description = "";
                boolean active = false;
                if (request.getParameter("id") != null) {
                    final Category category = categoryDAO.getElementsByFilter("id = ?", request.getParameter("id")).get(0);
                    name = category.getName();
                    description = category.getDescription();
                    active = category.getActive();
                }
            %>
            <form action="category_processer" method="post">
                <c:if test="${param.id != null}">
                    <input type="hidden" value="${param.id}" name="id"/>
                </c:if>
                <div class="form-floating">
                    <input type="text" class="form-control" id="name" placeholder="Gaming" name="name" required value="<%=name%>">
                    <label for="name">Name</label>
                </div>
                <br>
                <div class="form-floating">
                    <input type="text" class="form-control" id="description" placeholder="An epic category" name="description" value="<%=description%>">
                    <label for="description">Description</label>
                </div>
                <br>
                <div class="checkbox mb-3">
                    <input type="checkbox" <%=active ? "checked" : ""%> name="active"> Active
                </div>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Submit</button>
            </form>
        </main>
    </div>
</div>
</body>
</html>
