package demangular


class AuthInterceptor {
	AuthInterceptor() {
		matchAll()
	}

    boolean before() {
    	if(session["login"]!=null && session["login"].trim()!=""){
    		log.debug 'Redirecting to login page'
    		redirect(controller: 'authentication', action: "login")
    		return false
    	}
    	true
 	}

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
