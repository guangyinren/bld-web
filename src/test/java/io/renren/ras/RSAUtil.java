package io.renren.ras;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;


public class RSAUtil {
	public static final String KEY_ALGORITHM = "RSA";
	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

	private static final String PUBLIC_KEY = "RSAPublicKey";
	private static final String PRIVATE_KEY = "RSAPrivateKey";

	public static byte[] decryptBASE64(String key) {
		return Base64.decode(key);
	}

	public static String encryptBASE64(byte[] bytes) {
		return Base64.encode(bytes);
	}

	/**
	 * 用私钥对信息生成数字签名
	 * 
	 * @param data
	 *            加密数据
	 * @param privateKey
	 *            私钥
	 * @return
	 * @throws Exception
	 */
	public static String sign(byte[] data, String privateKey) throws Exception {
		// 解密由base64编码的私钥
		byte[] keyBytes = decryptBASE64(privateKey);
		// 构造PKCS8EncodedKeySpec对象
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		// KEY_ALGORITHM 指定的加密算法
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		// 取私钥匙对象
		PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
		// 用私钥对信息生成数字签名
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initSign(priKey);
		signature.update(data);
		return encryptBASE64(signature.sign());
	}

	/**
	 * 校验数字签名
	 * 
	 * @param data
	 *            加密数据
	 * @param publicKey
	 *            公钥
	 * @param sign
	 *            数字签名
	 * @return 校验成功返回true 失败返回false
	 * @throws Exception
	 */
	public static boolean verify(byte[] data, String publicKey, String sign)
			throws Exception {
		// 解密由base64编码的公钥
		byte[] keyBytes = decryptBASE64(publicKey);
		// 构造X509EncodedKeySpec对象
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		// KEY_ALGORITHM 指定的加密算法
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		// 取公钥匙对象
		PublicKey pubKey = keyFactory.generatePublic(keySpec);
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initVerify(pubKey);
		signature.update(data);
		// 验证签名是否正常
		return signature.verify(decryptBASE64(sign));
	}

	public static byte[] decryptByPrivateKey(byte[] data, String key)
			throws Exception {
		// 对密钥解密
		byte[] keyBytes = decryptBASE64(key);
		// 取得私钥
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
		// 对数据解密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		return cipher.doFinal(data);
	}

	/**
	 * 解密<br>
	 * 用私钥解密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPrivateKey(String data, String key)
			throws Exception {
		return decryptByPrivateKey(decryptBASE64(data), key);
	}

	/**
	 * 解密<br>
	 * 用公钥解密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPublicKey(byte[] data, String key)
			throws Exception {
		// 对密钥解密
		byte[] keyBytes = decryptBASE64(key);
		// 取得公钥
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicKey = keyFactory.generatePublic(x509KeySpec);
		// 对数据解密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		return cipher.doFinal(data);
	}

	/**
	 * 加密<br>
	 * 用公钥加密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPublicKey(String data, String key)
			throws Exception {
		// 对公钥解密
		byte[] keyBytes = decryptBASE64(key);
		// 取得公钥
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicKey = keyFactory.generatePublic(x509KeySpec);
		// 对数据加密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		return cipher.doFinal(data.getBytes());
	}

	/**
	 * 加密<br>
	 * 用私钥加密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPrivateKey(byte[] data, String key)
			throws Exception {
		// 对密钥解密
		byte[] keyBytes = decryptBASE64(key);
		// 取得私钥
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
		// 对数据加密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		return cipher.doFinal(data);
	}

	/**
	 * 取得私钥
	 * 
	 * @param keyMap
	 * @return
	 * @throws Exception
	 */
	public static String getPrivateKey(Map<String, Key> keyMap)
			throws Exception {
		Key key = (Key) keyMap.get(PRIVATE_KEY);
		return encryptBASE64(key.getEncoded());
	}

	/**
	 * 取得公钥
	 * 
	 * @param keyMap
	 * @return
	 * @throws Exception
	 */
	public static String getPublicKey(Map<String, Key> keyMap) throws Exception {
		Key key = keyMap.get(PUBLIC_KEY);
		return encryptBASE64(key.getEncoded());
	}

	/**
	 * 初始化密钥
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Key> initKey() throws Exception {
		KeyPairGenerator keyPairGen = KeyPairGenerator
				.getInstance(KEY_ALGORITHM);
		keyPairGen.initialize(1024);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		Map<String, Key> keyMap = new HashMap<String, Key>(2);
		keyMap.put(PUBLIC_KEY, keyPair.getPublic());// 公钥
		keyMap.put(PRIVATE_KEY, keyPair.getPrivate());// 私钥
		return keyMap;
	}
	
	public static void demo() throws Exception {
		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCwjDm1HXDw8QH5ZtGMQIl2h/I8E+chOQA8aQ8xCR/+aHnROaN/ZU5Vmd2Zz7g6cAacR9BSm60+iSCYtvEGJKl0WqvbPGJkc8tedjNF1QqgWqkkuE6Udgw2OkEKJCxDg6PrAniR7Cc0io9G8bW4P8JDJjSbbafvMPDDFbVVUWJxxwIDAQAB";
		String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALCMObUdcPDxAflm0YxAiXaH8jwT5yE5ADxpDzEJH/5oedE5o39lTlWZ3ZnPuDpwBpxH0FKbrT6JIJi28QYkqXRaq9s8YmRzy152M0XVCqBaqSS4TpR2DDY6QQokLEODo+sCeJHsJzSKj0bxtbg/wkMmNJttp+8w8MMVtVVRYnHHAgMBAAECgYAOLuW/8CKPqL0A3Uq+WrzwYdGLFApAeATV1Zbb2KDSXnBS56+D346gf+D2p2Jkh3VwfrB0wn7zhC6zNhc86BsY1K6Q7xU8b7asDBqki48H3ExuxjEosEqUdLf9p9pPBCPI3I4CN/EZPEoFjNRNi5ZX/CY4iaOgsXPHEkcxuW3GQQJBAOBo9UpXesZYCsmuuGN5SOy6tXI613NUBvXKXkxBil3ZOqozlaSjv5NSQb2zLeh2DcYfecumfgn04rNM/pLeDmECQQDJZnXWg4VrXdjc9hqu/8rkmxdhsr3ERkX1uKJrDUB+AOdFs6mS9gEHnJ70zqQ2ucbhQ4htulbLc9pBVL5gy+EnAkEArdhhfa/7SsBVyxvxeA4zMkEJ4242Df/gTHTzTDvRxxZL3iKMILlB5gzpJN40CEu8K+miXuOh7HCrVp+k733awQJBAMDkERhS/wXF7F40l3nkIz6wC8TWnEnPxFGDdItzNcF4vAhV+qN2WaYgq11sTHrdk01MkO4G+foCC5dmwq+SlSECQGm58ReqUTRDAKl32VX0vEdVvOj2getVxW6jQjJFiGj8iNDfK+DpiLfns3YjwSlWHGxHz1S6/lQ+58+M+fEyvUs=";

		String inputStr = "sign";
		byte[] data = inputStr.getBytes();

		byte[] encodedData = RSAUtil.encryptByPrivateKey(data, privateKey);

		byte[] decodedData = RSAUtil
				.decryptByPrivateKey(Base64.decode("mIENuMEvbTkceKAzoqDLx8qiuZ12wZ5eRhZMKf2dfL+ZJkxJHnBXxNZiMpbIFHjIJSoP7sBxknR8PEPFAVgNoL2HqlEmOGFzpXugWK37fDpoKSOFpT0AKJyY4/j87F52YZlIjsJgk74+KDyrPKxagzEZejb8bAI4Ln/54UaVhd0="),
						privateKey);
		String outputStr = new String(decodedData);
		System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);

		System.err.println("私钥签名——公钥验证签名");
		// 产生签名
		String sign = RSAUtil.sign(encodedData, privateKey);
		System.err.println("签名:" + sign);
		// 验证签名
		boolean status = RSAUtil.verify(encodedData, publicKey, sign);
		System.err.println("状态:" + status);
	}
	
	public static void encrypt() throws Exception {
//		Map<String, Key> keyMap = RSACode.initKey();
//		String publicKey = RSACode.getPublicKey(keyMap);
//		String privateKey = RSACode.getPrivateKey(keyMap);
		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCtHkmsyzDLAHVwsElwcwwk7j9L+GIjTKq0VnjbKNNW5CwrROXGEaGR3bq7z2uG9YF/ygK3JBAxcAnq3np3qR7bTNO6YwuS0x4JZb2DwWoP5SkycwXDgUClGUzh03GWb5C52MvVvNXiJwKsntnhnzfYY48COqFkNuXvSl+Vj27FYQIDAQAB";
		String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAK0eSazLMMsAdXCwSXBzDCTuP0v4YiNMqrRWeNso01bkLCtE5cYRoZHdurvPa4b1gX/KArckEDFwCereenepHttM07pjC5LTHgllvYPBag/lKTJzBcOBQKUZTOHTcZZvkLnYy9W81eInAqye2eGfN9hjjwI6oWQ25e9KX5WPbsVhAgMBAAECgYBC1V+SEvuqU2oDcDtZ60Bz/Xp4RNL2V8HLT1rnGRLGB965cabXWbUrkBNoMEKN3rf48q8rrwOFYoChqPRUv/jGBE5JibK7gTSPzDMLOGngMk6whSRvLBQ1kaFNwMD3vAz8y5Md+sePvD72tBquDCzVdBGQSDfFlLFo+5wPfzS9AQJBAN58VpWywEV2xsoavbQf1xLoyLTRYz6fSjpp1kZA3jfRE5OOZzaUchNhQ3BufRYO8spYb4k/YlGW8w/xrUmU9jECQQDHMjUGpLobwzJKLQ31CSK7QQ/3UnlzCCOTkYd6duJcGyZUntgMRog7EGhkNC+4aa/z8VSuSUARNh45oSo4boYxAkB8InfU8nUgzNLBdQYfeBxyKnvBl4p+KDYsPV0WuZ7DGd6IV83ywASeF4ifNKaKJjEFAS7KLxlWWJipbri282whAkEArPmOTlyRODaC3yLMsfHi9RSEltJJoHh63FRNfyzpV+5DlMvy9IXzGscev5UJs2wjXQQ98rKtLcT+7jBjh2mCoQJBALO/PuFoWEaxBJ1/7JeQlKBPEWa1pM4obC12XM+G0LoaiyG7/LYk+l5pUp8bVbPcZoD1d+K0/DRBRTn94JxvX6A=";
		System.out.println("公钥:"+publicKey);
		System.out.println("私钥:"+privateKey);
		
		String data="hello";
		String dataZn="吕海潮";
		
		System.out.println("英文数据:"+data);
		System.out.println("中文数据:"+dataZn);
		
		byte[] endata=RSAUtil.encryptByPublicKey(data,publicKey);
		byte[] endataZn=RSAUtil.encryptByPublicKey(dataZn,publicKey);
		
		System.out.println("公钥加密英文数据:"+Base64.encode(endata));
		System.out.println("公钥加密中文数据:"+Base64.encode(endataZn));
		
		byte[] dedata=RSAUtil.decryptByPrivateKey(endata, privateKey);
		byte[] dedataZn=RSAUtil.decryptByPrivateKey(endataZn, privateKey);
		
		System.out.println("私钥解密英文数据:"+new String(dedata));
		System.out.println("私钥解密中文数据:"+new String(dedataZn));
	}

	public static void decrypt() throws Exception {
		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCtHkmsyzDLAHVwsElwcwwk7j9L+GIjTKq0VnjbKNNW5CwrROXGEaGR3bq7z2uG9YF/ygK3JBAxcAnq3np3qR7bTNO6YwuS0x4JZb2DwWoP5SkycwXDgUClGUzh03GWb5C52MvVvNXiJwKsntnhnzfYY48COqFkNuXvSl+Vj27FYQIDAQAB";
		String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAK0eSazLMMsAdXCwSXBzDCTuP0v4YiNMqrRWeNso01bkLCtE5cYRoZHdurvPa4b1gX/KArckEDFwCereenepHttM07pjC5LTHgllvYPBag/lKTJzBcOBQKUZTOHTcZZvkLnYy9W81eInAqye2eGfN9hjjwI6oWQ25e9KX5WPbsVhAgMBAAECgYBC1V+SEvuqU2oDcDtZ60Bz/Xp4RNL2V8HLT1rnGRLGB965cabXWbUrkBNoMEKN3rf48q8rrwOFYoChqPRUv/jGBE5JibK7gTSPzDMLOGngMk6whSRvLBQ1kaFNwMD3vAz8y5Md+sePvD72tBquDCzVdBGQSDfFlLFo+5wPfzS9AQJBAN58VpWywEV2xsoavbQf1xLoyLTRYz6fSjpp1kZA3jfRE5OOZzaUchNhQ3BufRYO8spYb4k/YlGW8w/xrUmU9jECQQDHMjUGpLobwzJKLQ31CSK7QQ/3UnlzCCOTkYd6duJcGyZUntgMRog7EGhkNC+4aa/z8VSuSUARNh45oSo4boYxAkB8InfU8nUgzNLBdQYfeBxyKnvBl4p+KDYsPV0WuZ7DGd6IV83ywASeF4ifNKaKJjEFAS7KLxlWWJipbri282whAkEArPmOTlyRODaC3yLMsfHi9RSEltJJoHh63FRNfyzpV+5DlMvy9IXzGscev5UJs2wjXQQ98rKtLcT+7jBjh2mCoQJBALO/PuFoWEaxBJ1/7JeQlKBPEWa1pM4obC12XM+G0LoaiyG7/LYk+l5pUp8bVbPcZoD1d+K0/DRBRTn94JxvX6A=";
		System.out.println("公钥:"+publicKey);
		System.out.println("私钥:"+privateKey);
		
		String data="fmS23LuQqH6sYeQavr1/vaMBlV9UB9/zB9Y952wW1y7caVlUDs7ifZwMRg42DqOCsBgIUCqE2zlq/d1nneuhvoGEl+iJnHAoK6rf3ZMxZUQQuAWm1OeBA8rIZxUDgA7h02aFz7QkNzFFKXmF8zhk3YpE8y9/YzXZdDaAYFcsdDs=";
		
		System.out.println("私钥解密英文数据:"+new String(RSAUtil.decryptByPrivateKey(Base64.decode(data), privateKey)));
	}
	
	public static void main(String[] args) throws Exception {
//		encrypt();
		decrypt();
	}
}