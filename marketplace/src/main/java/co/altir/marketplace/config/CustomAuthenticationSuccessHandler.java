package co.altir.marketplace.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1,
			Authentication authentication) throws IOException, ServletException {

		boolean hasRtlrRole = false;
		boolean hasDistrRole = false;
		boolean hasAdminRole = false;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ROLE_RTLR")) {
				hasRtlrRole = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
				hasAdminRole = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_DISTR")) {
				hasDistrRole = true;
				break;
			}
		}

		if (hasRtlrRole) {
			redirectStrategy.sendRedirect(arg0, arg1, "/v1/retailer/test");
		} else if (hasDistrRole) {
			redirectStrategy.sendRedirect(arg0, arg1, "/v1/distributer/test");
		} else if (hasAdminRole) {
			redirectStrategy.sendRedirect(arg0, arg1, "/v1/admin/test");
		} else {
			throw new IllegalStateException();
		}
	}

}