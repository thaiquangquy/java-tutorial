package com.pairlearning.expensetracker;

import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;

import static io.jsonwebtoken.security.Keys.secretKeyFor;

public class Constants {
//    public static final SecretKey API_SECRET_KEY = secretKeyFor(SignatureAlgorithm.HS256);
    public static final String API_SECRET_KEY = "36AADE31EF9195B2DBB95C7AF2F3C8C1AFE7339823134C3536A914468C";
    public static final long TOKEN_VALIDITY = 2 * 60 * 60 * 1000;
}
