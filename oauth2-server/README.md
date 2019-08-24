# oauth-server

## Key store file generation
Generate a keystore file:
$ keytool -genkeypair -alias jwt -keyalg RSA -keypass password -keystore jwt.jks -storepass password

It is recommended to migrate to PKCS12:
$ keytool -importkeystore -srckeystore jwt.jks -destkeystore jwt.jks -deststoretype pkcs12

Export the public key:
keytool -list -rfc -keystore jwt.jks | openssl x509 -inform pem -pubkey

## Example 
curl -u clientId:secret -X POST localhost:8080/auth-server/oauth/token\?grant_type=client_credentials