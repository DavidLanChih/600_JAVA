/**
 *second 
 */
package com.mingrisoft.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyAgreement;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 * @author baiweiming
 * 
 */
public class BothDHServerFile {

	private String keyAlgorithm = "DH";
	private String secretAlgorithm = "DES";
	// 服務端資料檔案
	private String serverdataFile = "fileServerData.dat";
	// 客戶端資料檔案
	private String clientdataFile = "fileClientData.dat";
	// 服務端私鑰檔案
	private String privateServerkeyFile = "keyServerPrivateData.dat";
	// 服務端公鑰檔案
	private String publicServerkeyFile = "keyServerPublicData.dat";
	// 客戶端公鑰檔案
	private String publicClientkeyFile = "keyClientPublicData.dat";

	/**
	 * 把資料寫到指定的檔案上
	 * 
	 * @param data
	 *            資料
	 * @param fileName
	 *            檔案名稱
	 */
	public void writeFile(byte[] data, String fileName) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(fileName);
			fileOutputStream.write(data);
			fileOutputStream.close();
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根據fileName讀取資料檔案
	 * 
	 * @param fileName
	 * @return
	 */
	public byte[] readFile(String fileName) {

		// 讀取
		try {
			File file = new File(fileName);
			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fileInputStream.read(data);
			fileInputStream.close();
			return data;
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 產生服務端密鑰對
	 */
	public void generateServerKeyFile() {
		KeyPairGenerator keyPairGen = null;
		try {
			keyPairGen = KeyPairGenerator.getInstance(keyAlgorithm);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		KeyPair keyPair = keyPairGen.generateKeyPair();

		// 公鑰
		PublicKey publicKey = keyPair.getPublic();
		writeFile(publicKey.getEncoded(), publicServerkeyFile);

		// 私鑰
		PrivateKey privateKey = keyPair.getPrivate();
		writeFile(privateKey.getEncoded(), privateServerkeyFile);
	}

	/**
	 * 產生服務端機密密鑰
	 * 
	 * @return
	 */
	private SecretKey getServerSecretKey() {
		byte[] privateServerKey = readFile(privateServerkeyFile);
		byte[] publicClientKey = readFile(publicClientkeyFile);

		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicClientKey);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(
				privateServerKey);

		Key publicKey = null;
		KeyFactory keyFactory = null;
		Key privateKey = null;
		KeyAgreement keyAgree = null;

		try {
			keyFactory = KeyFactory.getInstance(keyAlgorithm);
			publicKey = keyFactory.generatePublic(x509KeySpec);
			privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
			// 建立密鑰協定
			keyAgree = KeyAgreement.getInstance(keyFactory.getAlgorithm());
			//初始化密鑰
			keyAgree.init(privateKey);
			keyAgree.doPhase(publicKey, true);
			return keyAgree.generateSecret(secretAlgorithm);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 服務端資料加密
	 * 
	 * @param data
	 */
	public void encryptForServer(byte[] data) {

		SecretKey secretKey = getServerSecretKey();

		try {
			Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			writeFile(cipher.doFinal(data), serverdataFile);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 服務端資料解密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public byte[] decryptForServer() {
		SecretKey secretKey = getServerSecretKey();

		try {
			byte[] data = readFile(clientdataFile);
			Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return cipher.doFinal(data);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] arg) {
		String data = "客戶端你好，我是服務端";
		BothDHServerFile bothDHServerFile = new BothDHServerFile();
		BothDHClientFile bothDHClientFile = new BothDHClientFile();

		// 產生服務端密鑰對
		bothDHServerFile.generateServerKeyFile();
		// 產生客戶端密鑰對
		bothDHClientFile.generateClientKeyFile();
		// 服務端加密
		bothDHServerFile.encryptForServer(data.getBytes());
		// 客戶端解密
		byte[] data1 = bothDHClientFile.decryptForClient();
		System.out.println("Servet原始資料：" + data);
		System.out.println("Client解密資料：" + new String(data1));
	}

}
