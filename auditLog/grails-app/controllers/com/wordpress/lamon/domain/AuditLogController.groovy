package com.wordpress.lamon.domain

import org.springframework.dao.DataIntegrityViolationException

class AuditLogController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [auditLogInstanceList: AuditLog.list(params), auditLogInstanceTotal: AuditLog.count()]
    }

    def create() {
        [auditLogInstance: new AuditLog(params)]
    }

    def save() {
        def auditLogInstance = new AuditLog(params)
        if (!auditLogInstance.save(flush: true)) {
            render(view: "create", model: [auditLogInstance: auditLogInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'auditLog.label', default: 'AuditLog'), auditLogInstance.id])
        redirect(action: "show", id: auditLogInstance.id)
    }

    def show(Long id) {
        def auditLogInstance = AuditLog.get(id)
        if (!auditLogInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'auditLog.label', default: 'AuditLog'), id])
            redirect(action: "list")
            return
        }

        [auditLogInstance: auditLogInstance]
    }

    def edit(Long id) {
        def auditLogInstance = AuditLog.get(id)
        if (!auditLogInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'auditLog.label', default: 'AuditLog'), id])
            redirect(action: "list")
            return
        }

        [auditLogInstance: auditLogInstance]
    }

    def update(Long id, Long version) {
        def auditLogInstance = AuditLog.get(id)
        if (!auditLogInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'auditLog.label', default: 'AuditLog'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (auditLogInstance.version > version) {
                auditLogInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'auditLog.label', default: 'AuditLog')] as Object[],
                          "Another user has updated this AuditLog while you were editing")
                render(view: "edit", model: [auditLogInstance: auditLogInstance])
                return
            }
        }

        auditLogInstance.properties = params

        if (!auditLogInstance.save(flush: true)) {
            render(view: "edit", model: [auditLogInstance: auditLogInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'auditLog.label', default: 'AuditLog'), auditLogInstance.id])
        redirect(action: "show", id: auditLogInstance.id)
    }

    def delete(Long id) {
        def auditLogInstance = AuditLog.get(id)
        if (!auditLogInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'auditLog.label', default: 'AuditLog'), id])
            redirect(action: "list")
            return
        }

        try {
            auditLogInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'auditLog.label', default: 'AuditLog'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'auditLog.label', default: 'AuditLog'), id])
            redirect(action: "show", id: id)
        }
    }
}
