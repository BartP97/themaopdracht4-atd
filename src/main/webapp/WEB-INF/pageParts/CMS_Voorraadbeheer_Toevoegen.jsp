<jsp:include page="/WEB-INF/view/cms/header.jsp">
    <jsp:param name="title" value="Artikel Toevoegen" />
</jsp:include>

<%@ page pageEncoding="UTF-8" %>
<form class="form" method="POST" action="/cms/voorraad/toevoegen">
<div class="tableWrap content">
    <div class="form-group">
        <label for="artikel">Artikel:</label>
        <input type="text" name="artikel" id="artikel" />
    </div>
    
    <div class="form-group">
        <label for="prijs">Prijs:</label>
        <input type="number" name="prijs" id="prijs" />
    </div>
    
    <div class="form-group">
        <label for="voorraad">Voorraad:</label>
        <input type="number" name="voorraad" id="voorraad" />
    </div>
</div>
<footer class="contentMenu">
    <button name="send" type="submit">Artikel Toevoegen</button>
</footer>
</form>

<%@include file="/WEB-INF/view/cms/footer.jsp" %>