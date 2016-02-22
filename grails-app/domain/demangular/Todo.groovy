package demangular
import grails.rest.*

@Resource(formats=['json','xml'])
class Todo {
    String description
    Boolean done
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
