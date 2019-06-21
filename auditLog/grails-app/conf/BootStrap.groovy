import com.wordpress.lamon.domain.Book

class BootStrap {

    def auditLogService

    def init = { servletContext ->

        auditLogService.makeDomainClassesAuditable()

        new Book(title: "God Delusion", author: "Richard Dawkins").save()
        new Book(title: "The Hobbit", author: "J. R. R. Tolkien").save()

    }
    def destroy = {
    }
}
