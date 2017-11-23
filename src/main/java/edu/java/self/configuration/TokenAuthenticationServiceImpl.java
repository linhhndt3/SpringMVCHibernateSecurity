package edu.java.self.configuration;

import java.io.IOException;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TokenAuthenticationServiceImpl implements TokenAuthenticationService {
	private static final String AUTH_HEADER_NAME = "X-AUTH-TOKEN";

//	@Autowired
//	@Qualifier("userDaoImpl")
//	private UserDao userDao;
//
//	@Autowired
//	@Qualifier("userTokenDaoImpl")
//	private UserTokenDao userTokenDao;
//
//	@Autowired
//	@Qualifier("tokenHandlerServiceImpl")
//	private TokenHandlerService tokenHandlerService;
//	
//	@Autowired
//	private UtilService utilService;
	
	@Autowired
	private SSUserDetailsService sSUserDetailsService;

	@Override
	public Authentication getAuthenticationForLogin(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		UserAuthentication userAuthentication = new UserAuthentication();
		userAuthentication.setAuthenticated(true);
		userAuthentication.setUser((UserInfo)new SSUserDetailsService().loadUserByUsername("username")); // get from request
		
		return userAuthentication;
	}

	@Override
	public Authentication getAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {

		final String token = request.getHeader(AUTH_HEADER_NAME);
		
		UserAuthentication userAuthentication = new UserAuthentication();
		
		userAuthentication.setAuthenticated(true);
		userAuthentication.setUser((UserInfo)new SSUserDetailsService().loadUserByUsername("token")); // get from request
//		auth.setIpAddress(IPUtil.getRemoteIp(request));
//		
//		Info info = auth.getInfo();
//		
//		if (!Util.isNullOrEmpty(token)) {
//			User user = null;
//			try {
//				user = tokenHandlerService.parseUserFromToken(token);
//				
//				if (!Util.isNullObject(user)) {
//					response.setStatus(HttpServletResponse.SC_OK);
//					auth.setUser(user);
//					auth.setAuthenticated(true);
//					auth.setToken(token);
//					return auth;
//				} else {
//					info.setCode(101L);
//					info.setDesc(utilService.getMessage("user.notfound"));
//				}
//			} catch (TokenException e) {
//				info.setCode(102L);
//				info.setDesc(e.getDescription());
//				info.setObject(e);
//				
//				logger.warn("Token Exception : " + e.getMessage());
//			} catch (Exception e){
//				info.setCode(103L);
//				info.setDesc("UNWANTED_EXCEPTION_RELOGIN_NEEDED");
//				
//				logger.warn("Exception", e);
//			}
//			
//		} else {
//			info.setCode(100L);
//			info.setDesc(utilService.getMessage("token.notfound"));
//		}
//
//		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//		auth.setAuthenticated(false);
		return userAuthentication;
	}

//	@Override
//	public UserToken addAuthentication(HttpServletResponse response, UserAuthentication authResult) {
//		final User user = authResult.getDetails();
//		String token = tokenHandlerService.calculateTokenForUser(user);
//
//		UserToken utoken = new UserToken();
//		utoken.setUser(user);
//		utoken.setToken(token);
//		utoken.setStatus(TokenStatus.ACTIVE.getTokenStatus());
//		utoken.setIpAddress(authResult.getIpAddress());
//		utoken.setCreatedDate(new Date());
//		utoken.setAuthType(authResult.getAuthType().getLoginType());
//
//		userTokenDao.deactivateAllTokensByUser(user.getId());
//		userTokenDao.create(utoken);
//		tokenHandlerService.insertToCache(token, user);
//
//		response.addHeader(AUTH_HEADER_NAME, token);
//		return utoken;
//	}

}
