<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ include file="_include/header.jsp" %>

<h2>Connexion</h2>

<s:form action="login">
    <s:textfield name="login" label="Identifiant" requiredLabel="true" />
    <s:password name="pwd" label="Mot de passe" requiredLabel="true" />

    <s:submit value="Connexion"/>
</s:form>
</body>
</html>