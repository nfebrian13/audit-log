package com.wordpress.lamon.services

import org.codehaus.groovy.grails.commons.DefaultGrailsDomainClass
import com.wordpress.lamon.domain.AuditLog

class AuditLogService {

    def grailsApplication

    def makeDomainClassesAuditable() {
        grailsApplication.domainClasses.each { domainClass ->
            if(domainClass.hasProperty("auditable")) {
                domainClass.metaClass.afterInsert = {
                    logChanges(delegate, "INSERT")
                }
                domainClass.metaClass.afterUpdate = {
                    logChanges(delegate, "UPDATE")
                }
                domainClass.metaClass.afterDelete = {
                    logChanges(delegate, "DELETE")
                }
            }
        }
    }

    def logChanges = { obj, event ->

        def props = obj?.properties
        def persistentProperties = new DefaultGrailsDomainClass(obj?.class)?.properties?.findAll { it?.persistent }
        def eProperties = [:]

        persistentProperties.each {
            if(props.containsKey(it?.name)) {
                eProperties[it?.name] = props[it?.name]
            }
        }

        def logInstance = new AuditLog(
                entityId: obj?.id?.toString(),
                entityName: obj?.class?.toString(),
                entityProperties: eProperties?.toString(),
                eventType: event
        )

        AuditLog.withNewSession { org.hibernate.Session session ->
            session.save(logInstance)
        }

        println "${event} -> ${obj}"
    }
}