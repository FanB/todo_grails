package demangular


class AuthInterceptor {
	AuthInterceptor() {
		matchAll().excludes(controller: "session")
	}

    boolean before() {
    	if(session["login"]==null || session["login"].trim()==""){
    		log.debug 'Redirecting to login page'
    		redirect(controller: 'session', action: "index")
    		return false
    	}
    	true
 	}

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
