package com.wordpress.lamon.domain



import org.junit.*
import grails.test.mixin.*

@TestFor(AuditLogController)
@Mock(AuditLog)
class AuditLogControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/auditLog/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.auditLogInstanceList.size() == 0
        assert model.auditLogInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.auditLogInstance != null
    }

    void testSave() {
        controller.save()

        assert model.auditLogInstance != null
        assert view == '/auditLog/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/auditLog/show/1'
        assert controller.flash.message != null
        assert AuditLog.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/auditLog/list'

        populateValidParams(params)
        def auditLog = new AuditLog(params)

        assert auditLog.save() != null

        params.id = auditLog.id

        def model = controller.show()

        assert model.auditLogInstance == auditLog
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/auditLog/list'

        populateValidParams(params)
        def auditLog = new AuditLog(params)

        assert auditLog.save() != null

        params.id = auditLog.id

        def model = controller.edit()

        assert model.auditLogInstance == auditLog
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/auditLog/list'

        response.reset()

        populateValidParams(params)
        def auditLog = new AuditLog(params)

        assert auditLog.save() != null

        // test invalid parameters in update
        params.id = auditLog.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/auditLog/edit"
        assert model.auditLogInstance != null

        auditLog.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/auditLog/show/$auditLog.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        auditLog.clearErrors()

        populateValidParams(params)
        params.id = auditLog.id
        params.version = -1
        controller.update()

        assert view == "/auditLog/edit"
        assert model.auditLogInstance != null
        assert model.auditLogInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/auditLog/list'

        response.reset()

        populateValidParams(params)
        def auditLog = new AuditLog(params)

        assert auditLog.save() != null
        assert AuditLog.count() == 1

        params.id = auditLog.id

        controller.delete()

        assert AuditLog.count() == 0
        assert AuditLog.get(auditLog.id) == null
        assert response.redirectedUrl == '/auditLog/list'
    }
}
