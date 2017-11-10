package fr.gfi.ldappolicy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LdapOps {

	private static final String UID = "dupond";

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");

		System.out.println("Connecting to LDAP");

		LdapUserManager resource = (LdapUserManager) context.getBean("ldapUserManager");
		//resource.changePassword(UID, "xx", "dupond");
		
		//Boolean isTrue = resource.login(UID, "dupond");

		System.out.println(resource.getPolicy(UID));

	}

}
