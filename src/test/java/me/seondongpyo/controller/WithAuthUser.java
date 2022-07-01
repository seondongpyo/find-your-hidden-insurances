package me.seondongpyo.controller;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContext;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import me.seondongpyo.domain.Role;
import me.seondongpyo.security.AuthUser;

@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithAuthUser.WithAuthUserSecurityContextFactory.class)
public @interface WithAuthUser {

	String username();
	Role role();

	class WithAuthUserSecurityContextFactory implements WithSecurityContextFactory<WithAuthUser> {

		@Override
		public SecurityContext createSecurityContext(WithAuthUser annotation) {
			String username = annotation.username();
			Role role = annotation.role();

			AuthUser authUser = new AuthUser(1L, username, "1234", "tester", role);
			UsernamePasswordAuthenticationToken token =
				new UsernamePasswordAuthenticationToken(authUser, "1234", List.of(new SimpleGrantedAuthority(role.name())));

			SecurityContext context = SecurityContextHolder.getContext();
			context.setAuthentication(token);
			return context;
		}
	}
}
