
<%@ page import="com.wordpress.lamon.domain.AuditLog" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'auditLog.label', default: 'AuditLog')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-auditLog" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-auditLog" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list auditLog">
			
				<g:if test="${auditLogInstance?.entityName}">
				<li class="fieldcontain">
					<span id="entityName-label" class="property-label"><g:message code="auditLog.entityName.label" default="Entity Name" /></span>
					
						<span class="property-value" aria-labelledby="entityName-label"><g:fieldValue bean="${auditLogInstance}" field="entityName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${auditLogInstance?.eventType}">
				<li class="fieldcontain">
					<span id="eventType-label" class="property-label"><g:message code="auditLog.eventType.label" default="Event Type" /></span>
					
						<span class="property-value" aria-labelledby="eventType-label"><g:fieldValue bean="${auditLogInstance}" field="eventType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${auditLogInstance?.entityId}">
				<li class="fieldcontain">
					<span id="entityId-label" class="property-label"><g:message code="auditLog.entityId.label" default="Entity Id" /></span>
					
						<span class="property-value" aria-labelledby="entityId-label"><g:fieldValue bean="${auditLogInstance}" field="entityId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${auditLogInstance?.entityProperties}">
				<li class="fieldcontain">
					<span id="entityProperties-label" class="property-label"><g:message code="auditLog.entityProperties.label" default="Entity Properties" /></span>
					
						<span class="property-value" aria-labelledby="entityProperties-label"><g:fieldValue bean="${auditLogInstance}" field="entityProperties"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${auditLogInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="auditLog.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${auditLogInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${auditLogInstance?.id}" />
					<g:link class="edit" action="edit" id="${auditLogInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
