
<%@ page import="com.wordpress.lamon.domain.AuditLog" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'auditLog.label', default: 'AuditLog')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-auditLog" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-auditLog" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="entityName" title="${message(code: 'auditLog.entityName.label', default: 'Entity Name')}" />
					
						<g:sortableColumn property="eventType" title="${message(code: 'auditLog.eventType.label', default: 'Event Type')}" />
					
						<g:sortableColumn property="entityId" title="${message(code: 'auditLog.entityId.label', default: 'Entity Id')}" />
					
						<g:sortableColumn property="entityProperties" title="${message(code: 'auditLog.entityProperties.label', default: 'Entity Properties')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'auditLog.dateCreated.label', default: 'Date Created')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${auditLogInstanceList}" status="i" var="auditLogInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${auditLogInstance.id}">${fieldValue(bean: auditLogInstance, field: "entityName")}</g:link></td>
					
						<td>${fieldValue(bean: auditLogInstance, field: "eventType")}</td>
					
						<td>${fieldValue(bean: auditLogInstance, field: "entityId")}</td>
					
						<td>${fieldValue(bean: auditLogInstance, field: "entityProperties")}</td>
					
						<td><g:formatDate date="${auditLogInstance.dateCreated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${auditLogInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
