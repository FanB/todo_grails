package demangular

class UrlMappings {

    static mappings = {
        "/login"(controller: 'session', action: 'index', method: 'GET')
        "/logout"(controller: 'session',action: 'destroy', method: 'DELETE')
        "/todos"(resources:"todo")
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
