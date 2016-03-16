package demangular

import com.unboundid.ldap.sdk.*

class SessionController {
	static allowedMethods = [login: "POST", index: "GET", logout: "DELETE"]

	def index() {}

    def login() { 
    	String login = params.login
    	String password = params.password
    	LDAPConnection connection = new LDAPConnection('10.125.0.64',1390)
    	BindResult bindResult = connection.bind("uid=${login},ou=people,dc=sli,dc=dom",password)
    	if (bindResult.resultCode == ResultCode.SUCCESS){
    		session["login"] = login
    		render(view:'/index')
    	}else{
    		log.error "failure"
    		redirect(controller: "session", action: "login")
    	}
    }

    def logout() { }
}
