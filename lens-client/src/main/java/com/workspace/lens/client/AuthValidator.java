package com.workspace.lens.client;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.flipkart.kloud.filter.AuthenticationException;
import com.flipkart.kloud.filter.JWTValidationService;
import com.flipkart.kloud.filter.SecurityContextHolder;
import com.flipkart.kloud.filter.SystemUser;
import com.nimbusds.jwt.ReadOnlyJWTClaimsSet;

/**
 * Created by deepak.barr on 11/08/15.
 */
public class AuthValidator {

  public static final Log log = LogFactory.getLog(AuthValidator.class);

  private final JWTValidationService jwtValidationService;

  public AuthValidator() {
    String authnUrl ="https://kloud-authn-0001.ch.flipkart.com/openid-connect-server-webapp";
    String clientId = "apache-lens";
    this.jwtValidationService = new JWTValidationService(authnUrl, clientId);
  }

  public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException {
    new AuthValidator().validate(AuthNClient.getAuthHeader());
  }

  public void validate(String authorizationHeader) throws IOException {
    log.info("auth header :" + authorizationHeader);

    authorizationHeader=authorizationHeader+"a";

    if (authorizationHeader != null) {
      String token = extractBearerToken(authorizationHeader);
      log.info("token :" + token);
      if (token != null) {
        try {
          ReadOnlyJWTClaimsSet claims = jwtValidationService.validate(token);
          SystemUser user = new SystemUser(claims.getSubject());
          SecurityContextHolder.getSecurityContext().setUser(user);
          System.out.println("WOOOOOOW");
        } catch (Exception e) {
          System.out.println("ERORRRRRRRRRR");
          throw new AuthenticationException(e);
        }
      }
    }
  }

  private String extractBearerToken(String authorizationHeader) {

    log.info("Extracting token...");

    String prefix = "Bearer";
    if (authorizationHeader.startsWith(prefix)) {
      int commaIndex = authorizationHeader.indexOf(44);
      authorizationHeader = authorizationHeader.substring(prefix.length()).trim();
      return commaIndex != -1 ? authorizationHeader.substring(0, commaIndex) : authorizationHeader;
    } else {
      return null;
    }
  }
}

