package com.wordpress.lamon.domain

class AuditLog {

    Date dateCreated

    String entityName
    String entityId
    String entityProperties
    String eventType

    static mapping = {
        entityProperties(type: 'text')
    }

    static constraints = {
        entityName(nullable: false, blank: false)
        eventType(nullable: false, blank: false, inList: ['INSERT', 'UPDATE', 'DELETE'])
        entityId(nullable: false, blank: false)
        entityProperties(nullable: false, blank: false)
    }
}
