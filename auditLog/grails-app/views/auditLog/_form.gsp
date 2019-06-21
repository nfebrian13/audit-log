<%@ page import="com.wordpress.lamon.domain.AuditLog" %>



<div class="fieldcontain ${hasErrors(bean: auditLogInstance, field: 'entityName', 'error')} required">
	<label for="entityName">
		<g:message code="auditLog.entityName.label" default="Entity Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="entityName" required="" value="${auditLogInstance?.entityName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: auditLogInstance, field: 'eventType', 'error')} required">
	<label for="eventType">
		<g:message code="auditLog.eventType.label" default="Event Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="eventType" from="${auditLogInstance.constraints.eventType.inList}" required="" value="${auditLogInstance?.eventType}" valueMessagePrefix="auditLog.eventType"/>
</div>

<div class="fieldcontain ${hasErrors(bean: auditLogInstance, field: 'entityId', 'error')} required">
	<label for="entityId">
		<g:message code="auditLog.entityId.label" default="Entity Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="entityId" required="" value="${auditLogInstance?.entityId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: auditLogInstance, field: 'entityProperties', 'error')} required">
	<label for="entityProperties">
		<g:message code="auditLog.entityProperties.label" default="Entity Properties" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="entityProperties" required="" value="${auditLogInstance?.entityProperties}"/>
</div>

