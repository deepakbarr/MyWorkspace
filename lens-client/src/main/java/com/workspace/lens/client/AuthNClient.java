package com.workspace.lens.client;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.flipkart.kloud.authn.AuthTokenService;
import com.flipkart.kloud.authn.PrivateKeyCredential;

/**
 * Created by deepak.barr on 12/08/15.
 */
public class AuthNClient {
  private static final String authnUrl = "https://kloud-authn-0001.ch.flipkart.com/openid-connect-server-webapp";
  private static  final String privateKeyPath="/Users/deepak.barr/coderep/MyWorkspace/lens-client/src/main/resources/key/private.pem";
  private static final String clientId="lens-test-client";
  private static final String targetClientId="apache-lens";

  public static String getAuthHeader() throws NoSuchAlgorithmException, IOException, InvalidKeySpecException {
    PrivateKeyCredential privateKeyCredential = PrivateKeyCredential.fromPemFile(clientId, privateKeyPath);
    AuthTokenService tokenService = new AuthTokenService(authnUrl, privateKeyCredential);
    String header = tokenService.fetchToken(targetClientId).toAuthorizationHeader();
    System.out.println("header = " + header);
    return header;
  }

  public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException {
      getAuthHeader();
  }
}
