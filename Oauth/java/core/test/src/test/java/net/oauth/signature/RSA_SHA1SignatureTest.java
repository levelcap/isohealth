/*
 * Copyright 2007 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.oauth.signature;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Random;
import junit.framework.TestCase;
import net.oauth.OAuth;
import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthException;
import net.oauth.OAuthMessage;
import net.oauth.OAuthProblemException;
import net.oauth.OAuthServiceProvider;

/**
 * @author Dirk Balfanz
 */
public class RSA_SHA1SignatureTest extends TestCase {

    private static final String PRIVATE_KEY =
            "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALRiMLAh9iimur8V"
          + "A7qVvdqxevEuUkW4K+2KdMXmnQbG9Aa7k7eBjK1S+0LYmVjPKlJGNXHDGuy5Fw/d"
          + "7rjVJ0BLB+ubPK8iA/Tw3hLQgXMRRGRXXCn8ikfuQfjUS1uZSatdLB81mydBETlJ"
          + "hI6GH4twrbDJCR2Bwy/XWXgqgGRzAgMBAAECgYBYWVtleUzavkbrPjy0T5FMou8H"
          + "X9u2AC2ry8vD/l7cqedtwMPp9k7TubgNFo+NGvKsl2ynyprOZR1xjQ7WgrgVB+mm"
          + "uScOM/5HVceFuGRDhYTCObE+y1kxRloNYXnx3ei1zbeYLPCHdhxRYW7T0qcynNmw"
          + "rn05/KO2RLjgQNalsQJBANeA3Q4Nugqy4QBUCEC09SqylT2K9FrrItqL2QKc9v0Z"
          + "zO2uwllCbg0dwpVuYPYXYvikNHHg+aCWF+VXsb9rpPsCQQDWR9TT4ORdzoj+Nccn"
          + "qkMsDmzt0EfNaAOwHOmVJ2RVBspPcxt5iN4HI7HNeG6U5YsFBb+/GZbgfBT3kpNG"
          + "WPTpAkBI+gFhjfJvRw38n3g/+UeAkwMI2TJQS4n8+hid0uus3/zOjDySH3XHCUno"
          + "cn1xOJAyZODBo47E+67R4jV1/gzbAkEAklJaspRPXP877NssM5nAZMU0/O/NGCZ+"
          + "3jPgDUno6WbJn5cqm8MqWhW1xGkImgRk+fkDBquiq4gPiT898jusgQJAd5Zrr6Q8"
          + "AO/0isr/3aa6O6NLQxISLKcPDk2NOccAfS/xOtfOz4sJYM3+Bs4Io9+dZGSDCA54"
          + "Lw03eHTNQghS0A==";

    private static final String PUBLIC_KEY =
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC0YjCwIfYoprq/FQO6lb3asXrx"
          + "LlJFuCvtinTF5p0GxvQGu5O3gYytUvtC2JlYzypSRjVxwxrsuRcP3e641SdASwfr"
          + "mzyvIgP08N4S0IFzEURkV1wp/IpH7kH41EtbmUmrXSwfNZsnQRE5SYSOhh+LcK2w"
          + "yQkdgcMv11l4KoBkcwIDAQAB";

    private static final String CERTIFICATE =
            "-----BEGIN CERTIFICATE-----\n"
          + "MIIBpjCCAQ+gAwIBAgIBATANBgkqhkiG9w0BAQUFADAZMRcwFQYDVQQDDA5UZXN0\n"
          + "IFByaW5jaXBhbDAeFw03MDAxMDEwODAwMDBaFw0zODEyMzEwODAwMDBaMBkxFzAV\n"
          + "BgNVBAMMDlRlc3QgUHJpbmNpcGFsMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKB\n"
          + "gQC0YjCwIfYoprq/FQO6lb3asXrxLlJFuCvtinTF5p0GxvQGu5O3gYytUvtC2JlY\n"
          + "zypSRjVxwxrsuRcP3e641SdASwfrmzyvIgP08N4S0IFzEURkV1wp/IpH7kH41Etb\n"
          + "mUmrXSwfNZsnQRE5SYSOhh+LcK2wyQkdgcMv11l4KoBkcwIDAQABMA0GCSqGSIb3\n"
          + "DQEBBQUAA4GBAGZLPEuJ5SiJ2ryq+CmEGOXfvlTtEL2nuGtr9PewxkgnOjZpUy+d\n"
          + "4TvuXJbNQc8f4AMWL/tO9w0Fk80rWKp9ea8/df4qMq5qlFWlx6yOLQxumNOmECKb\n"
          + "WpkUQDIDJEoFUzKMVuJf4KO/FJ345+BNLGgbJ6WujreoM1X/gYfdnJ/J\n"
          + "-----END CERTIFICATE-----";

    protected OAuthConsumer clientJceKey;
    protected OAuthConsumer clientDerKey;
    protected OAuthConsumer clientPemKey;
    protected OAuthConsumer serverJceKey;
    protected OAuthConsumer serverDerKey;
    protected OAuthConsumer serverPemKey;
    protected OAuthConsumer serverX509JceCert;
    protected OAuthConsumer serverX509DerCert;
    protected OAuthConsumer serverX509PemCert;

    @Override
    protected void setUp() throws Exception {
        EncodedKeySpec pubKeySpec =
                new X509EncodedKeySpec(OAuthSignatureMethod
                        .decodeBase64(PUBLIC_KEY));
        KeyFactory fac = KeyFactory.getInstance("RSA");
        PublicKey publicKey = fac.generatePublic(pubKeySpec);

        EncodedKeySpec privKeySpec =
                new PKCS8EncodedKeySpec(OAuthSignatureMethod
                        .decodeBase64(PRIVATE_KEY));
        fac = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = fac.generatePrivate(privKeySpec);

        CertificateFactory certFac = CertificateFactory.getInstance("X509");
        ByteArrayInputStream in = new ByteArrayInputStream(
                                                        CERTIFICATE.getBytes());
        X509Certificate cert = (X509Certificate)certFac.generateCertificate(in);

        String url1 = "http://www.google.com/url1 ";
        String url2 = "http://www.google.com/url2";
        String url3 = "http://www.google.com/url3";
        OAuthServiceProvider provider =
                new OAuthServiceProvider(url1, url2, url3);

        clientJceKey = new OAuthConsumer(url1, "google", null, provider);
        clientJceKey.setProperty (RSA_SHA1.PRIVATE_KEY, privateKey);
        serverJceKey = new OAuthConsumer(url1, "google", null, provider);
        serverJceKey.setProperty(RSA_SHA1.PUBLIC_KEY, publicKey);

        clientDerKey = new OAuthConsumer(url1, "google", null, provider);
        clientDerKey.setProperty (RSA_SHA1.PRIVATE_KEY, deBase64(PRIVATE_KEY));
        serverDerKey = new OAuthConsumer(url1, "google", null, provider);
        serverDerKey.setProperty(RSA_SHA1.PUBLIC_KEY, deBase64(PUBLIC_KEY));

        clientPemKey = new OAuthConsumer(url1, "google", null, provider);
        clientPemKey.setProperty (RSA_SHA1.PRIVATE_KEY, PRIVATE_KEY);
        serverPemKey = new OAuthConsumer(url1, "google", null, provider);
        serverPemKey.setProperty(RSA_SHA1.PUBLIC_KEY, PUBLIC_KEY);

        serverX509JceCert = new OAuthConsumer(url1, "google", null, provider);
        serverX509JceCert.setProperty(RSA_SHA1.X509_CERTIFICATE, cert);

        serverX509DerCert = new OAuthConsumer(url1, "google", null, provider);
        serverX509DerCert.setProperty(RSA_SHA1.X509_CERTIFICATE,
                                      cert.getEncoded());

        serverX509PemCert = new OAuthConsumer(url1, "google", null, provider);
        serverX509PemCert.setProperty(RSA_SHA1.X509_CERTIFICATE, CERTIFICATE);

    }

    private byte[] deBase64(String string) {
        return OAuthSignatureMethod.decodeBase64(string);
    }

    // we don't need unpredictability, just uniqueness
    private static final Random random = new Random();

    private static OAuthMessage prepareRequestMessage(OAuthConsumer consumer,
                                                     String httpMethod,
                                                     URL url,
                                                     String signatureMethod) {
        OAuthMessage message = new OAuthMessage(httpMethod,
                                              url.toString(),
                                              new ArrayList<OAuth.Parameter>());
        message.addParameter(OAuth.OAUTH_SIGNATURE_METHOD, signatureMethod);
        message.addParameter(OAuth.OAUTH_VERSION, OAuth.VERSION_1_0);
        message.addParameter(OAuth.OAUTH_CONSUMER_KEY, consumer.consumerKey );
        long currentTime = System.currentTimeMillis() / 1000l;
        message.addParameter(OAuth.OAUTH_TIMESTAMP,
                             Long.toString(currentTime, 10));
        byte[] nonce = new byte[8];
        random.nextBytes(nonce);
        BigInteger nonceInt = new BigInteger(1, nonce);
        message.addParameter(OAuth.OAUTH_NONCE,
                             nonceInt.toString(10));
        return message;
    }

    private static void validateSignature(OAuthMessage message, OAuthAccessor accessor)
        throws IOException, OAuthException, URISyntaxException
    {
        OAuthSignatureMethod.newSigner(message, accessor).validate(message);
    }

    private static void doTests(OAuthMessage message,
                                OAuthAccessor clientAccessor,
                                OAuthAccessor serverAccessor) throws Exception {

        message.sign(clientAccessor);

        try {
            validateSignature(message, serverAccessor);
        } catch(Exception e) {
            fail("message should have verified, but didn't");
        }

        try {
            message.sign(serverAccessor);
            fail("shouldn't be able to sign message without private key, " +
                 "but did");
        } catch(IllegalStateException e) {
            // expected
        }

        try {
            validateSignature(message, clientAccessor);
            fail("shouldn't be able to verify message without public key, " +
            	 "but did");
        } catch(IllegalStateException e) {
            // expected
        }

        message.addParameter("foo", "bar");
        try {
            validateSignature(message, serverAccessor);
            fail("modified message signature should not have validated, " +
            	 "but did");
        } catch(OAuthProblemException e) {
            // to be expected
        }

    }

    static void signAndVerify(OAuthConsumer client, OAuthConsumer server) throws Exception {
        String urlStr = "http://www.google.com/foo?param1=value1&param2=value2";
        URL url = new URL(urlStr);
        OAuthMessage message = prepareRequestMessage(client, "GET", url, OAuth.RSA_SHA1);
        doTests(message, new OAuthAccessor(client), new OAuthAccessor(server));
    }

    public void testSignVerifyJce() throws Exception {
        String urlStr = "http://www.google.com/foo?param1=value1&param2=value2";
        URL url = new URL(urlStr);

        OAuthMessage message = prepareRequestMessage(clientJceKey,
                                                     "GET",
                                                     url,
                                                     OAuth.RSA_SHA1);

        OAuthAccessor accessor1 = new OAuthAccessor(clientJceKey);
        OAuthAccessor accessor2 = new OAuthAccessor(serverJceKey);
        doTests(message, accessor1, accessor2);
    }

    public void testSignVerifyDer() throws Exception {
        String urlStr = "http://www.google.com/foo?param1=value1&param2=value2";
        URL url = new URL(urlStr);

        OAuthMessage message = prepareRequestMessage(clientDerKey,
                                                     "GET",
                                                     url,
                                                     OAuth.RSA_SHA1);

        OAuthAccessor accessor1 = new OAuthAccessor(clientDerKey);
        OAuthAccessor accessor2 = new OAuthAccessor(serverDerKey);
        doTests(message, accessor1, accessor2);
    }

    public void testSignVerifyPem() throws Exception {
        String urlStr = "http://www.google.com/foo?param1=value1&param2=value2";
        URL url = new URL(urlStr);

        OAuthMessage message = prepareRequestMessage(clientPemKey,
                                                     "GET",
                                                     url,
                                                     OAuth.RSA_SHA1);

        OAuthAccessor accessor1 = new OAuthAccessor(clientPemKey);
        OAuthAccessor accessor2 = new OAuthAccessor(serverPemKey);
        doTests(message, accessor1, accessor2);
    }

    public void testSignVerifyX509Jce() throws Exception {
        String urlStr = "http://www.google.com/foo?param1=value1&param2=value2";
        URL url = new URL(urlStr);

        OAuthMessage message = prepareRequestMessage(clientJceKey,
                                                     "GET",
                                                     url,
                                                     OAuth.RSA_SHA1);

        OAuthAccessor accessor1 = new OAuthAccessor(clientJceKey);
        OAuthAccessor accessor2 = new OAuthAccessor(serverX509JceCert);
        doTests(message, accessor1, accessor2);
    }

    public void testSignVerifyX509Der() throws Exception {
        String urlStr = "http://www.google.com/foo?param1=value1&param2=value2";
        URL url = new URL(urlStr);

        OAuthMessage message = prepareRequestMessage(clientJceKey,
                                                     "GET",
                                                     url,
                                                     OAuth.RSA_SHA1);

        OAuthAccessor accessor1 = new OAuthAccessor(clientJceKey);
        OAuthAccessor accessor2 = new OAuthAccessor(serverX509DerCert);
        doTests(message, accessor1, accessor2);
    }

    public void testSignVerifyX509Pem() throws Exception {
        String urlStr = "http://www.google.com/foo?param1=value1&param2=value2";
        URL url = new URL(urlStr);

        OAuthMessage message = prepareRequestMessage(clientJceKey,
                                                     "GET",
                                                     url,
                                                     OAuth.RSA_SHA1);

        OAuthAccessor accessor1 = new OAuthAccessor(clientJceKey);
        OAuthAccessor accessor2 = new OAuthAccessor(serverX509PemCert);
        doTests(message, accessor1, accessor2);
    }
}
